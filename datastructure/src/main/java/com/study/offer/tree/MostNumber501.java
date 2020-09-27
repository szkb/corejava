package com.study.offer.tree;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/24 10:00
 */
public class MostNumber501 {

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        find(root, map);

        List<Integer> ans = new ArrayList<>();
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                ans.add(entry.getKey());
            }
        }

        int[] result = new int[ans.size()];
        AtomicInteger i = new AtomicInteger(0);
        ans.forEach(item -> result[i.getAndIncrement()] = item);

        return result;
    }

    public void find(TreeNode root, Map<Integer, Integer> map) {
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        if (root.left != null) {
            find(root.left, map);
        }
        if (root.right != null) {
            find(root.right, map);
        }
    }

}
