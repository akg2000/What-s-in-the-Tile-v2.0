package com;
import org.junit.Test;
public class mytest2{
    @Test(expected = Cricket_exception.class)
    public void testgame() throws Cricket_exception{
        Cricket c = new Cricket(10);
        c.get_cricket_attack(10);
    }
}