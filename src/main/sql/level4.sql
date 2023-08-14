-- 보호소에서 중성화한 동물
-- https://school.programmers.co.kr/learn/courses/30/lessons/59045
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS AS I
         RIGHT JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE (I.SEX_UPON_INTAKE NOT LIKE 'Spayed%' AND I.SEX_UPON_INTAKE NOT LIKE 'Neutered%')
  AND (O.SEX_UPON_OUTCOME LIKE 'Spayed%' OR O.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY I.ANIMAL_ID

-- 식품분류별 가장 비싼 식품의 정보 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131116
SELECT P.CATEGORY, T.MAX_PRICE, P.PRODUCT_NAME
FROM FOOD_PRODUCT AS P
         RIGHT JOIN (SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
                     FROM FOOD_PRODUCT
                     WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
                     GROUP BY CATEGORY) AS T
                    ON P.CATEGORY = T.CATEGORY AND P.PRICE = T.MAX_PRICE
ORDER BY T.MAX_PRICE DESC

-- 5월 식품들의 총매출 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131117
SELECT P.PRODUCT_ID, P.PRODUCT_NAME, (P.PRICE * O.TOTAL_AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS P
         JOIN
     (SELECT PRODUCT_ID, SUM(AMOUNT) AS TOTAL_AMOUNT
      FROM FOOD_ORDER
      WHERE DATE_FORMAT(PRODUCE_DATE, '%Y-%m') = '2022-05'
      GROUP BY PRODUCT_ID) AS O
     ON P.PRODUCT_ID = O.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID

-- 취소되지 않은 진료 예약 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/132204
SELECT A.APNT_NO,
       P.PT_NAME,
       P.PT_NO,
       A.MCDP_CD,
       D.DR_NAME,
       A.APNT_YMD
FROM APPOINTMENT AS A
         JOIN PATIENT AS P ON A.PT_NO = P.PT_NO
         JOIN DOCTOR AS D ON A.MDDR_ID = D.DR_ID
WHERE DATE_FORMAT(A.APNT_YMD, "%Y-%m-%d") = '2022-04-13'
  AND A.APNT_CNCL_YMD IS NULL
  AND A.MCDP_CD = 'CS'
ORDER BY APNT_YMD;

-- 년, 월, 성별 별 상품 구매 회원 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131532
SELECT YEAR, MONTH, GENDER, COUNT (*) AS USERS
FROM (
    SELECT YEAR (SALES_DATE) AS YEAR, MONTH (SALES_DATE) AS MONTH, GENDER
    FROM ONLINE_SALE AS S
    JOIN USER_INFO AS U ON S.USER_ID=U.USER_ID
    WHERE GENDER IS NOT NULL
    GROUP BY YEAR, MONTH, GENDER, U.USER_ID
    ) AS T
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER

-- 서울에 위치한 식당 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131118
SELECT I.REST_ID,
       I.REST_NAME,
       I.FOOD_TYPE,
       I.FAVORITES,
       I.ADDRESS,
       ROUND(AVG(R.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO AS I
         JOIN REST_REVIEW AS R ON I.REST_ID = R.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY I.REST_ID
ORDER BY SCORE DESC, I.FAVORITES DESC

-- 우유와 요거트가 담긴 장바구니
-- https://school.programmers.co.kr/learn/courses/30/lessons/62284
SELECT CART_ID
FROM (SELECT *
      FROM CART_PRODUCTS
      WHERE NAME IN ('Milk', 'Yogurt')
      GROUP BY CART_ID, NAME) AS T
GROUP BY CART_ID
HAVING COUNT(*) = '2'
ORDER BY CART_ID

-- 주문량이 많은 아이스크림들 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/133027
SELECT F.FLAVOR
FROM FIRST_HALF AS F
         RIGHT JOIN JULY AS J ON F.SHIPMENT_ID = J.SHIPMENT_ID
GROUP BY J.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) DESC LIMIT 3

-- 저자 별 카테고리 별 매출액 집계하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144856
SELECT T.AUTHOR_ID, T.AUTHOR_NAME, T.CATEGORY, SUM(TOTAL_SALES) AS TOTAL_SALES
FROM (SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * S.SALES) AS TOTAL_SALES
      FROM BOOK AS B
               JOIN AUTHOR AS A ON B.AUTHOR_ID = A.AUTHOR_ID
               RIGHT JOIN BOOK_SALES AS S ON B.BOOK_ID = S.BOOK_ID
      WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01'
      GROUP BY B.BOOK_ID) AS T
GROUP BY T.AUTHOR_ID, T.CATEGORY
ORDER BY T.AUTHOR_ID, T.CATEGORY DESC

-- 그룹별 조건에 맞는 식당 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131124
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE AS M
         JOIN (SELECT MEMBER_ID, COUNT(*) AS REVIEW_COUNT
               FROM REST_REVIEW
               GROUP BY MEMBER_ID
               ORDER BY REVIEW_COUNT DESC LIMIT 1) AS B
              ON M.MEMBER_ID = B.MEMBER_ID
         JOIN REST_REVIEW AS R ON M.MEMBER_ID = R.MEMBER_ID
ORDER BY REVIEW_DATE, REVIEW_TEXT

-- 오프라인/온라인 판매 데이터 통합하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131537
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE AS O
WHERE DATE_FORMAT(SALES_DATE, '%Y-%m')='2022-03'
UNION ALL
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE AS F
WHERE DATE_FORMAT(SALES_DATE, '%Y-%m')='2022-03'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID

-- 입양 시각 구하기(2)
-- https://school.programmers.co.kr/learn/courses/30/lessons/59413
/* WITH 구문 : 이후에 오는 쿼리에서 임시 테이블의 테이블명을 사용하여 값을 참조할 수 있다.
   WITH 테이블명 AS (
       SELECT -
   )
*/
/*
WITH RECURSIVE 구문은 가상 테이블을 생성하면서 가상 테이블 자신의 값을 참조하여 값을 결정할 때 사용된다.
 WITH [RECURSIVE] TABLE명 AS (
    SELECT - # 비반복문. 무조건 필수
    [UNION ALL] # RECURSIVE 사용 시 필수. 다음에 이어붙어야 할 때 사용
    SELECT -
    [WHERE -] # RECURSIVE 사용 시 필수. 정지 조건 필요할 때 사용
)
 */
WITH RECURSIVE HOURS AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1 FROM HOURS
    WHERE HOUR < 23 -- 값을 추가하는 것은 HOUR + 1이기 때문에
)

SELECT H.HOUR, IFNULL(T.COUNT, 0) AS COUNT FROM HOURS AS H
    LEFT JOIN (
    SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT FROM ANIMAL_OUTS
    GROUP BY HOUR
    ) AS T
ON H.HOUR=T.HOUR
ORDER BY HOUR

