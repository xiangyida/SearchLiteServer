create table login_records
(
    id      bigint auto_increment
        primary key,
    user_id bigint                              null,
    time    timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    charset = utf8;


create table problem
(
    problem_id           int          not null
        primary key,
    title                varchar(255) null,
    knowledge_point      varchar(255) null,
    comeout              varchar(255) null,
    problem_picture_name varchar(255) null,
    picture_answer       varchar(50)  null
)
    charset = utf8;


create table search_records
(
    id         bigint auto_increment
        primary key,
    user_id    bigint                              null,
    problem_id varchar(255)                        not null,
    view_time  timestamp default CURRENT_TIMESTAMP null
)
    charset = utf8;


create table user
(
    id      bigint auto_increment
        primary key,
    open_id varchar(255)                        null,
    name    varchar(255)                        not null,
    time    timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint user_open_id_uindex
        unique (open_id)
)
    charset = utf8;

