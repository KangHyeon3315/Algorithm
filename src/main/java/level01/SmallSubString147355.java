package level01;

/**
 * 크기가 작은 부분문자열
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */
public class SmallSubString147355 {

    public static void main(String[] args) {
        String t = "3141592";
        String p = "271";

        int result = solution(t, p);
        System.out.println(result);
    }

    public static int solution(String t, String p) {
        long num = Long.parseLong(p);
        int size = p.length();

        int answer = 0;
        for (int i = 0; i <= t.length() - size; i++) {
            String subS = t.substring(i, i + size);

            if (num >= Long.parseLong(subS)) {
                answer++;
            }
        }

        return answer;
    }
}
