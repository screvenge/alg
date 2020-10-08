package com.sc.alg.practise.common;

public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode() {
        this.val = 1;
        this.next = new ListNode(4);
        this.next.next = new ListNode(3);
        this.next.next.next = new ListNode(2);
        this.next.next.next.next = new ListNode(5);
        this.next.next.next.next.next = new ListNode(2);
        this.next.next.next.next.next.next = new ListNode(6);
    }

    public void print() {
        ListNode current = this;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(current.val);
            if (current.next != null) {
                current = current.next;
                sb.append(",");
            } else {
                break;
            }
        }
        System.out.println(sb);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
