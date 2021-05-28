package com;

import java.io.File;
/**
 * @PackageName: com
 * @ClassName: Test3
 * @Description:
 * @author:
 * @date: 2021/4/24 16:15
 */
public class Test3 {
    Long max = 0L;
    File file  = null;
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        File maxFile = test3.findMaxFile(new File("D:\\Bin"));

        System.out.println(maxFile);
    }

    public File findMaxFile(File dir) {

        File[] files = dir.listFiles();

        for (File value : files) {
            if (value.isFile()) {
                if (value.length() > max) {
                    max = value.length();
                    file = value;
                }
            } else {
                File maxFile = findMaxFile(value);
                if (maxFile.length() > max) {
                    max = value.length();
                    file = value;
                }
            }
        }
        return file;
    }


}