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

## List -> Array

```java
int[] array = result.stream().mapToInt(Integer::intValue).toArray();

Integer[] array = result.toArray(new Integer[0]);
```

## 진수 변화
```java
String s = Integer.toString(n, 3); // 3진법 변환
```

# 문자열

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

## 소수 갯수 구하기

1. 숫자 배열을 만든다.
2. 2부터 시작해서 해당 숫자의 배수들을 모두 0으로 만든다.
3. 0이 아닌 숫자들의 갯수를 센다.

```java
int[] numArr = new int[n];

// 숫자 배열 초기화
for(int i = 0; i < n; i++) {
    numArr[i] = i + 1;
}
numArr[0] = 0;

int count = n - 1;
for(int i = 1; i < n; i++) {
    if(numArr[i] == 0) continue;
        
    // 해당 숫자의 배수들을 모두 0으로 만든다.
    int num = i + 1;
    for(int j = num * 2; j <= n; j += num) {
        if(numArr[j - 1] != 0) count--;
        numArr[j - 1] = 0;

    }
}


return count;
```

## 최대 공약수(GCD) 구하기

유클리드 호제법을 사용하면 두 수의 최대 공약수를 효율적으로 구할 수 있다.

GCD(a, b) = GCD(b, a % b) (단, a >= b)

```java
private int gcd(int a, int b) {
    if(b == 0) return a;
    
    return gcd(b, a % b);
}
```

## 최소 공배수 구하기
a와 b의 최소 공배수 LCM(a, b)는 a * b / GCD(a, b)로 구할 수 있다.
```java
private int lcm(int a, int b) {
    return a * b / gcd(a, b);
}
```


# 기타

1. long을 사용하는 경우 연산에서 int를 사용해 long 범위를 넘어가는 경우가 있는지 확인한다.
2. 문제의 제한사항에서 입력값의 최대 크기를 확인하고 복잡도를 고려한다.
3. 맵을 탐색할 때, 최단거리를 구하는 문제는 BFS를 사용하는게 좋다.
4. Collection에서 일부 큰 수들 or 일부 작은 수들을 구하는 문제는 PriorityQueue를 사용하는게 좋다.