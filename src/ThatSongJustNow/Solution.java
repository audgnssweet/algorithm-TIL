package ThatSongJustNow;

public class Solution {

    public static String solution(String m, String[] musicinfos) {
        String res = "";
        String resRadio = "";
        m = transform(m);

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            //시간 정보
            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");
            int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);

            //이름 정보
            String name = info[2];

            //악보 정보
            String radio = transform(info[3]);

            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while (sb.length() < (end - start)) {
                sb.append(radio.charAt(idx));

                idx = idx == radio.length() - 1 ? 0 : idx + 1;
            }
            radio = sb.toString();

            int pos = radio.indexOf(m);
            if (pos != -1 && resRadio.length() < radio.length()) {
                resRadio = radio;
                res = name;
            }
        }

        return res.length() == 0 ? "(None)" : res;
    }

    static String transform(String m) {
        return m.replaceAll("C#", "H")
            .replaceAll("D#", "I")
            .replaceAll("E#", "J")
            .replaceAll("F#", "K")
            .replaceAll("G#", "L")
            .replaceAll("A#", "M")
            .replaceAll("B#", "N");
    }

}
