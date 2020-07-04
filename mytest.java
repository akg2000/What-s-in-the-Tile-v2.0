package com;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class mytest{
    @Test(expected = Snake_exception.class)
    public void testgame() throws Snake_exception{
        Snake s = new Snake(10);
        s.get_snake_attack(15);
    }


}