package com.forezp.thread.suanfa.翻转链表;

import com.forezp.thread.suanfa.bean.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-16  10:19
 **/
public class ReverseListNode {

    public ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode cur = head,  pre  = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        h.next = new ListNode(1);
        h.next.next = new ListNode(2);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(4);


        ReverseListNode r = new ReverseListNode();

        ListNode reverse = r.reverse(h);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }

        List<Student> students = new ArrayList<>();
        students.add(new Student("ClassA", "Male"));
        students.add(new Student("ClassA", "Female"));
        students.add(new Student("ClassB", "Male"));
        students.add(new Student("ClassB", "Male"));
        students.add(new Student("ClassB", "Female"));
        students.add(new Student("ClassC", "Female"));

        Map<String, Map<String, Long>> classGenderCount =
                students.stream()
                .collect(Collectors.groupingBy(Student::getClassName,
                        Collectors.groupingBy(Student::getGender, Collectors.counting())));

        System.out.println("Class gender count:");
        classGenderCount.forEach((className, genderCountMap) -> {
            System.out.println(className + ":");
            genderCountMap.forEach((gender, count) -> System.out.println(gender + ": " + count));
        });

    }

    static class Student {
        private String className;
        private String gender;

        public Student(String className, String gender) {
            this.className = className;
            this.gender = gender;
        }

        public String getClassName() {
            return className;
        }

        public String getGender() {
            return gender;
        }
    }
}
