DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
account_id SERIAL PRIMARY KEY,
username varchar (20) UNIQUE NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name varchar(50) NOT NULL,
balance MONEY NOT NULL
);


INSERT
	INTO
	accounts (username,
	first_name,
	last_name,
	balance)
VALUES ('JS123',
'John',
'Smith',
'50000');

INSERT
	INTO
	accounts (username,
	first_name,
	last_name,
	balance)
VALUES ('JB098',
'Jane',
'Baker',
'80000');

DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions ( 
transaction_id SERIAL PRIMARY KEY,
username VARCHAR(20) UNIQUE NOT NULL,
withdrawl MONEY,
deposit MONEY,
memo varchar(500),
CONSTRAINT fk_account FOREIGN KEY(username) 
REFERENCES accounts(username) 
);

INSERT 
	INTO transactions (
	username,
	withdrawl,
	deposit,
	memo
	)
	VALUES (
	'JS123',
	'0',
	'3000',
	'just got paid'
	);
INSERT 
INTO transactions (
username,
withdrawl,
deposit,
memo 
)
VALUES (
'JB098',
'1000',
'0',
'');

UPDATE accounts 
SET balance = ((SELECT balance FROM accounts WHERE username = JS123)-)


