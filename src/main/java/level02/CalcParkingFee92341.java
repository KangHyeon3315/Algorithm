package level02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 주차 요금 계산
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class CalcParkingFee92341 {
    /*
    입출력 예
    fees	records	result
    [180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	[14600, 34400, 5000]
    [120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	[0, 591]
    [1, 461, 1, 10]	["00:00 1234 IN"]	[14841]
     */
    public static void main(String[] args) {
        int[] result = new CalcParkingFee92341().solution(new int[]{180, 5000, 10, 600}, new String[]{
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        });
        System.out.println(Arrays.toString(result));

        result = new CalcParkingFee92341().solution(new int[]{120, 0, 60, 591}, new String[]{
                "16:00 3961 IN",
                "16:00 0202 IN",
                "18:00 3961 OUT",
                "18:00 0202 OUT",
                "23:58 3961 IN"
        });
        System.out.println(Arrays.toString(result));

        result = new CalcParkingFee92341().solution(new int[]{1, 461, 1, 10}, new String[]{
                "00:00 1234 IN"
        });
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int timeUnit = fees[2];
        int feeUnit = fees[3];

        Map<String, Integer> minMap = new HashMap<>();
        Map<String, String> carMap = new HashMap<>();
        for(String record : records) {
            String time = record.substring(0, 5);
            String carNum = record.substring(6, 10);
            String act = record.substring(11);

            if(carMap.containsKey(carNum)) {
                int min = calcMin(carMap.get(carNum), time);
                minMap.put(carNum, minMap.getOrDefault(carNum, 0) + min);
                carMap.remove(carNum);
            } else {
                carMap.put(carNum, time);
            }
        }

        for(String carNum : carMap.keySet()) {
            int min = calcMin(carMap.get(carNum), "23:59");
            minMap.put(carNum, minMap.getOrDefault(carNum, 0) + min);
        }

        int[] answer = new int[minMap.keySet().size()];
        int i = 0;
        for(String carNum : minMap.keySet().stream().sorted().toList()) {
            int min = minMap.get(carNum);
            int fee = calcFee(min, defaultTime, defaultFee, timeUnit, feeUnit);

            answer[i++] = fee;
        }

        return answer;
    }

    private int calcMin(String inTime, String outTime) {
        String[] splitedIn = inTime.split(":");
        String[] splitedOut = outTime.split(":");

        int in = Integer.parseInt(splitedIn[0]) * 60 + Integer.parseInt(splitedIn[1]);
        int out = Integer.parseInt(splitedOut[0]) * 60 + Integer.parseInt(splitedOut[1]);

        return out - in;
    }

    private int calcFee(int min, int defaultTime, int defaultFee, int timeUnit, int feeUnit) {
        int result = defaultFee;
        if(min <= defaultTime) {
            return result;
        }

        int over = min - defaultTime;
        result += (int)Math.ceil((double)over / timeUnit) * feeUnit;
        return result;
    }
}
