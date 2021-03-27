CREATE TABLE IF NOT EXIST organization (
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY_KEY AUTO_INCREMENT,
    name      VARCHAR(50) NOT NULL COMMENT 'Имя',
    full_name VARCHAR(500) NOT NULL COMMENT 'Полное имя',
    inn       VARCHAR(12) NOT NULL COMMENT 'Индивидуальный налоговый номер',
    kpp       VARCHAR(10) NOT NULL COMMENT 'Код причины постановки на учет',
    address   VARCHAR(500) NOT NULL COMMENT 'Адресс организации',
    phone     VARCHAR(50) COMMENT 'Телефон организации',
    is_active  TINYINT
    );

COMMENT ON TABLE organization IS 'Организация';

CREATE TABLE IF NOT EXIST office (
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY_KEY AUTO_INCREMENT,
    org_id  INTEGER NOT NULL COMMENT 'Id организации',
    name    VARCHAR(50) COMMENT 'Название офиса',
    address VARCHAR(50) COMMENT 'Адрес офиса',
    phone   VARCHAR(50) COMMENT 'Телефон офиса',
    is_active TINYINT
    );

COMMENT ON TABLE office IS 'Офис';

CREATE TABLE IF NOT EXIST user (
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY_KEY AUTO_INCREMENT,
    office_id   INTEGER NOT NULL COMMENT 'Id офиса',
    first_name  VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name VARCHAR(50) COMMENT 'Фамилия',
    middle_name VARCHAR(50) COMMENT 'Отчество',
    position    VARCHAR(50) NOT NULL 'Должность',
    phone       VARCHAR(50) COMMENT 'Телефон',
    doc_code    VARCHAR(50) COMMENT 'Код документа',
    doc_name    VARCHAR(50) COMMENT 'Название документа',
    doc_number  VARCHAR(50) COMMENT 'Номер документа',
    doc_date    VARCHAR(50) COMMENT 'Дата выдачи документа',
    citizenship_code VARCHAR(50) COMMENT 'Код города',
    is_identified TINYINT(50) COMMENT 'Идентификация'
    );

COMMENT ON TABLE user IS 'Сотрудник';

CREATE TABLE organization_office (
    organization_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор организации',
    office_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор офиса',
    PRIMARY KEY (organization_id, office_id)
    );

COMMENT ON TABLE organization_office IS 'join-таблица для связи организации и офиса';


CREATE TABLE office_user (
    office_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор офиса',
    user_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор сотрудника',
    PRIMARY KEY (office_id, user_id)
    );

COMMENT ON TABLE office_user IS 'join-таблица для связи офиса и сотрудника';