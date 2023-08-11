package level02;

/**
 * 점프와 순간 이동
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */
public class JumpTeleportation12980 {

    /*
    입출력 예
    N	result
    5	2
    6	2
    5000	5
     */
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int ans = 0;

        int pos = n;
        while (pos > 0) {
            if (pos % 2 == 1) {
                pos--;
                ans++;
            }

            pos /= 2;
        }
        return ans;
    }
}
