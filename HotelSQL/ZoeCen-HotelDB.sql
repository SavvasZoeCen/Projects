DROP DATABASE IF EXISTS HotelDB;

CREATE DATABASE IF NOT EXISTS HotelDB;

USE HotelDB;
CREATE TABLE IF NOT EXISTS `Room`(
	`RoomNum` INT NOT NULL,
    `RoomType` VARCHAR(10),
    `ADAAccessible` BOOL NOT NULL,
    `StandardOccupancy` INT NOT NULL,
    `MaxOccupancy` INT NOT NULL,
    `BasePrice` DOUBLE NOT NULL,
    `ExtraPerson` INT NULL,
    PRIMARY KEY (`RoomNum`)
);

USE HotelDB;
CREATE TABLE IF NOT EXISTS `Guest`(
	`GuestID` INT NOT NULL AUTO_INCREMENT,
	`Name` VARCHAR(50) NOT NULL,
    `Address` VARCHAR(256) NOT NULL,
    `City` VARCHAR(50) NOT NULL,
    `State` VARCHAR(5) NOT NULL,
    `ZipCode` INT NOT NULL,
    `Phone` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`GuestID`)
);

USE HotelDB;
CREATE TABLE IF NOT EXISTS `Amenity`(
	`AmenityID` INT NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`AmenityID`)
);

USE HotelDB;
CREATE TABLE IF NOT EXISTS `Reservation`(
	`ReservationID` INT NOT NULL AUTO_INCREMENT,
    `GuestID` INT NOT NULL,
	`Adults` INT NOT NULL,
    `Children` INT NOT NULL,
    `StartDate` DATE NOT NULL,
    `EndDate` DATE NOT NULL,
    `TotalCost` DOUBLE NOT NULL,
    PRIMARY KEY (`ReservationID`)
);
ALTER TABLE `Reservation`
ADD CONSTRAINT `fk_Guest` foreign key (`GuestID`) 
references `Guest` (`GuestID`) ON DELETE NO ACTION;


USE HotelDB;
CREATE TABLE IF NOT EXISTS `RoomAmenities`(
	`RoomNum` INT NOT NULL,
    `AmenityID` INT NOT NULL,
	PRIMARY KEY (`RoomNum`, `AmenityID`)
);
ALTER TABLE `RoomAmenities`
ADD CONSTRAINT `fk_Room` foreign key (`RoomNum`) 
references `Room` (`RoomNum`) ON DELETE NO ACTION;

ALTER TABLE `RoomAmenities`
ADD CONSTRAINT `fk_Amenity` foreign key (`AmenityID`) 
references `Amenity` (`AmenityID`) ON DELETE NO ACTION;


USE HotelDB;
CREATE TABLE IF NOT EXISTS `RoomReservation`(
	`RoomNum` INT NOT NULL,
    `ReservationID` INT NOT NULL,
	PRIMARY KEY (`RoomNum`, `ReservationID`)
);
ALTER TABLE `RoomReservation`
ADD CONSTRAINT `fk_RoomNum` foreign key (`RoomNum`) 
references `Room` (`RoomNum`) ON DELETE NO ACTION;

ALTER TABLE `RoomReservation`
ADD CONSTRAINT `fk_Reservation` foreign key (`ReservationID`) 
references `Reservation` (`ReservationID`) ON DELETE NO ACTION;
