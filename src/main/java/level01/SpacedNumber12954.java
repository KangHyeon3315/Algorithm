package level01;

/**
 * x만큼 간격이 있는 n개의 숫자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12954
 */
public class SpacedNumber12954 {
    /*
    입출력 예
    x	n	answer
    2	5	[2,4,6,8,10]
    4	3	[4,8,12]
    -4	2	[-4, -8]
     */
    public static void main(String[] args) {
        int x = 2;
        int n = 5;

        long[] result = solution(x, n);
        for(long i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        x = 4;
        n = 3;
        result = solution(x, n);
        for(long i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        x = -4;
        n = 2;
        result = solution(x, n);
        for(long i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i = 1; i <= n; i++) {
            answer[i - 1] = (long)x * i;
        }
        return answer;
    }
}
