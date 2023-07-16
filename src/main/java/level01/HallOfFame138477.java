package level01;

import java.util.ArrayList;

/**
 * 명예의 전당 (1)
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/138477
 */
public class HallOfFame138477 {
    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        int[] result = solution(k, score);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    public static int[] solution(int k, int[] score) {
        ArrayList<Integer> ranks = new ArrayList();
        int[] answer = new int[score.length];

        for(int i = 0 ; i < score.length; i++) {
            ranks.add(score[i]);
            ranks.sort((o1, o2) -> o2 - o1);

            if(ranks.size() > k) {
                ranks.remove(k);
                answer[i] = ranks.get(k - 1);
            } else {
                answer[i] = ranks.get(i);
            }
        }

        return answer;
    }
}
