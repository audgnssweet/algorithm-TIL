package SkillTree;

public class Solution {

    public static int solution(String skill, String[] skill_trees) {
        String regex = "[^" + skill + "]";
        int res = 0;
        for (String skill_tree : skill_trees) {
            String cur = skill_tree.replaceAll(regex, "");
            if (cur.length() == 0) {
                ++res;
            } else if (cur.charAt(0) == skill.charAt(0) && skill.contains(cur)) {
                ++res;
            }
        }

        return res;
    }
}
