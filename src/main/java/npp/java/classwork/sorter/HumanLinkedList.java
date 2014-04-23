package npp.java.classwork.sorter;

import java.util.List;

/**
 * Created by aleksandr on 19.04.14.
 */
public class HumanLinkedList {
    private class Node{
        private Human human;
        private Node next;

        public Node(Human human){
            this.human=human;
            this.next=null;
        }

        public Human getHuman() {
            return human;
        }

        public void setHuman(Human human) {
            this.human = human;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head, current, tail;
    private int size;

    public HumanLinkedList(){
        this.head=null;
        this.current=null;
        this.tail=null;
        size=0;
    }

    public  boolean endOfList(){
        return this.current==null;
    }

    public boolean isEmpty(){
        return  this.head==null;
    }

    public void add (Human human){
        Node node = new Node(human);
        if (this.isEmpty()){
            this.head=node;
            this.tail=node;
        }
        else{
            node.setNext(head);
            this.head=node;
        }
        this.current=node;
        size++;
    }

    public Human getCurrent(){
        if (this.current!=null){
            Human result = current.getHuman();
            current=current.getNext();
            return result;
        }
        else{
            //TODO: exception current == null
            return null;
        }
    }

    public void append(HumanLinkedList list){
        if (!list.isEmpty()){
            if (!this.isEmpty()) {
                this.tail.setNext(list.head);
                this.tail = list.tail;
            }
            else{
                this.head=list.head;
                this.tail=list.tail;
            }
        }
        size+=list.size;
    }


//bubble sortByName by Name
    public void sortByName(){
        Node currentNode = this.head;
        Node last=null;
        for (int i=0; i<size;i++){
            while (currentNode.next!=last){
                if (currentNode.human.getName().compareTo(currentNode.next.human.getName())>0){
                    Human temp=currentNode.human;
                    currentNode.human=currentNode.next.human;
                    currentNode.next.human=temp;
                }
                currentNode=currentNode.next;
            }
            last=currentNode;
            currentNode=head;
        }
    }

}
