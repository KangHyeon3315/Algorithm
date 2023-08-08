package level02;

/**
 * 최댓값과 최솟값
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */
public class MinMaxValue12939 {

    /*
    입출력 예
    s	return
    "1 2 3 4"	"1 4"
    "-1 -2 -3 -4"	"-4 -1"
    "-1 -1"	"-1 -1"
     */
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }

    public static String solution(String s) {
        String[] nums = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(String num : nums) {
            int n = Integer.parseInt(num);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        return String.format("%d %d", min, max);
    }
}
