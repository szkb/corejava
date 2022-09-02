package caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2022/8/31 15:09
 */
public class XProductForbidLocalCache {
    private static final LoadingCache<String, Boolean> X_PRODUCT_FORBID_CACHE = Caffeine.newBuilder()
        .initialCapacity(10)
        .maximumSize(500L)
        .expireAfterWrite(1, TimeUnit.MINUTES)
        .build(XProductForbidLocalCache::loadCache);

    static boolean loadCache(String key) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "1");

        return !map.containsKey("hello");
    }

    @Test
    public void test() {
        System.out.println(X_PRODUCT_FORBID_CACHE.get("hello"));
    }
}
