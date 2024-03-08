import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class LRUCache {
  HashMap<Object, Object> cache;
  List<Object> lruList;
  int capacity = 1024;

  public LRUCache(int capacity) {
    cache = new HashMap<>();
    lruList = new ArrayList<>();
  }

  void put(Object key, Object value) {
    if (cache.size() >= capacity) {
      Object lruItemKey = lruList.remove(0);
      cache.remove(lruItemKey);
    }
    cache.put(key, value);
    lruList.add(key);
  }
  Object get(Object key) {
    lruList.remove(key);
    lruList.add(key);

    return cache.get(key);
  }
}
