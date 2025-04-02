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
        Regiao_de_Comercializacao varchar(100) null, -- modificada de int para varchar
        Data_Registro_ANS date null
    );

-- Tabela para os demonstrativos contábeis por operadora.
    create table demonstracoes_contabeis (
        ID int AUTO_INCREMENT primary key,
        _DATA date null,
        REG_ANS varchar(10) null,
        CD_CONTA_CONTABIL varchar(20) null,
        DESCRICAO text,
        VL_SALDO_INICIAL decimal(15, 2),
        VL_SALDO_FINAL decimal(15, 2)
    );

-- Importar o aruivo CSV com os dados cadastrais das operadoras.
    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Relatorio_cadop.csv'
    into table operadoras_ativas
    fields terminated by ';'
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows;

-- Importar o aruivo CSV com os demonstrativos contábeis das operadoras nos anos de 2023 (4 arquivos).
    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/1T2023.csv'
    into table demonstracoes_contabeis
    fields terminated by ';'
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows
    (_DATA, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @VL_SALDO_INICIAL_, @VL_SALDO_FINAL_)
    set
    	VL_SALDO_INICIAL = REPLACE(@VL_SALDO_INICIAL_, ',', '.'),
    	VL_SALDO_FINAL = REPLACE(@VL_SALDO_FINAL_, ',', '.');

    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/2T2023.csv'
    into table demonstracoes_contabeis
    fields terminated by ";"
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows
    (_DATA, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @VL_SALDO_INICIAL_, @VL_SALDO_FINAL_)
    set
    	VL_SALDO_INICIAL = REPLACE(@VL_SALDO_INICIAL_, ',', '.'),
    	VL_SALDO_FINAL = REPLACE(@VL_SALDO_FINAL_, ',', '.');

    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/3T2023.csv'
    into table demonstracoes_contabeis
    fields terminated by ";"
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows
    (_DATA, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @VL_SALDO_INICIAL_, @VL_SALDO_FINAL_)
    set
    	VL_SALDO_INICIAL = REPLACE(@VL_SALDO_INICIAL_, ',', '.'),
    	VL_SALDO_FINAL = REPLACE(@VL_SALDO_FINAL_, ',', '.');

    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/4T2023.csv'
    into table demonstracoes_contabeis
    fields terminated by ";"
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows
    (_DATA, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @VL_SALDO_INICIAL_, @VL_SALDO_FINAL_)
    set
    	VL_SALDO_INICIAL = REPLACE(@VL_SALDO_INICIAL_, ',', '.'),
    	VL_SALDO_FINAL = REPLACE(@VL_SALDO_FINAL_, ',', '.');


    -- Agora os arquivos contábeis de 2024 (4 arquivos)

    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/1T2024.csv'
    into table demonstracoes_contabeis
    fields terminated by ";"
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows
    (_DATA, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @VL_SALDO_INICIAL_, @VL_SALDO_FINAL_)
    set
    	VL_SALDO_INICIAL = REPLACE(@VL_SALDO_INICIAL_, ',', '.'),
    	VL_SALDO_FINAL = REPLACE(@VL_SALDO_FINAL_, ',', '.');

    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/2T2024.csv'
    into table demonstracoes_contabeis
    fields terminated by ";"
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows
    (_DATA, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @VL_SALDO_INICIAL_, @VL_SALDO_FINAL_)
    set
    	VL_SALDO_INICIAL = REPLACE(@VL_SALDO_INICIAL_, ',', '.'),
    	VL_SALDO_FINAL = REPLACE(@VL_SALDO_FINAL_, ',', '.');

    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/3T2024.csv'
    into table demonstracoes_contabeis
    fields terminated by ";"
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows
    (_DATA, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @VL_SALDO_INICIAL_, @VL_SALDO_FINAL_)
    set
    	VL_SALDO_INICIAL = REPLACE(@VL_SALDO_INICIAL_, ',', '.'),
    	VL_SALDO_FINAL = REPLACE(@VL_SALDO_FINAL_, ',', '.');

    load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/4T2024.csv'
    into table demonstracoes_contabeis
    fields terminated by ";"
    enclosed by '"'
    lines terminated by '\n'
    ignore 1 rows
    (_DATA, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @VL_SALDO_INICIAL_, @VL_SALDO_FINAL_)
    set
    	VL_SALDO_INICIAL = REPLACE(@VL_SALDO_INICIAL_, ',', '.'),
    	VL_SALDO_FINAL = REPLACE(@VL_SALDO_FINAL_, ',', '.');


-- Filtar as 10 operadoras com maiores despesas no ultimo trimestre (considerando o ano de 2024)

select
    dc.REG_ANS,
    oa.Razao_Social,
    sum(dc.VL_SALDO_FINAL) as total_despesa
from demonstracoes_contabeis dc
join operadoras_ativas oa on dc.REG_ANS = oa.Registro_ANS
where dc.DESCRICAO like '%EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS  DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR %'
  and dc._DATA between '2024-01-01' and '2024-01-02'
group by dc.REG_ANS, oa.Razao_Social
order by total_despesa desc
LIMIT 10;


-- Filtro para 10 operadoras com maiores despesas nessa categoria (considerando o ano 2024)

select
    dc.REG_ANS,
    oa.Razao_Social,
    sum(dc.VL_SALDO_FINAL) as total_despesa
from demonstracoes_contabeis dc
join operadoras_ativas oa on dc.REG_ANS = oa.Registro_ANS
where dc.DESCRICAO like '%EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS  DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR %'
  and year(dc._DATA) = '2024'
group by dc.REG_ANS, oa.Razao_Social
order by total_despesa desc
LIMIT 10;