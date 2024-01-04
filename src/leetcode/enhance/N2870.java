import java.util.Map.Entry;

class Solution {
    public int minOperations(int[] nums) {
        int answer = 0;
        int savedTemp = 0;
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

        for (int n : nums) {
            map.compute(n, (k, v) -> (v == null) ? 1 : v + 1);
        }

        // entrySet 보다 성능이 낮음.
        // for (Integer i : map.keySet()) {
        //      System.out.println(i + " : " + map.get(i));
        // }

        while (!map.isEmpty()) {
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return -1;
                }

                if (2 < entry.getValue() && (entry.getValue() % 3 == 0 || entry.getValue() % 3 == 2)) {
                    answer += entry.getValue() / 3;
                    savedTemp = entry.getValue() % 3;
                    if (savedTemp == 0) {
                        map.remove(entry.getKey());
                        continue;
                    }
                    map.put(entry.getKey(), savedTemp);
                }

                if (entry.getValue() % 2 == 0 || entry.getValue() % 3 == 1 || savedTemp != 0) {
                    if (4 < entry.getValue() && entry.getValue() % 3 == 1) {
                        int temp = entry.getValue() - 2;
                        map.put(entry.getKey(), temp);
                        answer += 1;
                        continue;
                    }
                    if (savedTemp != 0) {
                        answer += savedTemp / 2;
                        map.remove(entry.getKey());
                        savedTemp = 0;
                        continue;
                    }

                    System.out.println(entry.getValue());
                    answer += entry.getValue() / 2;
                    map.remove(entry.getKey());

                }

            }
        }
        

        return answer;        
    }
}