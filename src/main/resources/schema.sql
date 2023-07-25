CREATE TABLE IF NOT EXISTS member_tb

(
    id INT PRIMARY KEY,
    user_id VARCHAR(255),
    user_name VARCHAR(255),
    user_pwd VARCHAR(255)

);

CREATE TABLE IF NOT EXISTS board_tb

(
    boardId INT PRIMARY KEY,
    title VARCHAR(255),
    content VARCHAR(255),
    writerDate VARCHAR(255)
    postCount
    );



CREATE SEQUENCE IF NOT EXISTS my_sequence START WITH 1 INCREMENT BY 1;