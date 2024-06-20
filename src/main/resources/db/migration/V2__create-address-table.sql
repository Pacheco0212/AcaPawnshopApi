CREATE TABLE address(
    addressId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_Id BIGINT NOT NULL,
    street VARCHAR(50),
    num INT,
    CP VARCHAR(5),
    municipality VARCHAR(50),
    state VARCHAR(50),
    FOREIGN KEY (user_Id) REFERENCES users(user_id) ON DELETE CASCADE
);