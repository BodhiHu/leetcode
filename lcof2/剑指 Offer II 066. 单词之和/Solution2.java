import java.util.HashMap;
import java.util.Map;

public class Solution2 {

  public class MapSum {
    Map<String, Integer> map;
    public MapSum() {
      this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
      this.map.put(key, val);
    }

    public int sum(String prefix) {
      return this.map.entrySet().stream()
        .filter((ent) -> ent.getKey().startsWith(prefix))
        .mapToInt(ent -> ent.getValue())
        .sum();
    }
  }
}
