package caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import lombok.Data;
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

        Map<User, String> map = new HashMap<>();
        User user = new User();
        user.setName("1");
        map.put(user, "1");

        User user1 = new User();
        user1.setName("1");
        map.put(user1, "1");
        System.out.println(map.size());
    }

    @Data
    static class User {
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "User{" +
                "name='" + name + '\'' +
                '}';
        }
    }
}
