--restaurants
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (1, '名古屋和食亭', 'image11.jpg', '名古屋の伝統的な和食を楽しめる落ち着いた雰囲気のお店。', '11:00', '22:00', 1000, 5000, '460-0008', '愛知県名古屋市中央区栄1-2-3', '052-123-4567', 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (2, '名古屋洋食堂', 'image07.jpg', '名古屋風の洋食を提供するカジュアルなレストラン。', '10:00', '21:00', 1500, 4000, '460-0008', '愛知県名古屋市中区栄4-5-6', '052-234-5678', 2);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (3, '名古屋うどん屋', 'image06.jpg', '名古屋名物のきしめんが楽しめるお店。', '11:00', '20:00', 800, 2000, '460-0008', '愛知県名古屋市中区栄7-8-9', '052-345-6789', 3);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (4, '名古屋揚げ物屋', 'image01.jpg', '名古屋名物の手羽先や味噌カツが楽しめるお店。', '12:00', '22:00', 800, 3000, '460-0008', '愛知県名古屋市中区栄22-23-24', '052-890-1234', 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (5, '名古屋焼き肉館', 'image13.jpg', '名古屋風の特製タレで楽しむ焼き肉店。', '17:00', '23:00', 2000, 6000, '460-0008', '愛知県名古屋市中区栄25-26-27', '052-901-2345', 4);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (6, '名古屋デザートパラダイス', 'image05.jpg', '名古屋名物のスイーツが楽しめるカフェ。', '10:00', '20:00', 500, 1500, '460-0008', '愛知県名古屋市中区栄28-29-30', '052-012-3456', 6);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (7, '名古屋丼丸', 'image03.jpg', '名古屋名物のひつまぶしや天丼が人気の店。', '11:00', '22:00', 1200, 3000, '460-0008', '愛知県名古屋市中区栄16-17-18', '052-678-9012', 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (8, '名古屋バーガーショップ', 'image15.jpg', '名古屋風味の特製バーガーが人気のお店。', '11:00', '21:00', 700, 2000, '460-0003', '名古屋市中区錦3-24-4', '052-123-8901', 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (9, 'イタリアン トラットリア・マルゲリータ', 'image14.jpg', '本格的なイタリア料理とピザが自慢の店。', '11:00', '22:00', 1200, 6000, '460-0011', '名古屋市東区葵1-14-1', '052-345-1234', 2);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (10, '鰻の名店', 'image02.jpg', '名古屋名物ひつまぶしが楽しめる専門店。', '11:30', '21:30', 2000, 8000, '460-0008', '名古屋市中区栄1-5-7', '052-234-5678', 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (11, 'ダイニングカフェ ラ・パルマ', 'image08.jpg', 'モダンな雰囲気で洋食を楽しめるダイニングカフェ。', '10:00', '21:00', 1000, 5000, '460-0012', '愛知県名古屋市中区新栄3-2-4', '052-456-2345', 2);
INSERT IGNORE INTO restaurants (id, name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id) VALUES (12, '和風居酒屋 わかば', '新鮮な魚介を使った料理が楽しめる居酒屋。', '17:00', '23:00', 2000, 7000, '460-0012', '名古屋市中区新栄2-10-12', '052-456-7890', 5);




--categories
INSERT IGNORE INTO categories (id, name) VALUES (1, '和食');
INSERT IGNORE INTO categories (id, name) VALUES (2, '洋食');
INSERT IGNORE INTO categories (id, name) VALUES (3, '麺類');
INSERT IGNORE INTO categories (id, name) VALUES (4, '焼肉');
INSERT IGNORE INTO categories (id, name) VALUES (5, '海鮮系');
INSERT IGNORE INTO categories (id, name) VALUES (6, 'スイーツ');
INSERT IGNORE INTO categories (id, name) VALUES (7, 'ハンバーガー');
INSERT IGNORE INTO categories (id, name) VALUES (8, '丼もの');
INSERT IGNORE INTO categories (id, name) VALUES (9, 'お好み焼き');
INSERT IGNORE INTO categories (id, name) VALUES (10, '鍋');
INSERT IGNORE INTO categories (id, name) VALUES (11, '郷土料理');


--roles
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_PREMIUM');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');



--users
delete from users;
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '侍 太郎', 'サムライ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (2, '侍 花子', 'サムライ ハナコ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 3, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (3, '侍 義勝', 'サムライ ヨシカツ', '638-0644', '奈良県五條市西吉野町湯川X-XX-XX', '090-1234-5678', 'yoshikatsu.samurai@example.com', 'password', 2, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (4, '侍 幸美', 'サムライ サチミ', '342-0006', '埼玉県吉川市南広島X-XX-XX', '090-1234-5678', 'sachimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (5, '侍 雅', 'サムライ ミヤビ', '527-0209', '滋賀県東近江市佐目町X-XX-XX', '090-1234-5678', 'miyabi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (6, '侍 正保', 'サムライ マサヤス', '989-1203', '宮城県柴田郡大河原町旭町X-XX-XX', '090-1234-5678', 'masayasu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (7, '侍 真由美', 'サムライ マユミ', '951-8015', '新潟県新潟市松岡町X-XX-XX', '090-1234-5678', 'mayumi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (8, '侍 安民', 'サムライ ヤスタミ', '241-0033', '神奈川県横浜市旭区今川町X-XX-XX', '090-1234-5678', 'yasutami.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (9, '侍 章緒', 'サムライ アキオ', '739-2103', '広島県東広島市高屋町宮領X-XX-XX', '090-1234-5678', 'akio.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (10, '侍 祐子', 'サムライ ユウコ', '601-0761', '京都府南丹市美山町高野X-XX-XX', '090-1234-5678', 'yuko.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (11, '侍 秋美', 'サムライ アキミ', '606-8235', '京都府京都市左京区田中西春菜町X-XX-XX', '090-1234-5678', 'akimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (12, '侍 信平', 'サムライ シンペイ', '673-1324', '兵庫県加東市新定X-XX-XX', '090-1234-5678', 'shinpei.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (2, '侍 テスト', 'サムライ テスト', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'test.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 3, true);




--reservations
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (1, 5, 1, '2024-06-29', '21:00', 3);  
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (2, 1, 1, '2024-07-05', '21:00', 5); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (3, 6, 1, '2024-07-10', '21:00', 2); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (4, 10, 1, '2024-07-17', '21:00', 6); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (5, 2, 1, '2024-07-26', '21:00', 2); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (6, 4, 1, '2024-07-31', '21:00', 3); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (7, 11, 1, '2024-08-01', '21:00', 5); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (8, 8, 1, '2024-08-14', '21:00', 3); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (9, 7, 1, '2024-08-20', '21:00', 5); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (10, 3, 1, '2024-08-23', '21:00', 2); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (11, 9, 1, '2024-08-29', '21:00', 4); 
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (12, 12, 1, '2024-08-30', '21:00', 6); 




--reviews
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (1, 1, 1, 5, '落ち着いた雰囲気でゆっくり過ごせました。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (2, 1, 2, 4, '伝統的なたれがおいしかったです。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (3, 1, 3, 4, '駅からも近く分かりやすいところにありました。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (4, 1, 4, 5, 'メニューが豊富なのでまた行きたいです。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (5, 1, 5, 4, '待ち時間も短くて良かったです。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (6, 1, 6, 5, '店員さんの対応がとてもよかったです。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (7, 1, 7, 4, '安くて美味しくて最高でした。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (8, 1, 8, 3, '清潔感がありよかったです。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (9, 1, 9, 4, '安い、早い、うまいで最高でした。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (10, 1, 10, 5, '英語で対応している店員さんもいてすごかったです。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (11, 1, 11, 4, '座席も多く子連れでも入りやすかったです。');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, score, content) VALUES (12, 1, 12, 5, 'おいしかったです。');



--favorites
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (1, 1, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (2, 2, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (3, 3, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (4, 4, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (5, 5, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (6, 6, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (7, 7, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (8, 8, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (9, 9, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (10, 10, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (11, 11, 1);
 INSERT IGNORE INTO favorites (id, restaurant_id, user_id) VALUES (12, 12, 1);
