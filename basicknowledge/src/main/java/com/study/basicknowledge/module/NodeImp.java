//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.study.basicknowledge.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class NodeImp<T> implements Node<T> {
    private List<T> values = new ArrayList();
    Map<String, Node<T>> childMap = new HashMap();
    boolean isValueNode;
    boolean valueIgnoreCase = false;
    private int minParameterLength;

    NodeImp(boolean isValueNode, boolean valueIgnoreCase) {
        this.isValueNode = isValueNode;
        this.valueIgnoreCase = valueIgnoreCase;
        this.minParameterLength = 1 + (isValueNode ? 1 : 0);
    }

    Node<T> createChild() {
        return new NodeImp(!this.isValueNode, this.valueIgnoreCase);
    }

    private void addToMap(T obj) {
        if (this.isValueNode) {
            this.values.add(obj);
        }

    }

    public void add(T obj, String[] kvs, int index) {
        if (obj != null) {
            if (kvs != null && kvs.length - index >= this.minParameterLength) {
                this.addIndex(obj, kvs, index);
            } else {
                this.addToMap(obj);
            }

        }
    }

    void addIndex(T obj, String[] kvs, int index) {
        String key = kvs[index];
        if (!this.isValueNode && this.valueIgnoreCase) {
            key = key.toUpperCase();
        }

        Node<T> node = (Node)this.childMap.computeIfAbsent(key, (o) -> {
            return this.createChild();
        });
        node.add(obj, kvs, index + 1);
    }

    public Stream<T> find(String[] kvs, int index) {
        return kvs != null && kvs.length - index >= this.minParameterLength ? this.findWithIndex(kvs, index) : this.findAll();
    }

    Stream<T> findWithIndex(String[] kvs, int index) {
        String key = kvs[index];
        if (!this.isValueNode && this.valueIgnoreCase) {
            key = key.toUpperCase();
        }

        Node<T> node = (Node)this.childMap.get(key);
        return node != null ? node.find(kvs, index + 1) : Stream.empty();
    }

    public Stream<T> findAll() {
        return Stream.concat(this.values.stream(), this.childMap.values().stream().flatMap(Node::findAll));
    }
}
