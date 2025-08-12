CREATE TABLE student (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    grade CHAR(1),
    classroom CHAR(1)
);

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE loan (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,
    loaned BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_loan_student FOREIGN KEY (student_id) REFERENCES student (id),
    CONSTRAINT fk_loan_book FOREIGN KEY (book_id) REFERENCES book (id)
);