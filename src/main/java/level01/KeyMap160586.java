package level01;

import java.util.HashMap;

/**
 * 대충 만든 자판
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */
public class KeyMap160586 {

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};

        int[] result = solution(keymap, targets);

        for (int i : result) {
            System.out.printf("%d  ", i);
        }
        System.out.println();
    }

    public static int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> keyCountMap = new HashMap<>();
        for(String oneKeyMap : keymap) {
            for(int i = 0; i < oneKeyMap.length(); i++) {
                char key = oneKeyMap.charAt(i);

                if(keyCountMap.containsKey(key)) {
                    int count = keyCountMap.get(key);

                    keyCountMap.put(key, i + 1> count ? count : i + 1);
                } else {
                    keyCountMap.put(key, i + 1);
                }
            }
        }

        int[] answer = new int[targets.length];
        for(int i = 0 ; i < targets.length; i++) {
            String target = targets[i];

            int count = 0;
            for(char ch : target.toCharArray()) {
                if(!keyCountMap.containsKey(ch)) {
                    count = -1;
                    break;
                }

                count += keyCountMap.get(ch);
            }
            answer[i] = count;

        }
        return answer;
    }
}
