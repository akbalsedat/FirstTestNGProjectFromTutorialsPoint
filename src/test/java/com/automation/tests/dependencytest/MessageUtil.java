package com.automation.tests.dependencytest;

public class MessageUtil {
    private String message;

    public MessageUtil(String message){
        this.message = message;
    }

    //prints the message
    public String printMessage(){
        System.out.println(message);
        return message;
    }

    //add "Hi!" to the message
    public String salutationMessage(){
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}
