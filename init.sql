---- Create the mentorize database
CREATE DATABASE mentorize;

-- Connect to the mentorize database
\c mentorize;

-- Create the tb_category table
CREATE TABLE IF NOT EXISTS tb_category (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    teacher_id UUID not null,
    foreign key(teacher_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_checkin (
    id UUID PRIMARY KEY,
    startDate date not null,
    student_id UUID not null,
    foreign key(student_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_checkout (
    id UUID PRIMARY KEY,
    endDate date not null,
    student_id UUID not null,
    review_id UUID not null,
    foreign key(review_id) references tb_review(id) on delete cascade,
    foreign key(student_id) references tb_register(id) on delete cascade
);

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
    teacher numeric,
    classTheme VARCHAR(255),
    login_id UUID not null,
    foreign key(login_id) references tb_login(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_review (
    id UUID PRIMARY KEY,
    score numeric not null,
    comment VARCHAR(255),
    reviewDate date not null,
    student_id UUID not null,
    foreign key(student_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_schedule (
    id UUID PRIMARY KEY,
    classNumber numeric not null,
    localType VARCHAR(255),
    detailsLocal VARCHAR(255),
    availableDays date not null,
    availableHours date not null,
    teacher_id UUID not null,
    foreign key(teacher_id) references tb_register(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_category_register(
    teacher_id UUID not null,
    category_id UUID not null,
    primary key(teacher_id, category_id),
    foreign key(teacher_id) references tb_register(id) on delete cascade,
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