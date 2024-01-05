-- Insert data into the `planes` table
INSERT INTO `planes` (`idPlan`, `velocity`, `price`, `discount`) VALUES
(1, 100, 29.99, 0.1),
(2, 200, 39.99, 0.15),
(3, 300, 49.99, 0.2),
(4, 400, 59.99, 0.25),
(5, 500, 69.99, 0.3);

-- Insert data into the `cliente` table
INSERT INTO `cliente` (`idCliente`, `name`, `lastName`, `dni`, `birthdate`, `province`, `city`, `FKidPlan`) VALUES
(1, 'John', 'Doe', 123456789, '1990-01-01', 'Province1', 'City1', 1),
(2, 'Jane', 'Smith', 987654321, '1995-02-15', 'Province2', 'City2', 2),
(3, 'Mike', 'Johnson', 456789123, '1988-05-20', 'Province3', 'City3', 3),
(4, 'Emily', 'Williams', 654321987, '1992-09-10', 'Province4', 'City4', 4),
(5, 'David', 'Brown', 789123456, '1985-11-30', 'Province5', 'City5', 5),
(6, 'Sophia', 'Miller', 321654987, '1998-03-25', 'Province1', 'City1', 1),
(7, 'Daniel', 'Wilson', 159753468, '1987-07-12', 'Province2', 'City2', 2),
(8, 'Olivia', 'Jones', 852369741, '1993-04-18', 'Province3', 'City3', 3),
(9, 'Ethan', 'Anderson', 147258369, '1996-08-05', 'Province4', 'City4', 4),
(10, 'Ava', 'Taylor', 369147258, '1989-12-22', 'Province5', 'City5', 5);