CREATE SCHEMA vote_app AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS vote_app.vote
(
    dt_create timestamp(6) without time zone NOT NULL,
    artist character varying COLLATE pg_catalog."default" NOT NULL,
    genre_1 character varying COLLATE pg_catalog."default" NOT NULL,
    genre_2 character varying COLLATE pg_catalog."default" NOT NULL,
    genre_3 character varying COLLATE pg_catalog."default" NOT NULL,
    genre_4 character varying COLLATE pg_catalog."default",
    genre_5 character varying COLLATE pg_catalog."default",
    about text COLLATE pg_catalog."default" NOT NULL
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS vote_app.vote
    OWNER to postgres;