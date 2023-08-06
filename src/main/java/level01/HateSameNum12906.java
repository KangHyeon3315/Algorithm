package level01;

import java.util.ArrayList;
import java.util.List;

/**
 * 같은 숫자는 싫어
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class HateSameNum12906 {

    /*
    입출력 예
    arr	answer
    [1,1,3,3,0,1,1]	[1,3,0,1]
    [4,4,4,3,3]	[4,3]
     */
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        arr = new int[]{4, 4, 4, 3, 3};
        result = solution(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i : arr) {
            if (answer.size() == 0 || answer.get(answer.size() - 1) != i)
                answer.add(i);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
