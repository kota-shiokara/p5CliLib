package ikanoshiokara.p5clilib;

import ikanoshiokara.p5clilib.ListSegments;

public class Cmd{
    private String currentDirectory;

    public Cmd(String firstDirectory){
        this.currentDirectory = firstDirectory;
    }

    public String getCurrentDirectory(){
        return this.currentDirectory;
    }

    public void setCurrentDirectory(String nextDirectory){
        this.currentDirectory = nextDirectory;
    }

    public String ls(){
        return new ListSegments(this.currentDirectory).ls();
    }

    public String ls(String[] option){
        return new ListSegments(this.currentDirectory, option).ls();
    }
}
