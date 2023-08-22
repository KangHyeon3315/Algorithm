package level02;

import java.util.*;

/**
 * 주식 가격
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice42584 {

    class Pair {
        private final int price;

        private int incDate;

        public Pair(int price) {
            this.price = price;
            this.incDate = -1;
        }

        public int getPrice() {
            return price;
        }

        public int getIncDate() {
            return incDate;
        }

        public void update() {
            incDate++;
        }
    }

    /*
    입출력 예
    prices	return
    [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
     */
    public static void main(String[] args) {
        StockPrice42584 stockPrice = new StockPrice42584();
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = stockPrice.solution(prices);
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int[] prices) {
        List<Pair> paires = new ArrayList<>();
        List<Pair> incPaires = new ArrayList<>();
        for(int date = 0; date < prices.length; date++) {
            Pair p = new Pair(prices[date]);
            paires.add(p);
            incPaires.add(p);

            int price = prices[date];
            for(int i = incPaires.size() - 1; i >= 0; i--) {
                Pair pair = incPaires.get(i);

                pair.update();

                if(pair.getPrice() > price) {
                    incPaires.remove(pair);
                }
            }
        }

        int[] answer = new int[prices.length];
        for(int i = 0; i < paires.size(); i++) {
            answer[i] = paires.get(i).getIncDate();
        }

        return answer;
    }
}
