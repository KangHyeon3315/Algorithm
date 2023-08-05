package level01;

/**
 * 최대공약수와 최소공배수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12940
 */
public class GreatestCommonDivisorLeastCommonMultiple12940 {

    /*
    입출력 예
    n	m	return
    3	12	[3, 12]
    2	5	[1, 10]
     */
    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        int[] result = solution(n, m);
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        n = 2;
        m = 5;
        result = solution(n, m);
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        for (int i = Math.min(n, m); i >= 0; i--) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
                break;
            }
        }

        for (int i = Math.min(n, m); i <= n * m; i++) {
            if (i % n == 0 && i % m == 0) {
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}
