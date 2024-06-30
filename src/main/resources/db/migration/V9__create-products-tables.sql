CREATE TABLE products (
    product_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    purchase_price DECIMAL(10,2) NOT NULL,
    sale_price DECIMAL(10,2) NOT NULL,
    purchase_date DATE DEFAULT CURRENT_DATE,
    sale_date DATE DEFAULT CURRENT_DATE,
    type VARCHAR(50) NOT NULL,
    state VARCHAR(15) NOT NULL,
    availability BOOLEAN NOT NULL DEFAULT TRUE,
    seller_Id BIGINT NOT NULL,
    buyer_Id BIGINT NOT NULL,
    FOREIGN KEY (seller_Id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (buyer_Id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE product_detail (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_Id BIGINT NOT NULL,
    material VARCHAR(20),
    fur VARCHAR(50),
    fur_type VARCHAR(50),
    tissue VARCHAR(50),
    width DECIMAL(10,2) CHECK ( width >= 0 ),
    long DECIMAL(10,2) CHECK ( long >= 0 ),
    weight DECIMAL(10,2) CHECK ( weight >= 0 ),
    weight_unit ENUM('kg','g','lb'),
    size_unit ENUM('cm','in'),
    FOREIGN KEY (product_Id) REFERENCES products(product_id) ON DELETE CASCADE
);