INSERT INTO Currency(code,country) VALUES ('USD','United States Of America');
INSERT INTO Currency( code,country) VALUES ('EUR','Europe');
INSERT INTO Currency( code,country) VALUES ('JPN','Japan');
INSERT INTO Currency( code,country) VALUES ('AUD','Australia');
INSERT INTO Currency( code,country) VALUES ('CAD','Canada');
INSERT INTO Currency( code,country) VALUES ('CHK','check repulic');



INSERT INTO CurrencyMatrix(id,base,toCurrency,relation) VALUES (2,'CAD','USD','D');
INSERT INTO CurrencyMatrix(id,base,toCurrency,relation) VALUES (3,'EUR','USD','D');
INSERT INTO CurrencyMatrix(id,base,toCurrencytoCurrency,relation) VALUES (4,'AUD','USD','D');
INSERT INTO CurrencyMatrix(id,base,toCurr,relation) VALUES (5,'CHK','EUR','D');
INSERT INTO CurrencyMatrix(id,base,toCurrency,relation) VALUES (6,'JPN','USD','D');


INSERT INTO ExchangeRate(id,fromCurrency,toCurrency,ratio) VALUES (1,'CAN','USD',0.9);
INSERT INTO ExchangeRate(id,fromCurrency,toCurrency,ratio) VALUES (2,'EUR','USD',1.9);
INSERT INTO ExchangeRate(id,fromCurrency,toCurrency,ratio) VALUES (3,'AUD','USD',0.95);
INSERT INTO ExchangeRate(id,fromCurrency,toCurrency,ratio) VALUES (4,'JPN','USD',400);
INSERT INTO ExchangeRate(id,fromCurrency,toCurrency,ratio) VALUES (5,'CHK','EUR',9.1);