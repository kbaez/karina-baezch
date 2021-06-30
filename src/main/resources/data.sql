DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      lprice VARCHAR(250) NOT NULL,
                      curr1 VARCHAR(250) NOT NULL,
                      curr2 VARCHAR(250) NOT NULL,
		      create_date TIMESTAMP(6) NOT NULL
);