CREATE TABLE teachers (
  _id int NOT NULL AUTO_INCREMENT unique,
  t_name varchar(255) NOT NULL,
  email varchar(255),
  phone varchar(255),
  t_subject varchar(255) default "generic substitute",

  PRIMARY KEY (_id)

)ENGINE=InnoDB;