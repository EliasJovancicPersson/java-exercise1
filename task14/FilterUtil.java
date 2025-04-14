package task14;

import java.util.ArrayList;

public class FilterUtil {
    public static String[] filter(String[] a, Filter f) {
        ArrayList<String> res = new ArrayList<String>();
        for (String string : a) {
            if(f.accept(string)){
                res.add(string);
            }
        }
        String[] output = new String[res.size()];
        res.toArray(output);
        return output;
    }

    public static Filter catFilter = new Filter() {
        public boolean accept(String x) {
            if (x.length() == 3) {
                return true;
            }
            return false;
        };
    };
}
