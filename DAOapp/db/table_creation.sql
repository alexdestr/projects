CREATE TABLE "Users"
(
    user_id BIGSERIAL NOT NULL PRIMARY KEY,
    login VARCHAR UNIQUE NOT NULL,
    hash_password VARCHAR  NOT NULL,
    user_name VARCHAR  NOT NULL,
    user_last_name VARCHAR  NOT NULL,
    registration_date TIMESTAMP NOT NULL
);

CREATE TABLE "News"
(
    news_id BIGSERIAL NOT NULL PRIMARY KEY,
    author_id BIGINT NOT NULL REFERENCES "Users"(user_id),
    tittle VARCHAR  NOT NULL,
    news_text TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL
);

CREATE TABLE "Comments"
(
    comments_id BIGSERIAL NOT NULL PRIMARY KEY,
    news_id BIGINT NOT NULL REFERENCES "News"(news_id),
    author_id BIGINT NOT NULL REFERENCES "Users"(user_id),
    comment_text TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL
);

CREATE TABLE "Tags"
(
    news_id BIGINT NOT NULL REFERENCES "News"(news_id),
    tag_name VARCHAR  NOT NULL
);

