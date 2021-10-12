package SortFileNames;

public class OtherSolution {

    public static void main(String[] args) {
        if (m.find()){
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
