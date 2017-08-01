DROP DATABASE IF EXISTS SuperHero;
CREATE DATABASE SuperHero;
USE SuperHero;


CREATE TABLE SuperHero.SuperHero
(SuperHeroID Int NOT NULL AUTO_INCREMENT,
SuperHeroName VARCHAR(45) NOT NULL,
Description VARCHAR(45) NOT NULL,
SuperPower VARCHAR(45) NOT NULL,
PRIMARY KEY (SuperHeroID));

CREATE TABLE SuperHero.Organization
(OrganizationID Int NOT NULL AUTO_INCREMENT,
OrganizationName VARCHAR(45) NOT NULL,
Description VARCHAR(45) NOT NULL,
Address VARCHAR(45) NOT NULL,
Email VARCHAR(45) NOT NULL,
PRIMARY KEY (OrganizationID));


CREATE TABLE SuperHero.Location
(LocationID Int NOT NULL AUTO_INCREMENT,
LocationName VARCHAR(45) NOT NULL,
Description VARCHAR(45) NOT NULL,
Address VARCHAR(45) NOT NULL,
Latitude DECIMAL NOT NULL,
Longitude DECIMAL NOT NULL,
PRIMARY KEY (LocationID));

CREATE TABLE SuperHero.Sighting
(SightingID Int NOT NULL AUTO_INCREMENT,
SightingDate DATE NOT NULL,
LocationID INT NOT NULL,
FOREIGN KEY (LocationID)
REFERENCES Location(LocationID),
PRIMARY KEY (SightingID));

CREATE TABLE SuperHero.MemberOrg
(MemberOrg Int NOT NULL AUTO_INCREMENT,
SuperHeroID INT NOT NULL,
OrganizationID INT NOT NULL,
FOREIGN KEY (SuperHeroID)
REFERENCES SuperHero(SuperHeroID),
FOREIGN KEY (OrganizationID)
REFERENCES Organization(OrganizationID),
PRIMARY KEY (MemberOrg));

CREATE TABLE SuperHero.SuperHeroSighting
(SuperHeroSighting Int NOT NULL AUTO_INCREMENT,
SuperHeroID INT NOT NULL,
SightingID INT NOT NULL,
FOREIGN KEY (SuperHeroID)
REFERENCES SuperHero(SuperHeroID),
FOREIGN KEY (SightingID)
REFERENCES Sighting(SightingID),
PRIMARY KEY (SuperHeroSighting));