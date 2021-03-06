INSERT INTO Currency( code,country,format) VALUES ('CAD','Canada',2);
INSERT INTO Currency( code,country,format) VALUES ('CZK','check repulic',2);
INSERT INTO Currency( code,country,format) VALUES ('CNY','Chinese',2);
INSERT INTO Currency( code,country,format) VALUES ('DKK','Danish',2);
INSERT INTO Currency( code,country,format) VALUES ('EUR','Europe',2);
INSERT INTO Currency( code,country,format) VALUES ('GBP','Great Britian',2);
INSERT INTO Currency( code,country,format) VALUES ('JPY','Japan',0);
INSERT INTO Currency( code,country,format) VALUES ('USD','United States Of America',2);
INSERT INTO Currency( code,country,format) VALUES ('AUD','Australia',2);
INSERT INTO Currency( code,country,format) VALUES ('NOK','Norwegain',2);
INSERT INTO Currency( code,country,format) VALUES ('NZD','New Zealand',2);


INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (2,'CAD','USD','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (3,'CAD','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (4,'CNY','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (6,'CNY','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (7,'CZK','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (8,'CZK','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (9,'CZK','CNY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (10,'DKK','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (11,'DKK','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (12,'DKK','CNY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (13,'DKK','CZK','EUR');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (14,'EUR','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (15,'EUR','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (16,'EUR','CNY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (17,'EUR','CZK','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (18,'EUR','DKK','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (19,'GBP','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (20,'GBP','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (21,'GBP','CNY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (22,'GBP','CZK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (23,'GBP','DKK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (24,'GBP','EUR','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (25,'JPY','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (26,'JPY','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (27,'JPY','CNY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (28,'JPY','CZK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (29,'JPY','DKK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (30,'JPY','EUR','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (31,'JPY','GBP','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (32,'NOK','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (33,'NOK','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (34,'NOK','CNY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (35,'NOK','CZK','EUR');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (36,'NOK','DKK','EUR');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (37,'NOK','EUR','Inv');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (38,'NOK','GBP','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (39,'NOK','JPY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (40,'NZD','CAD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (41,'NZD','AUD','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (42,'NZD','CNY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (43,'NZD','CZK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (44,'NZD','DKK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (45,'NZD','EUR','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (46,'NZD','GBP','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (47,'NZD','JPY','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (48,'NZD','NOK','USD');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (49,'USD','CAD','Inv');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (50,'USD','AUD','Inv');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (51,'USD','CNY','Inv');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (52,'USD','CZK','EUR');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (53,'USD','DKK','EUR');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (54,'USD','EUR','Inv');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (55,'USD','GBP','Inv');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (56,'USD','JPY','D');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (57,'USD','NOK','EUR');
INSERT INTO Currency_Matrix(id,base,to_Currency,relation) VALUES (58,'USD','NZD','Inv');


INSERT INTO Exchange_Rate(date,from_currency,id,to_currency,ratio) VALUES (20170701,'CAD',1,'USD',0.8711);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'EUR',2,'USD',1.2315);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'AUD',3,'USD',0.8371);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'USD',4,'JPY',119.95);
INSERT INTO Exchange_Rate(date,from_currency,id,to_currency,ratio) VALUES (20170701,'USD',5,'CNY',6.1715);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'GBP',6,'USD',1.5683);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'NZD',7,'USD',0.7750);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'EUR',8,'CZK',27.6028);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'EUR',9,'DKK',7.4405);
INSERT INTO Exchange_Rate(date,from_Currency,id,to_Currency,ratio) VALUES (20170701,'EUR',10,'NOK',8.6651);
