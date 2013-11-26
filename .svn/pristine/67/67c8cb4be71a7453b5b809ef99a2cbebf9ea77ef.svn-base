# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table alumno (
  id                        bigint not null,
  codigo                    bigint,
  nombres                   varchar(255),
  apellidos                 varchar(255),
  genero                    varchar(255),
  fecha                     timestamp,
  residencia                varchar(255),
  provincia                 varchar(255),
  escuela                   varchar(255),
  user                      varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  created                   timestamp,
  updated                   timestamp,
  constraint pk_alumno primary key (id))
;

create table clase (
  id                        bigint not null,
  titulo                    varchar(255),
  descripcion               varchar(255),
  file                      varchar(255),
  created                   timestamp,
  updated                   timestamp,
  curso_id                  bigint,
  constraint pk_clase primary key (id))
;

create table curso (
  id                        bigint not null,
  name                      varchar(255),
  ciclo                     integer,
  creditos                  integer,
  grupo                     integer,
  created                   timestamp,
  updated                   timestamp,
  profesor_id               bigint,
  constraint pk_curso primary key (id))
;

create table matricula (
  id                        bigint not null,
  tipo_alumno_id            bigint,
  tipo_curso_id             bigint,
  constraint pk_matricula primary key (id))
;

create table noticia (
  id                        bigint not null,
  titulo                    varchar(255),
  contenido                 varchar(255),
  imagen                    varchar(255),
  escuela                   varchar(255),
  created                   timestamp,
  updated                   timestamp,
  constraint pk_noticia primary key (id))
;

create table profesor (
  id                        bigint not null,
  dni                       bigint,
  nombres                   varchar(255),
  apellidos                 varchar(255),
  fecha                     timestamp,
  email                     varchar(255),
  user                      varchar(255),
  password                  varchar(255),
  created                   timestamp,
  updated                   timestamp,
  constraint pk_profesor primary key (id))
;

create sequence alumno_seq;

create sequence clase_seq;

create sequence curso_seq;

create sequence matricula_seq;

create sequence noticia_seq;

create sequence profesor_seq;

alter table clase add constraint fk_clase_curso_1 foreign key (curso_id) references curso (id) on delete restrict on update restrict;
create index ix_clase_curso_1 on clase (curso_id);
alter table curso add constraint fk_curso_profesor_2 foreign key (profesor_id) references profesor (id) on delete restrict on update restrict;
create index ix_curso_profesor_2 on curso (profesor_id);
alter table matricula add constraint fk_matricula_tipoAlumno_3 foreign key (tipo_alumno_id) references alumno (id) on delete restrict on update restrict;
create index ix_matricula_tipoAlumno_3 on matricula (tipo_alumno_id);
alter table matricula add constraint fk_matricula_tipoCurso_4 foreign key (tipo_curso_id) references curso (id) on delete restrict on update restrict;
create index ix_matricula_tipoCurso_4 on matricula (tipo_curso_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists alumno;

drop table if exists clase;

drop table if exists curso;

drop table if exists matricula;

drop table if exists noticia;

drop table if exists profesor;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists alumno_seq;

drop sequence if exists clase_seq;

drop sequence if exists curso_seq;

drop sequence if exists matricula_seq;

drop sequence if exists noticia_seq;

drop sequence if exists profesor_seq;

