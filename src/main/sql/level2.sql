-- 최솟값 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59038
SELECT MIN(DATETIME) AS 시간 FROM ANIMAL_INS

-- 고양이와 개는 몇 마리 있을까
-- https://school.programmers.co.kr/learn/courses/30/lessons/59040
SELECT ANIMAL_TYPE, COUNT(*) FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE

-- 동명 동물 수 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
-- GROUP BY의 조건은 HAVING 절에서 사용
SELECT NAME, COUNT(*) FROM ANIMAL_INS WHERE NAME IS NOT NULL GROUP BY NAME HAVING COUNT(*) > 1 ORDER BY NAME;

-- 루시와 엘라 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59046
-- IN 연산자를 사용하면 여러 개의 조건을 OR로 묶을 수 있다.
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE FROM ANIMAL_INS WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty') ORDER BY ANIMAL_ID;

-- 이름에 el이 들어가는 동물 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59047
-- LOWER 함수를 사용하면 문자열을 소문자로 변환할 수 있다.
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE ANIMAL_TYPE = 'Dog' AND LOWER(NAME) LIKE '%el%' ORDER BY LOWER(NAME);

-- 동물 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59406
SELECT COUNT(*) AS COUNT FROM ANIMAL_INS;

-- 중복 제거하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59408
-- DISTINCT를 사용하면 중복을 제거할 수 있다.
SELECT COUNT(DISTINCT(NAME)) AS COUNT FROM ANIMAL_INS;

-- 중성화 여부 파악하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59409
-- CASE WHEN ~ THEN ~ ELSE ~ END 문을 사용하면 조건에 따라 다른 값을 출력할 수 있다.
SELECT ANIMAL_ID, NAME, CASE WHEN SEX_UPON_INTAKE LIKE 'Spayed%' OR SEX_UPON_INTAKE LIKE 'Neutered%' THEN 'O' ELSE 'X' END AS 중성화 FROM ANIMAL_INS;

-- NULL 처리하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59410
-- Null 처리는 IFNULL 함수를 사용하면 된다.
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE FROM ANIMAL_INS ORDER BY ANIMAL_ID;

-- 입양 시각 구하기(1)
-- https://school.programmers.co.kr/learn/courses/30/lessons/59412
SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT FROM ANIMAL_OUTS WHERE HOUR(DATETIME) >= 9 AND HOUR(DATETIME) < 20 GROUP BY HOUR(DATETIME) ORDER BY HOUR(DATETIME);

-- DATETIME에서 DATE로 형 변환
-- https://school.programmers.co.kr/learn/courses/30/lessons/59414
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜 FROM ANIMAL_INS ORDER BY ANIMAL_ID;

-- 가격이 제일 비싼 식품의 정보 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131115
SELECT * FROM FOOD_PRODUCT ORDER BY PRICE DESC LIMIT 1;

-- 3월에 태어난 여성 회원 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131120
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH FROM MEMBER_PROFILE WHERE MONTH(DATE_OF_BIRTH) = '3' AND TLNO IS NOT NULL AND GENDER = 'W'  ORDER BY MEMBER_ID;

-- 카테고리 별 상품 개수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131529
-- SUBSTR 함수를 사용하면 문자열의 일부를 추출할 수 있다. (첫 문자 Index는 1부터 시작)
-- SUBSTR(문자열, 시작 Index, 길이)
SELECT SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY, COUNT(*) AS PRODUCTS FROM PRODUCT GROUP BY CATEGORY ORDER BY CATEGORY

-- 가격대 별 상품 개수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131530
SELECT (PRICE - PRICE % 10000) AS PRICE_GROUP, COUNT(*) AS PRODUCTS FROM PRODUCT GROUP BY PRICE_GROUP ORDER BY PRICE_GROUP;

-- 상품 별 오프라인 매출 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131533
SELECT PRODUCT_CODE, P.PRICE * SUM(SALES_AMOUNT) AS SALES FROM PRODUCT AS P JOIN OFFLINE_SALE AS O ON P.PRODUCT_ID = O.PRODUCT_ID GROUP BY P.PRODUCT_ID ORDER BY SALES DESC, PRODUCT_CODE;

-- 재구매가 일어난 상품과 회원 리스트 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131536
SELECT USER_ID, PRODUCT_ID FROM ONLINE_SALE GROUP BY USER_ID, PRODUCT_ID HAVING COUNT(*) >= 2 ORDER BY USER_ID, PRODUCT_ID DESC

-- 진료과별 총 예약 횟수 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/132202
SELECT MCDP_CD AS 진료과코드, COUNT(*) AS 5월예약건수 FROM APPOINTMENT WHERE YEAR(APNT_YMD) = '2022' AND MONTH(APNT_YMD) = '5' GROUP BY MCDP_CD ORDER BY 5월예약건수, 진료과코드;

-- 성분으로 구분한 아이스크림 총 주문량
-- https://school.programmers.co.kr/learn/courses/30/lessons/133026
SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER FROM FIRST_HALF AS F JOIN ICECREAM_INFO AS I ON F.FLAVOR = I.FLAVOR GROUP BY INGREDIENT_TYPE;

-- 조건에 맞는 도서와 저자 리스트 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144854
SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE FROM BOOK AS B JOIN AUTHOR AS A ON B.AUTHOR_ID = A.AUTHOR_ID WHERE CATEGORY='경제' ORDER BY PUBLISHED_DATE

-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151137
SELECT CAR_TYPE, COUNT(*) AS CARS FROM CAR_RENTAL_COMPANY_CAR WHERE OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%가죽시트%' GROUP BY CAR_TYPE ORDER BY CAR_TYPE

-- 자동차 평균 대여 기간 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/157342
SELECT CAR_ID, ROUND(AVG(TIMESTAMPDIFF(DAY, START_DATE, END_DATE) + 1), 1) AS AVERAGE_DURATION FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY GROUP BY CAR_ID HAVING AVERAGE_DURATION >= 7 ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC

-- 조건에 부합하는 중고거래 상태 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/164672
-- CASE WHEN 조건 THEN 값1 WHEN 조건 THEN 값2 ELSE 값3 END
SELECT
    BOARD_ID,
    WRITER_ID,
    TITLE,
    PRICE,
    CASE
        WHEN (STATUS='SALE') THEN '판매중'
        WHEN (STATUS='RESERVED') THEN '예약중'
        WHEN (STATUS='DONE') THEN '거래완료'
        END AS STATUS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID DESC
