CREATE TABLE public."Comments"
(
    comment_id integer NOT NULL DEFAULT nextval('"Comments_comment_id_seq"'::regclass),
    news_id integer NOT NULL DEFAULT nextval('"Comments_news_id_seq"'::regclass),
    author_id integer NOT NULL DEFAULT nextval('"Comments_author_id_seq"'::regclass),
    comment_text text COLLATE pg_catalog."default" NOT NULL,
    sending_date date NOT NULL,
    CONSTRAINT "Comments_pkey" PRIMARY KEY (comment_id),
    CONSTRAINT author_id FOREIGN KEY (author_id)
        REFERENCES public."Users" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT news_id FOREIGN KEY (news_id)
        REFERENCES public."News" (news_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."Comments"
    OWNER to postgres;

CREATE TABLE public."News"
(
    news_id integer NOT NULL DEFAULT nextval('"News_news_id_seq"'::regclass),
    author_id integer NOT NULL,
    tittle character(100) COLLATE pg_catalog."default" NOT NULL,
    news_text text COLLATE pg_catalog."default" NOT NULL,
    public_date date NOT NULL,
    CONSTRAINT "primary" PRIMARY KEY (news_id),
    CONSTRAINT "News_author_id_fkey" FOREIGN KEY (author_id)
        REFERENCES public."Users" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."News"
    OWNER to postgres;

CREATE TABLE public."Tags"
(
    "news_ID" integer NOT NULL DEFAULT nextval('"Tags_news_ID_seq"'::regclass),
    tags character(100) COLLATE pg_catalog."default",
    CONSTRAINT "NewsKEy" FOREIGN KEY ("news_ID")
        REFERENCES public."News" (news_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public."Tags"
    OWNER to postgres;

CREATE TABLE public."Users"
(
    user_id integer NOT NULL DEFAULT nextval('"Users_user_id_seq"'::regclass),
    login character(100) COLLATE pg_catalog."default" NOT NULL,
    hash_password character(100) COLLATE pg_catalog."default" NOT NULL,
    user_name character(100) COLLATE pg_catalog."default" NOT NULL,
    user_last_name character(100) COLLATE pg_catalog."default" NOT NULL,
    date_of_registration date NOT NULL,
    CONSTRAINT "Users_pkey" PRIMARY KEY (user_id)
)

TABLESPACE pg_default;

ALTER TABLE public."Users"
    OWNER to postgres;