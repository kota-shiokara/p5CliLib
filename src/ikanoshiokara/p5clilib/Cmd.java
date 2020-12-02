package ikanoshiokara.p5clilib;

/*
* @author kota-shiokara
* @version 0.3.0
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Cmd{
    private String currentDirectory;
    private final String VERSION = "v0.3.0";

    public Cmd(String firstDirectory){
        this.currentDirectory = firstDirectory;
    }

    public String getCurrentDirectory(){
        return this.currentDirectory;
    }

    public void setCurrentDirectory(String nextDirectory){
        this.currentDirectory = nextDirectory;
    }

    public String getVERSION() {
        return VERSION;
    }

    public String cmd(String command){
        if(command.equals("version")){
            return "P5CliLib version: " + getVERSION();
        }
        try{
            Class<?> c = Commander.class;
            Constructor constructor = c.getDeclaredConstructor(String.class);
            Object obj = constructor.newInstance(currentDirectory);
            Method m = c.getMethod(command);
            return m.invoke(obj).toString();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
            return "\"" + command + "\" is not found.";
        } catch (IllegalAccessException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        } catch (InvocationTargetException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        } catch (InstantiationException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        }
    }

    public String cmd(String command, String[] option){
        try{
            Class<?> c = Commander.class;
            Constructor constructor = c.getDeclaredConstructor(String.class);
            Object obj = constructor.newInstance(currentDirectory);
            Method m = c.getMethod(command + "WithOption");
            return m.invoke(obj, option).toString();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
            return "\"" + command + "\" is not found.";
        } catch (IllegalAccessException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        } catch (InvocationTargetException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        } catch (InstantiationException e){
            e.printStackTrace();
            return "Error: " + e.toString();
        }
    }
}
