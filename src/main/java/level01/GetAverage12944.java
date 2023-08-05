package level01;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 평균 구하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12944
 */
public class GetAverage12944 {

    /*
    입출력 예
    arr	return
    [1,2,3,4]	2.5
    [5,5]	5
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        double result = solution(arr);
        System.out.println(result);

        arr = new int[]{5,5};
        result = solution(arr);
        System.out.println(result);
    }

    public static double solution(int[] arr) {
        return Arrays.stream(arr).asLongStream().average().getAsDouble();
    }
}
