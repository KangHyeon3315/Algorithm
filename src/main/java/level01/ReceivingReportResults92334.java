package level01;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 신고 결과 받기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
public class ReceivingReportResults92334 {

    public static void main(String[] args) {
        /*
        입출력 예
        id_list	report	k	result
        ["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
        ["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
         */

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = new ReceivingReportResults92334().solution(id_list, report, k);
        System.out.println("Case 1 : " + result[0] + ", " + result[1] + ", " + result[2] + ", " + result[3]);

        id_list = new String[]{"con", "ryan"};
        report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
        k = 3;
        result = new ReceivingReportResults92334().solution(id_list, report, k);
        System.out.println("Case 2 : " + result[0] + ", " + result[1]);

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, ArrayList<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> reportedCountMap = new HashMap<>();

        for(String reportStr : report) {
            String[] reportArr = reportStr.split(" ");

            if(!reportMap.containsKey(reportArr[0])) {
                reportMap.put(reportArr[0], new ArrayList<>());
            }

            if(!reportMap.get(reportArr[0]).contains(reportArr[1])) {
                reportMap.get(reportArr[0]).add(reportArr[1]);
                reportedCountMap.put(reportArr[1], reportedCountMap.getOrDefault(reportArr[1], 0) + 1);
            }
        }



        int[] answer = new int[id_list.length];
        for(int i = 0 ; i < id_list.length; i++) {
            int count = 0;

            String user = id_list[i];
            for(String reportedUser : reportMap.getOrDefault(user, new ArrayList<>())) {
                if(reportedCountMap.getOrDefault(reportedUser, 0) >= k) {
                    count++;
                }
            }

            answer[i] = count;
        }
        return answer;
    }
}
