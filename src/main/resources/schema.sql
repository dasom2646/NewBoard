-- 맴버 테이블 생성
CREATE TABLE IF NOT EXISTS TB_MEMBER
(
    MEMBER_SEQ BIGINT PRIMARY KEY,
    MEMBER_ID VARCHAR(255) NOT NULL,
    MEMBER_NAME VARCHAR(255) NOT NULL,
    MEMBER_PWD VARCHAR(255) NOT NULL
    );


-- 보드 테이블 생성
CREATE TABLE IF NOT EXISTS TB_BOARD
(
    BOARD_SEQ  INT  PRIMARY KEY NOT NULL,
    BOARD_TITLE VARCHAR(100) NOT NULL,
    BOARD_CONTENT TEXT NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL,
    BOARD_VIEWS INT DEFAULT 0,
    CATEGORY VARCHAR(255) NOT NULL,
    MEMBER_SEQ BIGINT, -- 맴버 테이블의 시퀀스를 참조하는 외래 키
    FILENAME VARCHAR(255), -- 파일명 컬럼 추가
    FILE_DATA BLOB, -- 파일 데이터 컬럼 추가
    CONSTRAINT fk_MEMBER_SEQ FOREIGN KEY (MEMBER_SEQ) REFERENCES TB_MEMBER (MEMBER_SEQ)
    );

CREATE TABLE IF NOT EXISTS TB_COMMENT (
    COMMENT_SEQ INT PRIMARY KEY NOT NULL,
    CONTENT TEXT NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL,
    MEMBER_SEQ BIGINT, -- 회원 테이블의 시퀀스를 참조하는 외래 키
    CONSTRAINT fk_COMMENT_MEMBER_SEQ FOREIGN KEY (MEMBER_SEQ) REFERENCES TB_MEMBER (MEMBER_SEQ)
);
-- 시퀀스
CREATE SEQUENCE IF NOT EXISTS MEMBER_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS BOARD_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS COMMENT_SEQ START WITH 1 INCREMENT BY 1;


