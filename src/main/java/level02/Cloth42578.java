package level02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 의상
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Cloth42578 {

    /*
    입출력 예
    clothes	return
    [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
    [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3
     */
    public static void main(String[] args) {
        System.out.println(new Cloth42578().solution(new String[][]{
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        }));
        System.out.println(new Cloth42578().solution(new String[][]{
            {"crow_mask", "face"},
            {"blue_sunglasses", "face"},
            {"smoky_makeup", "face"}
        }));
    }

    public int solution(String[][] clothes) {
        // 개선사항 : List가 아니라 옷 종류 갯수를 Integer 형태로 관리
        Map<String, List<String>> clothMap = new HashMap<>();
        for(String[] clothInfo : clothes) {
            String cloth = clothInfo[0];
            String type = clothInfo[1];

            clothMap.putIfAbsent(type, new ArrayList<>());
            clothMap.get(type).add(cloth);
        }

        int answer = 1;
        for(String type : clothMap.keySet()) {
            int num = clothMap.get(type).size();
            num += 1; // 안입은 경우

            answer *= num;
        }
        answer -= 1; // 아무것도 안입은 경우

        return answer;
    }
}
