INSERT INTO Currency(code,country,format) VALUES ('USD','United States Of America',2);
INSERT INTO Currency( code,country,format) VALUES ('EUR','Europe',2);
INSERT INTO Currency( code,country,format) VALUES ('JPN','Japan',0);
INSERT INTO Currency( code,country,format) VALUES ('AUD','Australia',2);
INSERT INTO Currency( code,country,format) VALUES ('CAD','Canada',2);
INSERT INTO Currency( code,country,format) VALUES ('CHK','check repulic',2);

INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (2,'CAD','USD','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (3,'EUR','USD','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (4,'AUD','USD','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (5,'CHK','EUR','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (6,'JPN','USD','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (7,'JPN','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (8,'JPN','CHK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (9,'AUD','JPN','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (10,'AUD','CHK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (11,'CHK','USD','EUR');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (12,'USD','EUR','Inv');


INSERT INTO Exchange_Rate(date,from_currency,id,to_currency,ratio) VALUES (20170701,'CAD',1,'USD',2.0);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'EUR',2,'USD',3.0);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'AUD',3,'USD',4.0);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'JPN',4,'USD',400);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'CHK',5,'EUR',10.0);