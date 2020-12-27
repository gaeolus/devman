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

create table department (
  id                        bigint not null,
  name                      varchar(255),
  manager_id                bigint,
  nurse_station_tel         varchar(255),
  engineer_id               bigint,
  icon                      varchar(255),
  parent_id                 bigint,
  ord                       integer,
  remark                    varchar(255)/*,
  constraint pk_department primary key (id)*/)
;

create table device (
  id                        bigint not null,
  name                      varchar(255),
  cname                     varchar(255),
  manufacturer              varchar(255),
  regno                     varchar(255),
  model                     varchar(255),
  udi                       varchar(255),
  hudi                      varchar(255),
  sn                        varchar(255),
  status                    varchar(255),
  price                     float,
  catalog                   bigint,
  warranty                  timestamp,
  measure                   boolean,
  introduced                timestamp,
  discontinued              timestamp,
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

create table equipment (
  id                        bigint not null,
  equ_name                  varchar(255),
  cname                     varchar(255),
  factory_name              varchar(255),
  factory_id                bigint,
  regno                     varchar(255),
  specification             varchar(255),
  udi                       varchar(255),
  manufacturedate           timestamp,
  serial_number             varchar(255),
  osnumber                  varchar(255),
  ibnumber                  varchar(255),
  equ_no                    varchar(255),
  record                    varchar(255),
  xh                        bigint,
  country                   varchar(255),
  created                   timestamp,
  updated                   timestamp,
  unit                      varchar(255),
  bar                       varchar(255),
  saler                     varchar(255),
  word_name                 varchar(255),
  category_id               bigint,
  warranty                  timestamp,
  equipment_disuse          varchar(255),
  is_warranty               varchar(255),
  repair_status             varchar(255),
  supplier_id               bigint,
  supplier_name             varchar(255),
  service_begin             timestamp,
  service_end               timestamp,
  status_name               varchar(255),
  state                     varchar(255),
  installdate               timestamp,
  discontinued              timestamp,
  disno                     varchar(255),
  buy_money                 float,
  dept_name                 varchar(255),
  department_id             bigint,
  equput                    varchar(255),
  depart_person             varchar(255),
  depart_person_tel         varchar(255),
  remark                    varchar(255),
  constraint pk_equipment primary key (id))
;

create table fee (
  id                        bigint auto_increment not null,
  sjid                      integer,
  ylxh                      integer,
  yldj                      float,
  ylsl                      integer,
  hjje                      float,
  constraint pk_fee primary key (id))
;

create table order_item (
  id                        bigint not null,
  purchase_id               bigint,
  product_id                bigint,
  quantity                  bigint,
  price                     float,
  sale                      varchar(255),
  constraint pk_order_item primary key (id))
;

create table product (
  id                        bigint not null,
  name                      varchar(255),
  cname                     varchar(255),
  ename                     varchar(255),
  manufacturer              varchar(255),
  address                   varchar(255),
  model                     varchar(255),
  catalog                   varchar(255),
  regno                     varchar(255),
  regperiod                 timestamp,
  mfno                      varchar(255),
  type                      varchar(255),
  xh                        bigint,
  country                   varchar(255),
  unit                      varchar(255),
  distribute                varchar(255),
  ship                      varchar(255),
  warranty                  timestamp,
  measure                   boolean,
  period                    float,
  memo                      varchar(255),
  picture                   varbinary(255),
  created                   timestamp not null,
  updated                   timestamp not null,
  constraint pk_product primary key (id))
;

create table purchase (
  id                        bigint not null,
  department                varchar(255),
  employee                  varchar(255),
  amount                    float,
  status                    varchar(255),
  created                   timestamp not null,
  constraint pk_purchase primary key (id))
;

create table repair (
  id                        bigint auto_increment not null,
  department_id             bigint,
  equ_code                  varchar(255),
  equ_name                  varchar(255),
  equipment_gg              varchar(255),
  fault_description         varchar(255),
  repair_date               timestamp,
  repair_person             varchar(255),
  repair_tel                varchar(255),
  mainten_date              timestamp,
  repair_status             varchar(255),
  remark                    varchar(255),
  create_name               varchar(255),
  constraint pk_repair primary key (id))
;

create table stock_item (
  id                        bigint not null,
  quantity                  bigint,
  udi                       varchar(255),
  sn                        varchar(255),
  constraint pk_stock_item primary key (id))
;

create table tag (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_tag primary key (id))
;

create table user (
  id                        bigint not null,
  name                      varchar(255),
  code                      varchar(255),
  pwd                       varchar(255),
  dept                      bigint,
  gender                    integer,
  positions                 integer,
  manager                   bigint,
  mobile                    varchar(255),
  tel                       varchar(255),
  email                     varchar(255),
  birthday                  varchar(255),
  remark                    varchar(255),
  role_id                   bigint,
  status                    varchar(255),
  constraint pk_user primary key (id))
;

create sequence checklist_seq;

create sequence department_seq;

create sequence device_seq;

create sequence doctor_seq;

create sequence equipment_seq;

create sequence fee_seq;

create sequence order_item_seq;

create sequence product_seq;

create sequence purchase_seq;

create sequence repair_seq;

create sequence stock_item_seq;

create sequence tag_seq;

create sequence user_seq;

alter table checklist add constraint fk_checklist_doctor_1 foreign key (doctor_id) references doctor (id) on delete restrict on update restrict;
create index ix_checklist_doctor_1 on checklist (doctor_id);
alter table device add constraint fk_device_doctor_2 foreign key (doctor_id) references doctor (id) on delete restrict on update restrict;
create index ix_device_doctor_2 on device (doctor_id);
alter table order_item add constraint fk_order_item_purchase_3 foreign key (purchase_id) references purchase (id) on delete restrict on update restrict;
create index ix_order_item_purchase_3 on order_item (purchase_id);
alter table order_item add constraint fk_order_item_product_4 foreign key (product_id) references product (id) on delete restrict on update restrict;
create index ix_order_item_product_4 on order_item (product_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists checklist;

drop table if exists department;

drop table if exists device;

drop table if exists doctor;

drop table if exists equipment;

drop table if exists fee;

drop table if exists order_item;

drop table if exists product;

drop table if exists purchase;

drop table if exists repair;

drop table if exists stock_item;

drop table if exists tag;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists checklist_seq;

drop sequence if exists department_seq;

drop sequence if exists device_seq;

drop sequence if exists doctor_seq;

drop sequence if exists equipment_seq;

drop sequence if exists fee_seq;

drop sequence if exists order_item_seq;

drop sequence if exists product_seq;

drop sequence if exists purchase_seq;

drop sequence if exists repair_seq;

drop sequence if exists stock_item_seq;

drop sequence if exists tag_seq;

drop sequence if exists user_seq;

