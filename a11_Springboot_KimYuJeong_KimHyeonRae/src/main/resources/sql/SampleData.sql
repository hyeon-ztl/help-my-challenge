-- video 샘플 데이터
INSERT INTO `video` (`video_id`, `title`, `youtube_url`, `channel_name`, `view_cnt`, `part_code`)
VALUES (1, '전신 칼로리 다이어트 최고의 운동', 'https://youtu.be/DCAp0b16kyo?si=NgMhAvkZJVD_X9Iv', 'Thankyou BUBU', 0, 100), -- 전신
		(2, '상체 다이어트 최고의 운동 BEST[팔뚝살/겨드랑이살/등살/가슴어깨라인]', 'https://youtu.be/54tTYO-vU2E?si=QIg5RYGICcYn8KCQ', 'Thankyou BUBU', 0, 200), -- 상체
		(3, '등살 & 허리 얇아지는 최고의 운동 BEST5[힙업은 보너스]', 'https://youtu.be/BEm70PkkVPs?si=TSJD3M8CU_MVACNI', 'Thankyou BUBU', 0, 201), -- 등
        (4, '예쁜 일자어깨 승모근 스트레칭 BEST3 [거북목/굽은등/라운드숄더 교정]', 'https://youtu.be/dJXZRZvqbYg?si=oWeV3y9Uioq3fQ3w', 'Thankyou BUBU', 0, 202), -- 어깨
        (5, '[ENG] 헬린이들 가슴 운동 가보자고!💪', 'https://youtu.be/CAt37ltbjTI?si=ruvLvU4UHzojeXFr', '힙으뜸', 0, 203), -- 가슴
        (6, '👑조회수 ‘8,000,000’ 찍은👑전설의 팔뚝살빼는운동 7분 리뉴얼 버전', 'https://youtu.be/JsF2nzetLBU?si=ANayZG2aZ8RAujh3', '비타민신지니 VitaminJINY', 0, 204), -- 팔
        (7, '아랫뱃살 똥배 폭파 운동', 'https://youtu.be/2Uv1B3kjCOI?si=-Ph6GArtHssEwJn0', 'Thankyou BUBU', 0, 205), -- 복부
        (8, '하체비만 11자다리 최고의 운동 [하체 핵매운맛]', 'https://youtu.be/NDsjmxTROEo?si=28W3XY_kwgisP0Vp', 'Thankyou BUBU', 0, 300), -- 하체
        (9, '단기간 최고의 힙업운동 BEST5 [힙딥운동/중둔근운동]', 'https://youtu.be/oB-PmMdKAVA?si=DPvZH7Rv5VpXN3Hr', 'Thankyou BUBU', 0, 301), -- 엉덩이
	    (10, '허벅지 안쪽살 5cm 줄어드는 운동 [안쪽살 마라맛🔥]', 'https://youtu.be/UMyGJAMj_DQ?si=-D6dxx0hPUoMjLxa', 'Thankyou BUBU', 0, 302), -- 허벅지
        (11, '종아리 얇아지는 최고의 스트레칭 3가지', 'https://youtu.be/2xmNzityfKI?si=8wpJ7q8VXwT2uVyC', 'Thankyou BUBU', 0, 303), -- 종아리
        (12, '얼굴살 & 얼굴붓기 빠지는 스트레칭 3가지', 'https://youtu.be/WqS7fSi9rR4?si=xLiMriHiv75cruu0', 'Thankyou BUBU', 0, 400); -- 기타

-- video review 샘플 데이터
INSERT INTO `review` (`video_id`, `email`, `content`)
VALUES ('1', 'gusto917', "하고 나니 배고파요"),
		('2', 'aabbc0908@naver.com', "상체 전반적으로 운동할 수 있어서 좋았어요!"),
        ('3', 'gusto917', "등살이 사라졌어요~!"),
        ('4', 'gusto917', "어깨가 제니됨ㅎ"),
        ('4', 'aabbc0908@naver.com', "직각어깨 대박"),
        ('5', 'gusto917', "가슴 펌핑 대박이에요"),
		('6', 'gusto917', "팔이 완전 얇아졌어요"),
        ('6', 'aabbc0908@naver.com', "1일차"),
        ('6', 'aabbc0908@naver.com', "2일차"),
        ('7', 'gusto917', "배가 홀쭉해졌어요"),
        ('8', 'gusto917', "다리가 후들거려요"),
        ('8', 'aabbc0908@naver.com', "하고 나면 못 걷겠어요"),
        ('9', 'gusto917', "엉덩이가 완전 업됐어요"),
        ('10', 'gusto917', "허벅지가 얇아졌어요"),
        ('11', 'gusto917', "종아리가 얇아졌어요"),
        ('12', 'aabbc0908@naver.com', "얼굴이 작아졌어요");

-- goal 샘플 데이터
INSERT INTO `goal` (`email`, `start_date`, `end_date`, `goal_code`, `goal_description`, `text`, `pledge`)
VALUES ('aabbc0908@naver.com', '2024-11-10', '2024-12-31', 100, '5kg 감량', '나 다이어트 할거다~!', '실패하면 뿌링클 쏜다~!'),
		('gusto917', '2024-12-01', '2024-12-31', 100, '10kg 증량', '나 살찔거야', '실패하면 돈까스에 새우멘치까지 사줌');

-- message 샘플 데이터
INSERT INTO `message` (`goal_id`, `receiver`, `sender`, `sender_nickname`, `content`, `day`)
VALUES (2, 'gusto917', 'aabbc0908@naver.com', '수원얼짱녀', '5키로 증량 껌이지', 1),
		(2, 'gusto917', 'aabbc0908@naver.com', '수원최고미인', '돈까스 잘 먹을게~ㅎㅎ', 10),
        (1, 'aabbc0908@naver.com', 'gusto917', '서울대입구거주남', '유정아 너가 뺄 살이 어딨다고 그래ㅜㅜ', 1),
        (1, 'aabbc0908@naver.com', 'gusto917', '불타지않은아르민', '유정아 내가 마라엽떡 사줄게', 20);

commit;

SELECT * FROM `body_part`;
SELECT * FROM `video`;
SELECT * FROM `review`;
SELECT * FROM `goal_type`;
SELECT * FROM `goal`;
SELECT * FROM `message`;