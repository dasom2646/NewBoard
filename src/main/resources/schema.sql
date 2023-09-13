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
    BOARD_SEQ  BIGINT  PRIMARY KEY NOT NULL,
    BOARD_TITLE VARCHAR(100) NOT NULL,
    BOARD_CONTENT TEXT NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL,
    BOARD_VIEWS INT DEFAULT 0,
    CATEGORY VARCHAR(255) NOT NULL,
    MEMBER_SEQ BIGINT, -- 맴버 테이블의 시퀀스를 참조하는 외래 키
    FILENAME VARCHAR(255), -- 파일명 컬럼 추가
    CONSTRAINT fk_MEMBER_SEQ FOREIGN KEY (MEMBER_SEQ) REFERENCES TB_MEMBER (MEMBER_SEQ)
    );

-- 댓글 테이블 생성
CREATE TABLE TB_comment (
    comment_seq BIGINT PRIMARY KEY NOT NULL,
    content VARCHAR(1000),
    created_date TIMESTAMP NOT NULL,
    member_seq BIGINT,
    board_seq BIGINT,
   FOREIGN KEY (MEMBER_SEQ) REFERENCES TB_MEMBER(MEMBER_SEQ),
   FOREIGN KEY (BOARD_SEQ) REFERENCES TB_BOARD(BOARD_SEQ)
);
-- 좋아요 테이블 생성

CREATE TABLE IF NOT EXISTS TB_LIKE (
    LIKE_SEQ BIGINT PRIMARY KEY NOT NULL,
    MEMBER_SEQ BIGINT, -- 맴버 테이블의 시퀀스를 참조하는 외래 키
    BOARD_SEQ BIGINT, -- 게시판 테이블의 시퀀스를 참조하는 외래 키
    CREATED_AT TIMESTAMP NOT NULL,
    CONSTRAINT fk_LIKE_MEMBER_SEQ FOREIGN KEY (MEMBER_SEQ) REFERENCES TB_MEMBER (MEMBER_SEQ),
    CONSTRAINT fk_LIKE_BOARD_SEQ FOREIGN KEY (BOARD_SEQ) REFERENCES TB_BOARD (BOARD_SEQ)
);


-- 시퀀스
CREATE SEQUENCE IF NOT EXISTS MEMBER_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS BOARD_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS COMMENT_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS LIKE_SEQ START WITH 1 INCREMENT BY 1;


