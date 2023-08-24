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
       , 0
       , '반려동물'
       , 1);


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
       , 0
       , '오늘의 책'
       , 1);

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
       , 0
       , '오늘의 책'
       , 1);

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
       , 0
       , '오늘의 책'
       , 1);

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
       , 0
       , '오늘의 책'
       , 1);

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
       , 0
       , '요리 레시피'
       , 1);
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
       , 0
       , '요리 레시피'
       , 1);

INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES ( NEXTVAL('BOARD_SEQ')
       , '홍콩 2박 3일, 다채로운 경험과 아름다운 순간들'
       , '첫째 날, 홍콩 디즈니랜드에서의 시간은 아이와 함께 즐기는 재미로 가득 찼어요.\n ' ||
         '디즈니 캐릭터와 함께한 만남과 신나는 놀이기구는 우리 가족에게 뜻깊은 순간이었어요.\n' ||
         '둘째 날은 홍콩 여행에서 정말로 특별한 하루였어요. 아침 일찍 나와 거리를 거닐며 현지 문화를 체험하는 것부터 시작했어요.\n' ||
          '현지 시장에서의 재미난 구경과 로컬 음식들의 향기는 정말 놀라웠답니다.\n' ||
          '로컬 가게에서 맛본 홍콩 특유의 딤섬과 바게트는 제 입맛을 사로잡았어요. 현지인들과 함께 점심을 보내며 자연스럽게 소통하고 그들의 일상을 엿볼 수 있어서 더욱 의미 있는 시간이었어요.\n\n' ||
         '마지막 날, 빈폴리오 피크에서의 야경은 저에게 평생 잊지 못할 순간이었어요.\n' ||
          '홍콩의 빛이 가득한 야경은 정말 환상적이었고, 그 순간을 사진에 담으며 영원한 추억으로 남겼어요.\n' ||
          '한국에서 홍콩까지의 비행시간은 짧아서 편안한 여행을 시작할 수 있었어요. \n' ||
          '홍콩의 다양한 관광지와 현지 음식들을 맛보며, 그곳의 다양한 매력을 느낄 수 있었어요.' ||
         '가장 좋았던 곳은 홍콩의 거리 음식 문화였어요. \n\n' ||
         '현지인들이 자주 찾는 로컬 식당에서 맛본 따뜻한 만두와 시원한 음료들은 정말로 맛있었고, 현지 문화를 더욱 느낄 수 있었어요.\n' ||
         '홍콩의 짧지만 풍성한 2박 3일은 정말로 특별한 경험이었어요. 이번 여행으로 홍콩의 아름다움과 다양한 매력을 느낄 수 있었고, 가족과 함께한 소중한 순간들을 영원히 기억하며 다음 여행을 기다리게 되었어요. '
       , CURRENT_TIMESTAMP
       , 0
       , '해외여행'
       , 1);

INSERT INTO TB_BOARD ( BOARD_SEQ
                     , BOARD_TITLE
                     , BOARD_CONTENT
                     , created_DATE
                     , board_Views
                     , category
                     , MEMBER_SEQ)
VALUES (NEXTVAL('BOARD_SEQ'),
       '영혼의 탐색, 음악과 감동의 여정 ''소울''',
       '2020년 12월 25일 개봉한 픽스의 새로운 영화 ''소울''은 음악가의 꿈을 쫓는 주인공이 죽음과 삶 사이의 영혼의 세계를 여행하며 진정한 의미를 찾아가는 이야기입니다. \n' ||
       '아름다운 애니메이션과 따뜻한 감정으로 가득한 이 작품은 우리의 인생과 가치에 대한 고민을 자연스럽게 불러일으킵니다.\n\n' ||
       '개인적으로 ''소울''은 마음을 여는 영화였어요.\n' ||
       '음악과 색감, 감동적인 이야기가 모두 완벽하게 어우러져 있었어요. \n' ||
       '주인공의 내면의 탐색과 성장을 따라가며 저 또한 자신의 삶을 되돌아보게 되었어요. \n' ||
       '이 작품은 우리가 평소에 간과하는 소중한 순간들을 놓치지 말아야 한다는 메시지를 전달해주었어요. \n' ||
       '주인공의 성장과 모험을 따라가며 우리 자신도 생각하게 되는 순간들이 많아서 감동을 느낄 수 있었어요. \n' ||
       '정말 눈과 귀, 마음이 즐거웠던 작품이었고, 감상 후 오랜 시간동안 생각이 남았답니다',
       CURRENT_TIMESTAMP,
       0,
       '영화 리뷰',
       1);
