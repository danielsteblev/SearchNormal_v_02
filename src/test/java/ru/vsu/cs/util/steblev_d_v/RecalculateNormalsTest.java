package ru.vsu.cs.util.steblev_d_v;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RecalculateNormalsTest {

    @Test
    public void recalculateNormalsTest(){
        boolean resultIsTrue = false;
        Model model = new Model();
        model.vertices.add(new Vector3f(1, -1, -1));
        model.vertices.add(new Vector3f(1, -1, 1));
        model.vertices.add(new Vector3f(-1, -1, 1));


        Vector3f expected = new Vector3f(0, 0, -1);
        Vector3f result = v1.sub(v2);
        if(result.equals(expected)){
            resultIsTrue = true;
        }
        assertTrue(resultIsTrue);
    }
}
