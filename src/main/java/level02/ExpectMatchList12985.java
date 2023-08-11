package level02;

/**
 * 예상 대진표
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
public class ExpectMatchList12985 {

    /*
    입출력 예
    N	A	B	answer
    8	4	7	3
     */
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int player1 = Math.min(a, b);
        int player2 = Math.max(a, b);
        int roundN = n;
        int round = 0;
        while (roundN >= 1) {
            round++;

            if (player1 % 2 == 1 && player1 + 1 == player2) {
                break;
            }

            player1 = (player1 + 1) / 2;
            player2 = (player2 + 1) / 2;

            roundN /= 2;
        }

        return round;
    }
}
