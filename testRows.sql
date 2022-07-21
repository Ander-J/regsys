INSERT INTO payment (method) VALUES ('sularaha');
INSERT INTO payment (method) VALUES ('ülekanne');
INSERT INTO event (id, date, event_name, location) VALUES (1, TO_DATE('17/12/2019', 'DD/MM/YYYY'), 'Lorem Ipsum', 'Valge saal');
INSERT INTO event (id, date, event_name, location) VALUES (2, TO_DATE('11/05/2020', 'DD/MM/YYYY'), 'Keemia konverents', 'Messikeskus');
INSERT INTO event (id, date, event_name, location) VALUES (3, TO_DATE('03/01/2022', 'DD/MM/YYYY'), 'Autonäitus', 'Näitusesaal');
INSERT INTO event (id, date, event_name, location) VALUES (4, TO_DATE('27/09/2022', 'DD/MM/YYYY'), 'Hackathon', 'Messikeskus');
INSERT INTO event (id, date, event_name, location) VALUES (5, TO_DATE('12/11/2022', 'DD/MM/YYYY'), 'Tehnoloogia konverents', 'Messikeskus');
INSERT INTO person (first_name, last_name, id_code, payment_method, event_entity_id) VALUES ('John', 'Smith', '37904072386', 'ülekanne', 1);
INSERT INTO person (first_name, last_name, id_code, payment_method, event_entity_id) VALUES ('Valter', 'Valge', '35302122587', 'sularaha', 2);
INSERT INTO person (first_name, last_name, id_code, payment_method, event_entity_id) VALUES ('Juss', 'Roosamees', '38912123281', 'ülekanne', 2);
INSERT INTO person (first_name, last_name, id_code, payment_method, event_entity_id) VALUES ('Ants', 'Topi', '35811038642', 'sularaha', 3);
INSERT INTO person (first_name, last_name, id_code, payment_method, event_entity_id) VALUES ('Elina', 'Meri', '48203112385', 'ülekanne', 3);
INSERT INTO person (first_name, last_name, id_code, payment_method, event_entity_id) VALUES ('Pille', 'Pärn', '49904023356', 'sularaha', 4);
INSERT INTO person (first_name, last_name, id_code, payment_method, event_entity_id) VALUES ('Sten', 'Kukk', '38211111111', 'ülekanne', 5);
INSERT INTO person (first_name, last_name, id_code, payment_method, event_entity_id) VALUES ('John', 'Smith', '37904072386', 'ülekanne', 5);
INSERT INTO company (company_name, attendants, reg_code, payment_method, event_entity_id) VALUES ('Ipsum OÜ', 2, '732133', 'ülekanne', 1);
INSERT INTO company (company_name, attendants, reg_code, payment_method, event_entity_id) VALUES ('Keemiatööstuse OÜ', 10, '763133', 'ülekanne', 2);
INSERT INTO company (company_name, attendants, reg_code, payment_method, event_entity_id) VALUES ('AS Rooste diilerid', 1, '762133', 'sularaha', 3);
INSERT INTO company (company_name, attendants, reg_code, payment_method, event_entity_id) VALUES ('Kiirarendus OÜ', 8, '784133', 'ülekanne', 4);
INSERT INTO company (company_name, attendants, reg_code, payment_method, event_entity_id) VALUES ('Arvutimüük OÜ', 7, '785133', 'sularaha', 5);