INSERT INTO student (name, email, grade, classroom) VALUES ('Maria Silva', 'maria.silva@email.com', '9', 'A');
INSERT INTO student (name, email, grade, classroom) VALUES ('João Souza', 'joao.souza@email.com', '8', 'B');
INSERT INTO student (name, email, grade, classroom) VALUES ('Ana Costa', 'ana.costa@email.com', '7', 'C');
INSERT INTO student (name, email, grade, classroom) VALUES ('Pedro Santos', 'pedro.santos@email.com', '6', 'D');

INSERT INTO book (title, author, available) VALUES ('O Senhor dos Anéis', 'J.R.R. Tolkien', 1);
INSERT INTO book (title, author, available) VALUES ('Dom Casmurro', 'Machado de Assis', 1);
INSERT INTO book (title, author, available) VALUES ('Clean Code', 'Robert C. Martin', 1);
INSERT INTO book (title, author, available) VALUES ('1984', 'George Orwell', 0);
INSERT INTO book (title, author, available) VALUES ('O Hobbit', 'J.R.R. Tolkien', 1);

INSERT INTO loan (student_id, book_id, loan_date, return_date, loaned) VALUES (1, 1, '2025-08-01', '2025-08-08', TRUE);
INSERT INTO loan (student_id, book_id, loan_date, return_date, loaned) VALUES (2, 2, '2025-08-05', '2025-08-12', TRUE);
INSERT INTO loan (student_id, book_id, loan_date, return_date, loaned) VALUES (3, 3, '2025-08-10', '2025-08-17', TRUE);
INSERT INTO loan (student_id, book_id, loan_date, return_date, loaned) VALUES (4, 4, '2025-08-12', '2025-08-19', FALSE);
INSERT INTO loan (student_id, book_id, loan_date, return_date, loaned) VALUES (1, 5, '2025-08-15', '2025-08-22', TRUE);
