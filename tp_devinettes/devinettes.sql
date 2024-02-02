DROP DATABASE IF EXISTS tp_devinette;

CREATE DATABASE If NOT EXISTS tp_devinette;

USE tp_devinette;


CREATE TABLE devinette
(
    id_riddle INT AUTO_INCREMENT NOT NULL,
    riddle    VARCHAR(255)       NULL,
    answer    VARCHAR(255)       NULL,
    CONSTRAINT pk_devinette PRIMARY KEY (id_riddle)
);

CREATE TABLE reponse
(
    id_reponse   INT AUTO_INCREMENT NOT NULL,
    devinette_id INT                NULL,
    user_answer VARCHAR(255) NULL,
    CONSTRAINT pk_reponse PRIMARY KEY (id_reponse)
);

ALTER TABLE reponse
    ADD CONSTRAINT FK_REPONSE_ON_DEVINETTE FOREIGN KEY (devinette_id) REFERENCES devinette (id_riddle);