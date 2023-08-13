package level02;

import java.util.Arrays;

/**
 * n^2 배열 자르기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */
public class SquareArraySlice87390 {

    /*
    입출력 예
    n	left	right	result
    3	2	5	[3,2,2,3]
    4	7	14	[4,3,3,3,4,4,4,4]
     */
    public static void main(String[] args) {
        int[] result = new SquareArraySlice87390().solution(3, 2, 5);
        System.out.println(Arrays.toString(result));

        result = new SquareArraySlice87390().solution(4, 7, 14);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        for(long idx = left; idx <= right; idx++) {
            long i = idx / n;
            long j = idx % n;

            long value = Math.max(i, j) + 1;
            answer[(int)(idx - left)] = (int)value;
        }


        return answer;
    }
}
