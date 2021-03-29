# java_billing_software
An open source java front end project which enables anyone with java, mysql installed to run a smooth and responsive Graphical Desktop Billing Software.

To use this software, we need mysql connector and itextpdf jar files.

The database tables used are as follows: (simple for now, can be enhanced with security and performance by using caches, checks)

# users
CREATE TABLE `users` (
  `name` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `account_type` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
# customers
CREATE TABLE `customers` (
  `name` varchar(50) NOT NULL,
  `email` varchar(85) DEFAULT NULL,
  `phone` varchar(10) NOT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
# items
CREATE TABLE `items` (
  `item_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `item_name` varchar(256) NOT NULL,
  `cost` float unsigned zerofill NOT NULL,
  `active` tinyint DEFAULT '1',
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `item_name_UNIQUE` (`item_name`)
) ENGINE=InnoDB AUTO_INCREMENT=632572653 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
# bills
CREATE TABLE `bills` (
  `id` int NOT NULL,
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `location_UNIQUE` (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
