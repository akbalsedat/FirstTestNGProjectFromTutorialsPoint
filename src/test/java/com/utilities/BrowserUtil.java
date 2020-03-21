package com.utilities;

public class BrowserUtil {
    public static void wait(int x){
        try {
            Thread.sleep(1000 * x);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
