package ikanoshiokara.p5clilib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface Ls {

    String ls();

    String lsWithOption(String[] option);

    /*String current;
    List<String> fileList = new ArrayList<String>();

    public String runCmd(String current){
        File array[];
        try{
            array = new File(current).listFiles(); // 受け取ったディレクトリの中身を吐き出す
        }catch (NullPointerException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        }
        for(File f: array){
            if(f.isFile()){
                fileList.add(f.getName()); // ファイルはそのままfileListに
            }else if(f.isDirectory()){
                fileList.add(f.getName() + "/"); // ディレクトリは/をつけて格納
            }
        }
        return String.join(" ", this.fileList);
    }

    public String runCmdWithOption(String current, String[] option){
        File array[];
        try{
            array = new File(current).listFiles(); // 受け取ったディレクトリの中身を吐き出す
        }catch (NullPointerException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        }
        for(File f: array){
            if(f.isFile()){
                fileList.add(f.getName()); // ファイルはそのままfileListに
            }else if(f.isDirectory()){
                fileList.add(f.getName() + "/"); // ディレクトリは/をつけて格納
            }
        }
        return String.join(" ", this.fileList);
    }*/
}
