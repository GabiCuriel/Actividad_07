package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ModelGyA {
    private String path;
    public String message;
    
    public String getPath(){
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void readFile(String path){
        try {
            String row;
            String x="";
            try (FileReader file = new FileReader(path)){
                BufferedReader bufferedReader = new BufferedReader (file);
                while((row = bufferedReader.readLine()) != null){
                    x=x+row+"\n";
                    this.setMessage(x);
                    System.out.println(row);
                }
                this.setMessage(x);
                bufferedReader.close();
            }
        }catch (FileNotFoundException err){
            System.out.println("File not found:" +err.getMessage());
        }catch (IOException err){
            System.err.println("Error on I/O operation" +err.getMessage());
        }
    }
    public void writeFile(String path, String message){ 
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, false); 
            try (PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(message);
                printWriter.close();
            }
        }catch (FileNotFoundException err){
            System.out.println("File not found:" +err.getMessage());
        }catch (IOException err){
            System.err.println("Error on I/O operation" +err.getMessage());
        } 
    } 
}
