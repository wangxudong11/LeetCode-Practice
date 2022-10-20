/**
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 

 请你将两个数相加，并以相同形式返回一个表示和的链表。 

 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 

 

 示例 1： 
 
 
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
 

 示例 2： 

 
输入：l1 = [0], l2 = [0]
输出：[0]
 

 示例 3： 

 
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
 

 

 提示： 

 
 每个链表中的节点数在范围 [1, 100] 内 
 0 <= Node.val <= 9 
 题目数据保证列表表示的数字不含前导零 
 

 Related Topics 递归 链表 数学 👍 8775 👎 0

*/

package com.bifang.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author 彼方
 * 2022-10-19 09:46:42  // 生成当前你做题的时间
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1=solution.getList(new int[]{9,9,9,9,9,9,9});
        ListNode l2=solution.getList(new int[]{9,9,9,9});
        solution.addTwoNumbers(l1,l2);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode getList(int[] param){
            ListNode first=new ListNode();
            ListNode cur=first;
            for (int i=0;i<param.length;i++) {
                cur.val=param[i];
                if(i==param.length-1)
                    break;
                cur.next=new ListNode();
                cur=cur.next;
            }
            return first;
        }
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode cur_l1 = l1;
            ListNode cur_l2 = l2;
            ListNode firstNode = new ListNode();
            ListNode cur = firstNode;
            int temp = 0;
            while (cur_l1!=null || cur_l2!=null) {
                int x = cur_l1 == null ? 0 : cur_l1.val;
                int y = cur_l2 == null ? 0 : cur_l2.val;
                cur.val = x + y + temp;
                temp=0;
                temp = cur.val / 10;
                cur.val %= 10;

                cur_l1 = cur_l1 == null ? null : cur_l1.next;
                cur_l2 = cur_l2 == null ? null : cur_l2.next;
                if(cur_l1==null&&cur_l2==null)
                    break;
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            if(temp!=0)
                cur.next=new ListNode(temp);
            //cur.val = cur_l1.val + cur_l2.val + temp;
            //temp = cur.val / 10;
            //cur.val %= 10;
            return firstNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
