CREATE TABLE app_user
(
    id            BIGINT       NOT NULL,
    user_name     VARCHAR(15)  NOT NULL,
    display_name  VARCHAR(64)  NOT NULL,
    email         VARCHAR(260) NOT NULL,
    password_hash VARCHAR(256) NOT NULL,
    salt          VARCHAR(32)  NOT NULL,
    created       TIMESTAMP(6) NOT NULL,
    updated       TIMESTAMP(6),
    version       BIGINT       NOT NULL,
    CONSTRAINT pk_app_user_id PRIMARY KEY (id)
);

CREATE TABLE post
(
    id      BIGINT       NOT NULL,
    details TEXT         NOT NULL,
    likes   INTEGER      NOT NULL,
    user_id BIGINT       NOT NULL,
    created TIMESTAMP(6) NOT NULL,
    updated TIMESTAMP(6),
    version BIGINT       NOT NULL,
    CONSTRAINT pk_post_id PRIMARY KEY (id),
    CONSTRAINT fk_post_app_user_id FOREIGN KEY (user_id) REFERENCES app_user (id)
);

CREATE TABLE comments
(
    id      BIGINT       NOT NULL,
    comment TEXT         NOT NULL,
    likes   INTEGER      NOT NULL,
    user_id BIGINT       NOT NULL,
    post_id BIGINT       NOT NULL,
    created TIMESTAMP(6) NOT NULL,
    updated TIMESTAMP(6),
    version BIGINT       NOT NULL,
    CONSTRAINT pk_comments_id PRIMARY KEY (id),
    CONSTRAINT fk_comments_app_user_id FOREIGN KEY (user_id) REFERENCES app_user (id),
    CONSTRAINT fk_comments_post_id FOREIGN KEY (post_id) REFERENCES post (id)
);
