INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active) VALUES (1, 'ТАНТК', 'Таганрогский Авиационный Научно-исследовательский Комплекс', '8723459176','8928736511','г. Таганрог,ул. Инструментальная, д. 1, стр 1','+7(495)223-32-22', true);
INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active) VALUES (2, 'ОАО "АКБ Сухой"', 'Открытое Акционерное Общество Авиационное Конструкторское Бюро Сухой', '2784572316','3651189287','г. Москва, ул. Столярная, д. 3, стр 23','+7(495)881-33-22', true);

INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (1, 'ЛИК', 'г. Таганрог,ул. Инструментальная, д. 28, стр 2', '+7(495)810-83-76', 1, 1);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (2, 'БТК', 'г. Таганрог,ул. Инструментальная, д. 4, стр 1', '+7(495)883-11-12', 1, 1);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (3, 'НИО-ГМ', 'г. Москва, ул. Столярная, д. 10, стр 3', '+7(495)777-11-11', 1, 2);
INSERT INTO office (id, name, address, phone, is_active, org_id) VALUES (4, 'КБ-3', 'г. Москва, ул. Столярная, д. 8, стр 1', '+7(495)727-21-21', 1, 2);

INSERT INTO country (id, citizenship_name, citizenship_code) VALUES (1, 'Нидерланды', '528');
INSERT INTO country (id, citizenship_name, citizenship_code) VALUES (2, 'Российская федерация', '643');
INSERT INTO country (id, citizenship_name, citizenship_code) VALUES (3, 'ОАЭ', '784');

INSERT INTO doc_type (id, doc_code, doc_name) VALUES (1, '21', 'Паспорт гражданина Российской Федерации');
INSERT INTO doc_type (id, doc_code, doc_name) VALUES (2, '07', 'Военный билет');
INSERT INTO doc_type (id, doc_code, doc_name) VALUES (3, '10', 'Паспорт иностранного гражданина');
INSERT INTO doc_type (id, doc_code, doc_name) VALUES (4, '91', 'Иные документы');

INSERT INTO user (id, first_name, second_name, middle_name, position, phone, country_id, is_identified, office_id)
      VALUES (1, 'Анатолий', 'Пестемеев', 'Бомба', 'Слесарь инструментальщик', '89098283645', 1, 1, 1),
             (2,  'Вадик', 'Петровский', 'Штык', 'Микроскопщик БТК',  '89285674189', 2, 1, 2),
             (3,  'Генадий', 'Бобков', 'Пуля', 'Рулетчик 1го разряда',  '89287777777', 2, 1, 3),
             (4,  'Гера', 'Либерман', 'Сусликович', 'Каптер 1го разряда',  '89285555555', 2, 1, 4);

INSERT INTO document (user_id, doc_name, doc_number, doc_type_id) VALUES (1, 'Паспорт РФ', '5010526191', 1);
INSERT INTO document (user_id, doc_name, doc_number, doc_type_id) VALUES (2, 'Паспорт иностранного гражданина', '7079353781', 3);
INSERT INTO document (user_id, doc_name, doc_number, doc_type_id) VALUES (3, 'Военный билет', '2619153781', 2);
INSERT INTO document (user_id, doc_name, doc_number, doc_type_id) VALUES (4, 'Паспорт РФ', '2619100000', 1);