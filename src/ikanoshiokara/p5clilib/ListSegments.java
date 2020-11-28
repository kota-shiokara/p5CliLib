package ikanoshiokara.p5clilib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListSegments {
    String current;
    List<String> fileList = new ArrayList<String>();

    ListSegments(String _current){
        this.current = _current;
    }

    ListSegments(String _current, String[] option){
        this.current = _current;
    }

    public String ls(){
        File array[];
        try{
            array = new File(this.current).listFiles(); // 受け取ったディレクトリの中身を吐き出す
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
}
