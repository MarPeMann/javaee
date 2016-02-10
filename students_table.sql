CREATE TABLE students (
  _id int NOT NULL AUTO_INCREMENT unique,
  s_name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  email varchar(255),
  phone varchar(255),

  PRIMARY KEY (_id)

)ENGINE=InnoDB;