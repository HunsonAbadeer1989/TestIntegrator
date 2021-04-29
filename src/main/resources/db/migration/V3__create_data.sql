INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active) VALUES (1, 'ТАНТК', 'Таганрогский Авиационный Научно-исследовательский Комплекс', '8723459176','8928736511','г. Таганрог,ул. Инструментальная, д. 1, стр 1','+7(495)223-32-22', true);
INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active) VALUES (2, 'ОАО "АКБ Сухой"', 'Открытое Акционерное Общество Авиационное Конструкторское Бюро Сухой', '2784572316','3651189287','г. Москва, ул. Столярная, д. 3, стр 23','+7(495)881-33-22', true);

INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (1, 'ЛИК', 'г. Таганрог,ул. Инструментальная, д. 28, стр 2', '+7(495)810-83-76', 1, 1);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (2, 'БТК', 'г. Таганрог,ул. Инструментальная, д. 4, стр 1', '+7(495)883-11-12', 1, 1);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (3, 'НИО-ГМ', 'г. Москва, ул. Столярная, д. 10, стр 3', '+7(495)777-11-11', 1, 2);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (4, 'КБ-3', 'г. Москва, ул. Столярная, д. 8, стр 1', '+7(495)727-21-21', 1, 2);

INSERT INTO country (name, code) VALUES ('Нидерланды', '528');
INSERT INTO country (name, code) VALUES ('Российская федерация', '643');
INSERT INTO country (name, code) VALUES ('ОАЭ', '784');

INSERT INTO doc_type (doc_code, doc_name) VALUES ('21', 'Паспорт гражданина Российской Федерации');
INSERT INTO doc_type (doc_code, doc_name) VALUES ('07', 'Военный билет');
INSERT INTO doc_type (doc_code, doc_name) VALUES ('10', 'Паспорт иностранного гражданина');
INSERT INTO doc_type (doc_code, doc_name) VALUES ('91', 'Иные документы');

INSERT INTO document (doc_code, doc_number, doc_date) VALUES ('21', '5010526191', '1999-01-28');
INSERT INTO document (doc_code, doc_number, doc_date) VALUES ('10', '7079353781', '1998-02-28');
INSERT INTO document (doc_code, doc_number, doc_date) VALUES ('07', '2619153781', '1997-03-28');
INSERT INTO document (doc_code, doc_number, doc_date) VALUES ('21', '2619100000', '1996-04-28');

INSERT INTO user (id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified, office_id, doc_code, doc_number)
      VALUES (1, 'Анатолий', 'Пестемеев', 'Бомба', 'Слесарь инструментальщик', '89098283645', '528', 1, 1, '21', '5010526191'),
             (2,  'Вадик', 'Петровский', 'Штык', 'Микроскопщик БТК',  '89285674189', '643', 1, 2, '10', '7079353781'),
             (3,  'Генадий', 'Бобков', 'Пуля', 'Рулетчик 1го разряда',  '89287777777', '643', 1, 3, '07', '2619153781'),
             (4,  'Гера', 'Либерман', 'Сусликович', 'Каптер 1го разряда',  '89285555555', '643', 1, 4, '21', '2619100000');