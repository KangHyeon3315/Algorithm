package level01;

import java.util.Arrays;

/**
 * 없는 숫자 더하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051
 */
public class DoesntExistsNumberAdd86051 {

    /*
    입출력 예
    numbers	result
    [1,2,3,4,6,7,8,0]	14
    [5,8,4,0,6,7,9]	6
     */
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        int result = solution(numbers);
        System.out.println(result);

        numbers = new int[]{5,8,4,0,6,7,9};
        result = solution(numbers);
        System.out.println(result);
    }


    public static int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}
