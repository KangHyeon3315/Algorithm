-- 조건에 부합하는 중고거래 댓글 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/164673

SELECT TITLE, B.BOARD_ID, REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d')
FROM USED_GOODS_BOARD AS B JOIN USED_GOODS_REPLY AS R ON B.BOARD_ID = R.BOARD_ID
WHERE B.CREATED_DATE >= '2022-10-01' AND B.CREATED_DATE <= '2022-10-31'
ORDER BY R.CREATED_DATE ASC, B.TITLE ASC;

-- 특정 옵션이 포함된 자동차 리스트 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/157343
SELECT * FROM CAR_RENTAL_COMPANY_CAR WHERE OPTIONS LIKE '%네비게이션%' ORDER BY CAR_ID DESC;

-- 자동차 대여 기록에서 장기/단기 대여 구분하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151138
SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE, '%Y-%m-%d') as START_DATE, DATE_FORMAT(END_DATE, '%Y-%m-%d') as END_DATE,
       CASE WHEN DATEDIFF(END_DATE, START_DATE) + 1>= 30 THEN '장기 대여' ELSE '단기 대여' END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE YEAR(START_DATE) = '2022' and MONTH(START_DATE) = '9'
ORDER BY HISTORY_ID DESC;

-- 평균 일일 대여 요금 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151136
SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE='SUV';

-- 조건에 맞는 도서 리스트 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144853
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE FROM BOOK WHERE CATEGORY='인문' AND YEAR(PUBLISHED_DATE) = 2021 ORDER BY PUBLISHED_DATE;

-- 과일로 만든 아이스크림 고르기
-- https://school.programmers.co.kr/learn/courses/30/lessons/133025
SELECT F.FLAVOR FROM FIRST_HALF AS F JOIN ICECREAM_INFO AS I ON F.FLAVOR = I.FLAVOR WHERE F.TOTAL_ORDER > 3000 AND I.INGREDIENT_TYPE='fruit_based' ORDER BY F.TOTAL_ORDER DESC

-- 인기있는 아이스크림
-- https://school.programmers.co.kr/learn/courses/30/lessons/133024
SELECT FLAVOR FROM FIRST_HALF ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC

-- 흉부외과 또는 일반외과 의사 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/132203
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD FROM DOCTOR WHERE MCDP_CD='CS' OR MCDP_CD='GS' ORDER BY HIRE_YMD DESC, DR_NAME ASC

-- 12세 이하인 여자 환자 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') FROM PATIENT WHERE AGE <= 12 AND GEND_CD = 'W' ORDER BY AGE DESC, PT_NAME ASC

-- 가장 비싼 상품 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131697
SELECT MAX(PRICE) AS MAX_PRICE FROM PRODUCT;

-- 조건에 맞는 회원수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131535
SELECT COUNT(USER_ID) AS USERS FROM USER_INFO WHERE YEAR(JOINED) = '2021' AND AGE >= 20 AND AGE <= 29;

-- 나이 정보가 없는 회원 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131528
SELECT COUNT(USER_ID) FROM USER_INFO WHERE AGE IS NULL;

-- 경기도에 위치한 식품창고 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131114
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N') AS FREEZER_YN FROM FOOD_WAREHOUSE WHERE ADDRESS LIKE '경기도%' ORDER BY WAREHOUSE_ID ASC;

-- 강원도에 위치한 생산공장 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131112
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS FROM FOOD_FACTORY WHERE ADDRESS LIKE '강원도%' ORDER BY FACTORY_ID ASC;

-- 최댓값 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59415
SELECT MAX(DATETIME) AS 시간 FROM ANIMAL_INS;

-- 이름이 있는 동물의 아이디
-- https://school.programmers.co.kr/learn/courses/30/lessons/59407
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NOT NULL ORDER BY ANIMAL_ID;

-- 상위 n개 레코드
-- https://school.programmers.co.kr/learn/courses/30/lessons/59405
SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME LIMIT 1;

-- 여러 기준으로 정렬하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59404
SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS ORDER BY NAME, DATETIME DESC;

-- 동물의 아이디와 이름
-- https://school.programmers.co.kr/learn/courses/30/lessons/59403
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS ORDER BY ANIMAL_ID;

-- 이름이 없는 동물의 아이디
-- https://school.programmers.co.kr/learn/courses/30/lessons/59039
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NULL ORDER BY ANIMAL_ID;

-- 어린 동물 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59037
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION != 'Aged' ORDER BY ANIMAL_ID;

-- 아픈 동물 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59036
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION = 'Sick' ORDER BY ANIMAL_ID;

-- 역순 정렬하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59035
SELECT NAME, DATETIME FROM ANIMAL_INS ORDER BY ANIMAL_ID DESC

-- 모든 레코드 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59034
SELECT * FROM ANIMAL_INS ORDER BY ANIMAL_ID;