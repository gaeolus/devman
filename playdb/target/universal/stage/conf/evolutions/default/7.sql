# --- !Ups
SET FOREIGN_KEY_CHECKS=0;

insert into department(id,name) select distinct department_id,dept_name from equipment;

INSERT INTO user(id,name,code,pwd,dept,gender) VALUES (1,'use1-name','use1','use1-pass',1,'0');
INSERT INTO user(id,name,code,pwd,dept,gender) VALUES (2,'use2-name','use2','use2-pass',2,'0');
INSERT INTO user(id,name,code,pwd,dept,gender) VALUES (3,'use3-name','use3','use3-pass',3,'0');
INSERT INTO user(id,name,code,pwd,dept,gender) VALUES (4,'use4-name','use4','use4-pass',4,'0');
INSERT INTO user(id,name,code,pwd,dept,gender) VALUES (5,'use5-name','use5','use5-pass',5,'0');
INSERT INTO user(id,name,code,pwd,dept,gender,role_id ) VALUES (6,'eng-name','use6','use6-pass',1,'0',3001);



SET FOREIGN_KEY_CHECKS=1;


# --- !Downs
SET FOREIGN_KEY_CHECKS=0;

delete from department;
INSERT INTO department(id,name,manager_id,engineer_id,parent_id) VALUES (1,'设备科',1,6,0);
INSERT INTO department(id,name,manager_id,engineer_id,parent_id) VALUES (2,'眼科',2,6,0);
INSERT INTO department(id,name,manager_id,engineer_id,parent_id) VALUES (3,'超声科',3,6,0);
INSERT INTO department(id,name,manager_id,engineer_id,parent_id) VALUES (4,'检验科',4,6,0);
INSERT INTO department(id,name,manager_id,engineer_id,parent_id) VALUES (5,'放射科',5,6,0);

delete from play_evolutions;

SET FOREIGN_KEY_CHECKS=1;