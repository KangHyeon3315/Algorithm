package level01;

import java.util.HashMap;
import java.util.Map;

/**
 * 추억 점수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */
public class MemoryScore176963 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] result = solution(name, yearning, photo);

        for (int i : result) {
            System.out.printf("%d  ", i);
        }
        System.out.println();
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for(int i = 0 ; i < photo.length; i++) {
            String[] peoples = photo[i];

            int sum = 0;
            for(String people : peoples) {
                sum += yearningMap.getOrDefault(people, 0);
            }

            answer[i] = sum;
        }
        return answer;
    }
}
