insert into blog(id, title) values (1, 'Titre 1');
insert into blog(id, title) values (2, 'Titre 2');

insert into tag(id, name) values (1, 'groovy');
insert into tag(id, name) values (2, 'javascript');
insert into tag(id, name) values (3, 'opinion');
insert into tag(id, name) values (4, 'web');

insert into blog_tag(id_blog, id_tag) values (1, 1);
insert into blog_tag(id_blog, id_tag) values (1, 3);
insert into blog_tag(id_blog, id_tag) values (1, 4);

insert into blog_tag(id_blog, id_tag) values (2, 2);
insert into blog_tag(id_blog, id_tag) values (2, 4);



