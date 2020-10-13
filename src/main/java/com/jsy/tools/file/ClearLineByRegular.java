package com.jsy.tools.file;

import com.jsy.tools.util.CloseableUtils;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 按照指定字符删除一行
 *
 * @Author: jsy
 * @Date: 2020/9/22 22:46
 */
public class ClearLineByRegular {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("ScannerTest, please enter source file name:");
        String inputName = sc.nextLine();  //读取字符串型输入
        System.out.println("please enter target file name");
        String outputName = sc.nextLine();  //读取字符串型输入
        System.out.println("please enter exclude str , split with comma of english");
        String target = sc.nextLine();  //读取字符串型输入

        // System.out.println("ScannerTest, Please Enter Age:");
        // int age = sc.nextInt();    //读取整型输入
        // System.out.println("ScannerTest, Please Enter Salary:");
        // float salary = sc.nextFloat(); //读取float型输入
        // System.out.println("Your Information is as below:");
        // System.out.println("Name:" + name +"\n" + "Age:"+age + "\n"+"Salary:"+salary);

        List<String> targetList = Arrays.asList(target.split(","));

        System.out.println("inputName = " + inputName);
        System.out.println("outputName = " + outputName);
        System.out.println("targetList = " + targetList);

        fileCopy(inputName, outputName, targetList);

    }

    // 文件字符流
    static void fileCopy(String inputName, String outputName, List<String> targetList) throws Exception {
        // 创建输入流
        FileReader fr = new FileReader(inputName);
        BufferedReader in = new BufferedReader(fr);

        // 创建输出流
        FileWriter fw = new FileWriter(outputName);
        PrintWriter out = new PrintWriter(fw);
        // 只能输出字符串，不是字符串会自动转换成字符串
        // out.println();

        while (true) {
            // 读一行
            String str = in.readLine();
            if (str == null) {
                break;
            }

            List<String> collect = targetList.stream().filter(t -> str.contains(t)).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(collect)) {
                out.println(str);
            }
        }

        System.out.println("end with succeed");

        CloseableUtils.closeQuietly(in);
        CloseableUtils.closeQuietly(out);
    }
}
