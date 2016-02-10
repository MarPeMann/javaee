CREATE TABLE course (
  _id int NOT NULL AUTO_INCREMENT unique,
  c_name varchar(255) NOT NULL,
  grade float,
  c_info text,
  PRIMARY KEY (_id)

)ENGINE=InnoDB;