package level01;

/**
 * 자연수 뒤집어 배열로 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12932
 */
public class ReverseDigits12932 {

    /*
    입출력 예
    n	return
    12345	[5,4,3,2,1]
     */
    public static void main(String[] args) {
        long n = 12345;

        int[] result = solution(n);
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] solution(long n) {
        char[] nArr = (n + "").toCharArray();
        int[] answer = new int[nArr.length];
        for(int i = 0; i < nArr.length; i++) {
            answer[nArr.length - i - 1] = nArr[i] - '0';
        }
        return answer;
    }
}
