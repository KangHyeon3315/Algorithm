package level03;

import java.util.Arrays;

/**
 * 숫자 게임
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12987
 */
public class NumberGame12987 {

    /*
    입출력 예
    A	B	result
    [5,1,3,7]	[2,2,6,8]	3
    [2,2,2,2]	[1,1,1,1]	0
     */
    public static void main(String[] args) {
        NumberGame12987 numberGame = new NumberGame12987();
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};
        System.out.println(numberGame.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int bIdx = 0;
        for(int aIdx = 0; aIdx < A.length; aIdx++) {
            int a = A[aIdx];

            for(int i = bIdx; i < B.length; i++) {
                int b = B[bIdx];
                bIdx = i + 1;

                if(a >= b) continue;

                answer++;
                break;
            }
        }

        return answer;
    }
}
