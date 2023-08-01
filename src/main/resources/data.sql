INSERT INTO TB_MEMBER ( MEMBER_SEQ
                      , MEMBER_ID
                      , MEMBER_NAME
                      , MEMBER_PWD)
VALUES (
           NEXTVAL('MEMBER_SEQ')
       , 'test'
       , '테스터'
       , 'test123');
