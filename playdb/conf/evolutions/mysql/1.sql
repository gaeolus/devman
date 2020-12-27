 --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups


create table checklist (
  id                        bigint auto_increment not null,
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
  constraint pk_checklist primary key (id)) engine=innodb
;

create table device (
  id                        bigint auto_increment not null,
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
  constraint pk_device primary key (id)) engine=innodb
;

create table doctor (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  department                varchar(255),
  constraint pk_doctor primary key (id)) engine=innodb
;

create table fee (
  id                        bigint auto_increment not null,
  sjid                      integer,
  ylxh                      integer,
  yldj                      float,
  ylsl                      integer,
  hjje                      float,
  constraint pk_fee primary key (id)) engine=innodb
;

create index ix_checklist_device_1 on checklist (dev);
create index ix_checklist_doctor_2 on checklist (doctor_id);
create index ix_device_doctor_3 on device (doctor_id);

alter table play_evolutions modify apply_script longtext;
alter table play_evolutions modify revert_script longtext;


# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table checklist;

drop table device;

drop table doctor;
drop table fee;

delete from play_evolutions;

alter table play_evolutions modify apply_script text;
alter table play_evolutions modify revert_script text;


SET FOREIGN_KEY_CHECKS=1;

