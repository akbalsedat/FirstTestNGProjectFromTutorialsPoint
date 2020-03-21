package com.automation.tests.tutorialspoint;
/* This class prints out given message*/
public class MessageUtil {
    private String message;
    //Constructor
    //@param message to be printed
    public MessageUtil(String message)
    {
        this.message = message;
    }
    //prints the message
    public String printMessage(){
        System.out.println(message);
        return message;
    }

    // add "Hi!" to the message
    public String salutationMessage()
    {
        message = "tutorialspoint" + message;
        System.out.println(message);
        return message;
    }

    // add "www.tutorialspoint" to the message
    public String exitMessage(){
            message = "www." + message;
        System.out.println(message);
        return message;
    }
}
