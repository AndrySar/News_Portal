CREATE TABLE news (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  content TEXT,
  date DATE NOT NULL
);


CREATE TABLE categories (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  UNIQUE (name)
);

CREATE TABLE news_categories (
  news_id INT REFERENCES news (id) ON UPDATE CASCADE ON DELETE CASCADE,
  categories_id INT REFERENCES categories (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT news_categories_pkey PRIMARY KEY (news_id, categories_id)
);