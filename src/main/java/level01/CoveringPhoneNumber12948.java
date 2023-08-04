package level01;

/**
 * 핸드폰 번호 가리기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12948
 */
public class CoveringPhoneNumber12948 {

    /*
    입출력 예
    phone_number	return
    "01033334444"	"*******4444"
    "027778888"	"*****8888"
    "4444" "4444"
     */
    public static void main(String[] args) {
        String phone_number = "01033334444";

        String result = solution(phone_number);
        System.out.println(result);

        phone_number = "027778888";
        result = solution(phone_number);
        System.out.println(result);

        phone_number = "4444";
        result = solution(phone_number);
        System.out.println(result);
    }

    public static String solution(String phone_number) {
        int hideCount = phone_number.length() - 4;
        String show_number = phone_number.substring(hideCount, phone_number.length());

        String hide_number = "";
        if(hideCount > 0) hide_number = String.format("%" + hideCount + "s", " ").replaceAll(" ", "*");
        return hide_number + show_number;
    }

    public static String batter_solution(String number) {
        char[] ch = number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}
