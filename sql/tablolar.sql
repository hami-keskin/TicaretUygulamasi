CREATE SCHEMA TradeDatabase;

CREATE TABLE `tradedatabase`.`users` (
  `userID` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);
  
  CREATE TABLE `tradedatabase`.`category` (
  `categoryID` INT NOT NULL,
  `categoryname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`categoryID`));

CREATE TABLE `tradedatabase`.`products` (
  `productID` INT NOT NULL,
  `categotyID` INT NULL,
  `productname` VARCHAR(45) NULL,
  `stockCount` INT NULL,
  PRIMARY KEY (`productID`),
  INDEX `categoryID_idx` (`categotyID` ASC) VISIBLE,
  CONSTRAINT `categoryID`
    FOREIGN KEY (`categotyID`)
    REFERENCES `tradedatabase`.`category` (`categoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `tradedatabase`.`orders` (
  `orderID` INT NOT NULL,
  `userID` INT NULL,
  `orderDate` VARCHAR(45) NULL,
  PRIMARY KEY (`orderID`),
  INDEX `userID_idx` (`userID` ASC) VISIBLE,
  CONSTRAINT `userID`
    FOREIGN KEY (`userID`)
    REFERENCES `tradedatabase`.`users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `tradedatabase`.`orderdetails` (
  `detailID` INT NOT NULL,
  `orderID` INT NULL,
  `productID` INT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`detailID`),
  INDEX `orderID_idx` (`orderID` ASC) VISIBLE,
  INDEX `productID_idx` (`productID` ASC) VISIBLE,
  CONSTRAINT `orderID`
    FOREIGN KEY (`orderID`)
    REFERENCES `tradedatabase`.`orders` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `productID`
    FOREIGN KEY (`productID`)
    REFERENCES `tradedatabase`.`products` (`productID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
