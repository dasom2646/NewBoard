INSERT INTO TB_MEMBER ( MEMBER_SEQ
                      , MEMBER_ID
                      , MEMBER_NAME
                      , MEMBER_PWD)
VALUES ( NEXTVAL('MEMBER_SEQ')
       , 'test'
       , '테스터'
       , 'test123');

-- 게시판 데이터
INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES ( NEXTVAL('BOARD_SEQ')
       , '6살 최유월'
       , '귀여운 게 죄라면, 유월이는 무기징역'
       , CURRENT_TIMESTAMP
       , '0'
       , '반려동물'
       , '1');


INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES ( NEXTVAL('BOARD_SEQ')
       , '늦가을 감성, 〈남한산성〉'
       , '오늘 소개할 책은 〈남한산성〉입니다. 이 책은 정승이라는 유명한 소설가가 쓴 작품으로, 한국 전쟁 당시의 서울을 배경으로 한 인간적 감성과 사랑을 그려냅니다. ' ||
         '주인공들의 우정과 사랑, 인간의 미련과 아픔이 서려 있어서 여운이 길게 남는 작품입니다. 늦가을의 낭만을 느낄 수 있는 추천 도서입니다.'
       , CURRENT_TIMESTAMP
       , '0'
       , '오늘의 책'
       , '1');

INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES ( NEXTVAL('BOARD_SEQ')
       , '인간의 역사를 바꾼 책, 〈유럽 혼돈의 시대〉'
       , '오늘 소개할 책은 〈유럽 혼돈의 시대〉입니다. ' ||
         '이 책은 루이스 앤더슨이 지은 역사 서적으로, 미국의 작가이자 연구자인 그는 유럽 역사의 중요한 사건들을 압축적으로 정리해냈습니다. ' ||
         '중세부터 현대까지의 유럽의 변화와 동요를 자세히 풀어냅니다. 이 책을 통해 우리는 현대 문명의 근간을 이루는 역사적 배경을 이해할 수 있습니다.'
       , CURRENT_TIMESTAMP
       , '0'
       , '오늘의 책'
       , '1');

INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES ( NEXTVAL('BOARD_SEQ')
       , '인생을 흔든 자기계발서, 〈멘토〉'
       , '오늘 소개할 책은 〈멘토〉입니다. 이 책은 래리 벤트와 편집자 존 헤슬러가 공동으로 저술한 자기계발서로, 성공을 이룬 사람들이 자신의 성공 비결과 멘토로서의 경험을 나누는 내용입니다. ' ||
         '특히 래리 벤트는 자신의 인생을 흔든 사연과 그로 인해 배운 교훈을 솔직하게 털어냅니다. 성공에 대한 통찰과 에너지를 얻을 수 있는 책입니다.'
       , CURRENT_TIMESTAMP
       , '0'
       , '오늘의 책'
       , '1');

INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES ( NEXTVAL('BOARD_SEQ')
       , '긍정의 힘, 〈하버드 행복 수업〉'
       , '오늘 소개할 책은 〈하버드 행복 수업〉입니다. 이 책은 행복과 긍정의 중요성을 강조하는 션 앵츠가 쓴 셀프 헬프 서적입니다. ' ||
         '하버드 대학교에서 행복과 성공의 비결을 가르치기도 한 션 앵츠의 강의를 담아냈습니다. ' ||
         '우리는 삶에서 긍정적인 면을 발견하고, 더 행복한 삶을 살기 위한 힌트를 얻을 수 있습니다.'
       , CURRENT_TIMESTAMP
       , '0'
       , '오늘의 책'
       , '1');

INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES ( NEXTVAL('BOARD_SEQ')
       , '부드러운 수플레 팬케이크 만들기'
       , '부드러운 수플레 팬케이크를 만드는 방법을 알려드립니다. 재료로는 밀가루, 달걀, 우유, 베이킹 파우더, 설탕, 소금이 필요합니다.' ||
         '밀가루, 달걀 노른자, 우유를 섞고, 다른 그릇에 달걀 흰자와 설탕을 묻혀 빵가루 모양이 될 때까지 저어주세요.' ||
         '이 두 가지를 섞어서 부드러운 반죽을 만들어 낸 뒤, 기름이 덜 묻도록 팬을 닦아줍니다. 중간 불에서 뒤집어가며 굽다가 완성되면 됩니다.' ||
         '달콤한 시럽이나 생과일과 함께 즐기면 완벽한 브런치 메뉴가 될 것입니다. 조리 시간은 약 15분입니다.'
       , CURRENT_TIMESTAMP
       , '0'
       , '요리 레시피'
       , '1');
INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES ( NEXTVAL('BOARD_SEQ')
       , '상큼한 과일 샐러드 만들기'
       , '더운 여름에 어울리는 상큼한 과일 샐러드를 소개합니다. ' ||
         '준비할 과일은 수박, 파인애플, 딸기, 오렌지 등이며, 과일마다 적당한 크기로 자르세요.' ||
         '큰 그릇에 모든 과일을 넣고, 꿀과 레몬 주스를 조금 섞은 드레싱을 부어주세요. 미리 냉장고에서 식혀두면 더 맛있게 즐길 수 있습니다.' ||
         '이 시원한 과일 샐러드는 더위를 식히는 간식으로도 좋고, 다양한 음식과 함께 맛있게 먹을 수 있습니다. ' ||
         '준비 시간은 10분이면 충분합니다 ^^.'
       , CURRENT_TIMESTAMP
       , '0'
       , '요리 레시피'
       , '1');

