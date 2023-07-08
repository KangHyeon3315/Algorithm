package level01;

import java.util.ArrayList;

/**
 * 덧칠하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */
public class Painting161989 {

    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};

        int result = solution(n, m, section);
        System.out.println(result);
    }

    public static int solution(int n, int m, int[] section) {
        ArrayList<Integer> sections = new ArrayList<>();
        for(int i = 0; i < section.length; i++) sections.add(section[i]);

        int answer = 0;
        while(sections.size() > 0) {
            int startPoint = sections.get(0);
            int endPoint = startPoint + m;
            answer++;

            while(sections.size() > 0 && sections.get(0) < endPoint) {
                sections.remove(0);
            }

        }
        return answer;
    }
}
