-- 없어진 기록 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59042
SELECT O.ANIMAL_ID, O.NAME FROM ANIMAL_OUTS AS O LEFT JOIN ANIMAL_INS AS I ON O.ANIMAL_ID = I.ANIMAL_ID WHERE I.ANIMAL_ID IS NULL;

-- 있었는데요 없었습니다
-- https://school.programmers.co.kr/learn/courses/30/lessons/59043
SELECT I.ANIMAL_ID, I.NAME FROM ANIMAL_INS AS I JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID=O.ANIMAL_ID WHERE O.DATETIME < I.DATETIME ORDER BY I.DATETIME;

-- 오랜 기간 보호한 동물(1)
-- https://school.programmers.co.kr/learn/courses/30/lessons/59044
SELECT I.NAME, I.DATETIME FROM ANIMAL_INS AS I LEFT JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID=O.ANIMAL_ID WHERE O.DATETIME IS NULL ORDER BY I.DATETIME LIMIT 3;

-- 오랜 기간 보호한 동물(2)
-- https://school.programmers.co.kr/learn/courses/30/lessons/59411
SELECT I.ANIMAL_ID, I.NAME FROM ANIMAL_INS AS I JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID=O.ANIMAL_ID ORDER BY TIMESTAMPDIFF(DAY, I.DATETIME, O.DATETIME) DESC LIMIT 2;

-- 헤비 유저가 소유한 장소
-- https://school.programmers.co.kr/learn/courses/30/lessons/77487
SELECT P.* FROM PLACES AS P
    JOIN
        (SELECT HOST_ID FROM PLACES GROUP BY HOST_ID HAVING COUNT(*) >= 2) AS H
    ON P.HOST_ID=H.HOST_ID
ORDER BY ID;

-- 조건별로 분류하여 주문상태 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131113
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
       CASE
           WHEN OUT_DATE IS NULL THEN '출고미정'
           WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
           ELSE  '출고대기'
           END AS 출고여부
FROM FOOD_ORDER ORDER BY ORDER_ID;

-- 즐겨찾기가 가장 많은 식당 정보 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131123
SELECT R.FOOD_TYPE, R.REST_ID, R.REST_NAME, R.FAVORITES FROM REST_INFO AS R
INNER JOIN
    (SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES FROM REST_INFO GROUP BY FOOD_TYPE) AS F
    ON R.FOOD_TYPE = F.FOOD_TYPE AND R.FAVORITES = F.FAVORITES
ORDER BY R.FOOD_TYPE DESC;