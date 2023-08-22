package level02;

import java.util.HashSet;
import java.util.Set;

/**
 * 스킬트리
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */
public class SkillTree49993 {

    /*
    입출력 예
    skill	skill_trees	return
    "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
     */
    public static void main(String[] args) {
        SkillTree49993 skillTree = new SkillTree49993();
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(skillTree.solution(skill, skillTrees));
    }

    public int solution(String skill, String[] skill_trees) {
        Set<Character> skillSet = new HashSet<>();
        for(char s : skill.toCharArray()) skillSet.add(s);

        int answer = 0;
        for(String userSkill : skill_trees) {
            if(isAvailable(skill, skillSet, userSkill)) answer++;
        }
        return answer;
    }

    private boolean isAvailable(String skill, Set<Character> skillSet, String user) {
        int sIdx = 0;
        for(int i = 0 ; i < user.length(); i++) {
            char s = user.charAt(i);

            if(sIdx < skill.length() && skill.charAt(sIdx) == s) {
                sIdx++;
            } else if(skillSet.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
