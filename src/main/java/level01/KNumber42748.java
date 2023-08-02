package level01;

import java.util.Arrays;

/**
 * K번째수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class KNumber42748 {

    /*
    입출력 예
    array	commands	return
    [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
     */
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};

        int[][] commands = {
                {2,5,3},
                {4,4,1},
                {1,7,3}
        };

        int[] result = solution(array, commands);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int commandsIdx = 0; commandsIdx < commands.length; commandsIdx++) {
            int[] command = commands[commandsIdx];
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;

            int[] subArr = new int[j - i + 1];
            for(int idx = 0; idx <= j - i; idx++) {
                subArr[idx] = array[i + idx];
            }

            Arrays.sort(subArr);

            answer[commandsIdx] = subArr[k];
        }

        return answer;
    }
}
