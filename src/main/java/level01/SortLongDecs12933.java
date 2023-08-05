package level01;

import java.util.Arrays;

/**
 * 정수 내림차순으로 배치하기

 * https://school.programmers.co.kr/learn/courses/30/lessons/12933
 */
public class SortLongDecs12933 {

    /*
    입출력 예
    n	return
    118372	873211
     */
    public static void main(String[] args) {
        long n = 118372;
        long result = solution(n);
        System.out.println(result);
    }

    public static long solution(long n) {
        char[] nArr = (n + "").toCharArray();
        Arrays.sort(nArr);

        StringBuilder sb = new StringBuilder().append(nArr).reverse();
        return Long.parseLong(sb.toString());
    }
}
