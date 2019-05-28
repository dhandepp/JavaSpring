package datastructures.linkedlist;

public class CycleLinkedListTest {

    public static  void main(String[] args){
        LinkedList list = new LinkedList();
        // Add few nodes
        list.append(2);
        list.append(3);
        list.append(5);
        list.append(7);
        list.append(11);

        list.createCycle(5,13);
        System.out.println(list.hasCycle());
    }
}
