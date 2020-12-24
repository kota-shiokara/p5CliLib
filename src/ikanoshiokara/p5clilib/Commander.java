package ikanoshiokara.p5clilib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Commander implements ListSegments, Kirby, PrintWorkingDirectory, CurrentDirectory{
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

    //region ListSegments
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
        return current + "\n" + String.join(" ", fileList);
    }

    public String lsWithOption(String options){
        String[] optionList = {"-h", "--help", "-a", "--all", "-d", "--dir", "-f", "--file"};
        String[] parseOptions;
        if(options.indexOf(" ") != -1){
            parseOptions = options.split(" ");
        }else{
            parseOptions = new String[1];
            parseOptions[0] = options;
        }
        File array[];
        List<String> fileList = new ArrayList<String>();
        boolean flagOption = false;
        for(String ol: optionList){
            for(String po: parseOptions){
                if(po.equals(ol)) flagOption = true;
            }
        }
        if(!flagOption){
            return current + "\n" + "no such option. Please see \"ls --help | -h\"";
        }

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
        return current + "\n" + String.join(" ", fileList);
    }
    //endregion

    //region Kirby
    public String kirby(){
        int num = new Random().nextInt(2);
        switch (num){
            case 1:
                return current + "\n" +
                        "─────────██████████──████────\n" +
                        "────────████▒▒░░░░░░░░██▒▒░░██──\n" +
                        "──────██▒▒░░░░██░░██░░░░██░░░░██\n" +
                        "────██▒▒░░░░░░██░░██░░░░░░▒▒░░██\n" +
                        "────██░░░░░░░░██░░██░░░░░░▒▒▒▒██\n" +
                        "──██░░░░░░▒▒▒▒░░░░░░▒▒▒▒░░░░▒▒██\n" +
                        "██▒▒░░░░░░░░░░░░██░░░░░░░░░░░░██\n" +
                        "██░░░░▒▒░░░░░░░░██░░░░░░░░░░▒▒██\n" +
                        "██░░░░▒▒░░░░░░░░░░░░░░░░░░░░██──\n" +
                        "──██████░░░░░░░░░░░░░░░░░░▒▒██──\n" +
                        "██▒▒▒▒▒▒██░░░░░░░░░░░░░░░░▒▒██──\n" +
                        "██▒▒▒▒▒▒▒▒██░░░░░░░░░░░░▒▒██────\n" +
                        "██▒▒▒▒▒▒▒▒██░░░░░░░░░░▒▒████────\n" +
                        "-██▒▒▒▒▒▒▒▒██▒▒▒▒▒▒████▒▒▒▒██──\n" +
                        "──██▒▒▒▒██████████▒▒▒▒▒▒▒▒▒▒██\n" +
                        "────██████──────████████████──";
            default:
                return current + "\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣶⣀⣀⣶⣄⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⢀⡠⣔⠮⠍⠛⠒⠒⠒⠚⠠⠽⣉⠙⠻⢿⣿⣿⣷⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⣠⡂⠕⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠢⢀⡹⠛⠋⠑⡄⠀⠀⠀\n" +
                        "⠀⣀⣀⣠⣼⠏⠀⠀⠀⠀⠀⠀⠀⠜⠑⣄⠀⠀⠀⠀⠀⠠⠊⠀⠀⠀⠀⣷⠀⠀⠀\n" +
                        "⣿⣿⣿⣿⡏⠀⠀⠀⢸⠉⢆⠀⠀⢸⣀⣸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡏⠀⠀⠀\n" +
                        "⣿⣿⣿⣿⠃⠀⠀⠀⠸⣄⣸⡆⠀⠈⢿⣿⣿⠀⣠⣴⣶⣶⡄⠀⢀⣤⣾⣇⣀⣀⡀\n" +
                        "⣿⣿⣿⣿⣦⣄⠀⠀⠀⢻⣿⣿⠀⠀⠈⠻⡿⠀⠘⠛⠛⠋⠁⠸⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⡿⢿⣿⣿⣷⢀⣀⠀⠻⠿⢀⣴⣶⣶⡆⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣦⣤⠛⣿⣿⣿⡿⠃⠀⠀⠹⣿⣿⣿⠇⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣦⡈⣿⣿⠇⠀⠀⠀⠀⠀⠉⠉⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃\n" +
                        "⠉⠻⣿⣿⣿⣿⣿⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀\n" +
                        "⠀⠀⠀⠀⠛⢿⣿⣿⣿⣷⢦⣄⣀⡀⠤⣤⣤⣀⣀⣬⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀\n" +
                        "⠀⠀⠀⢠⣴⣿⣿⣿⣿⣿⣦⣭⣷⣶⣿⣿⡿⠿⠟⠋⠁⠉⠛⠛⠿⠋⠁";
        }
    }
    //endregion

    //region PrintWorkingDirectory
    public String pwd(){
        return current + "\n" + current;
    }
    //endregion

    //TODO:移動できない問題を解決する
    //region CurrentDirectory
    public String cd(){
        return "directory is null, please select directory";
    }

    public String cdWithOption(String options){
        String[] parseOptions;
        if(options.indexOf(" ") != -1){
            parseOptions = options.split(" ");
        }else{
            parseOptions = new String[1];
            parseOptions[0] = options;
        }
        //ルートディレクトリによる絶対パスの時
        for (String option: parseOptions){
            if(option.equals("C:/") || option.equals("/")){
                return option + "\n" + "";
            }
        }
        for (String option: parseOptions){
            if(!option.startsWith("--") && !option.startsWith("-")){
                String[] moveDirectory;
                if(options.indexOf("/") != -1){
                    moveDirectory = option.split("/");
                }else{
                    moveDirectory = new String[1];
                    moveDirectory[0] = option;
                }
                for(String md: moveDirectory){
                    if(md.equals("..")){
                        if(current.lastIndexOf("/") != 0 && current.lastIndexOf("C:/") != 2){
                            current = current.substring(0, current.lastIndexOf("/"));
                        }
                    }else{
                        String tmp = current;
                        current += "/" + md;
                        if(ls().startsWith("Error")){
                            current = tmp;
                            return current + "\n" + md + ": No such file or directory";
                        }
                    }
                }
                return current + "\n" + "";
            }
        }
        return current + "\n" + "";
    }
    //endregion
}
