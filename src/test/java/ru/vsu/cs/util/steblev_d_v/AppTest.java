package ru.vsu.cs.util.steblev_d_v;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void vectorDifferenceTest(){
        boolean resultIsTrue = false;
        Vector3f v1 = new Vector3f(20, 15, 12);
        Vector3f v2 = new Vector3f(10, 5, 2);
        Vector3f expected = new Vector3f(10, 10, 10);
        Vector3f result = v1.sub(v2);
        if(result.equals(expected)){
            resultIsTrue = true;
        }
        assertTrue(resultIsTrue);
    }
}
