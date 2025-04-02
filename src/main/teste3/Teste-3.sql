-- Criação do banco de dados (se for necessário)
    create database if not exists teste_3;
    use teste_3;

-- Cria a tabela para os dados cadastrais das operadoras de planos de saúde.
    create table operadoras_ativas (
        Registro_ANS varchar(10) primary key,
        CNPJ varchar(20) null,
        Razao_Social varchar(255) null,
        Nome_Fantasia varchar(255) null,
        Modalidade varchar(100) null,
        Logradouro varchar(255) null,
        Numero varchar(20) null,
        Complemento varchar(100) null,
        Bairro varchar(100) null,
        Cidade varchar(100) null,
        UF char(2) null,
        CEP varchar(9) null,
        DDD varchar(3) null,
        Telefone varchar(20) null,
        Fax varchar(20) null,
        Endereco_Eletronico varchar(255) null,
        Representante varchar(100) null,
        Cargo_Representante varchar(100) null,
        Regiao_de_Comercializacao int null,
        Data_Registro_ANS date null
    );

-- Tabela para os demonstrativos contábeis por operadora.
    create table demonstracoes_contabeis (
        ID int AUTO_INCREMENT primary key,
        DATA date null,
        REG_ANS varchar(10) null,
        CD_CONTA_CONTABIL varchar(20) null,
        DESCRICAO text,
        VL_SALDO_INICIAL decimal(15, 2),
        VL_SALDO_FINAL decimal(15, 2)
    );
