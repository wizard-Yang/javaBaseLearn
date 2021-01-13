package main.java.集合.Map接口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author saijun.yang
 * @date 2021/1/13 10:11
 * @description hashmap集合。手动实现一个hashMap
 */
public class MyHashMap<K,V> {
    //实际数据存储数组
    transient Node<K,V>[] table;
    //数组需要扩容时的数据量
    int threshold;
    //数组初始化最大值(1073741824)
    static final int MAXIMUM_CAPACITY = 1 << 30;
    //加载因子，扩容出发条件
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //记录元素数量
    transient int size;

    public MyHashMap(int initialCapacity) {
        if(initialCapacity < 0){
            throw new IllegalArgumentException("illegal initial capacity" + initialCapacity);
        }
        if(initialCapacity > MAXIMUM_CAPACITY){
            initialCapacity = MAXIMUM_CAPACITY;
        }
        this.threshold = tableSizeFor(initialCapacity);
    }

    /**
     *  根据容量参数，返回一个2的n次幂的table长度。
     */
    static final int tableSizeFor(int cap) {
        //防止溢出，所以先减1
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        //最后加1是为了输入为0时，初始化必须为1
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 数据存储节点
     * @param <K>
     * @param <V>
     */
    static class Node<K,V> implements Map.Entry<K,V> {
        //该值为数组下标
        final int hash;
        //键值不可变
        final K key;
        V value;
        //当出现hash冲突时，使用链表存储
        MyHashMap.Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V v) {
            return this.value = v;
        }
    }

    /***************************************增删改查方法*****************************************/
    final V put(K key, V value){
        int hash = hash(key);
        Node<K,V>[] tab = table;
        //在数组中找到的节点
        Node<K,V> p;
        //用于取模运算
        int n;
        //数组存放下标
        int i;
        //判断是否需要扩容或者初始化
        if(tab == null || (n = tab.length) == 0){
            tab = resize();
            n = tab.length;
        }
        //判断新增加的节点key值是否在数组中
        i = (n-1) & hash;
        p = tab[i];
        if(p == null){
            tab[i] = newNode(hash, key, value,null);
        }else{//如果找到了这个节点，就要比对key值，从而判断是更新value还是使用链表往下拉
            Node<K,V> e;
            K k;
            //如果hash相同并且key也相同（对象地址以及equals相等）,等待只要将值替换即可
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))){
                e = p;
            }else{//向下查找链表
                for (int binCount = 0; ; ++binCount) {
                    e = p.next;
                    //如果链表下一个值为null，直接将这个节点接上
                    if(e == null){
                        p.next = newNode(hash, key, value,null);
                        //这里有个优化，就是binCount如果》=7，那么就要转化为红黑树结构了，这里不展开
                        break;
                    }
                    //如果下一个节点不为null并且key值都相等
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))){
                        break;
                    }
                    //p = e;
                }
                //e如果不为空，则代表找到了当前key的值，需要替换value
                if (e != null) {
                    V oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        ++size;
        return null;
    }

    /**
     * 数组扩容以及初始化
     * 该方法作用
     * 1.扩容
     * 2.初始化
     * @return
     */
    final Node<K,V>[] resize(){
        //将原table数组赋值给oldTab
        Node<K,V>[] oldTab = table;
        //旧数组长度
        int oldCap = oldTab == null ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap = 0;
        int newThr = 0;
        //判断是否需要扩容，通过oldCap大小，如果大于0，判断是否需要扩容·
        if(oldCap > 0){

        }else{//小于等于0说明需要初始化
            //这里说明下，我们只有一个构造方法，所以threshold一定有值
            newCap = oldThr;
        }
        if (newThr == 0) {
            //根据加载因子计算扩容临界点
            float ft = (float)newCap * DEFAULT_LOAD_FACTOR;
            //临界值计算，如果数组小于最大允许空间并且扩容临界点也小于这个临界点，则使用干这个，否则使用Integer最大值
            newThr = ((newCap < MAXIMUM_CAPACITY) && (ft < (float)MAXIMUM_CAPACITY)) ? (int)ft : Integer.MAX_VALUE;
        }
        Node<K,V>[] newTab = new Node[newCap];
        table = newTab;
        return newTab;
    }

    /**
     * 新增一个节点
     * @param hash hash值
     * @param key 键值
     * @param value value值
     * @param next 下一个节点
     * @return
     */
     Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    }

    /**
     * 获取key的hash值
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 获取元素数量
     * @return
     */
    public int size(){
        return size;
    }

    public int initCap(){
        if(table != null){
            return table.length;
        }
        return 0;
    }
}
