INSERT INTO news (name, description, content, date) VALUES
  ('G7 leaders gather for robust talks in Sicily',
   'The G7 consists of Canada, France, Germany, Italy, Japan, the UK and the US.',
   'Four of the group''s leaders - including Mr Trump and British Prime Minister Theresa May - will be sitting around the table for the first time.',
   '2017-01-02');


INSERT INTO categories (name) VALUES ('Sports');
INSERT INTO categories (name) VALUES ('Health');
INSERT INTO categories (name) VALUES ('Technology');
INSERT INTO categories (name) VALUES ('Fashion');
INSERT INTO categories (name) VALUES ('Business');
INSERT INTO categories (name) VALUES ('Politics');

INSERT INTO news_categories (news_id, categories_id) VALUES (1, 6);
