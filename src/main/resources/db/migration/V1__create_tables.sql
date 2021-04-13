CREATE TABLE IF NOT EXISTS organization (
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(50) NOT NULL COMMENT 'Имя',
    full_name VARCHAR(500) NOT NULL COMMENT 'Полное имя',
    inn       VARCHAR(12) NOT NULL COMMENT 'Индивидуальный налоговый номер',
    kpp       VARCHAR(10) NOT NULL COMMENT 'Код причины постановки на учет',
    address   VARCHAR(500) NOT NULL COMMENT 'Адресс организации',
    phone     VARCHAR(50) COMMENT 'Телефон организации',
    is_active  TINYINT
    );

COMMENT ON TABLE organization IS 'Организация';

CREATE TABLE IF NOT EXISTS office (
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    org_id  INTEGER NOT NULL COMMENT 'Id организации',
    name    VARCHAR(50) COMMENT 'Название офиса',
    address VARCHAR(50) COMMENT 'Адрес офиса',
    phone   VARCHAR(50) COMMENT 'Телефон офиса',
    is_active TINYINT,
    CONSTRAINT organization_id FOREIGN KEY (org_id) REFERENCES organization (id)
    );

COMMENT ON TABLE office IS 'Офис';

CREATE TABLE IF NOT EXISTS country (
    code INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(100)         NOT NULL
);

COMMENT ON TABLE country IS 'Страна';

CREATE TABLE IF NOT EXISTS document_type (
    code INTEGER PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

COMMENT ON TABLE document_type IS 'Тип документа';

CREATE TABLE IF NOT EXISTS user (
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    office_id   INTEGER NOT NULL COMMENT 'Id офиса',
    first_name  VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name VARCHAR(50) COMMENT 'Фамилия',
    middle_name VARCHAR(50) COMMENT 'Отчество',
    position    VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone       VARCHAR(50) COMMENT 'Телефон',
    country_code VARCHAR(50) COMMENT 'Код города',
    is_identified TINYINT(50) COMMENT 'Идентификация',
    CONSTRAINT office_id FOREIGN KEY (office_id) REFERENCES office (id),
    CONSTRAINT citizenship_code FOREIGN KEY (country_code) REFERENCES country (code)
    );

COMMENT ON TABLE user IS 'Сотрудник';

CREATE TABLE IF NOT EXISTS document (
    id         INTEGER PRIMARY KEY,
    doc_name   VARCHAR(50) NOT NULL,
    doc_number VARCHAR(30) NOT NULL,
    doc_date   DATE        NOT NULL,
    code       INT         NOT NULL,
    CONSTRAINT doc_code FOREIGN KEY (code) REFERENCES document_type (code),
    CONSTRAINT user_id FOREIGN KEY (`id`) REFERENCES user (id)
);

COMMENT ON TABLE document IS 'Документ';