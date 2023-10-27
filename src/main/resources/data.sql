insert into "member" (username, password, email, activated) values ('admin1', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin@gmail.com', 1);
insert into "member" (username, password, email, activated) values ('user1', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user@gmail.com', 1);

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into user_authority (member_id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (member_id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (member_id, authority_name) values (2, 'ROLE_USER');