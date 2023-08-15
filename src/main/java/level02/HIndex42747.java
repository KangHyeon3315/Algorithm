package level02;

import java.util.Arrays;

/**
 * H-Index
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex42747 {

    /*
    입출력 예
    citations	return
    [3, 0, 6, 1, 5]	3
     */
    public static void main(String[] args) {
        System.out.println(new HIndex42747().solution(new int[]{3, 0, 6, 1, 5}));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        for(int i = 0; i < n; i++) {
            int h = n - i; // 자기보다 인용 수가 같거나 많은 논문의 수 (자기 포함)
            if(citations[i] >= h) { // 인용의 수가 h보다 많거나 같은 경우
                return h;
            }
        }

        return 0;
    }
}
