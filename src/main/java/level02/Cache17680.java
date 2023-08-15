package level02;

import java.util.ArrayList;
import java.util.List;

/**
 * [1차] 캐시
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
public class Cache17680 {

    /*
    입출력 예제
    캐시크기(cacheSize)	도시이름(cities)	실행시간
    3	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	50
    3	["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	21
    2	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	60
    5	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	52
    2	["Jeju", "Pangyo", "NewYork", "newyork"]	16
    0	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	25
     */
    public static void main(String[] args) {
        System.out.println(new Cache17680().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(new Cache17680().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo",
                "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(new Cache17680().solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
                "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new Cache17680().solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
                "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new Cache17680().solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(new Cache17680().solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>();

        int answer = 0;
        for(String c : cities) {
            String city = c.toLowerCase();
            if(cache.contains(city)) { // hits
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else { // miss
                answer += 5;
                if(cacheSize > 0) {
                    if(cache.size() == cacheSize) {
                        cache.remove(0);
                    }
                    cache.add(city);
                }

            }
        }

        return answer;
    }
}
