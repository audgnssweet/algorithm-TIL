package Utf8Validation;

public class Utf8Validation {

    public boolean validUtf8(int[] data) {
        int idx = 0;

        while (idx < data.length) {
            int tmp = 7;    //7번째 bit부터 검사하기 때문에
            int cnt = 0;

            while ((data[idx] & (1 << tmp)) != 0) { //처음에 나오는 1의 개수를 저장한다.
                cnt += 1;
                tmp -= 1;
            }

            if (cnt == 1 || cnt > 5) {  //알맞지 않은 UTF-8 형태
                return false;
            }

            while (cnt > 1) {
                idx += 1;
                if ((idx == data.length) || ((data[idx] & (1 << 7)) == 0) || ((data[idx] & (1 << 6)) != 0)) {
                    return false;
                }
                cnt -= 1;
            }

            idx += 1;
        }

        return true;
    }
}
