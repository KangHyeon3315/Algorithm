package level02;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리를 지나는 트럭
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class BridgePassTruck42583 {

    /*
    입출력 예
    bridge_length	weight	truck_weights	return
    2	10	[7,4,5,6]	8
    100	100	[10]	101
    100	100	[10,10,10,10,10,10,10,10,10,10]	110
     */
    public static void main(String[] args) {
        BridgePassTruck42583 bridgePassTruck = new BridgePassTruck42583();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(bridgePassTruck.solution(bridge_length, weight, truck_weights));

        bridge_length = 100;
        weight = 100;
        truck_weights = new int[] {10};
        System.out.println(bridgePassTruck.solution(bridge_length, weight, truck_weights));

        bridge_length = 100;
        weight = 100;
        truck_weights = new int[] {10,10,10,10,10,10,10,10,10,10};
        System.out.println(bridgePassTruck.solution(bridge_length, weight, truck_weights));
    }

    class Truck {
        public final int weight;
        public int waitTime;

        public Truck(int weight, int length) {
            this.weight = weight;
            this.waitTime = length;
        }

        public void update(int num) {
            waitTime -= num;
        }

        public String toString() {
            return String.format("(%d : %d)", weight, waitTime);
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        List<Truck> passing = new ArrayList<>();
        List<Truck> waiting = new ArrayList<>();
        for(int w : truck_weights) waiting.add(new Truck(w, bridge_length));

        int passingWeight = 0;

        int answer = 1;
        while(waiting.size() > 0 || passing.size() > 0)  {
            if(waiting.size() > 0 && weight - passingWeight >= waiting.get(0).weight) {
                // 새로 올라갈 수 있는 경우
                Truck newTruck = waiting.remove(0);

                passingWeight+= newTruck.weight;
                passing.add(newTruck);
            }

            if(passing.size() > 0) {
                Truck firstTruck = passing.get(0);

                answer += 1;
                for(Truck t : passing)
                    t.update(1);

                if(firstTruck.waitTime == 0) {
                    // 트럭이 다 나온경우
                    passing.remove(0);
                    passingWeight -= firstTruck.weight;
                }
            }
        }
        return answer;
    }

}
