CREATE TABLE IF NOT EXISTS produto (
    codigo SERIAL PRIMARY KEY,
    descricao VARCHAR(100),
    validade DATE,
    ean VARCHAR(30),
    ativo BOOLEAN,
    preco NUMERIC(10,2)
);