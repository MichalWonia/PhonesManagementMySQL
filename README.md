# PhonesManagementMySQL

### in progress ...

```
CREATE TABLE `telephones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  ```
```
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('1', 'Honor', '8X', 'Blue');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('2', 'Sony', 'Xperia', 'Silver');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('3', 'Nokia', 'Lumia', 'Red');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('4', 'Iphone', '5S', 'Black');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('5', 'Nokia', '3310', 'Blue');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('6', 'Honor', 'P10', 'White');
INSERT INTO `telephones` (`id`, `brand`, `model`, `color`) VALUES ('7', 'Iphone', 'X', 'Black');

```
