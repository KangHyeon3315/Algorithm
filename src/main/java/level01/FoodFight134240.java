package level01;

/**
 * 푸드 파이트 대회
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 *
 *
 입출력 예
 food	result
 [1, 3, 4, 6]	"1223330333221"
 [1, 7, 1, 2]	"111303111"
 */
public class FoodFight134240 {

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};

        String result = solution(food);
        System.out.println(result);
    }

    public static String solution(int[] food) {
        String answer = "0";
        for(int i = food.length - 1; i >= 0 ; i--) {
            int count = food[i] / 2;

            String foodPlace = (i + "").repeat(count);
            answer = foodPlace + answer + foodPlace;
        }

        return answer;
    }
}
