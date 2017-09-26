---
title: java note
date: 2017-09-26 14:19:02
tags:
---

#Collection
	List  有序可重复
		ArrayList
		Vector
		LinkedList
	Set  无序不可重复  使用hash值达到不重复
		HashSet
		LinkedHashSet （按照插入顺序存放的，不重复的）
		SortedSet
		TreeSet
	Queue
		LinkedList
#Map
	hashMap
	weakhashMap
	SortedMap
		TreeMap
#Map.Entry
#Iterator
	ListIterator
#Enumeration 最早的输出的接口

#1.collection接口：
       @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }


        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {
        }
###注意 ：
1.al.retainAll(al1)相当于求交集然后放在al中；
2.两种方法将一个集合转变为数组：
	Integer []array1=al.toArray(new Integer[]{})通过泛型指定了数组的类型
	Object []array2=al.toArray()返回的是Object[],需要进行类型转换
3.LinkedList同时实现了List和Queue接口，就是一个链表的封装:
   LinkedList<String> ll=new LinkedList<String>();
    ll.add("eq");
    ll.add("eq1");
    ll.add("eq2");
    ll.add("eq3");
    ll.addFirst("23");
    ll.addLast("233");
    System.out.println(ll);
其中：Queue接口

element找到头 offer在队列尾加元素
peek找到头
poll找到头并删除
remove删除头


#2.List接口

可以重复 ，可以认为是一个数组，可以通过索引取出数据 
List对于Collection有很大的扩充 新增包括

指定位置增加数据
指定位置增加一组数据
取得指定位置数据
在指定位置删除数据
subList(from,to)返回子Listal1=al.subList(0,1); 等数据的顺序与插入顺序一样

#3.Set

其中的方法与Collection的完全一样

顺序与插入的顺序无关
不重复的，如果重复插入会忽略
TreeSet

数据是排序的！！，实际上也是SortedSet的一个子类
HashSet

数据散列存放
TreeSet自动排序原理

要排序必须可比较，因此TreeSet指定的类必须实现了Comparable方法

判断重复元素的原理

使用equals和hashCode方法来判断 首先判断hashCoede是否一样，不相同则为不同元素，相同则调用equals()来最终决定，因此将元素加入Set的的时候最好复写这两个方法

对象相等->hashcode一定相等
hashCode相等->对象不一定相等
SortedSet接口

是自动排序的 方法

返回首尾元素
返回任意一段子SortedSet headSet/tailSet/subSet
Iterator接口

Collection的输出方式

Iterator
ListIterator
foreach
Enumeration
集合的输出最好一定是用Iterator接口
Iterator是迭代输出接口
通过Collection.iterator()实例化
hasnext()判断是否有内容，并且移动指针
在使用迭代输出的时候，不要使用集合类的remove方法，而是要用iterator的remove方法，尽量不要再输出时删除
单向操作

比较的list:

(1)HashMap和Hashtable ( 注意table是小写的t)：

首先来看HashMap和HashTable，这两兄弟经常被放到一起来比较，那么它们有什么不一样呢？

a.HashMap不是线程安全的；HashTable是线程安全的，其线程安全是通过Sychronize实现。

b.由于上述原因，HashMap效率高于HashTable。

c.HashMap的键可以为null，HashTable不可以。

d.多线程环境下，通常也不是用HashTable，因为效率低。HashMap配合Collections工具类使用实现线程安全。同时还有ConcurrentHashMap可以选择，该类的线程安全是通过Lock的方式实现的，所以效率高于Hashtable。

e.HashMap的扩容代价非常大，要生成一个新的桶数组，然后要把所有元素都重新Hash落桶一次，几乎等于重新执行了一次所有元素的put。所以如果我们对Map的大小有一个范围的话，可以在构造时给定大小，一般大小设置为：(int) ((float) expectedSize / 0.75F + 1.0F)。

f.key的设计尽量简洁。

(2)数组 链表 哈希表之间的区别：

数组，链表，哈希表。各有优劣，顺便提一下，数组连续内存空间，查找速度快，增删慢；链表充分利用了内存，存储空间是不连续的，首尾存储上下一个节点的信息，所以寻址麻烦，查找速度慢，但是增删快；哈希表呢，综合了它们两个的有点，一个哈希表，由数组和链表组成。假设一条链表有1000个节点，现在查找最后一个节点，就得从第一个遍历到最后一个；如果用哈希表，将这条链表分为10组，用一个容量为10数组来存储这10组链表的头结点（a[0] = 0 , a[1] = 100 , a[2] = 200 …）。这样寻址就快了。

（3）什么是hash碰撞？

Hash碰撞，不同的key根据hash算法算出的值可能一样，如果一样就是所谓的碰撞。

(4)遍历一个HashTable的方式？

   第一种方法是 使用foreach方法去循环遍历 keyset 或者entryset;
   第二种方法是 使用keyset或者entryset的迭代器;

      //遍历方式一:for each遍历HashMap的entryset，注意这种方式在定义的时候就必须写成
        //Map<Integer , String> hs，不能写成Map hs;
        for(Entry<Integer , String> entry : hs.entrySet()){
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        }
        //遍历方式二：使用EntrySet的Iterator
        Iterator<Map.Entry<Integer , String>> iterator = hs.entrySet().iterator();
        while(iterator.hasNext()){
            Entry<Integer , String> entry =  iterator.next();
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        };
        //遍历方式三：for each直接使用HashMap的keyset
        for(Integer key : hs.keySet()){
            System.out.println("key:"+key+"  value:"+hs.get(key));
        };
        //遍历方式四：使用keyset的Iterator
        Iterator keyIterator = hs.keySet().iterator();
        while(keyIterator.hasNext()){
            Integer key = (Integer)keyIterator.next();
            System.out.println("key:"+key+"  value:"+hs.get(key));
        }  

(5)使用keyset的两种方式都会遍历两次，所以效率没有使用EntrySet高。

   HashMap输出是无序的，这个无序不是说每次遍历的结果顺序不一样，而是说与插入顺序不一样。 





