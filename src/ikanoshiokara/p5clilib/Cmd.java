package ikanoshiokara.p5clilib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public String cmd(String command){
        try{
            Class<?> c = Commander.class;
            Constructor constructor = c.getDeclaredConstructor(String.class);
            Object obj = constructor.newInstance(currentDirectory);
            Method m = c.getMethod(command);
            return m.invoke(obj).toString();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
            // "\"" + command + "\" is not found.";
            return "Error: " + e.toString();
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
            // "\"" + command + "\" is not found.";
            return "Error: " + e.toString();
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

    public static String toUpperCaseFirst(String str) {
        char[] arr = str.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }

    public static String toLowerCaseFirst(String str){
        char[] arr = str.toCharArray();
        arr[0] = Character.toLowerCase(arr[0]);
        return new String(arr);
    }
}
