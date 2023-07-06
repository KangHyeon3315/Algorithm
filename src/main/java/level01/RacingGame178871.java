package level01;

import java.util.HashMap;
import java.util.Map;

/**
 * 달리기 경주
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
public class RacingGame178871 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] result = solution(players, callings);

        for (String s : result) {
            System.out.printf("%s  ", s);
        }
        System.out.println();
    }

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> positionMap = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            positionMap.put(players[i], i);
        }

        for (String called : callings) {
            int i = positionMap.get(called);

            if (players[i].equals(called)) {
                String temp = players[i - 1];
                players[i - 1] = players[i];
                players[i] = temp;

                positionMap.put(players[i - 1], i - 1);
                positionMap.put(players[i], i);
            }
        }
        return players;
    }
}
