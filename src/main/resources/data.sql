DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      lprice VARCHAR(250) NOT NULL,
                      curr1 VARCHAR(250) NOT NULL,
                      curr2 VARCHAR(250) NOT NULL,
		      		  create_date TIMESTAMP(6) NOT NULL
);

INSERT INTO prices (id, lprice, curr1, curr2, create_date) VALUES (1,'34324.6','BTCaaa','USD',{ts '2021-07-06 10:30:15'})