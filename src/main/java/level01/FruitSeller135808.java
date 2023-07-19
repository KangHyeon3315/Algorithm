package level01;

import java.util.Arrays;

/**
 * 과일 장수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/135808
 */
public class FruitSeller135808 {

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};

        int result = solution(k, m, score);
        System.out.println(result);
    }

    public static int solution(int k, int m, int[] score) {
        Arrays.sort(score);

        int answer = 0;
        int boxCount = 0;
        for(int i = score.length - 1; i >= 0; i--) {
            boxCount++;

            if(boxCount == m) {
                int p = score[i];

                answer += p * m;

                boxCount = 0;
            }
        }

        return answer;
    }
}
