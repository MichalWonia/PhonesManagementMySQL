# PhonesManagementMySQL

A simple application to manage phones in a database. I used JDBC connector to connect to MySQL database. The application has a user interface that allows to check records in the database, add new phones, delete, update and search by selected field. <br/>

You need to create a table in the database. Use the following commands:

## Create table

```
CREATE TABLE `telephones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  ```
## Insert sample data into the table
  
```
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('1', 'Honor', '8X', 'Blue');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('2', 'Sony', 'Xperia', 'Silver');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('3', 'Nokia', 'Lumia', 'Red');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('4', 'Iphone', '5S', 'Black');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('5', 'Nokia', '3310', 'Blue');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('6', 'Honor', 'P10', 'White');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('7', 'Iphone', 'X', 'Black');
```
## What next ?

Start the application and follow the commands in the user interface.

## Author
Michal Wonia <br/>
Poland
