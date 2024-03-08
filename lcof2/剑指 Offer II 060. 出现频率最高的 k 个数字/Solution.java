import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> frequency = Arrays.stream(nums).boxed().collect(
            Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            )
        );
        Queue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Entry<Integer, Long> entry : frequency.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    public Integer[] reorder(int[] arr) {
        List<Integer> retList = new ArrayList<>();

        Map<Integer, Integer> byFreq = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // ...
        }

        Integer[] frequencies = (Integer[]) byFreq.values().toArray();
        Arrays.sort(frequencies);

        byFreq.entrySet().stream().sorted((entry1, entry2) -> {
            return -1 * (entry1.getValue() - entry2.getValue());
        }).forEach((entry) -> {
            Integer[] values = new Integer[entry.getValue()];
            Arrays.fill(values, entry.getKey());
            retList.addAll(Arrays.asList(values));
        });

        return (Integer[]) retList.toArray();
    }
}
