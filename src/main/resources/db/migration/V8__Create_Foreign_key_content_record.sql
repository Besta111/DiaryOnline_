ALTER TABLE CONTENT ADD CONSTRAINT CONTENT_RECORD_ID_FK
FOREIGN KEY (RECORD_ID) REFERENCES RECORD(ID);