
insert into client(id, name, created_date, last_updated_date)
values(1,'German', now(), now());
insert into client(id, name, created_date, last_updated_date)
values(2,'Toma', now(), now());
insert into client(id, name, created_date, last_updated_date)
values(3,'Facundo', now(), now());

insert into country_code(id,code,name)
values(1,'ARGENTINA','+54');
insert into country_code(id,code,name)
values(2,'BRASIL','+55');
insert into country_code(id,code,name)
values(3,'CHILE','+56');

insert into phone(id,description,number,country_code_id)
values(1,'Home Phone','0303456',1);
insert into phone(id,description,number,country_code_id)
values(2,'Work Phone','897516478',1);
insert into phone(id,description,number,country_code_id)
values(3,'Work Phone','1234567',2);
insert into phone(id,description,number,country_code_id)
values(4,'Home Phone','48896325',3);

insert into address(id,	description, street, number, floor,client_id)
values(1,'Home', '9 de Julio','1481','',1);
insert into address(id,	description, street, number, floor,client_id)
values(2,'Home', 'Avenida vieira souto','123','3',2);
insert into address(id,	description, street, number, floor,client_id)
values(3,'Home', 'Huerfanos','1915','3',3);

insert into phone_client(phone_id,client_id)
values(1,1);
insert into phone_client(phone_id,client_id)
values(2,2);
insert into phone_client(phone_id,client_id)
values(3,3);
