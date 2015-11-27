DROP DATABASE IF EXISTS bookstore;
create database bookstore;

USE bookstore;

DROP TABLE IF EXISTS books;

CREATE TABLE wydawnictwo(
    id_wyd INT UNSIGNED NOT NULL auto_increment, 
    wydawnictwo varchar(255),

    PRIMARY KEY(id_wyd)
);

INSERT INTO wydawnictwo (wydawnictwo) VALUES( "Nowa Era" );
INSERT INTO wydawnictwo (wydawnictwo) VALUES( "Zamkor" );
INSERT INTO wydawnictwo (wydawnictwo) VALUES( "PW" );

CREATE TABLE kategoria(
	id_kat int unsigned NOT NULL auto_increment,
	nazwa_kat varchar(255),

	PRIMARY KEY(id_kat)
);

INSERT INTO kategoria (nazwa_kat) VALUES ("Fizyka");
INSERT INTO kategoria (nazwa_kat) VALUES ("Chemia");
INSERT INTO kategoria (nazwa_kat) VALUES ("J. Polski");
INSERT INTO kategoria (nazwa_kat) VALUES ("Matematyka");

CREATE TABLE books(
	id		int  NOT NULL auto_increment,
	title	varchar(255) NOT NULL,
	author	varchar(255) NOT NULL,
	price	decimal(10, 2)NOT NULL,
	wydawnictwo_id int unsigned NOT NULL,
	kategoria int unsigned NOT NULL,
	FOREIGN KEY (wydawnictwo_id) REFERENCES wydawnictwo(id_wyd),
	FOREIGN KEY (kategoria) REFERENCES kategoria(id_kat),

	PRIMARY KEY(id)
);

INSERT INTO books ( title, author, price, wydawnictwo_id, kategoria ) VALUES ( "The Grapes of Wrath", "John Steinbeck", 12.99, 1, 1 );
INSERT INTO books ( title, author, price, wydawnictwo_id, kategoria ) VALUES ( "Nineteen Eighty-Four", "George Orwell", 8.99, 1, 3 );
INSERT INTO books ( title, author, price, wydawnictwo_id, kategoria ) VALUES ( "The Wind-Up Bird Chronicle", " Haruki Murakami", 15.99, 2, 2 );
INSERT INTO books ( title, author, price, wydawnictwo_id, kategoria ) VALUES ( "Metody numeryczne", "S. Wincenciak", 129.99, 3, 2 );
INSERT INTO books ( title, author, price, wydawnictwo_id, kategoria ) VALUES ( "Teoria obwodów", "Stanisław Osowski", 599.99, 1, 3 );

CREATE TABLE zamowienie(
	id_zamowienia int NOT NULL auto_increment,
	status varchar(255) NOT NULL,
	data date NOT NULL, 

	PRIMARY KEY(id_zamowienia)
);

INSERT INTO zamowienie ( status, data ) VALUES ("wykonane", '2015-11-15');
INSERT INTO zamowienie ( status, data ) VALUES ("niewykonane", '2015-11-13');
INSERT INTO zamowienie ( status, data ) VALUES ("wykonane", '2015-11-1');
INSERT INTO zamowienie ( status, data ) VALUES ("wykonane", '2015-11-12');
INSERT INTO zamowienie ( status, data ) VALUES ("wykonane", '2015-11-17');
INSERT INTO zamowienie ( status, data ) VALUES ("niewykonane", '2015-11-10');

CREATE TABLE ksiazki_zamowione(
	id_z int NOT NULL auto_increment,
	id_k int NOT NULL,
	liczba_ksiazek int NOT NULL,
	FOREIGN KEY (id_k) REFERENCES books(id),
	FOREIGN KEY (id_z) REFERENCES zamowienie(id_zamowienia),

	PRIMARY KEY(id_z)
);

INSERT INTO ksiazki_zamowione (liczba_ksiazek, id_k) VALUES ( 21, 2 );
INSERT INTO ksiazki_zamowione (liczba_ksiazek, id_k) VALUES ( 42, 4 );
INSERT INTO ksiazki_zamowione (liczba_ksiazek, id_k) VALUES ( 53, 5);
INSERT INTO ksiazki_zamowione (liczba_ksiazek, id_k) VALUES ( 132, 1);
INSERT INTO ksiazki_zamowione (liczba_ksiazek, id_k) VALUES ( 123, 3 );
INSERT INTO ksiazki_zamowione (liczba_ksiazek, id_k) VALUES ( 334, 2 );


