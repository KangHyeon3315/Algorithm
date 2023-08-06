package level01;

/**
 * 서울에서 김서방 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12919
 */
public class FindKimInSeoul12919 {

    /*
    입출력 예
    seoul	return
    ["Jane", "Kim"]	"김서방은 1에 있다"
     */
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        String result = solution(seoul);
        System.out.println(result);
    }

    public static String solution(String[] seoul) {
        int idx = -1;
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                idx = i;
                break;
            }
        }

        return String.format("김서방은 %d에 있다", idx);
    }
}
