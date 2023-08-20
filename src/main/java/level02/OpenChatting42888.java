package level02;

import java.util.*;

/**
 * 오픈채팅방
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
public class OpenChatting42888 {

    /*
    입출력 예
    record	result
    ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
     */
    public static void main(String[] args) {
        String[] result = new OpenChatting42888().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        System.out.println(Arrays.toString(result));
    }

    public String[] solution(String[] record) {
        Map<String, List<Integer>> userIdxMap = new HashMap<>();
        Map<String, String> userNameMap = new HashMap<>();

        List<String> answer = new ArrayList<>();
        for(String rec : record) {
            String[] recArr = rec.split(" ");
            userIdxMap.putIfAbsent(recArr[1], new ArrayList<>());
            if(recArr[0].equals("Enter")) {
                userNameMap.put(recArr[1], recArr[2]);
                userIdxMap.get(recArr[1]).add(answer.size());
                answer.add(String.format("님이 들어왔습니다.", recArr[1]));
            } else if(recArr[0].equals("Leave")) {
                userIdxMap.get(recArr[1]).add(answer.size());
                answer.add(String.format("님이 나갔습니다.", recArr[1]));
            } else { // rename
                userNameMap.put(recArr[1], recArr[2]);
            }
        }

        for(String userId : userIdxMap.keySet()) {
            for(int idx : userIdxMap.get(userId)) {
                answer.set(idx, userNameMap.get(userId) + answer.get(idx));
            }
        }

        return answer.toArray(new String[0]);
    }
}
