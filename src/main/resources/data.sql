INSERT INTO TB_MEMBER ( MEMBER_SEQ
                      , MEMBER_ID
                      , MEMBER_NAME
                      , MEMBER_PWD)
VALUES (
           NEXTVAL('MEMBER_SEQ')
       , 'test'
       , '테스터'
       , 'test123');


INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES (
           NEXTVAL('BOARD_SEQ')
       , '6살 최유월'
       , '귀여운 게 죄라면, 유월이는 무기징역'
       , CURRENT_TIMESTAMP
       , '0'
       , '반려동물'
       , '1' );