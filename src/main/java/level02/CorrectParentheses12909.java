package level02;

/**
 * 올바른 괄호
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class CorrectParentheses12909 {

    /*
    입출력 예
    s	answer
    "()()"	true
    "(())()"	true
    ")()("	false
    "(()("	false
     */
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }


    public static boolean solution(String s) {
        int openCount = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') openCount++;
            else if(openCount == 0) return false;
            else openCount--;
        }
        return openCount == 0;
    }
}
