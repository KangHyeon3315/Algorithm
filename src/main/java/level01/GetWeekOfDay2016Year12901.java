package level01;

import java.time.LocalDate;

/**
 * 2016년
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12901
 */
public class GetWeekOfDay2016Year12901 {

    /*
    입출력 예
    a	b	result
    5	24	"TUE"
     */
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        String result = solution(a, b);
        System.out.println(result);
    }

    public static String solution(int a, int b) {
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        LocalDate date = LocalDate.of(2016, a, b);

        int dayOfWeek = date.getDayOfWeek().getValue();

        return week[dayOfWeek - 1];
    }
}
