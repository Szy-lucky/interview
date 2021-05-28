package com;

import java.util.Scanner;

/**
 * @PackageName: com
 * @ClassName: XieCheng
 * @Description:
 * @author:
 * @date: 2021/5/27 19:13
 */
public class XieCheng {
        /*请完成下面这个函数，实现题目要求的功能
        当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
        ******************************开始写代码******************************/
        static int winner(int[] s, int[] t) {
            int lef = 0;
            int right = 0;
            int x = 0;
            int count = 0;
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < t.length; j++) {
                    if (s[i] == t[j]){
                        if (x == s[i]){
                            lef = i;
                        }
                        if (count == 0)
                            lef = i;
                        x = s[i];
                        count++;
                    }
                }
                count++;
            }
            return 0;
        }
        /******************************结束写代码******************************/


        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int res;

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[]values=line.split(",");
            int[]s=new int[values.length];
            for(int i=0;i<values.length;i++){
                s[i] = Integer.parseInt(values[i]);
            }

            line = scanner.nextLine();
            values=line.split(",");
            int[]t=new int[values.length];
            for(int i=0;i<values.length;i++){
                t[i] = Integer.parseInt(values[i]);
            }

            res = winner(s, t);
            System.out.println(String.valueOf(res));

        }
    }
