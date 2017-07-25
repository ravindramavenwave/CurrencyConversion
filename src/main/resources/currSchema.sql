drop TABLE Currency;
drop TABLE CurrencyMatrix;

create TABLE Currency(id INT PRIMARY KEY ,code VARCHAR(3) NOT NULL, country VARCHAR(100));
create TABLE CurrencyMatrix(id INT PRIMARY KEY ,base VARCHAR(3) FOREIGN KEY REFERENCES Currency(id),toCurr VARCHAR(3) FOREIGN KEY REFERENCES Currency(id),relation VARCHAR(3));