import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LL {
    public static ListNode insert(ListNode head, int x, int y) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == x - 1) {
                ListNode newNodex = new ListNode(40, temp.next);
                temp.next = newNodex;
            } else if (count == y - 1) {
                ListNode newNodex = new ListNode(50, temp.next);
                temp.next = newNodex;
            }
            temp = temp.next;
        }
        return head;
    }

    public static ListNode delete(ListNode head, int x, int y) {
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        int count = 0;
        while (temp != null && temp.next != null) {
            count++;
            if (count == x - 1 || count == y - 1) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode mover = head;
        for (int i = 1; i < n; i++) {
            int val = sc.nextInt();
            mover.next = new ListNode(val);
            mover = mover.next;
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        ListNode inserted = insert(head, x, y);
        
        printList(inserted);

        ListNode deleted = delete(inserted, x, y);
      
        printList(deleted);

        sc.close();
    }
}
