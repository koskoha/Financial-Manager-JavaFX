insert OR REPLACE into users (name, password) values ("Alisa", "123");
insert OR REPLACE into users (name, password) values ("wer", "1");
insert OR REPLACE into users (name, password) values ("kos", "1");
insert OR REPLACE into users (name, password) values ("eva", "1");
insert OR REPLACE into users (name, password) values ("mari", "1");

insert OR REPLACE into accounts (ballance,description, user_name) values (100,"General", "kos");
insert OR REPLACE into accounts (ballance,description, user_name) values (200,"checking", "kos");
insert OR REPLACE into accounts (ballance,description, user_name) values (300,"Saving", "kos");
insert OR REPLACE into accounts (ballance,description, user_name) values (100,"General", "eva");

INSERT OR REPLACE INTO records (DESCRIPTION, AMOUNT, IS_PUT, CATEGORY_ID, ACCOUNT_ID, RECORD_DATE) VALUES ("new car", 10000, 0, 3, 1, "20.03.2014");
INSERT OR REPLACE INTO records (description, amount, is_put, category_id, account_id, record_date) VALUES ("new Coat", 259999, 0, 3, 1, "30.11.2014");
INSERT OR REPLACE INTO records (description, amount, is_put, category_id, account_id, record_date) VALUES ("Manikure", 1500, 0, 4, 2, "20.06.2015");
INSERT OR REPLACE INTO records (description, amount, is_put, category_id, account_id, record_date) VALUES ("hair cut", 2000, 0, 4, 2, "10.09.2015");
INSERT OR REPLACE INTO records (description, amount, is_put, category_id, account_id, record_date) VALUES ("Kafe", 5000, 0, 2, 2, "10.09.2015");
INSERT OR REPLACE INTO records (description, amount, is_put, category_id, account_id, record_date) VALUES ("Ipoteka", 1900000, 0, 5, 3, "01.12.2015");
INSERT OR REPLACE INTO records (description, amount, is_put, category_id, account_id, record_date) VALUES ("Savings", 2000, 1, 5, 4, "31.12.2014");
INSERT OR REPLACE INTO records (description, amount, is_put, category_id, account_id, record_date) VALUES ("money", 5000, 0, 5, 5, "06.12.2015");


insert OR REPLACE into categories (name) values ("Food and Drinks"), ("Cafe"), ("Transport"), ("Health"), ("Other"), ("Salary");