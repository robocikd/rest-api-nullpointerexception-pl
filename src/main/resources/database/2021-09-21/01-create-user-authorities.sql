--liquibase formatted sql
--changeset RobocikD:4
create table users
(
    id       BIGINT AUTO_INCREMENT primary key,
    username varchar(50)  not null unique,
    password varchar(150) not null,
    enabled  boolean      not null
);
--changeset RobocikD:5
create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references
        users (username),
    unique key username_authority (username, authority)
);
--changeset RobocikD:6
insert into users (id, username, password, enabled)
values (1, 'test', '{bcrypt}$2a$10$W.ar48Q2oYjILVxNUi6HZuyn3puVrr7wGzzsyScj5ikBXU0VBNgKK', true);

insert into authorities (username, authority)
values ('test', 'USER');