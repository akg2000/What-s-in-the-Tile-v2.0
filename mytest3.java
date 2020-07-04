package com;
import org.junit.Test;
public class mytest3{
    @Test(expected = Trampoline_exception.class)
    public void testgame() throws Trampoline_exception{
        Trampoline t = new Trampoline(10);
        t.get_trampoline_attack(10);
    }
}