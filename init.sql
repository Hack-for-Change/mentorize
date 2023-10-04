---- Create the mentorize database
--CREATE DATABASE mentorize;

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
    foreign key(login_id) references tb_login(id) on delete cascade,
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