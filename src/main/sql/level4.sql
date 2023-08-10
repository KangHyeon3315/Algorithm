-- 보호소에서 중성화한 동물
-- https://school.programmers.co.kr/learn/courses/30/lessons/59045
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS AS I RIGHT JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID=O.ANIMAL_ID
WHERE (I.SEX_UPON_INTAKE NOT LIKE 'Spayed%' AND I.SEX_UPON_INTAKE NOT LIKE 'Neutered%')
  AND (O.SEX_UPON_OUTCOME LIKE 'Spayed%' OR O.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY I.ANIMAL_ID

-- 식품분류별 가장 비싼 식품의 정보 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131116
SELECT P.CATEGORY, T.MAX_PRICE, P.PRODUCT_NAME
FROM FOOD_PRODUCT AS P
         RIGHT JOIN (
    SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
) AS T
                    ON P.CATEGORY=T.CATEGORY AND P.PRICE=T.MAX_PRICE
ORDER BY T.MAX_PRICE DESC

-- 5월 식품들의 총매출 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131117
SELECT P.PRODUCT_ID, P.PRODUCT_NAME, (P.PRICE * O.TOTAL_AMOUNT) AS TOTAL_SALES FROM FOOD_PRODUCT AS P
JOIN
    (
        SELECT PRODUCT_ID, SUM(AMOUNT) AS TOTAL_AMOUNT FROM FOOD_ORDER
        WHERE DATE_FORMAT(PRODUCE_DATE, '%Y-%m')='2022-05'
        GROUP BY PRODUCT_ID
    ) AS O
ON P.PRODUCT_ID=O.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID

-- 취소되지 않은 진료 예약 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/132204
SELECT
    A.APNT_NO,
    P.PT_NAME,
    P.PT_NO,
    A.MCDP_CD,
    D.DR_NAME,
    A.APNT_YMD
FROM APPOINTMENT AS A
         JOIN PATIENT AS P ON A.PT_NO=P.PT_NO
         JOIN DOCTOR AS D ON A.MDDR_ID=D.DR_ID
WHERE
        DATE_FORMAT(A.APNT_YMD, "%Y-%m-%d")='2022-04-13'
  AND A.APNT_CNCL_YMD IS NULL
  AND A.MCDP_CD='CS'
ORDER BY APNT_YMD;

-- 년, 월, 성별 별 상품 구매 회원 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131532
SELECT YEAR, MONTH, GENDER, COUNT(*) AS USERS FROM (
    SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, GENDER
    FROM ONLINE_SALE AS S
    JOIN USER_INFO AS U ON S.USER_ID=U.USER_ID
    WHERE GENDER IS NOT NULL
    GROUP BY YEAR, MONTH, GENDER, U.USER_ID
    ) AS T
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER

-- 서울에 위치한 식당 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131118
SELECT
    I.REST_ID,
    I.REST_NAME,
    I.FOOD_TYPE,
    I.FAVORITES,
    I.ADDRESS,
    ROUND(AVG(R.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO AS I
         JOIN REST_REVIEW AS R ON I.REST_ID=R.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY I.REST_ID
ORDER BY SCORE DESC, I.FAVORITES DESC

-- 우유와 요거트가 담긴 장바구니
-- https://school.programmers.co.kr/learn/courses/30/lessons/62284
SELECT CART_ID FROM (
                        SELECT * FROM CART_PRODUCTS
                        WHERE NAME IN ('Milk', 'Yogurt')
                        GROUP BY CART_ID, NAME
                    ) AS T
GROUP BY CART_ID
HAVING COUNT(*)='2'
ORDER BY CART_ID

-- 주문량이 많은 아이스크림들 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/133027
SELECT F.FLAVOR FROM FIRST_HALF AS F RIGHT JOIN JULY AS J ON F.SHIPMENT_ID=J.SHIPMENT_ID
GROUP BY J.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) DESC LIMIT 3

-- 저자 별 카테고리 별 매출액 집계하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144856
SELECT T.AUTHOR_ID, T.AUTHOR_NAME, T.CATEGORY, SUM(TOTAL_SALES) AS TOTAL_SALES FROM (
    SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * S.SALES) AS TOTAL_SALES
    FROM BOOK AS B
             JOIN AUTHOR AS A ON B.AUTHOR_ID=A.AUTHOR_ID
             RIGHT JOIN BOOK_SALES AS S ON B.BOOK_ID=S.BOOK_ID
    WHERE DATE_FORMAT(SALES_DATE, '%Y-%m')='2022-01'
    GROUP BY B.BOOK_ID
) AS T
GROUP BY T.AUTHOR_ID, T.CATEGORY
ORDER BY T.AUTHOR_ID, T.CATEGORY DESC