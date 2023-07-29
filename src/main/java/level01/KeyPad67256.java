package level01;

/**
 * 키패드 누르기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
public class KeyPad67256 {

    /*
    입출력 예
    numbers	hand	result
    [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
    [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
     */
    public static void main(String[] args) {
        int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";

        String result = solution(numbers, hand);
        System.out.println(result);

        numbers = new int[]{7,0,8,2,8,3,1,5,7,6,2};
        hand = "left";

        result = solution(numbers, hand);
        System.out.println(result);

        numbers = new int[]{1,2,3,4,5,6,7,8,9,0};
        hand = "right";

        result = solution(numbers, hand);
        System.out.println(result);
    }

    public static String solution(int[] numbers, String hand) {
        int leftX = 0;
        int leftY = 3;

        int rightX = 2;
        int rightY = 3;

        StringBuilder answer = new StringBuilder();
        for(int num : numbers) {
            if(num % 3 == 1) {
                // 1, 4, 7
                answer.append("L");
                leftX = 2;
                leftY = (num - 1) / 3 ;
            } else if(num == 0 || num % 3 == 2) {
                // 2, 5, 8, 0
                int x = 1;
                int y = num > 0 ? (num - 2) / 3 : 3;

                int leftDist = Math.abs(x - leftX) + Math.abs(y - leftY);
                int rightDist = Math.abs(x - rightX) + Math.abs(y - rightY);

                if(leftDist > rightDist || (leftDist == rightDist && hand.equals("right"))) {
                    answer.append("R");
                    rightX = x;
                    rightY = y;
                } else {
                    answer.append("L");
                    leftX = x;
                    leftY = y;
                }
            } else {
                // 3, 6, 9
                answer.append("R");
                rightX = 2;
                rightY = num / 3 - 1;
            }
        }

        return answer.toString();
    }
}
