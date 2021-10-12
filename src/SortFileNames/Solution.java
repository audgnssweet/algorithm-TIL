package SortFileNames;

import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    static class File implements Comparable<File> {

        String head;
        String number;
        String other;
        int idx;

        public File(String head, String number, String other, int idx) {
            this.head = head;
            this.number = number;
            this.other = other;
            this.idx = idx;
        }

        @Override
        public int compareTo(File file) {
            if (!head.equalsIgnoreCase(file.head)) {
                return head.compareToIgnoreCase(file.head);
            }

            int cur = Integer.parseInt(number);
            int com = Integer.parseInt(file.number);
            if (cur != com) {
                return cur - com;
            }

            return idx - file.idx;
        }
    }

    public static String[] solution(String[] files) {
        PriorityQueue<File> pq = new PriorityQueue<>();

        Pattern headPattern = Pattern.compile("\\D+");
        Pattern numberPattern = Pattern.compile("\\d+");
        for (int i = 0; i < files.length; i++) {
            Matcher headMatcher = headPattern.matcher(files[i]);
            Matcher numberMatcher = numberPattern.matcher(files[i]);

            String head = headMatcher.find() ? headMatcher.group() : "";
            String number = numberMatcher.find() ? numberMatcher.group() : "";
            String other = files[i].replace(head + number, "");

            pq.offer(new File(head, number, other, i));
        }

        String[] res = new String[files.length];
        int idx = 0;
        while (!pq.isEmpty()) {
            File cur = pq.poll();
            res[idx++] = files[cur.idx];
        }
        return res;
    }

}
