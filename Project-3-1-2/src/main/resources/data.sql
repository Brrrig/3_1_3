insert into 2_2_3.roles (role) values ('ROLE_ADMIN');
insert into 2_2_3.roles (role) values ('ROLE_USER');

insert into 2_2_3.users (email, last_name, age, name, password) VALUES ('kurt@666.com', 'Cobain', 27, 'Kurt', '$2a$10$cuEoA9shZ8rHPrctA6KlN.SqXTNmlBfsKsHgqm/F69/02xQg9hfb6');
insert into 2_2_3.users (email, last_name, age, name, password) VALUES ('janis@666.com', 'Joplin', 27, 'Janis', '$2a$10$Wn/SNtfDfS.6UmqsF.psEeUEfpO05hVqz5Vqy236zddF4u8JCoTJe');

insert into 2_2_3.users_roles (user_id, roles_id) VALUES (1, 1);
insert into 2_2_3.users_roles (user_id, roles_id) VALUES (2, 1);
insert into 2_2_3.users_roles (user_id, roles_id) VALUES (2, 2);
