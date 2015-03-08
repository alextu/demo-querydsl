create table if not exists blog(id integer not null, title varchar not null);
create table if not exists blog_tag(id_tag integer not null, id_blog integer not null);
create table if not exists tag(id integer not null, name varchar not null);