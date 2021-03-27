CREATE INDEX IX_organization_office_Id ON organization_office (office_id);
ALTER TABLE organization_office ADD FOREIGN KEY (office_id) REFERENCES office(id);

CREATE INDEX IX_organization_office_Id ON organization_office (organization_id);
ALTER TABLE organization_office ADD FOREIGN KEY (organization_id) REFERENCES organization(id);

CREATE INDEX IX_office_user_Id ON office_user (user_id);
ALTER TABLE office_user ADD FOREIGN KEY (user_id) REFERENCES user(id);

CREATE INDEX IX_office_user_Id ON office_user (office_id);
ALTER TABLE office_user ADD FOREIGN KEY (office_id) REFERENCES office(id);