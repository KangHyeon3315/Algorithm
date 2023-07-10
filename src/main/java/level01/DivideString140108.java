package level01;

/**
 * 문자열 나누기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */
public class DivideString140108 {

    public static void main(String[] args) {
        String s = "banana";

        int result = solution(s);
        System.out.println(result);
    }

    public static int solution(String s) {
        int answer = 0;

        char firstCh = '\0';
        int firstCount = 0;
        int notFirstCount = 0;
        for(int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(firstCh == '\0') {
                answer++;
                firstCh = ch;
                firstCount = 0;
                notFirstCount = 0;
            }

            if(ch == firstCh) {
                firstCount++;
            } else {
                notFirstCount++;
            }

            if(firstCount == notFirstCount) {
                firstCh = '\0';
            }
        }
        return answer;
    }
}
