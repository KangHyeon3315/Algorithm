package level01;

import java.util.Scanner;

/**
 * 직사각형 별찍기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12969
 */
public class RectangularStar12969 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String row = "*".repeat(a);
        String answer = (row + "\n").repeat(b);

        System.out.println(answer);
    }
}
