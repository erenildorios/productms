# DESAFIO COMPASSO UOL

## CONFIGURAÇÃO DE BANCO DE DADOS
```
 BANCO DE DADOS : MYSQL 8.0
 USUARIO: root | SENHA: root
 DATABASE: DB_CATALOGO
 
 Para a criação do database e da tabela proposta pelo desafio, foi utilizado o Flyway.
 Vai ser criado a tabela produto de acordo com a DDL:
 ```
 ```sql CREATE TABLE `produto` (
     `id` varchar(40) NOT NULL,
     `description` varchar(60) NOT NULL,
     `name` varchar(50) NOT NULL,
     `price` decimal(19,2) NOT NULL,
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
   ```
