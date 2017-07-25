INSERT INTO Currency(code,country) VALUES ('USD','United States Of America');
INSERT INTO Currency(code,country) VALUES ('EUR','Europe');
INSERT INTO Currency(code,country) VALUES ('IND','India');
INSERT INTO Currency(code,country) VALUES ('AUD','Australia');
INSERT INTO Currency(code,country) VALUES ('CAN','Canada');
INSERT INTO Currency(code,country) VALUES ('CHK','check repulic');
INSERT INTO Currency(code,country) VALUES ('IND','India');

INSERT INTO CurrencyMatrix(base,toCurr,relation) VALUES ('IND','USD','D');
INSERT INTO CurrencyMatrix(base,toCurr,relation) VALUES ('CAD','USD','D');
INSERT INTO CurrencyMatrix(base,toCurr,relation) VALUES ('EUR','USD','D');
INSERT INTO CurrencyMatrix(base,toCurr,relation) VALUES ('AUD','USD','D');
INSERT INTO CurrencyMatrix(base,toCurr,relation) VALUES ('CHK','EUR','D');
INSERT INTO CurrencyMatrix(base,toCurr,relation) VALUES ('USD','USD','D');
INSERT INTO CurrencyMatrix(base,toCurr,relation) VALUES ('IND','USD','D');

