
SET client_encoding = 'UTF8';
CREATE SEQUENCE hibernate_sequence;

CREATE TABLE PRODUKSJONSPLASS(
    produksjonsplassid INTEGER      NOT NULL,
    kommunenummer      VARCHAR(4)   NOT NULL,
    gaardsnummer       INTEGER      NOT NULL,
    bruksnummer        INTEGER      NOT NULL,
    bygningsnummer     INTEGER      NOT NULL,
    koordinater        VARCHAR(255),
    koordinatsystem    VARCHAR(255),
    opprettetdato      TIMESTAMP    NOT NULL,
    lastchanged        TIMESTAMP    NOT NULL,
    CONSTRAINT produksjonsplass_pkey PRIMARY KEY (produksjonsplassid)
);

insert into produksjonsplass(produksjonsplassid, kommunenummer, gaardsnummer, bruksnummer, bygningsnummer, koordinater, koordinatsystem, opprettetdato, lastchanged)
values(1000000,'0001',1,1,-1, null, null, now(), now());

insert into produksjonsplass(produksjonsplassid, kommunenummer, gaardsnummer, bruksnummer, bygningsnummer, koordinater, koordinatsystem, opprettetdato, lastchanged)
values(1000001,'0001',3,1,-1,'{"type": "Point", "crs": {"type": "name", "properties": {"name": "EPSG:4326"}}, "coordinates": [11.348141, 60.845944]}', 'EPSG:4326', now(), now());

insert into produksjonsplass(produksjonsplassid, kommunenummer, gaardsnummer, bruksnummer, bygningsnummer, koordinater, koordinatsystem, opprettetdato, lastchanged)
values(1000002,'0001',2,1,-1,'{"type": "Point", "crs": {"type": "name", "properties": {"name": "EPSG:4326"}}, "coordinates": [11.631629, 60.31758]}', 'EPSG:4326', now(), now());

COMMIT;


