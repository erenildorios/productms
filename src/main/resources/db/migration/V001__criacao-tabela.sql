
CREATE TABLE produto (
    `id` varchar(40) NOT NULL,
    `description` varchar(60) NOT NULL,
    `name` varchar(50) NOT NULL,
    `price` decimal(19,2) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
