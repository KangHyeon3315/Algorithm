package level01;

import java.util.Arrays;

/**
 * 나누어 떨어지는 숫자 배열
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12910
 */
public class DivisibleNumArray12910 {

    /*
    입출력 예
    arr	divisor	return
    [5, 9, 7, 10]	5	[5, 10]
    [2, 36, 1, 3]	1	[1, 2, 3, 36]
    [3,2,6]	10	[-1]
     */
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        int[] result = solution(arr, divisor);
        System.out.println(Arrays.toString(result));

        arr = new int[]{2, 36, 1, 3};
        divisor = 1;
        result = solution(arr, divisor);
        System.out.println(Arrays.toString(result));

        arr = new int[]{3, 2, 6};
        divisor = 10;
        result = solution(arr, divisor);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] arr, int divisor) {

        int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
        return answer.length > 0 ? answer : new int[]{-1};
    }
}
