CREATE TABLE app_user
(
    id            BIGINT       NOT NULL,
    user_name     VARCHAR(15)  NOT NULL,
    display_name  VARCHAR(64)  NOT NULL,
    email         VARCHAR(260) NOT NULL,
    password_hash VARCHAR(256) NOT NULL,
    created       TIMESTAMP(6) NOT NULL,
    updated       TIMESTAMP(6),
    status        SMALLINT     NOT NULL,
    version       INT          NOT NULL,
    CONSTRAINT pk_app_user_id PRIMARY KEY (id),
    CONSTRAINT uk_app_user_user_name UNIQUE (user_name)
);

CREATE TABLE post
(
    id      BIGINT       NOT NULL,
    details TEXT         NOT NULL,
    likes   INTEGER      NOT NULL,
    user_id BIGINT       NOT NULL,
    created TIMESTAMP(6) NOT NULL,
    updated TIMESTAMP(6),
    status  SMALLINT     NOT NULL,
    version INT          NOT NULL,
    CONSTRAINT pk_post_id PRIMARY KEY (id),
    CONSTRAINT fk_post_app_user_id FOREIGN KEY (user_id) REFERENCES app_user (id)
);

CREATE TABLE comment
(
    id      BIGINT       NOT NULL,
    comment TEXT         NOT NULL,
    likes   INTEGER      NOT NULL,
    user_id BIGINT       NOT NULL,
    post_id BIGINT       NOT NULL,
    created TIMESTAMP(6) NOT NULL,
    updated TIMESTAMP(6),
    status  SMALLINT     NOT NULL,
    version INT          NOT NULL,
    CONSTRAINT pk_comments_id PRIMARY KEY (id),
    CONSTRAINT fk_comments_app_user_id FOREIGN KEY (user_id) REFERENCES app_user (id),
    CONSTRAINT fk_comments_post_id FOREIGN KEY (post_id) REFERENCES post (id)
);

CREATE TABLE contact_request
(
    id      BIGINT       NOT NULL,
    from_id BIGINT       NOT NULL,
    to_id   BIGINT       NOT NULL,
    created TIMESTAMP(6) NOT NULL,
    updated TIMESTAMP(6),
    status  SMALLINT     NOT NULL,
    version INT          NOT NULL,
    CONSTRAINT pk_contact_request PRIMARY KEY (id),
    CONSTRAINT fk_contact_request_from_id FOREIGN KEY (from_id) REFERENCES app_user (id),
    CONSTRAINT fk_contact_request_to_id FOREIGN KEY (to_id) REFERENCES app_user (id)
);

CREATE INDEX idx_contact_request_form_id ON contact_request (from_id);
CREATE INDEX idx_contact_request_to_id ON contact_request (to_id);

CREATE TABLE contact
(
    user1   BIGINT       NOT NULL,
    user2   BIGINT       NOT NULL,
    created TIMESTAMP(6) NOT NULL,
    updated timestamp(6),
    status  SMALLINT     NOT NULL,
    version INT,
    CHECK ( user1 < user2 ),
    CONSTRAINT pk_contacts_id PRIMARY KEY (user1, user2),
    CONSTRAINT fk_contacts_user1 FOREIGN KEY (user1) REFERENCES app_user (id),
    CONSTRAINT fk_contacts_user2 FOREIGN KEY (user2) REFERENCES app_user (id)
);

CREATE INDEX idx_contacts_user1 ON contact (user1);
CREATE INDEX idx_contacts_user2 ON contact (user2);

-- CREATE TABLE follower
-- (
--     followee_id BIGINT       NOT NULL,
--     follower_id BIGINT       NOT NULL,
--     created     TIMESTAMP(6) NOT NULL,
--     updated     TIMESTAMP(6),
--     status      SMALLINT     NOT NULL,
--     version     INT          NOT NULL,
--     CONSTRAINT pk_follower_id PRIMARY KEY (followee_id, follower_id),
--     CONSTRAINT fk_follower_followee_id FOREIGN KEY (followee_id) REFERENCES app_user (id),
--     CONSTRAINT fk_follower_follower_id FOREIGN KEY (follower_id) REFERENCES app_user (id)
-- );
--
-- CREATE INDEX idx_follower_followee_id ON follower (followee_id);
-- CREATE INDEX idx_follower_follower_id ON follower (follower_id);
