package level01;

import java.sql.SQLSyntaxErrorException;

/**
 * 신규 아이디 추천
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */
public class NewIdRecommend72410 {

    /*
    [입출력 예]
    no	new_id	result
    예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
    예2	"z-+.^."	"z--"
    예3	"=.="	"aaa"
    예4	"123_.def"	"123_.def"
    예5	"abcdefghijklmn.p"	"abcdefghijklmn"
     */
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String result = solution(new_id);
        System.out.println(result);

        new_id = "z-+.^.";
        result = solution(new_id);
        System.out.println(result);

        new_id = "=.=";
        result = solution(new_id);
        System.out.println(result);

        new_id = "123_.def";
        result = solution(new_id);
        System.out.println(result);

        new_id = "abcdefghijklmn.p";
        result = solution(new_id);
        System.out.println(result);
    }

    public static String solution(String new_id) {
        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[~!@#$%^&*()=+\\[\\{\\]\\}:?,<>/]", "");

        answer = answer.replaceAll("\\.{2,}", ".");

        if(answer.startsWith(".")) {
            answer = answer.substring(1, answer.length());
        }
        if(answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }

        if(answer.length() == 0) {
            answer =  "a";
        }

        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }

        if(answer.length() < 3) {
            String lastCh = answer.charAt(answer.length() - 1) + "";
            while(answer.length() < 3) {
                answer += lastCh;
            }
        }

        if(answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }

        return answer;
    }
}
