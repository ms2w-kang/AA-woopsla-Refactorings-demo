
/* Drop Tables */

DROP TABLE LineItem;
DROP TABLE ProductDescription;
DROP TABLE Sale;




/* Create Tables */

CREATE TABLE LineItem
(
	ItemID varchar(13) NOT NULL,
	Quantity int,
	SaleID int NOT NULL,
	ProductDescriptionID varchar(13),
	PRIMARY KEY (ItemID)
);


CREATE TABLE ProductDescription
(
	ItemID varchar(13) NOT NULL,
	Description varchar(255),
	Price double,
	PRIMARY KEY (ItemID)
);


CREATE TABLE Sale
(
	Id int NOT NULL UNIQUE,
	OccurredOn date,
	PRIMARY KEY (Id)
);



/* Create Foreign Keys */

ALTER TABLE LineItem
	ADD FOREIGN KEY (ProductDescriptionID)
	REFERENCES ProductDescription (ItemID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE LineItem
	ADD FOREIGN KEY (SaleID)
	REFERENCES Sale (Id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



