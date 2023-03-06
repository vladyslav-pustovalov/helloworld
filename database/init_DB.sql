CREATE DATABASE PetStore;

USE PetStore;

CREATE TABLE Categories (
CategoryID int NOT NULL UNIQUE,
CategoryName VARCHAR(255) NOT NULL UNIQUE,
PRIMARY KEY (CategoryID),
CHECK (CategoryID>0)
);

CREATE TABLE Tags (
TagID int NOT NULL UNIQUE,
TagName VARCHAR(255) NOT NULL UNIQUE,
PRIMARY KEY (TagID),
CHECK (TagID>0)
);

CREATE TABLE PhotoURLS (
PhotoURLID int NOT NULL UNIQUE,
PhotoURLAddress VARCHAR(255) NOT NULL UNIQUE,
PRIMARY KEY (PhotoURLID),
CHECK (PhotoURLID>0)
);

CREATE TABLE Pets (
PetID int NOT NULL UNIQUE,
PetCategory int NOT NULL,
PetName VARCHAR(255) NOT NULL,
PetPhoto int,
PetTag int,
Status ENUM('available', 'pending', 'sold'),
PRIMARY KEY (PetID),
CHECK (PetID>0),
FOREIGN KEY (PetCategory) REFERENCES Categories(CategoryID),
FOREIGN KEY (PetPhoto) REFERENCES PhotoURLS(PhotoURLID),
FOREIGN KEY (PetTag) REFERENCES Tags(TagID)
);