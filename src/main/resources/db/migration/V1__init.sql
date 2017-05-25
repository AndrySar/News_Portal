CREATE TABLE news (
  id SERIAL PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  description TEXT NOT NULL,
  date DATE NOT NULL,
  content TEXT NOT NULL
);


CREATE TABLE categories (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  UNIQUE (name)
);

CREATE TABLE news_categories (
  news_id INTEGER REFERENCES news (id) ON UPDATE CASCADE ON DELETE CASCADE,
  categories_id INTEGER REFERENCES categories (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT news_categories_pkey PRIMARY KEY (news_id, categories_id)
);