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