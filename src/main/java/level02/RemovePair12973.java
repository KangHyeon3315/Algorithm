package level02;

import java.util.ArrayList;
import java.util.List;

/**
 * 짝지어 제거하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class RemovePair12973 {

    /*
    입출력 예
    s	result
    baabaa	1
    cdcd	0
     */
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s)
    {
        List<Character> stack = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            if(stack.size() == 0 || stack.get(stack.size() - 1) != ch) {
                stack.add(ch);
            } else {
                stack.remove(stack.size() - 1);
            }
        };

        return stack.size() == 0 ? 1 : 0;
    }
}
