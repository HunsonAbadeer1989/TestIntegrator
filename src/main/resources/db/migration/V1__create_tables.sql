CREATE TABLE IF NOT EXISTS organization (
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(50) NOT NULL COMMENT 'Имя',
    full_name VARCHAR(500) NOT NULL COMMENT 'Полное имя',
    inn       VARCHAR(12) NOT NULL COMMENT 'Индивидуальный налоговый номер',
    kpp       VARCHAR(10) NOT NULL COMMENT 'Код причины постановки на учет',
    address   VARCHAR(500) NOT NULL COMMENT 'Адресс организации',
    phone     VARCHAR(50) COMMENT 'Телефон организации',
    is_active  BOOLEAN
    );

COMMENT ON TABLE organization IS 'Организация';

CREATE TABLE IF NOT EXISTS office (
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    org_id  INTEGER NOT NULL COMMENT 'Id организации',
    name    VARCHAR(50) COMMENT 'Название офиса',
    address VARCHAR(50) COMMENT 'Адрес офиса',
    phone   VARCHAR(50) COMMENT 'Телефон офиса',
    is_active BOOLEAN
    );

COMMENT ON TABLE office IS 'Офис';

CREATE TABLE IF NOT EXISTS country (
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    citizenship_code VARCHAR(10) NOT NULL COMMENT 'Код страны',
    citizenship_name VARCHAR(100) NOT NULL COMMENT 'Название страны'
);

COMMENT ON TABLE country IS 'Страна';

CREATE TABLE IF NOT EXISTS doc_type (
    id INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	doc_code VARCHAR(2)   NOT NULL COMMENT 'Код вида документа',
	doc_name VARCHAR(100) NOT NULL COMMENT 'Название документа'
);

COMMENT ON TABLE doc_type IS 'Тип документа';

CREATE TABLE IF NOT EXISTS document (
    user_id     INTEGER COMMENT 'Уникальный идентификатор пользователя, которому принадлежит документ' PRIMARY KEY,
    doc_name  VARCHAR(255) NOT NULL,
    doc_number VARCHAR(255) NOT NULL,
    doc_date   DATE,
    doc_type_id INTEGER   COMMENT 'Уникальный идентификатор типа документа'
);

COMMENT ON TABLE document IS 'Документ';

CREATE TABLE IF NOT EXISTS user (
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    office_id   INTEGER NOT NULL COMMENT 'Id офиса',
    first_name  VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name VARCHAR(50) NOT NULL COMMENT 'Фамилия',
    middle_name VARCHAR(50) NOT NULL COMMENT 'Отчество',
    position    VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone       VARCHAR(50) COMMENT 'Телефон',
    country_id  INTEGER  COMMENT 'Id страны',
    is_identified BOOLEAN  COMMENT 'Идентификация'
    );

COMMENT ON TABLE user IS 'Сотрудник';

