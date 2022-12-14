DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS accounts;

CREATE TABLE `customer` (
    `customer_id` int AUTO_INCREMENT primary KEY,
    `name` varchar(100) not null,
    `email` varchar(100) not null,
    `mobile_number` varchar(20) not null,
    `created_at` date default current_date
);

INSERT INTO `customer`(`name`, `email`, `mobile_number`) values ('Thais', 'thais@gmail.com', '987654337');

CREATE TABLE `accounts` (
  `customer_id` int not null,
  `id` int AUTO_INCREMENT primary KEY,
  `account_type` varchar(100) not null,
  `branch_address` varchar(200) not null,
  `created_at` date default current_date
);
INSERT INTO `accounts`(`customer_id`,`id`, `account_type`, `branch_address`) values (1,500, 'Debit', 'Casa #73, Bonao');