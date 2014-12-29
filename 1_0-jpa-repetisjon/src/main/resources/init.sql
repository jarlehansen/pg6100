INSERT INTO Customer (id, name, street, zip) VALUES(1, 'Tuva', 'Veien 1', '2000');
INSERT INTO Customer (id, name, street, zip) VALUES(2, 'Ola', 'Veien 2', '0150');
INSERT INTO Customer (id, name, street, zip) VALUES(3, 'Mari', 'Veien 3', '0150');

INSERT INTO Receipt (id, customer_id) VALUES(4, 1);
INSERT INTO Receipt (id, customer_id) VALUES(5, 2);
INSERT INTO Receipt (id, customer_id) VALUES(6, 3);

INSERT INTO Item (id, description, price, receipt_id) VALUES(7, 'Jakke', 599, 4);
INSERT INTO Item (id, description, price, receipt_id) VALUES(8, 'Lue', 199, 4);
INSERT INTO Item (id, description, price, receipt_id) VALUES(9, 'Bukse', 399, 5);
INSERT INTO Item (id, description, price, receipt_id) VALUES(10, 'Genser', 499, 6);