CREATE TABLE produto (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100),
    validade DATE,
    ean VARCHAR(30),
    ativo BOOLEAN,
    preco DECIMAL(10,2)
);
