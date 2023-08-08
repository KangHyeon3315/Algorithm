package level02;

import java.util.Arrays;
import java.util.Collections;

/**
 * 최솟값 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class MakeMinNum12941 {

    /*
    입출력 예
    A	B	answer
    [1, 4, 2]	[5, 4, 4]	29
    [1,2]	[3,4]	10
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int size = A.length;
        for(int i = 0; i < size; i++) {
            answer += A[i] * B[size - 1 - i];
        }

        return answer;
    }
}
