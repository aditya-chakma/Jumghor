INSERT INTO app_user(id, user_name, display_name, email, password_hash, salt, created) VALUES (0, 'aditya', 'kingsman', 'adityachakma199@gmail.com', 'password', 'salt', NOW());

INSERT INTO post(id, details, likes, user_id, created) VALUES (0, 'This is a Test', 100, 0, NOW());

INSERT INTO comment(id, comment, likes, user_id, post_id, created) VALUES (0, 'This is a Test', 100, 0, 0, NOW());