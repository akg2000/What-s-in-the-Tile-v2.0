package com;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
public class mytest6{
    @Test(timeout = 5000)
    public void testgame(){
        game g = new game("check",100);
//        g.gamestart();
        assertEquals(100,g.getLength_of_track());
    }
}