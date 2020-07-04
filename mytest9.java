package com;
import org.junit.Test;
import	org.junit.runner.JUnitCore;
import	org.junit.runner.Result;
import	org.junit.runner.notification.Failure;
import java.io.*;
import org.junit.*;
import java.util.Scanner;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class mytest9{
    @Test(timeout = 5000)
    public void testgame() throws IOException,ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name for checking");
        String check = scan.next();
        ObjectInputStream out = null;
        try{
            out = new ObjectInputStream(new FileInputStream(check));
            game g = (game)out.readObject();
        }
        catch (FileNotFoundException f) {
            fail();
        }
    }
}