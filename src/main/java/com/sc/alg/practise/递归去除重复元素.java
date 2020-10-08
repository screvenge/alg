package com.sc.alg.practise;

import com.sc.alg.practise.common.ListNode;

import java.util.*;

public class 递归去除重复元素 {
    public static void main(String[] args) {
        deleteDuplicates(new ListNode()).print();
    }

    /**
     * 思路：删除所有头部的重复节点，返回不重复的第一个节点。
     *
     * 1.特殊情况，头节点为null或头节点下一节点为null，直接返回头节点，这时不存在重复节点
     * 2.如果头节点与，头节点的下一节点值相等，跳过所有相等节点。递归调用函数判断最后一个跳过节点的后一节点。
     * 3.如果头节点与，头节点的下一节点值不等，递归调用函数判断头节点的后一节点。
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            // 一直循环到head和next不等为止
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}