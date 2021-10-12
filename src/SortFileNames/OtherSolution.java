package SortFileNames;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtherSolution {

    static class FileName {

        String head;
        String number;
        String tail;

        public FileName(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        Matcher m = Pattern.compile("").matcher("");
        String number = "";
        String s = "";
        String head = "";
        String tail = "";
        List<FileName> fileNameList = new ArrayList<>();

        if (m.find()) {
            number = m.group();
            int numberStartIndex = s.indexOf(number);
            head = s.substring(0, numberStartIndex);
            int numberEndIndex = numberStartIndex + number.length() - 1;
            if (numberEndIndex + 1 > s.length() - 1) {
                tail = "";
            } else {
                tail = s.substring(numberEndIndex + 1);
            }
            fileNameList.add(new FileName(head, number, tail));
        }
    }
}
