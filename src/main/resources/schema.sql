-- 맴버 테이블 생성
CREATE TABLE IF NOT EXISTS member_tb
(
    ID BIGINT PRIMARY KEY,
    USER_ID VARCHAR(255) NOT NULL,
    USER_NAME VARCHAR(255) NOT NULL,
    USER_PED VARCHAR(255) NOT NULL
    );

-- 보드 테이블 생성
CREATE TABLE IF NOT EXISTS board_tb
(
    board_Id BIGINT PRIMARY KEY,
    board_Title VARCHAR(255) NOT NULL,
    board_content TEXT,
    writer_Date TIMESTAMP NOT NULL,
    board_Count INT DEFAULT 0,
    member_Id BIGINT, -- 맴버 테이블의 ID를 참조하는 외래 키
    CONSTRAINT fk_member_id FOREIGN KEY (member_Id) REFERENCES member_tb (ID)
    );



 CREATE SEQUENCE IF NOT EXISTS my_sequence START WITH 1 INCREMENT BY 1;