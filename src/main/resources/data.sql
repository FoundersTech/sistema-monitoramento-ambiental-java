-- src/main/resources/data.sql

-- 1. Inserir Endereços (não possuem dependências)
INSERT INTO enderecos (id, rua, cidade, estado, cep, pais, numero, complemento, bairro, criado_em, atualizado_em) VALUES
(1, 'Rua da Tecnologia, 123', 'São Paulo', 'SP', '01000-000', 'Brasil', '123', 'Andar 10', 'Centro', NOW(), NOW()),
(2, 'Avenida da Inovação, 456', 'Rio de Janeiro', 'RJ', '20000-000', 'Brasil', '456', 'Bloco B', 'Porto', NOW(), NOW()),
(3, 'Praça da Ciência, 789', 'Curitiba', 'PR', '80000-000', 'Brasil', '789', 'Sala 1', 'Batel', NOW(), NOW());

-- 2. Inserir Empresas (dependem de Endereços)
INSERT INTO empresas (id, nome_empresa, cnpj_empresa, id_endereco, tipo_empresa, area_atuacao_empresa, nome_responsavel_empresa, cargo_responsavel_empresa, cpf_responsavel_empresa, email_responsavel_empresa, telefone_responsavel_empresa, criado_em, atualizado_em) VALUES
(1, 'Empresa de Tecnologia A', '11.111.111/0001-11', 1, 0, 'Tecnologia', 'Carlos Pereira', 'Diretor', '111.222.333-44', 'carlos.p@empresa-a.com', '11911112222', NOW(), NOW()),
(2, 'Empresa de Inovação B', '22.222.222/0001-22', 2, 5, 'P&D', 'Maria Oliveira', 'Gerente de Projetos', '222.333.444-55', 'maria.o@empresa-b.com', '21922223333', NOW(), NOW()),
(3, 'Empresa de Inovação C', '33.333.333/0001-33', 3, 7, 'Biotecnologia', 'João Santos', 'CEO', '333.444.555-66', 'joao.s@empresa-c.com', '41933334444', NOW(), NOW());

-- 3. Inserir Usuários (dependem de Empresas)
INSERT INTO usuarios (id, nome_usuario, email_usuario, id_empresa, criado_em, atualizado_em) VALUES
(1, 'admin_empresa_a', 'admin@empresa-a.com', 1, NOW(), NOW()),
(2, 'admin_empresa_b', 'admin@empresa-b.com', 2, NOW(), NOW()),
(3, 'admin_empresa_c', 'admin@empresa-c.com', 3, NOW(), NOW());

-- 4. Inserir Sensores (dependem de Endereços e Usuários)
INSERT INTO sensor (id, modelo, endereco_id, usuario_id) VALUES
(101, 'DHT22', 1, 1),
(102, 'BMP180', 1, 1),
(201, 'MQ-2', 2, 2),
(301, 'LM35', 3, 3);

-- 5. Inserir Dados Climáticos (dependem de Empresas e Sensores)
INSERT INTO dados_climaticos (id, id_empresa, sensor_id, localizacao, temperatura, umidade, periodo_coleta, local_coleta, criado_em) VALUES
(1, 1, 101, 'Escritório Principal', 23.5, 55.2, 'Manhã', 'Sala de Servidores', NOW()),
(2, 1, 102, 'Escritório Principal', 24.1, 54.9, 'Manhã', 'Área de Desenvolvimento', NOW()),
(3, 2, 201, 'Laboratório P&D', 26.0, 60.0, 'Tarde', 'Bancada de Testes 1', NOW()),
(4, 3, 301, 'Estufa de Biotecnologia', 22.8, 75.5, 'Noite', 'Setor A', NOW());
