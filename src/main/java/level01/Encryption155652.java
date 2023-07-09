package level01;

/**
 *
 * 입출력 예
 * s	skip	index	result
 * "aukks"	"wbqd"	5	"happy"
 */
public class Encryption155652 {

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String result = solution(s, skip, index);
        System.out.println(result);
    }

    public static String solution(String s, String skip, int index) {
        char[] answer = new char[s.length()];
        for(int i = 0 ; i < s.length(); i++) {
            answer[i] = replace(s.charAt(i), skip, index);
        }
        return new String(answer);
    }

    private static char replace(char ch, String skip, int index) {
        char result = ch;

        int i = 0;
        while(index > i) {
            result += 1;
            if(result > 'z') result = 'a';

            if(skip.contains(result + "")) {
                continue;
            }

            i++;

        }
        return result;
    }
}
