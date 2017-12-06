package com.github.ben870217;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TexTest {
    @Test
    public void aa() throws Exception {
        Tex s=new Tex();
        int c=s.aa(5);
        Assert.assertEquals(1,c);
    }

}
