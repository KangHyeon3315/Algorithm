package level02;

import java.util.Arrays;

/**
 * 귤 고르기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
public class PickTangerine138476 {

    /*
    입출력 예
    k	tangerine	result
    6	[1, 3, 2, 5, 4, 5, 2, 3]	3
    4	[1, 3, 2, 5, 4, 5, 2, 3]	2
    2	[1, 1, 1, 1, 2, 2, 2, 3]	1
     */
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    public static int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);

        int typeCount = tangerine[tangerine.length - 1];
        int[] sizes = new int[typeCount];

        for(int num : tangerine) {
            sizes[num - 1] += 1;
        }

        Arrays.sort(sizes);

        int answer = 0;
        for(int i = sizes.length - 1; i >= 0; i--) {
            k -= sizes[i];
            answer++;

            if(k <= 0) break;
        }
        return answer;
    }
}
