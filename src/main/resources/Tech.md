# 정렬

## List에서 정렬하는 방법

```java
List<String> list=new ArrayList<>();

        list.sort(Comparator.naturalOrder()); // 단순한 자료형의 경우 (오름차순)
        list.sort(Comparator.reverseOrder()); // 단순한 자료형의 경우 (내림차순)
        list.sort((o1,o2)->o1.compareTo(o2)) // Object의 경우
```

## Array에서 정렬하는 방법

```java
int[]array=new int[10];

        Arrays.sort(array); // 단순한 자료형의 경우
        Arrays.sort(array,(o1,o2)->o1.compareTo(o2)); // Object의 경우
```

# 계산 팁

## 약수 갯수 구하기

```java
for(int i = 1; i <= (int)Math.sqrt(n); i++) { // 제곱근까지만 확인
    if(n % i == 0) { // 약수 중 작은 수 저장
        arr.add(i);
    
        if(n / i != i){ // 약수 중 큰 수 저장
            arr.add(n / i);
        }
    }
}
```

# 변환

## Array -> List

```java
List<Integer> winNums=Arrays.stream(win_nums).boxed().collect(Collectors.toList());
```

# 탐색

## DFS

```java
public static void dfs(int[][] nodes, int i, boolean[] visited) {
    visited[i] = true;
    for (int j = 0; j < nodes.length; j++) {
        if (i != j && nodes[i][j] == 1 && !visited[j]) {
            dfs(nodes, j, visited);
        }
    }
}
```

## BFS



# 문자열

## 정규표현식

## 진법 표현

```java
String s = Integer.toString(n, 3); // 3진법 변환

int n = Integer.parseInt(s, 3); // 3진법 파싱
```

## 문자열 조작
```java
StringBuffer sb = new StringBuffer(str);
String reverse = sb.reverse().toString(); 
```


# 기타

## 소수 여부 판단
    
```java
private boolean isPrime(int num) {
    for(int i = 2; i * i <= num; i++){ // 제곱근까지만 확인 (제곱근 이후는 중복)
        if(num % i == 0) return false;
    }
    return true;
}
```