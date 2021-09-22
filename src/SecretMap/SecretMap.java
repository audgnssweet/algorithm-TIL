package SecretMap;

import java.util.ArrayList;
import java.util.List;

public class SecretMap {

    public List<String> secretMap(int n, int[] arr1, int[] arr2) {
        List<String> realRes = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            StringBuilder sb = new StringBuilder("");

            for (int j = n - 1; j >= 0; --j) {
                int mask = 1 << j;

                if ((arr1[i] & mask) != 0 || (arr2[i] & mask) != 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            realRes.add(sb.toString());
        }

        return realRes;
    }

}
