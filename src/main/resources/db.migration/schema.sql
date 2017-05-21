CREATE TABLE `news` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content` text,
  PRIMARY KEY (`id`)
);


CREATE TABLE `categories` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT name_unique UNIQUE (`name`)
);

CREATE TABLE news_categories (
  news_id INT UNSIGNED NOT NULL,
  categories_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (news_id) REFERENCES news (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (categories_id) REFERENCES categories (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);