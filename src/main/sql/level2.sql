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