package level02;

import java.util.Stack;

/**
 * 큰 수 만들기
 *
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class MakeBigNum42883 {

    /*
    입출력 예
    number	k	return
    "1924"	2	"94"
    "1231234"	3	"3234"
    "4177252841"	4	"775841"
     */
    public static void main(String[] args) {
        MakeBigNum42883 makeBigNum42883 = new MakeBigNum42883();

        String number = "4177252841";
        int k = 4;

        String answer = makeBigNum42883.solution(number, k);

        System.out.println(answer);
    }

    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(char ch : number.toCharArray()) {
            while(k > 0 && stack.size() > 0 && stack.peek() < ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        while(k > 0 && stack.size() > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();
    }
}
