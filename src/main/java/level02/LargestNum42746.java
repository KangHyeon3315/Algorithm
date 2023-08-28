package level02;

import java.util.ArrayList;
import java.util.List;

/**
 * 가장 큰 수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746#
 */
public class LargestNum42746 {

    /*
    입출력 예
    numbers	return
    [6, 10, 2]	"6210"
    [3, 30, 34, 5, 9]	"9534330"
     */
    public static void main(String[] args) {
        LargestNum42746 largestNum = new LargestNum42746();
        int[] numbers = {6, 10, 2};
        System.out.println(largestNum.solution(numbers));

        numbers = new int[] {3, 30, 34, 5, 9};
        System.out.println(largestNum.solution(numbers));
    }

    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();
        for(int n : numbers) {
            nums.add(n + "");
        }
        nums.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder answer = new StringBuilder();
        for(String n : nums) {
            if(answer.length() == 0 && n.startsWith("0")) continue;
            answer.append(n);
        }
        if(answer.length() == 0) return "0";

        return answer.toString();
    }
}
