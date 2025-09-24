package com.pocapi.poc.model;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String avatar;}
