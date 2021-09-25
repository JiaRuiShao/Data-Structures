package hashtable;

import java.util.HashMap;
import java.util.Map;

public class CheckPath {

    /**
     * Find complete path in Map.
     * Time: O(n)
     * Space: O(1)
     *
     * @param map the given path map
     * @return the complete path
     */
    public String tracePath(Map<String,String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String start = "", end = "";
        int path = map.size();
        for (String s : map.keySet()) { // O(n)
            if (!map.containsValue(s)) {
                start = s;
                end = map.get(s);
                path--;
                break;
            }
        }
        sb.append(start).append("->").append(end).append(", ");
        while (path > 0) { // O(n-1)
            start = end;
            end = map.get(start);
            sb.append(start).append("->").append(end).append(", ");
            path--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashMap<String,String> hMap = new HashMap<>();
        hMap.put("NewYork","Chicago");
        hMap.put("Boston","Texas");
        hMap.put("Missouri","NewYork");
        hMap.put("Texas","Missouri");

        String actual_output = new CheckPath().tracePath(hMap);
        System.out.println(actual_output);
    }
}
