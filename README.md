# Console-Based-Banking-System-in-Java

This project is a simple console-based banking system made with Java. It allows users to perform basic banking operations such as account creation, deposit, money transfer and viewing transactions, all possible thru the console. This is created purely to practice on my Java Spring framework concepts.

Features:
1. Account creation: Users can create new accounts with a 12-digit unique account number and initial balance of 0.
2. Deposit: Users can deposit funds into their accounts.
3. Money Transfer: Users can transfer funds from their accounts to other users, provided they have sufficient balance.
4. Balance Inquiry: Users can check the balance of their accounts.
5. view Transaction: Every transaction made will be recorded and viewed.

Technologies Used:
1. Java programming with OOP concepts.
2. Java Spring framework.
3. MySQL database.
4. JDBC for the connection to the database.

# Database Creation:
CREATE TABLE Account (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    account_number VARCHAR(16) NOT NULL,
    balance DECIMAL(10, 2) DEFAULT 0.00,
);

CREATE TABLE Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
	account_id INT NOT NULL,
    name VARCHAR(100) DEFAULT 'USER',
    address VARCHAR(255),
    contact_number VARCHAR(15),
	FOREIGN KEY (account_id) REFERENCES Account(account_id)
);

CREATE TABLE Credentials (
    credential_id INT PRIMARY KEY AUTO_INCREMENT,
	account_id INT NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password char(60) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
);

CREATE TABLE Transaction (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    transaction_type ENUM('deposit', 'withdrawal','registration','edit_profile'),
    amount DECIMAL(10, 2),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
);

# Screenshots
![Login](https://github.com/jHallsG/Console-Based-Banking-System-in-Java/assets/134239144/142e245b-e643-4167-a4c5-23aa2e74d4d7)


![Main Menu](https://github.com/jHallsG/Console-Based-Banking-System-in-Java/assets/134239144/53eb65dc-9daa-4463-b6dd-ad100b6655f4)



![Transactions](https://github.com/jHallsG/Console-Based-Banking-System-in-Java/assets/134239144/a6615f56-ab79-4d93-a8dd-603deba5b450)

# Important Notes
This project is not made with maven as it is just a practice project. All jars used can be seen in ".classpath" file.

# Contact
For questions or suggestions regarding this project, feel free to contact me:

Jan Hassan Gahal
janhassg@gmail.com
