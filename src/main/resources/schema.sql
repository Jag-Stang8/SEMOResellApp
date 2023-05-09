-- Create User table
CREATE TABLE IF NOT EXISTS user_table (
    id NUMBER(10) PRIMARY KEY,
    username VARCHAR2(50) NOT NULL,
    password VARCHAR2(100) NOT NULL
);

-- Create Listing table
CREATE TABLE IF NOT EXISTS listing_table (
    id NUMBER(10) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    desc VARCHAR2(1000) NOT NULL,
    image VARCHAR2(200) NOT NULL,
    price NUMBER(10,2) NOT NULL,
    seller_id NUMBER(10) NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES user_table (id)
);

-- Create Checkout table
CREATE TABLE IF NOT EXISTS checkout_table (
    id NUMBER(10) PRIMARY KEY,
    total_price NUMBER(10,2) NOT NULL,
    order_date TIMESTAMP NOT NULL,
    buyer_id NUMBER(10) NOT NULL,
    items NUMBER(10) NOT NULL,
    FOREIGN KEY (buyer_id) REFERENCES user_table (id)
);

-- Create Order table
CREATE TABLE IF NOT EXISTS order_table (
    id NUMBER(10) PRIMARY KEY,
    quantity NUMBER(100) NOT NULL,
    price NUMBER(10,2) NOT NULL,
    status VARCHAR2(50) NOT NULL,
    seller_id NUMBER(10) NOT NULL,
    buyer_id NUMBER(10) NOT NULL,
    listing_id NUMBER(10) NOT NULL,
    checkout_id NUMBER(10) NOT NULL,
    FOREIGN KEY (buyer_id) REFERENCES user_table (id),
    FOREIGN KEY (seller_id) REFERENCES user_table (id),
    FOREIGN KEY (listing_id) REFERENCES listing_table (id),
    FOREIGN KEY (checkout_id) REFERENCES checkout_table (id)
);

-- Create Review table
CREATE TABLE IF NOT EXISTS review_table (
    id NUMBER(10) PRIMARY KEY,
    rating NUMBER(1) NOT NULL,
    content VARCHAR2(1000),
    order_id NUMBER(10) NOT NULL,
    buyer_id NUMBER(10) NOT NULL,
    seller_id NUMBER(10) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES order_table (id),
    FOREIGN KEY (buyer_id) REFERENCES user_table (id),
    FOREIGN KEY (seller_id) REFERENCES user_table (id)
);

-- Create Message table
CREATE TABLE IF NOT EXISTS message_table (
    id NUMBER(10) PRIMARY KEY,
    content VARCHAR2(1000) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sender_id NUMBER(10) NOT NULL,
    recipient_id NUMBER(10) NOT NULL,
    FOREIGN KEY (sender_id) REFERENCES user_table (id),
    FOREIGN KEY (recipient_id) REFERENCES user_table (id)
);

-- Create Cart table
CREATE TABLE IF NOT EXISTS cart_table (
    id NUMBER(10) PRIMARY KEY,
    quantity NUMBER(100) NOT NULL,
    status VARCHAR2(50) NOT NULL,
    user_id NUMBER(10) NOT NULL,
    cart_listings NUMBER(10) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_table (id),
    FOREIGN KEY (cart_listings) REFERENCES listing_table (id)
);

-- Create CartListing table
CREATE TABLE IF NOT EXISTS cart_listing (
    cart_id NUMBER(10) NOT NULL,
    listing_id NUMBER(10) NOT NULL,
    PRIMARY KEY (cart_id, listing_id),
    FOREIGN KEY (cart_id) REFERENCES cart_table (id),
    FOREIGN KEY (listing_id) REFERENCES listing_table (id)
);

INSERT INTO user_table (id, username, password) VALUES (1000, 'testuser', 'testpassword');