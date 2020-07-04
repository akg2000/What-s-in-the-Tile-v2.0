package com;
import org.junit.Test;
public class mytest4{
    @Test(expected = White_exception.class)
    public void testgame() throws White_exception{
        White w = new White(10);
        w.get_white_attack(10);
    }
}