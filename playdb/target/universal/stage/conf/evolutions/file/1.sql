

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
  constraint pk_checklist primary key (id))
;

create table department (
  id                        bigint auto_increment not null,
  constraint pk_department primary key (id))
;

create table device (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  price                     float,
  introduced                timestamp,
  discontinued              timestamp,
  udi                       varchar(255),
  hudi                      varchar(255),
  sn                        varchar(255),
  jcks                      varchar(255),
  doctor_id                 bigint,
  constraint pk_device primary key (id))
;

create table doctor (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  department                varchar(255),
  constraint pk_doctor primary key (id))
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
  id                        bigint auto_increment not null,
  quantity                  bigint,
  price                     float,
  sale                      varchar(255),
  constraint pk_order_item primary key (id))
;

create table product (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  cname                     varchar(255),
  ename                     varchar(255),
  manufacturer              varchar(255),
  address                   varchar(255),
  model                     varchar(255),
  catalog                   varchar(255),
  regno                     varchar(255),
  regperiod                 datetime,
  mfno                      varchar(255),
  type                      varchar(255),
  xh                        bigint,
  country                   varchar(255),
  unit                      varchar(255),
  distribute                varchar(255),
  ship                      varchar(255),
  warranty                  datetime,
  measure                   boolean,
  period                    float,
  memo                      varchar(255),
  picture                   varbinary(255),
  created                   datetime NOT NULL COMMENT 'The permanent datetime when the article is created.',
  updated                   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'The datetime when the article is updated on.',
  constraint pk_product primary key (id))
;



create table purchase (
  id                        bigint auto_increment not null,
  department                varchar(255),
  employee                  varchar(255),
  constraint pk_purchase primary key (id))
;

create table stock_item (
  id                        bigint auto_increment not null,
  quantity                  bigint,
  udi                       varchar(255),
  sn                        varchar(255),
  constraint pk_stock_item primary key (id))
;

create table tag (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_tag primary key (id))
;

create index ix_checklist_device_1 on checklist (dev);
create index ix_checklist_doctor_2 on checklist (doctor_id);
create index ix_device_doctor_3 on device (doctor_id);



