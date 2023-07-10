package level01;

import java.util.HashMap;

/**
 * 가장 가까운 같은 글자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 */
public class nearestCharacter142086 {

    public static void main(String[] args) {
        String s = "banana";

        char test = '\0';

        int[] result = solution(s);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    public static int[] solution(String s) {
        HashMap<Character, Integer> positionMap = new HashMap<>();

        int[] answer = new int[s.length()];
        for(int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(positionMap.containsKey(ch)) {
                answer[i] = i - positionMap.get(ch);
            } else {
                answer[i] = -1;
            }


            positionMap.put(ch, i);
        }
        return answer;
    }
}
