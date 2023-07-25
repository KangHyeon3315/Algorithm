package level01;

/**
 * 부족한 금액 계산하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
 */
public class CalcShortfall82612 {

      /*
      입출력 예
      price	money	count	result
      3	20	4	10
      */
      public static void main(String[] args) {
          int price = 3;
          int money = 20;
          int count = 4;
          long result = solution(price, money, count);
          System.out.println(result);
      }

    public static long solution(int price, int money, int count) {
        long totalPrice = 0;
        for(int i = 1 ; i <= count; i++) {
            totalPrice += (long) price * i;
        }

        if(money < totalPrice) {
            return totalPrice - money;
        } else {
            return 0;
        }
    }

}
