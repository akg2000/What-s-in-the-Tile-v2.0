package com;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class mytest1{
    @Test(expected = Vulture_exception.class)
    public void testgame() throws Vulture_exception{
        Vulture s = new Vulture(10);
        s.get_vulture_attack(10);
    }


}