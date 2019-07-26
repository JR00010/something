package test.com.queue;
import java.util.Iterator;
 
/** 环形队列
 * @author 80003509
 *
 * @param <T>
 */
public class CircleQueue<T> implements Iterable<T> {
    private Node first;//链表头节点
    private Node last;//链表尾节点
    private int N;//链表大小
    /**
     * 迭代器实现
     * @return 迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new circleQueueIterator();
    }
    private class circleQueueIterator implements Iterator<T> {
        int queueSize=N;
        private Node currentNode=first;
        @Override
        public boolean hasNext() {
            return queueSize!=0;
        }
 
        @Override
        public T next() {
            queueSize--;
            T data=currentNode.data;
            currentNode=currentNode.next;
            return data;
        }
    }
 
    /**
     * 节点内部类
     */
    private class Node{
        T data;
        Node next;
    }
    /**
     * 在表尾巴添加节点
     * @param data
     */
    public void enqueue(T data){
        Node nextNode=new Node();
        nextNode.data=data;
        if(first==null){
            first=nextNode;
            last=nextNode;
        }else{
            nextNode.next=first;
            last.next=nextNode;
            last=nextNode;
        }
        N++;
    }
 
    /**
     * 删除表头第一个节点
     * @return 移除的节点数据
     */
    public T dequeue(){
        T data=first.data;
        last.next=first.next;
        first=first.next;
        N--;
        return data;
    }
 
    /**
     * 链表大小
     * @return 链表长度
     */
    public int size(){
        return N;
    }
 
}
