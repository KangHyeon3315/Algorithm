package level02;

/**
 * JadenCase 문자열 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */
public class JadenCaseString12951 {

    /*
    입출력 예
    s	return
    "3people unFollowed me"	"3people Unfollowed Me"
    "for the last week"	"For The Last Week"
     */
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }

    public static String solution(String s) {
        char[] answer = s.toLowerCase().toCharArray();

        boolean isFirstCh = true;
        for(int i = 0 ; i < answer.length; i++) {
            char ch = answer[i];
            if(ch != ' ' && isFirstCh) {
                answer[i] = Character.toUpperCase(ch);

                isFirstCh = false;
            }

            if(ch == ' ') {
                isFirstCh = true;
            }

        }

        return String.valueOf(answer);
    }
}
