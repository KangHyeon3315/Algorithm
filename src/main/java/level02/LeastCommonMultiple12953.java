package level02;

/**
 * N개의 최소공배수
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12953
 */
public class LeastCommonMultiple12953 {
    /*
    입출력 예
    arr	result
    [2,6,8,14]	168
    [1,2,3]	6
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
        System.out.println(solution(new int[]{1, 2, 3}));
    }

    public static int solution(int[] arr) {

        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            answer = lcm(answer, num);
        }


        return answer;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return a * b / gcd(max, min);
    }
}
