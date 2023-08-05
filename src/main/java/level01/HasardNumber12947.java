package level01;

/**
 * 하샤드 수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12947
 */
public class HasardNumber12947 {

    /*
    입출력 예
    x	return
    10	true
    12	true
    11	false
    13	false
     */
    public static void main(String[] args) {
        int x = 10;
        boolean result = solution(x);
        System.out.println(result);

        x = 12;
        result = solution(x);
        System.out.println(result);

        x = 11;
        result = solution(x);
        System.out.println(result);

        x = 13;
        result = solution(x);
        System.out.println(result);
    }

    public static boolean solution(int x) {
        int sum = 0;
        for(char ch : (x + "").toCharArray()) {
            sum += ch - '0';
        }

        return x % sum == 0;
    }
}
