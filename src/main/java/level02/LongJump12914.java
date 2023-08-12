package level02;

/**
 * 멀리 뛰기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */
public class LongJump12914 {

    /*
    입출력 예
    n	result
    4	5
    3	3
     */
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }

    public static long solution(int n) {
        if (n <= 2) return n; // way의 최소 사이즈(3 - index가 2까지 접근하므로) -> 그보다 작은 경우를 대비

        long[] way = new long[n + 1];
        way[1] = 1;
        way[2] = 2;

        /*
        n번째 도달하는 경우의 수 : n - 1번째에서 1칸을 뛴 경우의 수 + n - 2번째에서 2칸을 뛴 경우의 수
        */
        for(int i = 3; i <= n; i++) {
            way[i] = (way[i - 1] + way[i - 2]) % 1234567;
        }

        return way[n];
    }
}
