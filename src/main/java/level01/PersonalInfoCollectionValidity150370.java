package level01;

import java.util.ArrayList;
import java.util.HashMap;

/*
입출력 예
today	terms	privacies	result
"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
"2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]
 */
public class PersonalInfoCollectionValidity150370 {

    public static void main(String[] args) {
        String[] today = {"2022.05.19", "2020.01.01"};
        String[][] terms = {{"A 6", "B 12", "C 3"}, {"Z 3", "D 5"}};
        String[][] privacies = {{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}, {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}};

        for(int i = 0 ; i < today.length; i++) {
            int[] result = solution(today[i], terms[i], privacies[i]);
            for(int j = 0 ; j < result.length; j++) {
                System.out.print(result[j] + ", ");
            }
            System.out.println();
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<Character, Integer> termMap = new HashMap<>();
        for(String term : terms) {
            char termType = term.charAt(0);
            int duration = Integer.parseInt(term.substring(2));
            termMap.put(termType, duration);
        }

        ArrayList<Integer> answer = new ArrayList();
        for(int i = 0 ; i < privacies.length; i++) {
            String privacy = privacies[i];

            String dateStr = privacy.substring(0, 10);
            char termType = privacy.substring(11).charAt(0);

            String expireDateStr = getExpireDate(dateStr, termMap.get(termType));

            if(expireDateStr.compareTo(today) <= 0) {
                answer.add(i + 1);
            }
        }

        int[] answerArr = new int[answer.size()];
        for(int i = 0 ; i < answer.size(); i++) {
            answerArr[i] = answer.get(i);
        }
        return answerArr;
    }

    private static String getExpireDate(String dateStr, int duration) {
        String day = dateStr.substring(8);
        String month = dateStr.substring(5, 7);
        String year = dateStr.substring(0, 4);

        int added = Integer.parseInt(month) + duration;
        int addedMonth = added % 12;
        int addedYear = Integer.parseInt(year) + (added / 12);
        if(addedMonth == 0) {
            addedMonth = 12;
            addedYear -= 1;
        }
        month = String.format("%02d", addedMonth);
        year = String.format("%02d", addedYear);

        return year + "." + month + "." + day;
    }
}
