package com.shadman.practice.testDsa;

public class LinkedListEx1 {

    public static class LinkedListNode {
        LinkedListNode next;
        Integer value;
        LinkedListNode(Integer value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(14);
        LinkedListNode ptr = head;
        ptr.next = new LinkedListNode(34);
        ptr = ptr.next;
        ptr.next = new LinkedListNode(50);
        ptr = ptr.next;
        ptr.next = new LinkedListNode(12);
        ptr = ptr.next;
        ptr.next = new LinkedListNode(60);
        ptr = ptr.next;
        ptr.next = new LinkedListNode(23);
        ptr = ptr.next;
        ptr.next = new LinkedListNode(123);
        ptr = ptr.next;

        printMiddleNodeValue(head);
    }

    public static void printMiddleNodeValue(LinkedListNode node){
        LinkedListNode ptr1 = node;
        LinkedListNode ptr2 = node;

        // ptr2 move 2x and ptr move 1x
        while(ptr2.next != null){
            ptr2 = ptr2.next;
            if(ptr2.next == null) break;
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }

        System.out.println(ptr1.value);
    }


}
