INSERT INTO news (name, description, content, date) VALUES ('News1', 'Description_1', 'Some text 1', '2017-01-02');
INSERT INTO news (name, description, content, date) VALUES ('News2', 'Description_2', 'Some text 2', '2017-03-12');
INSERT INTO news (name, description, content, date) VALUES ('News3', 'Description_3', 'Some text 3', '2017-04-05');

-- INSERT INTO news (name, description, content) VALUES ('News1', 'Description_1', 'Some text 1');
-- INSERT INTO news (name, description, content) VALUES ('News2', 'Description_2', 'Some text 2');
-- INSERT INTO news (name, description, content) VALUES ('News3', 'Description_3', 'Some text 3');

INSERT INTO categories (name) VALUES ('Categories_1');
INSERT INTO categories (name) VALUES ('Categories_2');
INSERT INTO categories (name) VALUES ('Categories_3');

INSERT INTO news_categories (news_id, categories_id) VALUES (1, 1);
INSERT INTO news_categories (news_id, categories_id) VALUES (2, 1);
INSERT INTO news_categories (news_id, categories_id) VALUES (2, 2);
INSERT INTO news_categories (news_id, categories_id) VALUES (3, 3);