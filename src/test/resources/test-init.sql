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

INSERT INTO Exchange_Rate(id,from_Currency,to_Currency,ratio) VALUES (1,'CAD','USD',0.9);
INSERT INTO Exchange_Rate(id,from_Currency,to_Currency,ratio) VALUES (2,'EUR','USD',1.9);
INSERT INTO Exchange_Rate(id,from_Currency,to_Currency,ratio) VALUES (3,'AUD','USD',0.95);
INSERT INTO Exchange_Rate(id,from_Currency,to_Currency,ratio) VALUES (4,'JPN','USD',400);
INSERT INTO Exchange_Rate(id,from_Currency,to_Currency,ratio) VALUES (5,'CHK','EUR',9.1);