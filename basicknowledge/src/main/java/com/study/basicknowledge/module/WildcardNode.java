//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.study.basicknowledge.module;

import java.util.Arrays;
import java.util.stream.Stream;

public class WildcardNode<T> extends NodeImp<T> {
    private final String wildcard;
    private final String speratorPattern;
    private Node<T> wildcardChild;

    WildcardNode(boolean isValueNode, String wildcard, String speratorPattern, boolean valueIgnoreCase) {
        super(isValueNode, valueIgnoreCase);
        this.wildcard = wildcard;
        this.speratorPattern = speratorPattern;
    }

    Node<T> createChild() {
        return new WildcardNode(!this.isValueNode, this.wildcard, this.speratorPattern, this.valueIgnoreCase);
    }

    void addIndex(T obj, String[] kvs, int index) {
        if (!this.isValueNode) {
            if (kvs[index].trim().equals(this.wildcard)) {
                if (this.wildcardChild == null) {
                    this.wildcardChild = this.createChild();
                }

                this.wildcardChild.add(obj, kvs, index + 1);
            } else {
                this.splitAndAddIndex(obj, kvs, index);
            }
        } else {
            super.addIndex(obj, kvs, index);
        }

    }

    private void splitAndAddIndex(T obj, String[] kvs, int index) {
        String[] words = kvs[index].split(this.speratorPattern);
        Arrays.stream(words).map(String::trim).filter((o) -> {
            return o.length() > 0;
        }).forEach((o) -> {
            if (o.equals(this.wildcard)) {
                if (this.wildcardChild == null) {
                    this.wildcardChild = this.createChild();
                }

                this.wildcardChild.add(obj, kvs, index + 1);
            } else {
                String key = o;
                if (!this.isValueNode && this.valueIgnoreCase) {
                    key = o.toUpperCase();
                }

                Node<T> node = (Node)this.childMap.computeIfAbsent(key, (k) -> {
                    return this.createChild();
                });
                node.add(obj, kvs, index + 1);
            }

        });
    }

    Stream<T> findWithIndex(String[] kvs, int index) {
        Stream<T> superResult = super.findWithIndex(kvs, index);
        if (this.wildcardChild != null) {
            superResult = Stream.concat(superResult, this.wildcardChild.find(kvs, index + 1));
        }

        return superResult;
    }

    public Stream<T> findAll() {
        Stream<T> superResult = super.findAll();
        return this.wildcardChild != null ? Stream.concat(superResult, this.wildcardChild.findAll()) : superResult;
    }
}
