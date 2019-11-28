package com.learning.first;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuying on 2019/11/27 9:12
 */
public class FileTest {

    public static void main(String[] args) {
        FileTest.readFileByLines("D:/test.txt");
    }

    /**
     * 创建文件
     * @param filePath
     * @return
     */
    public static boolean createFile(String filePath) {
        boolean result = false;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 创建文件夹
     * @param directory
     * @return
     */
    public static boolean createDirectory(String directory){
        boolean result = false;
        File file = new File(directory);
        if(!file.exists()){
            result = file.mkdirs();
        }

        return result;
    }

    /**
     * 删除文件
     * @param filePath
     * @return
     */
    public static boolean deleteFile(String filePath) {
        boolean result = false;
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            result = file.delete();
        }

        return result;
    }

    /**
     * 删除文件夹
     * @param filePath
     */
    public static void deleteDirectory(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            return;
        }

        if(file.isFile()){
            file.delete();
        }else if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File myfile : files) {
                deleteDirectory(filePath + "/" + myfile.getName());
            }
            file.delete();
        }
    }

    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件
     * @param filePath
     * @return
     */
    public static String readFileByBytes(String filePath){
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            return null;
        }

        StringBuffer content = new StringBuffer();

        try {
            byte[] temp = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            while(fileInputStream.read(temp) != -1){
                content.append(new String(temp));
                temp = new byte[1024];
            }

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件，支持读取中文
     * @param filePath
     * @return
     */
    public static String readFileByChars(String filePath){
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            return null;
        }

        StringBuffer content = new StringBuffer();
        try {
            char[] temp = new char[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            while(inputStreamReader.read(temp) != -1){
                content.append(new String(temp));
                temp = new char[1024];
            }

            fileInputStream.close();
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     * @param filePath
     * @return
     */
    public static List<String> readFileByLines(String filePath){
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            return null;
        }

        List<String> content = new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String lineContent = "";
            while ((lineContent = reader.readLine()) != null) {
                content.add(lineContent);
                System.out.println(lineContent);
            }

            fileInputStream.close();
            inputStreamReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    /**
     * 字符串写入文件的几个类中，FileWriter效率最高，BufferedOutputStream次之，FileOutputStream最差。
     * 通过FileOutputStream写入文件
     * @param filePath
     * @param content
     * @throws IOException
     */
    public static void writeFileByFileOutputStream(String filePath, String content) throws IOException{
        File file = new File(filePath);
        synchronized (file) {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(content.getBytes("GBK"));
            fos.close();
        }
    }

    /**
     * 通过BufferedOutputStream写入文件
     * @param filePath
     * @param content
     * @throws IOException
     */
    public static void writeFileByBufferedOutputStream(String filePath, String content) throws IOException{
        File file = new File(filePath);
        synchronized (file) {
            BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filePath));
            fos.write(content.getBytes("GBK"));
            fos.flush();
            fos.close();
        }
    }

    /**
     * 通过FileWriter将字符串写入文件
     * @param filePath
     * @param content
     * @throws IOException
     */
    public static void writeFileByFileWriter(String filePath, String content) throws IOException{
        File file = new File(filePath);
        synchronized (file) {
            FileWriter fw = new FileWriter(filePath);
            fw.write(content);
            fw.close();
        }
    }
}
