INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active) VALUES (1, 'ТАНТК', 'Таганрогский Авиационный Научно-исследовательский Комплекс', '8723459176','8928736511','г. Таганрог,ул. Инструментальная, д. 1, стр 1','+7(495)223-32-22', true);
INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active) VALUES (2, 'ОАО "АКБ Сухой"', 'Открытое Акционерное Общество Авиационное Конструкторское Бюро Сухой', '2784572316','3651189287','г. Москва, ул. Столярная, д. 3, стр 23','+7(495)881-33-22', true);

INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (1, 'ЛИК', 'г. Таганрог,ул. Инструментальная, д. 28, стр 2', '+7(495)810-83-76', 1, 1);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (2, 'БТК', 'г. Таганрог,ул. Инструментальная, д. 4, стр 1', '+7(495)883-11-12', 1, 1);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (3, 'НИО-ГМ', 'г. Москва, ул. Столярная, д. 10, стр 3', '+7(495)777-11-11', 1, 2);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (4, 'КБ-3', 'г. Москва, ул. Столярная, д. 8, стр 1', '+7(495)727-21-21', 1, 2);

INSERT INTO country (id, name, code) VALUES (1, 'Нидерланды', '528');
INSERT INTO country (id, name, code) VALUES (2, 'Российская федерация', '643');
INSERT INTO country (id, name, code) VALUES (3, 'ОАЭ', '784');

INSERT INTO doc_type (id, name, code) VALUES (1, 'Паспорт гражданина Российской Федерации', '21');
INSERT INTO doc_type (id, name, code) VALUES (2, 'Военный билет', '07');
INSERT INTO doc_type (id, name, code) VALUES (3, 'Паспорт иностранного гражданина', '10');
INSERT INTO doc_type (id, name, code) VALUES (4, 'Иные документы', '91');

INSERT INTO document (id, doc_number, doc_date, doc_type_id) VALUES (1, '5010526191', '1999-01-28', 1);
INSERT INTO document (id, doc_number, doc_date, doc_type_id) VALUES (2, '7079353781', '1998-02-28', 3);
INSERT INTO document (id, doc_number, doc_date, doc_type_id) VALUES (3, '2619153781', '1997-03-28', 2);
INSERT INTO document (id, doc_number, doc_date, doc_type_id) VALUES (4, '2619100000', '1996-04-28', 4);

INSERT INTO user (id, first_name, second_name, middle_name, position, phone, country_id, is_identified, office_id, doc_id)
      VALUES (1, 'Анатолий', 'Пестемеев', 'Бомба', 'Слесарь инструментальщик', '89098283645', 2, 1, 1, 1),
             (2,  'Вадик', 'Петровский', 'Штык', 'Микроскопщик БТК',  '89285674189', 1, 1, 2, 2),
             (3,  'Генадий', 'Бобков', 'Пуля', 'Рулетчик 1го разряда',  '89287777777', 3, 1, 3, 3),
             (4,  'Гера', 'Либерман', 'Сусликович', 'Каптер 1го разряда',  '89285555555', 4, 1, 4, 4);