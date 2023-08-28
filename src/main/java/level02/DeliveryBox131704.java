package level02;

import java.util.Stack;

/**
 * 택배 상자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */
public class DeliveryBox131704 {

    /*
    입출력 예
    order	result
    [4, 3, 1, 2, 5]	2
    [5, 4, 3, 2, 1]	5
     */
    public static void main(String[] args) {
        DeliveryBox131704 deliveryBox = new DeliveryBox131704();
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(deliveryBox.solution(order));

        order = new int[] {5, 4, 3, 2, 1};
        System.out.println(deliveryBox.solution(order));
    }

    public int solution(int[] order) {
        Stack<Integer> subBelt = new Stack<>();

        int answer = 0;
        int orderIdx = 0;
        for(int box = 1; box <= order.length; box++) {
            subBelt.push(box);

            while(orderIdx < order.length && subBelt.size() > 0 && subBelt.peek() == order[orderIdx]) {
                subBelt.pop();
                orderIdx++;
                answer++;
            }
        }

        return answer;
    }
}
