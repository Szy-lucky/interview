package com;
/**
 * @PackageName: com
 * @ClassName: Test
 * @Description:
 * @author:
 * @date: 2021/4/24 16:15
 */
public class Test {
    public static void main(String[] args) {
        int[] ints = {3, 3, 1, 2, 4, 5, 2};
        Solution solution = new Solution();
        Solution5 solution5 = new Solution5();
        System.out.println(solution.canJump(ints));
        System.out.println(solution5.jump(ints));
    }
}

class Solution {
    public boolean canJump(int[] a) {
        // think it as merging n intervals
        if (a == null || a.length == 0) {
            return false;
        }
        int farthest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (i <= farthest && a[i] + i >= farthest) {
                farthest = a[i] + i;
            }
        }
        return farthest >= a.length - 1;
    }
}

class Solution5 {
    public int jump(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < a.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (a[i] + i > farthest) {
                    farthest = a[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }
}
