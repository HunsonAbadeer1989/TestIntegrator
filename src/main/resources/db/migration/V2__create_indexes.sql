--Index for organization by Name or by Inn search
CREATE INDEX IX_Organization_Inn ON organization (inn);
CREATE INDEX IX_Organization_name ON organization (name);

--Index for search offices in organization
CREATE INDEX IX_Office_Organization_Id ON office (org_id);

--Index for Users by Office_id search
CREATE INDEX IX_User_Office_Id ON user (office_id);

