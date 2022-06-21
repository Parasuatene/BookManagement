-- 書籍テーブル
CREATE TABLE t_book (
    id SERIAL NOT NULL
    , title VARCHAR(50) NOT NULL
    , author VARCHAR(50)
    , publisher VARCHAR(50)
    , img_path VARCHAR(50)
    , discription VARCHAR(1000)
    , PRIMARY KEY(id)
);

INSERT INTO
    t_book (title, author, publisher, discription)
VALUES 
    (
        '徹底攻略Java SE 11 Silver問題集［1Z0-815］対応'
        , '志賀 澄人'
        , '株式会社ソキウス・ジャパン'
        , 'オラクル社の資格試験「Oracle Certified Java Programmer, Silver SE 11 認定資格（試験番号：1Z0-815-JPN）」に完全対応！'
    )
    , (
        '独習JavaScript 新版'
        , '外村 将大'
        , '翔泳社'
        , 'JavaScript標準教科書が人気講師の書き下ろしで新登場！'
    )
    , (
        '動かして学ぶ！Git入門'
        , '冨永 和人'
        , '翔泳社'
        , 'JavaScript“標準教科書”が人気講師の書き下ろしで新登場！'
    );


-- ユーザーテーブル
CREATE TABLE t_user (
    id VARCHAR(50) NOT NULL
    , password VARCHAR(100) NOT NULL
    , last_name VARCHAR(20) NOT NULL
    , first_name VARCHAR(20) NOT NULL
    , authority INTEGER NOT NULL
    , PRIMARY KEY(id)
);


-- 貸出管理テーブル
CREATE TABLE t_rental_control(
    id SERIAL NOT NULL
    , user_id VARCHAR NOT NULL
    , book_id INTEGER NOT NULL
    , start_date DATE NOT NULL
    , schedule_date DATE NOT NULL
    , end_date DATE
    , PRIMARY KEY(id)
    , FOREIGN KEY(user_id) REFERENCES t_user(id)
    , FOREIGN KEY(book_id) REFERENCES t_book(id)
);

insert into t_rental_control(user_id, book_id, start_date, schedule_date) values('ryota_a', 1, '2022-06-23', '2022-06-28');


select * from t_book left outer join t_rental_control on t_book.id = t_rental_control.book_id;

-- 重複削除
create view v_latest_rental_info as select * from t_rental_control where id in (select max(id) from t_rental_control group by book_id);

-- 該当ユーザの貸出書籍リストを取得する
select * from v_latest_rental_info where user_id = 'ryota_a' and start_date is not null and end_date is null 

select * from (select * from v_latest_rental_info where user_id = 'ryota_a' and start_date is not null and end_date is null ) as vl
inner join t_book as tb on vl.book_id = tb.id;


SELECT tb.id AS tb_id, tb.title AS tb_title, tb.author AS tb_author, tb.publisher AS tb_publisher, tb.img_path AS tb_img_path, 
tb.discription AS tb_discription, vr.id AS vr_id, vr.user_id AS vr_user_id, vr.book_id AS vr_book_id, vr.start_date AS vr_start_date, vr.schedule_date
 AS vr_schedule_date, vr.end_date AS vr_end_date 
FROM (SELECT * FROM v_latest_rental_info AS vr WHERE user_id='yamada_taro' AND start_date IS NOT NULL AND end_date IS NULL) AS vr
INNER JOIN t_book AS tb ON vr.book_id = tb.id;


SELECT tb.id AS tb_id, tb.title AS tb_title, tb.author AS tb_author, tb.publisher AS tb_publisher, tb.img_path AS tb_img_path, 
tb.discription AS tb_discription, vr.id AS vr_id, vr.user_id AS vr_user_id, vr.book_id AS vr_book_id, vr.start_date AS vr_start_date, vr.schedule_date
 AS vr_schedule_date, vr.end_date AS vr_end_date 
FROM (SELECT * FROM t_rental_control AS vr WHERE user_id='yamada_taro' AND start_date IS NOT NULL AND end_date IS NULL) AS vr
INNER JOIN t_book AS tb ON vr.book_id = tb.id;