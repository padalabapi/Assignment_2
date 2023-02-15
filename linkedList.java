import java.util.Collections;
import java.util.LinkedList;
public class linkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeLists(Node headA, Node headB) {
        Node currA = headA;
        Node currB = headB;
        LinkedList<Integer> result = new LinkedList<>();

        while (currA != null || currB != null) {
            if (currA != null) {
                result.add(currA.data);
                currA = currA.next;
            }
            if (currB != null) {
                result.add(currB.data);
                currB = currB.next;
            }
        }

        Collections.sort(result);

        Node head = new Node(result.get(0));
        Node current = head;
        for (int i = 1; i < result.size(); i++) {
            current.next = new Node(result.get(i));
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node headA = new Node(27);
        headA.next = new Node(39);
        headA.next.next = new Node(18);
        headA.next.next.next = new Node(5);
        headA.next.next.next.next = new Node(33);
        headA.next.next.next.next.next = new Node(44);
        Node headB = new Node(1);
        headB.next = new Node(42);
        headB.next.next = new Node(32);
        headB.next.next.next = new Node(55);
        headB.next.next.next.next = new Node(43);
        headB.next.next.next.next.next = new Node(79);
        Node result = mergeLists(headA, headB);
        while (result != null) {
            System.out.print(result.data + "=>");
            result = result.next;
        }
    }
}