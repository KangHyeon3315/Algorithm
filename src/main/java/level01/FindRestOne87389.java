package level01;

public class FindRestOne87389 {

    /**
     * 나머지가 1이 되는 수 찾기
     *
     * https://school.programmers.co.kr/learn/courses/30/lessons/87389
     */
    public static void main(String[] args) {
        int n = 10;
        int result = solution(n);
        System.out.println("Case 1 : " + result);

        n = 12;
        result = solution(n);
        System.out.println("Case 2 : " + result);

        n = 1;
        result = solution(n);
        System.out.println("Case 3 : " + result);
    }

    public static int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) return i;
        }
        return -1; // 도달 X
    }
}
