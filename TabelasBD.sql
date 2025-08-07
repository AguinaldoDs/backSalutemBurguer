--| ingredientes
drop table if exists ingredientes;
create table ingredientes (
    id bigserial primary key,
    descricao varchar(200),
    preco_uni numeric,
    adicional boolean,
    ativo boolean default true,
    data_registro timestamp default current_timestamp
);

--| bebidas
drop table if exists bebidas;
create table bebidas (
    id bigserial primary key,
    descricao varchar(200),
    preco_uni numeric,
    zero_acucar boolean ,
    ativo boolean default true,
    data_registro timestamp default current_timestamp
);

--| lanche
drop table if exists lanche;
create table lanche (
    id bigserial primary key ,
    descricao varchar(200),
    ativo boolean default true,
    dataRegistro timestamp default current_timestamp
);

--| lanche
drop table if exists lanche_ingredientes;
create table lanche_ingredientes (
    id bigserial primary key ,
    id_lanche int,
    id_ingrediente int,
    descricao_ingrediente varchar(200),
    preco_ingrediente numeric,
    quantidade_padrao int,
    ativo boolean default true,
    dataRegistro timestamp default current_timestamp
);

--| pedidos
drop table if exists pedidos;
create table pedidos (
    id bigserial primary key,
    data_registro timestamp default current_timestamp
);

--| informações do cliente do pedido
drop table if exists informacoes_cliente_pedido;
create table informacoes_cliente_pedido (
    id bigserial primary key,
    id_pedido int,
    nome varchar(200),
    endereco varchar(300),
    telefone varchar(20),
    data_registro timestamp default current_timestamp
);

--| lanches do pedidos
drop table if exists pedido_item_lanche;
create table pedido_item_lanche (
    id bigserial primary key,
    id_pedido int,
    id_lanche int null,
    quantidade_lanche int null,
    dataRegistro timestamp default current_timestamp
);

--| bebidas do pedido
drop table if exists pedido_item_bebida;
create table pedido_item_bebida (
    id bigserial primary key,
    id_pedido int,
    id_bebida int null,
    quantidade_bebida int null,
    dataRegistro timestamp default current_timestamp
);







