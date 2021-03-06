package LogFileRealignment;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class LogFileRealignment {

    public String[] logRealignment(String[] logs) {

        TreeSet<String> set = new TreeSet<>((o1, o2) -> {
            final int res = o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")));
            if (res == 0) {
                return o1.compareTo(o2);
            }
            return res;
        });
        Deque<String> deque = new LinkedList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                deque.addLast(log);
            } else {
                set.add(log);
            }
        }
        while (!set.isEmpty()) {
            deque.addFirst(set.pollLast());
        }
        return deque.toArray(new String[0]);
    }

    public String[] logRealignment2(String[] logs) {

        List<String> digits = new LinkedList<>();
        List<String> chars = new LinkedList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digits.add(log);
            } else {
                chars.add(log);
            }
        }

        chars.sort((log1, log2) -> {
            int res = log1.substring(log1.indexOf(" ")).compareTo(log2.substring(log2.indexOf(" ")));
            if (res == 0) {
                return log1.compareTo(log2);
            }
            return res;
        });

        chars.addAll(digits);
        return chars.toArray(new String[0]);
    }

    public String[] logRealignment3(String[] logs) {

        TreeSet<String> set = new TreeSet<>(
            (log1, log2) -> {
                if (Character.isDigit(log1.split(" ")[1].charAt(0))) {
                    return 1;
                } else if (Character.isDigit(log2.split(" ")[1].charAt(0))) {
                    return -1;
                }

                int res = log1.substring(log1.indexOf(" ")).compareTo(log2.substring(log2.indexOf(" ")));
                if (res == 0) {
                    return log1.compareTo(log2);
                }
                return res;
            }
        );
        for (String log : logs) {
            set.add(log);
        }

        return set.toArray(new String[0]);
    }

}
