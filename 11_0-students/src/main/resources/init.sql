insert into Student values(1, 'Per');
insert into Student values(2, 'Kari');
insert into Student values(3, 'Lars');

insert into Subject values(1, 'Enterprise programmering 2', 'PG6100');
insert into Subject values(2, 'Undersøkelsesmetoder', 'PJ6100');
insert into Subject values(3, 'Hovedprosjekt', 'PJ6000');

-- Per
insert into Subject_Student (Student_id, Subject_id) values(1, 1);
insert into Subject_Student (Student_id, Subject_id) values(1, 2);
insert into Subject_Student (Student_id, Subject_id) values(1, 3);

-- Kari
insert into Subject_Student (Student_id, Subject_id) values(2, 1);
insert into Subject_Student (Student_id, Subject_id) values(2, 3);

-- Lars
insert into Subject_Student (Student_id, Subject_id) values(3, 1);
insert into Subject_Student (Student_id, Subject_id) values(3, 2);
