package level01;

/**
 * 음양 더하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/76501
 */
public class PlusMinusSum76501 {

    /*
    입출력 예
    absolutes	signs	result
    [4,7,12]	[true,false,true]	9
    [1,2,3]	[false,false,true]	0
     */
    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        int result = solution(absolutes, signs);
        System.out.println(result);

        absolutes = new int[]{1, 2, 3};
        signs = new boolean[]{false, false, true};
        result = solution(absolutes, signs);
        System.out.println(result);

        
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
