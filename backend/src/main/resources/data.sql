INSERT INTO user(personName) VALUES('Israel');

INSERT INTO diet(name_identifier, user_id) VALUES("",1);

INSERT INTO meal(meal_type, diet_id) VALUES(0, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(1, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(2, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(3, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(4, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(5, 1);

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);
