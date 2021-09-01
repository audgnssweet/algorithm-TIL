package ValidAnagram;

public class OtherValidAnagram {

    public boolean isAnagram(String str1, String str2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : str1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            count2[c - 'a']++;
        }

        for (int i = 0; i <= 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
