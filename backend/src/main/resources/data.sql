INSERT INTO user(person_name) VALUES ('Israel');

INSERT INTO diet(user_id, name_identifier) VALUES (1, 'Segunda');

INSERT INTO meal(meal_type, diet_id) VALUES(0, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(1, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(2, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(3, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(4, 1);
INSERT INTO meal(meal_type, diet_id) VALUES(5, 1);

INSERT INTO food(food_name, group_macro, group_type, portion_type, calorie_per_one_hundred_grams, calorie_per_portion)
VALUES ('Leite Integral', 6, 5,);