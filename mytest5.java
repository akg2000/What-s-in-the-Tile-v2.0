package com;
import org.junit.Test;
public class mytest5{
    @Test(expected = Game_win_exception.class)
    public void testgame() throws Game_win_exception{
        Game_win_exception g = new Game_win_exception("---------");
        throw new Game_win_exception("opoo");
    }
}