package level01;

/**
 * 내적
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/70128
 */
public class InnerProduct70128 {

    /*
    입출력 예
    a	b	result
    [1,2,3,4]	[-3,-1,0,2]	3
    [-1,0,1]	[1,0,-1]	-2
     */
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};

        int result = solution(a, b);
        System.out.println(result);

        a = new int[]{-1,0,1};
        b = new int[]{1,0,-1};
        result = solution(a, b);
        System.out.println(result);
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0 ; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
