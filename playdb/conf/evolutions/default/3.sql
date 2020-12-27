# --- Sample dataset

# --- !Ups
SET FOREIGN_KEY_CHECKS=0;

insert into device(id,name,jcks,introduced,discontinued) select distinct dev,sbmc,jcks,now(),now() from checklist;

insert into doctor(id,name,department) select distinct doctor_id,zxysxm,jcks from checklist;

SET FOREIGN_KEY_CHECKS=1;


# --- !Downs
SET FOREIGN_KEY_CHECKS=0;

delete from device;
delete from doctor;
delete from play_evolutions;

SET FOREIGN_KEY_CHECKS=1;
