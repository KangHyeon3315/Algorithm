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

-- 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/164671
-- 문자열을 합치는 방법은 CONCAT을 이용
SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) AS FILE_PATH FROM USED_GOODS_FILE AS F
JOIN (SELECT BOARD_ID FROM USED_GOODS_BOARD ORDER BY VIEWS DESC LIMIT 1) AS V ON F.BOARD_ID = V.BOARD_ID
ORDER BY F.FILE_ID DESC;

-- 조건에 맞는 사용자 정보 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/164670
-- 문자열의 범위를 추출하는 방법은 SUBSTR을 이용 SUBSTR(문자열, 시작Index, 갯수) <- (INDEX는 1부터 시작)
SELECT
    USER_ID,
    NICKNAME,
    CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS 전체주소,
    CONCAT(SUBSTR(TLNO, 1, 3), '-', SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8, 4)) AS 전화번호
FROM USED_GOODS_USER AS U
         JOIN USED_GOODS_BOARD AS B
              ON B.WRITER_ID=U.USER_ID
GROUP BY U.USER_ID HAVING COUNT(*) >= 3
ORDER BY U.USER_ID DESC;

-- 조건에 맞는 사용자와 총 거래금액 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/164668
SELECT USER_ID, NICKNAME, SUM(B.PRICE) AS TOTAL_SALES FROM USED_GOODS_USER AS U
JOIN USED_GOODS_BOARD AS B ON U.USER_ID=B.WRITER_ID
WHERE STATUS='DONE'
GROUP BY U.USER_ID HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES;

-- 대여 기록이 존재하는 자동차 리스트 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/157341
SELECT DISTINCT(C.CAR_ID) AS CAR_ID FROM CAR_RENTAL_COMPANY_CAR AS C
RIGHT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    ON C.CAR_ID=H.CAR_ID
WHERE CAR_TYPE='세단' AND MONTH(START_DATE)=10
ORDER BY C.CAR_ID DESC;


-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/157340
-- GROUP에서 하나라도 START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16'이면 대기중이므로 MAX를 이용 (true가 1, false가 0이므로 MAX를 이용하면 1이 나옴)
SELECT
    CAR_ID,
    CASE
        WHEN MAX(START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16') THEN '대여중'
        ELSE '대여 가능'
        END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151139
SELECT MONTH(START_DATE) AS MONTH, H.CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    JOIN
    (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE YEAR(START_DATE)='2022' AND MONTH(START_DATE) BETWEEN 8 AND 10
    GROUP BY CAR_ID HAVING COUNT(*) >= 5) AS C
ON H.CAR_ID=C.CAR_ID
WHERE YEAR(START_DATE)='2022' AND MONTH(START_DATE) BETWEEN 8 AND 10
GROUP BY MONTH, H.CAR_ID
ORDER BY MONTH, H.CAR_ID DESC

-- 카테고리 별 도서 판매량 집계하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144855
SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES FROM BOOK AS B
JOIN BOOK_SALES AS S ON B.BOOK_ID=S.BOOK_ID
WHERE DATE_FORMAT(SALES_DATE, '%Y-%m')='2022-01'
GROUP BY CATEGORY
ORDER BY CATEGORY;
