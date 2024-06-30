CREATE TABLE ticket(
    ticket_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ticket_number VARCHAR(20) UNIQUE NOT NULL,
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_Id BIGINT NOT NULL,
    product_Id BIGINT NOT NULL,
    FOREIGN KEY (user_Id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (product_Id) REFERENCES products(product_id) ON DELETE CASCADE
);