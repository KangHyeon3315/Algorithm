package level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 과제 진행하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */
public class ProceedingAssignment176962 {
    /*
    입출력 예
    plans	result
    [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]	["korean", "english", "math"]
    [["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]	["science", "history", "computer", "music"]
    [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]
     */
    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[] result = solution(plans);
        System.out.println(Arrays.toString(result));

        plans = new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        result = solution(plans);
        System.out.println(Arrays.toString(result));

        plans = new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        result = solution(plans);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));

        int answerIdx = 0;
        String[] answer = new String[plans.length];

        String[] doing = null;
        List<String[]> taskStack = new ArrayList<String[]>();
        for(int i = 0 ; i < plans.length; i++) {
            if(doing == null) {
                doing = plans[i];
                continue;
            }

            int duration = getDuration(doing[1], plans[i][1]);
            int playTime = Integer.parseInt(doing[2]);

            if(duration >= playTime) { // 수행 시간이 충분한 경우
                answer[answerIdx++] = doing[0];

                if(duration > playTime) { // 남은 Task 수행
                    int rest = duration - playTime;
                    while(taskStack.size() > 0 && rest > 0) {
                        doing = taskStack.get(taskStack.size() - 1);
                        playTime = Integer.parseInt(doing[2]);

                        if(rest >= playTime) {
                            rest -= playTime;

                            answer[answerIdx++] = doing[0];
                            taskStack.remove(taskStack.size() - 1);
                        } else {
                            playTime -= rest;
                            taskStack.get(taskStack.size() - 1)[2] = playTime + "";
                            break;
                        }
                    }

                }
            } else { // 수행 시간이 부족한 경우 (할 수 있는만큼 수행하고 stack에 push)
                int rest = playTime - duration;
                doing[2] = rest + "";
                taskStack.add(doing);
            }

            doing = plans[i];

        }
        if(doing != null) answer[answerIdx++] = doing[0]; // 마지막 task 수행

        while(taskStack.size() > 0) { // 완료하지 못한 최근 task부터 수행
            answer[answerIdx++] = taskStack.get(taskStack.size() - 1)[0];
            taskStack.remove(taskStack.size() - 1);
        }

        return answer;
    }

    private static int getDuration(String t1, String t2) {
        String[] t1Arr = t1.split(":");
        String[] t2Arr = t2.split(":");

        int hour = Integer.parseInt(t2Arr[0]) - Integer.parseInt(t1Arr[0]);
        int minute = Integer.parseInt(t2Arr[1]) - Integer.parseInt(t1Arr[1]);

        return hour * 60 + minute;
    }
}
