package level02;

import java.util.HashSet;

/**
 * 전화번호 목록
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneList42577 {


    /*
    입출력 예제
    phone_book	return
    ["119", "97674223", "1195524421"]	false
    ["123","456","789"]	true
    ["12","123","1235","567","88"]	false
     */
    public static void main(String[] args) {
        System.out.println(new PhoneList42577().solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(new PhoneList42577().solution(new String[]{"123","456","789"}));
        System.out.println(new PhoneList42577().solution(new String[]{"12","123","1235","567","88"}));
    }

    public boolean solution(String[] phone_book) {
        HashSet<String> phoneSet = new HashSet<>();
        for(String phone : phone_book) {
            phoneSet.add(phone);
        }

        for(String phone : phone_book) {
            for(int i = 1; i < phone.length(); i++) {
                String sub = phone.substring(0, i);

                if(phoneSet.contains(sub)) {
                    return false;
                }
            }
        }

        return true;
    }
}
