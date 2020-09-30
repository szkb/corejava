//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.study.basicknowledge.module;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CascadeIndexer<T> {
    private Node<T> rootNode;

    public CascadeIndexer() {
        this.rootNode = new NodeImp(true, false);
    }

    public CascadeIndexer(boolean ignoreCase) {
        this.rootNode = new NodeImp(true, ignoreCase);
    }

    public CascadeIndexer(String speratorPattern) {
        this.rootNode = new WildcardNode(true, (String)null, speratorPattern, false);
    }

    public CascadeIndexer(String speratorPattern, boolean valueIgnoreCase) {
        this.rootNode = new WildcardNode(true, (String)null, speratorPattern, valueIgnoreCase);
    }

    public CascadeIndexer(String wildcard, String speratorPattern) {
        this.rootNode = new WildcardNode(true, wildcard, speratorPattern, false);
    }

    public CascadeIndexer(String wildcard, String speratorPattern, boolean valueIgnoreCase) {
        this.rootNode = new WildcardNode(true, wildcard, speratorPattern, valueIgnoreCase);
    }

    public void add(T obj, String... kvs) {
        this.rootNode.add(obj, kvs, 0);
    }

    public Collection<T> find(String... kvs) {
        return (Collection)this.streamFind(kvs).collect(Collectors.toList());
    }

    public Stream<T> streamFind(String... kvs) {
        return this.rootNode.find(kvs, 0).distinct();
    }

    public boolean isEmpty() {
        return this.streamFind().findAny().isPresent();
    }
}
