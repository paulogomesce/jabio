create table usuario_sistema(
  id serial not null,
  nome varchar(100) not null,
  login varchar(50) not null,
  senha varchar(100) not null,
  habilitado boolean not null,
  constraint "pk_usuario_sistema_id" primary key(id)
);

create unique index "idx_usuario_sistema_login" on usuario_sistema(login);

create table perfil_sistema(
  id serial not null,
  nome varchar(50) not null,
  descricao varchar(255) not null,
  constraint "pk_perfil_sistema_id" primary key (id)
);

create unique index "idx_perfil_sistema_nome" on perfil_sistema(nome);

create table usuario_perfil_sistema(
  usuario_id integer not null,
  perfil_sistema_id integer not null,
  constraint "fk_usuario_perfil" foreign key(usuario_id) references usuario_sistema(id),
  constraint "fk_perfil_usuario" foreign key(perfil_sistema_id) references perfil_sistema(id)
);

--Inserção de Perfies
insert into perfil_sistema(nome, descricao) values
('ROLE_ADMIN','Perfil de Administrador. Tem Acesso a todas as funções do sitema');
insert into perfil_sistema(nome, descricao) values
('ROLE_CONVIDADO','Perfil de Convidados');
insert into perfil_sistema(nome, descricao) values
('ROLE_VISITANTE','Perfil de Visitante');

--Inserção de Usuários
Insert into usuario_sistema(nome, login, senha, habilitado) values
('Administrador', 'admin', 'admin', true);
Insert into usuario_sistema(nome, login, senha, habilitado) values
('Convidado', 'convidado', 'convidado', true);
Insert into usuario_sistema(nome, login, senha, habilitado) values
('Visitante', 'visitante', 'visitante', true);

--Associação do Usuários aos Perfies
insert into usuario_perfil_sistema(usuario_id, perfil_sistema_id) values
(1, 1);
insert into usuario_perfil_sistema(usuario_id, perfil_sistema_id) values
(3, 2);
insert into usuario_perfil_sistema(usuario_id, perfil_sistema_id) values
(4, 6);

select * from perfil_sistema
select * from usuario_sistema
select * from usuario_perfil_sistema

select login, senha, habilitado from usuario_sistema where login = ?
select us.login, ps.nome
  from usuario_sistema us, perfil_sistema ps, usuario_perfil_sistema ups
 where us.id = ups.usuario_id
   and ps.id = ups.perfil_sistema_id
   and us.login = 

select md5('visitante')

