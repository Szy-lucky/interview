package com;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com
 * @ClassName: Main2
 * @Description:
 * @author:
 * @date: 2021/4/24 15:38
 */
public class Main2 {
    public static void main(String[] args) {

        /*ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = new Solution1().returnNode1(l1, 1);
        while (listNode != null){
            System.out.println(listNode.val + "    ");
            listNode = listNode.next;
        }*/

        System.out.println(new Solution1().reverse(1534236469));

    }
}


class Solution1 {

    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            if((res * 10) / 10 != res){
                res = 0;
                break;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }


    public ListNode returnNode1(ListNode listNode, int n){
        if (listNode == null){
            return listNode;
        }
        ListNode first = listNode;
        if (first.val == n){
            return first.next;
        }
        ListNode pre = null;
        while (listNode != null){
            if (listNode.val == n){
               ListNode now = listNode;
               pre.next = listNode.next;
               now.next = null;
               break;
            }
            pre = listNode;
            listNode = listNode.next;
        }
        return first;
    }

    public ListNode returnNode(ListNode listNode, int n){
        if (listNode == null || listNode.next == null){
            return listNode;
        }
        Map<Integer, ListNode> map = new HashMap();
        int i = 1;
        while (listNode != null){
            map.put(i, listNode);
            if (listNode.next != null){
                i ++;
            }
            listNode = listNode.next;
        }
        i = i - n;
        listNode = map.get(i);
        ListNode nextNode = listNode.next.next;
        listNode.next.next = null;
        listNode.next = nextNode;
        return map.get(1);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length ==0)
            return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]){
                min = prices[i];
            }
            profit = profit < prices[i] - min ? prices[i] - min: profit;
        }
        return profit;
    }

    public String convert(String s, int numRows) {


        String rs = "";
        if (numRows == 1)
            return s;
        int a = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int k = i;
            while (k < s.length()){
                rs += s.substring(k, k+1);
                k += a;
                if(i != numRows - 1 && i != 0 && k - (2 * i) < s.length()){
                    rs += s.substring(k - (2 * i), k - (2 * i) + 1);
                }

            }
        }
        return rs;
    }

    public String longestPalindrome(String s) {
        if(s.length() <= 1 || s == null)
            return s;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String helper = helper(s, i, i);
            if (helper.length() > longest.length())
                longest = helper;

            String helper1 = helper(s, i, i + 1);
            if (helper1.length() > longest.length())
                longest = helper1;
        }
        return longest;
    }
    public String helper(String s, int begin, int end){
        while (begin >= 0 && end <= s.length() -1 && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
    /*public String longestPalindrome(String s) {
        if(s.length() <= 1 || s == null)
            return s;
        int len = s.length();
        int maxl = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = s.charAt(0) + "";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int k = i + j;
                if(s.charAt(j) == s.charAt(k) && (k - j <= 2 || dp[j + 1][k - 1])){
                    dp[j][k] = true;

                    if (k - j + 1 > maxl){
                        maxl = k - j + 1;
                        longest = s.substring(j, k + 1);
                    }
                }
            }
        }
        return longest;
    }*/

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)
            return 0;
        if (nums1.length == 0){
            int i = nums2.length / 2;
            if (nums2.length % 2 != 0)
                return nums2[i];
            else
                return (nums2[i - 1] + nums2[i]) / 2.0;
        }
        if (nums2.length == 0){
            int i = nums1.length / 2;
            if (nums1.length % 2 != 0)
                return nums1[i];
            else
                return (nums1[i - 1] + nums1[i]) / 2.0;
        }
        int[] sum = new int[nums1.length + nums2.length];
        for(int i = 0, j = 0, u = 0;i < nums1.length && j < nums2.length;u++){
            if (nums1[i] < nums2[j]){
                sum[u] = nums1[i];
                i++;
            }else{
                sum[u] = nums2[j];
                j++;
            }
            if (i == nums1.length){
                ++u;
                for (int k = j; k < nums2.length; k++, ++u) {
                    sum[u] = nums2[k];
                }
                break;
            }
            if (j == nums2.length){
                ++u;
                for (int k = i; k < nums1.length; k++, u++) {
                    sum[u] = nums1[k];
                }
                break;
            }
        }
        int i = sum.length / 2;
        if (sum.length % 2 != 0)
            return sum[i];
        else
            return (sum[i - 1] + sum[i]) / 2.0;
    }
    /*public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[2];
        for(int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }*/

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[2];
        map.put(target - nums[0], 0);
        for(int i = 1; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                a[0] = map.get(nums[i]);
                a[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }
        return a;
    }
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(target - nums[0], 0);
        for(int i = 1; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }

}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*long i1 = 0, i2 = 0, i = 0;
        while (l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            i1 += x * Math.pow(10, i);
            i2 += y * Math.pow(10, i);
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            i++;
        }
        long i3 = i1 + i2;
        ListNode listNode = new ListNode((int) (i3 % 10));
        ListNode f = listNode;
        i3 /= 10;
        while (i3 != 0){

            listNode.next = new ListNode((int) (i3 % 10));
            listNode = listNode.next;
            i3 /= 10;
        }
        return f;*/


        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int index = 0;
        int max = 0;
        for(int i= 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= index){
                index = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - index + 1);
        }
        return max;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int val, int i) {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
