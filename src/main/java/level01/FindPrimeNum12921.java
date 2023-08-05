package level01;

/**
 * 소수 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12921
 */
public class FindPrimeNum12921 {

    /*
    입출력 예
    n	result
    10	4
    5	3
     */
    public static void main(String[] args) {
        int n = 10;
        int result = solution(n);
        System.out.println(result);

        n = 5;
        result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int[] numArr = new int[n];

        for(int i = 0; i < n; i++) {
            numArr[i] = i + 1;
        }
        numArr[0] = 0;

        int count = n - 1;
        for(int i = 1; i < n; i++) {
            if(numArr[i] == 0) continue;

            int num = i + 1;
            for(int j = num * 2; j <= n; j += num) {
                if(numArr[j - 1] != 0) count--;
                numArr[j - 1] = 0;

            }
        }


        return count;
    }
}
