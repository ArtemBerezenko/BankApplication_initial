package com.luxoft.bankapp.service;

import com.luxoft.bankapp.BankCommander.BankCommander;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static com.sun.activation.registries.LogSupport.log;


/**
 * Created by omsk20 on 11/11/2016.
 */
public class BankFeedService {
    static Map<String, String> map = new HashMap<>();

   public static void loadFeed(String folder){
       File f = null;
       File[] paths;
       try{
           f = new File(folder);
           paths = f.listFiles();
           for(File path : paths)
           {
               loadFeed(path);
               System.out.println(path);
           }
       }catch(Exception e){
           e.printStackTrace();
       }
   }

    public static void loadFeed(File file) {
            try {
                BufferedReader in =
                        new BufferedReader(
                                new FileReader(file));
                String line = "1";
                while( (line = in.readLine()) != null) {
                    log(line);
                    put(line);
                    BankCommander.currentBank.parseFeed(map);
                }
                in.close();
                System.out.println(BankCommander.currentBank);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void put(String line) {
        String[] newLine = line.split(";");
        for(int i = 0; i < newLine.length; ++i) {
            map.put( newLine[i].split("=")[0], newLine[i].split("=")[1]);
    }
    }

}
