package level01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class StageRate {
    public final int stage;
    public final Float rate;

    public StageRate(int stage, float rate) {
        this.stage = stage;
        this.rate = rate;
    }
}

/**
 * 실패율
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */
public class FailureRate42889 {

    /*
    입출력 예
    N	stages	result
    5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
    4	[4,4,4,4,4]	[4,1,2,3]
     */
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] result = solution(N, stages);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        N = 4;
        stages = new int[]{4, 4, 4, 4, 4};
        result = solution(N, stages);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }



    public static int[] solution(int N, int[] stages) {
        int userNum = stages.length;

        HashMap<Integer, Integer> passCountMap = new HashMap<>();
        for (int stage : stages) {
            for (int i = 1; i < stage; i++) {
                passCountMap.put(i, passCountMap.getOrDefault(i, 0) + 1);
            }
        }

        List<StageRate> rates = new ArrayList<>();
        int lastPassed = userNum;
        for (int i = 1; i <= N; i++) {
            int passed = passCountMap.getOrDefault(i, 0);

            if (lastPassed > 0)
                rates.add(new StageRate(i, (float)(lastPassed - passed) / lastPassed));
            else
                rates.add(new StageRate(i, 0));

            lastPassed = passed;
        }

        rates.sort((o1, o2) -> o2.rate.compareTo(o1.rate));

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = rates.get(i).stage;
        }

        return answer;
    }

}
