package level03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 불량 사용자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
public class BadUser64064 {

    /*
    [입출력 예]
    user_id	banned_id	result
    ["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]	2
    ["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]	2
    ["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3
     */
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(new BadUser64064().solution(user_id, banned_id));

        user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        banned_id = new String[]{"*rodo", "*rodo", "******"};

        System.out.println(new BadUser64064().solution(user_id, banned_id));

        user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        banned_id = new String[]{"fr*d*", "*rodo", "******", "******"};

        System.out.println(new BadUser64064().solution(user_id, banned_id));

    }

    public int solution(String[] user_id, String[] banned_id) {

        return dfs(user_id, new boolean[user_id.length], banned_id, 0, new HashSet<>());
    }

    private int dfs(String[] userIds, boolean[] banned, String[] bannedIds, int idx, Set<String> resultSet) {
        if(bannedIds.length == idx) {
            String resultStr = Arrays.toString(banned);
            if(resultSet.contains(resultStr)) {
                return 0;
            } else {
                resultSet.add(resultStr);
                return 1;
            }
        }

        String pattern = "^" + bannedIds[idx].replaceAll("\\*", "\\\\w") + "$";

        int answer = 0;
        for(int i = 0; i < userIds.length; i++) {
            if(banned[i]) continue;

            String id = userIds[i];

            if(!id.matches(pattern)) continue;

            banned[i] = true;

            answer += dfs(userIds, banned, bannedIds, idx + 1, resultSet);

            banned[i] = false;

        }

        return answer;
    }
}
