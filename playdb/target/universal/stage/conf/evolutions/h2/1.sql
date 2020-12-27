 --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table checklist (
  id                        bigint not null,
  yjxh                      integer,
  tjhm                      varchar(255),
  brxz                      varchar(255),
  mzhm                      varchar(255),
  zyhm                      varchar(255),
  brxm                      varchar(255),
  brid                      integer,
  kdrq                      timestamp,
  kdys                      varchar(255),
  ksmc                      varchar(255),
  jcrq                      timestamp,
  jcks                      varchar(255),
  zxpb                      integer,
  zxrq                      timestamp,
  zxysxm                    varchar(255),
  doctor_id                 bigint,
  sybz                      integer,
  fymc                      varchar(255),
  fyxh                      integer,
  dev                       bigint,
  sbmc                      varchar(255),
  constraint pk_checklist primary key (id))
;

create table device (
  id                        bigint not null,
  name                      varchar(255),
  gname                     varchar(255),
  manufacturer              varchar(255),
  model                     varchar(255),
  reg                       varchar(255),
  price                     float,
  introduced                timestamp,
  discontinued              timestamp,
  catalog                   bigint,
  udi                       varchar(255),
  hudi                      varchar(255),
  sn                        varchar(255),
  jcks                      varchar(255),
  doctor_id                 bigint,
  constraint pk_device primary key (id))
;

create table doctor (
  id                        bigint not null,
  name                      varchar(255),
  department                varchar(255),
  constraint pk_doctor primary key (id))
;

create table fee (
  id                        bigint serial not null,
  sjid                      integer,
  ylxh                      integer,
  yldj                      float,
  ylsl                      integer,
  hjje                      float,
  constraint pk_fee primary key (id))
;

create sequence checklist_seq;

create sequence device_seq;

create sequence doctor_seq;

create sequence fee_seq;

--alter table checklist add constraint fk_checklist_doctor_1 foreign key (doctor_id) references doctor (id) on delete restrict on update restrict;
create index ix_checklist_doctor_1 on checklist (doctor_id);
--alter table device add constraint fk_device_doctor_2 foreign key (doctor_id) references doctor (id) on delete restrict on update restrict;
create index ix_device_doctor_2 on device (doctor_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists checklist;

drop table if exists device;

drop table if exists doctor;

drop table if exists fee;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists checklist_seq;

drop sequence if exists device_seq;

drop sequence if exists doctor_seq;

drop sequence if exists fee_seq;

