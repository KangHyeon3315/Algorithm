package level02;

import java.util.*;


/**
 * 괄호 회전하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
public class RotateBracket76502 {
    /*
    입출력 예
    s	result
    "[](){}"	3
    "}]()[{"	2
    "[)(]"	0
    "}}}"	0
     */
    public static void main(String[] args) {
        System.out.println(new RotateBracket76502().solution("[](){}"));
        System.out.println(new RotateBracket76502().solution("}]()[{"));
        System.out.println(new RotateBracket76502().solution("[)(]"));
        System.out.println(new RotateBracket76502().solution("}}}"));
    }

    public int solution(String s) {
        int answer = 0;

        Deque<Character> sq = new ArrayDeque<>();
        for(char ch : s.toCharArray()) sq.addLast(ch);

        for(int i = 0; i < s.length(); i++) {
            char ch = sq.removeFirst();
            sq.addLast(ch);

            if(ch == ']' || ch == ')' || ch == '}') {
                if(check(sq)) {
                    answer++;
                }
            }
        }


        return answer;
    }

    private boolean check(Deque<Character> sq) {
        Map<Character, Character> bracketMap = Map.of('{','}', '(',')', '[',']');

        Stack<Character> s = new Stack<>();
        for(char ch : sq) {
            if(ch == '{' || ch == '(' || ch == '[') {
                s.add(ch);
            } else if(s.size() > 0 && bracketMap.get(s.peek()) == ch) {
                s.pop();
            } else {
                return false;
            }

        }

        return s.size() == 0;
    }
}
