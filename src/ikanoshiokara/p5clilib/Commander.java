package ikanoshiokara.p5clilib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Commander implements Ls{
    private String current;
    Commander(String _current){
        current = _current;
    }

    void setCurrent(String _current){
        current = _current;
    }

    String getCurrent(){
        return current;
    }

    public String ls(){
        List<String> fileList = new ArrayList<String>();
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
        return String.join(" ", fileList);
    }

    public String lsWithOption(String[] option){
        File array[];
        List<String> fileList = new ArrayList<String>();
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
        return String.join(" ", fileList);
    }
}
