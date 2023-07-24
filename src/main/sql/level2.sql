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