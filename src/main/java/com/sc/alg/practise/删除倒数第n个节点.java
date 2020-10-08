package com.sc.alg.practise;

import com.sc.alg.practise.common.ListNode;

public class 删除倒数第n个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy作为虚空节点, 代表链表表头
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // first向后移动, second向后移动, 达到倒数的效果
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 删除元素后维护新的链式
        second.next = second.next.next;

        // dummy的头为虚空节点
        return dummy.next;
    }
}
