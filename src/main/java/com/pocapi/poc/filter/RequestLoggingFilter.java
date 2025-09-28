package com.pocapi.poc.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            // CorrelationId
            String correlationId = extractOrGenerateCorrelationId(request);
            MDC.put("correlationId", correlationId);

            // Outros metadados úteis
            MDC.put("method", request.getMethod());
            MDC.put("uri", request.getRequestURI());
            MDC.put("userAgent", request.getHeader("User-Agent"));

            // Adiciona no response
            response.setHeader("X-Correlation-ID", correlationId);

            filterChain.doFilter(request, response);

        } finally {
            MDC.clear();
        }
    }

    private String extractOrGenerateCorrelationId(HttpServletRequest request) {
        String correlationId = request.getHeader("X-Correlation-ID");
        return (correlationId != null && !correlationId.trim().isEmpty())
                ? correlationId
                : UUID.randomUUID().toString();
    }
}