-- Script de criação da base de dados para usuários (H2 In-Memory Database)
-- Baseado na estrutura JSON fornecida

-- Drop table se existir (útil para reinicializações)
DROP TABLE IF EXISTS users;

-- Criação da tabela compatível com H2
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    avatar VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);

-- Criação de índices para melhor performance (H2 sintaxe)
CREATE INDEX IF NOT EXISTS idx_users_email ON users(email);
CREATE INDEX IF NOT EXISTS idx_users_name ON users(first_name, last_name);

-- Inserção de dados de exemplo
INSERT INTO users (email, first_name, last_name, avatar) VALUES
('joao.silva@email.com', 'João', 'Silva', 'https://example.com/avatars/joao.jpg'),
('maria.santos@email.com', 'Maria', 'Santos', 'https://example.com/avatars/maria.jpg'),
('pedro.oliveira@email.com', 'Pedro', 'Oliveira', 'https://example.com/avatars/pedro.jpg'),
('ana.costa@email.com', 'Ana', 'Costa', 'https://example.com/avatars/ana.jpg'),
('carlos.ferreira@email.com', 'Carlos', 'Ferreira', 'https://example.com/avatars/carlos.jpg'),
('lucia.pereira@email.com', 'Lúcia', 'Pereira', 'https://example.com/avatars/lucia.jpg'),
('rafael.almeida@email.com', 'Rafael', 'Almeida', 'https://example.com/avatars/rafael.jpg'),
('camila.rodrigues@email.com', 'Camila', 'Rodrigues', 'https://example.com/avatars/camila.jpg'),
('bruno.martins@email.com', 'Bruno', 'Martins', 'https://example.com/avatars/bruno.jpg'),
('fernanda.lima@email.com', 'Fernanda', 'Lima', 'https://example.com/avatars/fernanda.jpg');