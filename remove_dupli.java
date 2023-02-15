class ListNode {
    int value;
    ListNode next;

    ListNode(int val) {
        this.value = val;
        this.next = null;
    }
}

public class  remove_dupli {
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(12);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next.next.next = new ListNode(6);

        ListNode result = removeDuplicates(head);
        while (result != null) {
            System.out.print(result.value + "->");
            result = result.next;
        }
    }
}