package level01;

import java.util.HashSet;

/**
 * 폰켓몬
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Fonkemon1845 {

    /*
    입출력 예
    nums	result
    [3,1,2,3]	2
    [3,3,3,2,2,4]	3
    [3,3,3,2,2,2]	2
     */
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int result = solution(nums);
        System.out.println(result);

        nums = new int[]{3,3,3,2,2,4};
        result = solution(nums);
        System.out.println(result);

        nums = new int[]{3,3,3,2,2,2};
        result = solution(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int num : nums) numSet.add(num);

        return Math.min(nums.length / 2, numSet.size());
    }
}
