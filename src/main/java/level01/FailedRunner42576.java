package level01;

import java.util.HashMap;

/**
 * 완주하지 못한 선수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class FailedRunner42576 {
    /*
    입출력 예
    participant	completion	return
    ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
    ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
    ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
     */
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String result = solution(participant, completion);
        System.out.println(result);

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        result = solution(participant, completion);
        System.out.println(result);

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        result = solution(participant, completion);
        System.out.println(result);
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> userCountMap = new HashMap<>();
        for(String name : participant) {
            userCountMap.put(name, userCountMap.getOrDefault(name, 0) + 1);
        }
        for(String name : completion) {
            userCountMap.put(name, userCountMap.get(name) - 1);
        }

        for(String name : userCountMap.keySet()) {
            if(userCountMap.get(name) > 0) {
                return name;
            }
        }

        return "";
    }
}
