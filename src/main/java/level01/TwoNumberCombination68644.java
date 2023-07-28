package level01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 두 개 뽑아서 더하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 */
public class TwoNumberCombination68644 {


    /*
    입출력 예
    numbers	result
    [2,1,3,4,1]	[2,3,4,5,6,7]
    [5,0,2,7]	[2,5,7,9,12]
     */
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result));

        numbers = new int[]{5,0,2,7};
        result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] numbers) {
        Set<Integer> comb = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                comb.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[comb.size()];
        int i = 0;
        for (int num : comb) {
            answer[i++] = num;
        }
        Arrays.sort(answer);
        return answer;

    }
}
