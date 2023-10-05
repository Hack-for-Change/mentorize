-- Create tables

CREATE TABLE IF NOT EXISTS tb_login (
    id UUID PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    phone VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tb_register (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    photo VARCHAR(255),
    document VARCHAR(255),
    email VARCHAR(255),
    teacher VARCHAR,
    login_id UUID not null,
    foreign key(login_id) references tb_login(id) on delete cascade
);
CREATE TABLE IF NOT EXISTS tb_schedule (
    id UUID PRIMARY KEY,
    class_number int,
    local_type VARCHAR(255),
    details_local VARCHAR(255),
    class_theme VARCHAR(255),
    email VARCHAR(255),
    available_days VARCHAR(255) not null,
    available_hours VARCHAR(255) not null,
    teacher_id UUID not null,
    foreign key(teacher_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_category (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    schedule_id UUID not null,
    foreign key(schedule_id) references tb_schedule(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_review (
    id UUID PRIMARY KEY,
    score int not null,
    comment VARCHAR(255),
    review_date date not null,
    student_id UUID not null,
    foreign key(student_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_checkin (
    id UUID PRIMARY KEY,
    start_date date not null,
    student_id UUID not null,
    foreign key(student_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_checkout (
    id UUID PRIMARY KEY,
    end_date date not null,
    student_id UUID not null,
    review_id UUID not null,
    foreign key(review_id) references tb_review(id) on delete cascade,
    foreign key(student_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_schedule (
    id UUID PRIMARY KEY,
    class_number int,
    local_type VARCHAR(255),
    details_local VARCHAR(255),
    class_theme VARCHAR(255),
    email VARCHAR(255),
    available_days VARCHAR(255) not null,
    available_hours VARCHAR(255) not null,
    teacher_id UUID not null,
    foreign key(teacher_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_category_schedule(
    schedule_id UUID not null,
    category_id UUID not null,
    primary key(schedule_id, category_id),
    foreign key(schedule_id) references tb_schedule(id) on delete cascade,
    foreign key(category_id) references tb_category(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_checkin_register(
    checkin_id UUID not null,
    student_id UUID not null,
    primary key(student_id, checkin_id),
    foreign key(student_id) references tb_register(id) on delete cascade,
    foreign key(checkin_id) references tb_checkin(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_checkout_register_review(
    checkout_id UUID not null,
    student_id UUID not null,
    review_id UUID not null,
    primary key(student_id, checkout_id, review_id),
    foreign key(student_id) references tb_register(id) on delete cascade,
    foreign key(checkout_id) references tb_checkout(id) on delete cascade,
    foreign key(review_id) references tb_review(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_login_register(
    login_id UUID not null,
    register_id UUID not null,
    primary key(register_id, login_id),
    foreign key(register_id) references tb_register(id) on delete cascade,
    foreign key(login_id) references tb_login(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_review_register(
    review_id UUID not null,
    student_id UUID not null,
    primary key(student_id, review_id),
    foreign key(student_id) references tb_register(id) on delete cascade,
    foreign key(review_id) references tb_review(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_schedule_register(
    schedule_id UUID not null,
    teacher_id UUID not null,
    primary key(teacher_id, schedule_id),
    foreign key(teacher_id) references tb_register(id) on delete cascade,
    foreign key(schedule_id) references tb_schedule(id) on delete cascade
);
INSERT INTO public.tb_login
(id, email, "password", phone)
VALUES('3626af2f-329b-4e98-b116-2b1ad0468db4'::uuid, 'angela@mentorize.com.br', 'v1PF5WXhtkfgN6Ld3PaS8CQwvhAwkfbWFftfeeCZs+zBFR5pkeiBMg0r4UfL6hc8', '1132326658');
INSERT INTO public.tb_login
(id, email, "password", phone)
VALUES('c15c0dc6-d811-4d19-ac4d-282477fc8338'::uuid, 'th@mentorize.com.br', 'iPdCQ95GjI0q39ghtT32y0XTv2zIpuTeSNx6XCgh5OygmyCgzDHM5aJY3RUs2SOf', '1132326658');
INSERT INTO public.tb_login
(id, email, "password", phone)
VALUES('ea587dc7-60cb-4dfd-b503-ccc375bd90e8'::uuid, 'joao@mentorize.com.br', 'wphFM7NII121Qo3Jl1EPrWW74aCHjDPc3aKzdcYU4lTH3hmKkTBKa1TRZmxRIOuB', '1132326658');
INSERT INTO public.tb_login
(id, email, "password", phone)
VALUES('cf9a1f28-6d27-4b74-ac44-fbdbf340e90e'::uuid, 'will@mentorize.com.br', 'YCipZsggxT8NJ93MdBSfBhEwRRPTutSXty5aSmLjSodFyN5SuB5g5RlGnJAC/gKz', '1132326658');
INSERT INTO public.tb_register
(id, "name", photo, "document", email, teacher, login_id)
VALUES('eeee95ce-ed54-40f1-a42e-f90ed1ac31f4'::uuid, 'João Pedro', 'https://github.com/Thcamposmartins.png', '111111111-11', 'joao@mentorize.com.br', 'true', 'ea587dc7-60cb-4dfd-b503-ccc375bd90e8'::uuid);
INSERT INTO public.tb_register
(id, "name", photo, "document", email, teacher, login_id)
VALUES('3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid, 'Thais', 'https://github.com/Thcamposmartins.png', '111111111-11', 'th@mentorize.com.br', 'false', 'c15c0dc6-d811-4d19-ac4d-282477fc8338'::uuid);
INSERT INTO public.tb_register
(id, "name", photo, "document", email, teacher, login_id)
VALUES('5044717f-7b54-49a1-b92a-bd47fc96a79a'::uuid, 'Thais', 'https://github.com/Thcamposmartins.png', '111111111-11', 'will@mentorize.com.br', 'true', 'cf9a1f28-6d27-4b74-ac44-fbdbf340e90e'::uuid);
INSERT INTO public.tb_schedule
(id, class_number, local_type, details_local, class_theme, email, available_days, available_hours, teacher_id)
VALUES('ee8398a1-afa4-4997-ad0f-cee22f220977'::uuid, 10, 'Presencial', 'Praça Igreja Matriz', 'Yoga', 'th@mentorize.com.br', '2023-10-04', '14:30:00', '3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid);
INSERT INTO public.tb_schedule
(id, class_number, local_type, details_local, class_theme, email, available_days, available_hours, teacher_id)
VALUES('71894fdc-d77a-44b3-b268-f13605b31efc'::uuid, 10, 'Presencial', 'Praça Igreja Matriz', 'Yoga', 'joao@mentorize.com.br', '2023-10-04', '14:30:00', 'eeee95ce-ed54-40f1-a42e-f90ed1ac31f4'::uuid);
INSERT INTO public.tb_schedule
(id, class_number, local_type, details_local, class_theme, email, available_days, available_hours, teacher_id)
VALUES('6f0162b1-9725-4c1c-91fa-1f29b73bfe6d'::uuid, 5, 'Presencial', 'Quadra Municipal', 'Basquete', 'will@mentorize.com.br', '2023-10-10', '14:30:00', '5044717f-7b54-49a1-b92a-bd47fc96a79a'::uuid);
INSERT INTO public.tb_checkin
(id, start_date, student_id)
VALUES('a1e33149-5fd5-4ebe-b031-ed81a74cc408'::uuid, '2023-10-04', '3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid);
INSERT INTO public.tb_review
(id, score, "comment", review_date, student_id)
VALUES('7ecfdda2-11a3-4d08-901d-ce871822fd7a'::uuid, 2, 'Não gostei muito, o professor nao abre para questionamentos', '2023-10-04', '3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid);
INSERT INTO public.tb_review
(id, score, "comment", review_date, student_id)
VALUES('7f7e3584-8ac8-4e13-8b84-ba26a38d4769'::uuid, 2, 'Não gostei muito, o professor nao abre para questionamentos', '2023-10-04', '3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid);
INSERT INTO public.tb_review
(id, score, "comment", review_date, student_id)
VALUES('e2701aa2-cbf0-4e3a-b6e0-1dabc8ceaad0'::uuid, 5, 'Otima, Aula', '2023-10-04', '3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid);
INSERT INTO public.tb_checkout
(id, end_date, student_id, review_id)
VALUES('3b75d662-75e7-47b8-9f62-a4e4ce7765d9'::uuid, '2023-10-04', '3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid, '7ecfdda2-11a3-4d08-901d-ce871822fd7a'::uuid);
INSERT INTO public.tb_checkout
(id, end_date, student_id, review_id)
VALUES('f568a38c-3934-499d-ac48-988141d74193'::uuid, '2023-10-04', '3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid, '7f7e3584-8ac8-4e13-8b84-ba26a38d4769'::uuid);
INSERT INTO public.tb_checkout
(id, end_date, student_id, review_id)
VALUES('a24c26b2-847c-40f4-8df5-edfbbb608b34'::uuid, '2023-10-04', '3d9cd75e-379e-4eb7-acee-b1927c153490'::uuid, 'e2701aa2-cbf0-4e3a-b6e0-1dabc8ceaad0'::uuid);
