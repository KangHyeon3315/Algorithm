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
