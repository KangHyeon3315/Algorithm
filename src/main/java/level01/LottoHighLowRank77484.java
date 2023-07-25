package level01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또의 최고 순위와 최저 순위
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
 */
public class LottoHighLowRank77484 {

    /*
    입출력 예
    lottos	win_nums	result
    [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
    [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
    [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
     */
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};
        int[] result = solution(lottos, winNums);
        System.out.println(Arrays.toString(result));

        lottos = new int[]{0, 0, 0, 0, 0, 0};
        winNums = new int[]{38, 19, 20, 40, 15, 25};
        result = solution(lottos, winNums);
        System.out.println(Arrays.toString(result));

        lottos = new int[]{45, 4, 35, 20, 3, 9};
        winNums = new int[]{20, 9, 3, 45, 4, 35};
        result = solution(lottos, winNums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> winNums = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int maxScore = 0;
        int minScore = 0;

        for(int num : lottos) {
            if(num == 0) {
                maxScore++;
            } else {
                if(winNums.contains(num)) {
                    maxScore++;
                    minScore++;
                }
            }
        }

        if(maxScore == 0) maxScore = 1;
        if(minScore == 0) minScore = 1;
        return new int[]{7 - maxScore, 7 - minScore};
    }
}
