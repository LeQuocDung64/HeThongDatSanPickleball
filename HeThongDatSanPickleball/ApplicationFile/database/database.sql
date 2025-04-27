-- Tạo CSDL
CREATE DATABASE IF NOT EXISTS pickleball_shop;
USE pickleball_shop;

-- Bảng sản phẩm
CREATE TABLE products (
                          id INT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          price INT NOT NULL,
                          category ENUM('food', 'equipment') NOT NULL,
                          image VARCHAR(255),
                          is_new BOOLEAN DEFAULT FALSE
);

-- Bảng giỏ hàng
create table cart_items (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            product_id INT,
                            quantity INT NOT NULL DEFAULT 1,
                            FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Bảng đơn hàng
CREATE TABLE orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        customer_name VARCHAR(100),
                        phone VARCHAR(15),
                        address TEXT,
                        payment_method ENUM('cash', 'card', 'momo'),
                        total_amount INT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Thêm sản phẩm vào bảng products
INSERT INTO products (id, name, price, category, image, is_new) VALUES
 (1, 'Bánh mì sandwich', 35000, 'food', 'https://plus.unsplash.com/...b98e5', TRUE),
 (2, 'Nước ép cam', 30000, 'food', 'https://plus.unsplash.com/...f4a6', FALSE),
(3, 'Sữa chua Hy Lạp', 25000, 'food', 'https://images.unsplash.com/...05df', FALSE),
(4, 'Revive thường', 10000, 'food', 'https://cdn.tgdd.vn/...543.jpg', FALSE),
(5, 'Revive chanh muối', 12000, 'food', 'https://thegioidouong.net/...jpg', FALSE),
(6, 'Nước ngọt các loại', 10000, 'food', 'https://file.hstatic.net/...94.jpg', FALSE),
(7, 'Mì xào hải sản', 40000, 'food', 'https://www.maggi.com.vn/...70.jpg', TRUE),
(8, 'Cà phê sữa đá', 30000, 'food', 'https://ongbi.vn/...jpg', FALSE),
(9, 'Cà phê đá', 25000, 'food', 'https://bizweb.dktcdn.net/...jpg', FALSE),
 (10, 'Giày đế mềm', 850000, 'equipment', 'https://lh7-rt.googleusercontent.com/...GQU', FALSE),
(11, 'Băng đeo cổ tay', 50000, 'equipment', 'https://down-vn.img.susercontent.com/...wrx8f', FALSE),
(12, 'Túi đựng bóng', 120000, 'equipment', 'https://bissport.com/...png', TRUE),
(13, 'Quả bóng', 100000, 'equipment', 'https://file.hstatic.net/...png', FALSE);


CREATE TABLE courts (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100),
                        type VARCHAR(50),
                        description TEXT,
                        image_url VARCHAR(255)
);

CREATE TABLE booking (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          full_name VARCHAR(100),
                          email VARCHAR(100),
                          court_type VARCHAR(50),
                          booking_date DATE,
                          booking_time TIME
);
INSERT INTO courts (name, type, description, image_url) VALUES
('null', 'VIP', 'Sân cao cấp với bề mặt tiêu chuẩn, hệ thống chiếu sáng hiện đại, phù hợp người chơi nâng cao và sân mướt siêu đẹp. Hợp cho giải đấu hoặc trải nghiệm sang trọng.', '/img/SanVip.png'),
('null', 'Trong Nhà', 'Sân với mái che, ánh sáng nhân tạo và điều hòa. Lý tưởng chơi bất kỳ thời điểm nào, đặc biệt khi thời tiết xấu.', '/img/sanNha.png'),
('null', 'Ngoài Trời', 'Sân với không gian thoáng đãng, chi phí thấp. Phù hợp cho các trận đấu giải trí hoặc luyện tập ban ngày.', '/img/sanNgoaiTroi.png'),
('null', 'Tiêu Chuẩn', 'Sân đúng quy chuẩn quốc tế (13.41m x 6.1m), bề mặt chất lượng cao. Phù hợp giải đấu chính thức và luyện tập chuyên nghiệp.', '/img/sanTieuChuan.png'),
('null', 'Thường', 'Sân cải biên, thường chuyển đổi từ sân tennis hoặc đa năng. Chi phí rẻ, phù hợp cho người mới chơi hoặc giải trí.', '/img/sanThuong.png');
