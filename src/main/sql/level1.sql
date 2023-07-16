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