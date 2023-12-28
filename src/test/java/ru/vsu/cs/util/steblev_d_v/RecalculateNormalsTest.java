package ru.vsu.cs.util.steblev_d_v;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RecalculateNormalsTest {

    private static Model constructBrickModel() {
        Model model = new Model();

        model.vertices = new ArrayList<>(List.of(new Vector3f[]{
                new Vector3f(0, 0, 0),
                new Vector3f(0, 2, 0),
                new Vector3f(1, 2, 0),
                new Vector3f(1, 0, 0),
                new Vector3f(0, 0, 1),
                new Vector3f(0, 2, 1),
                new Vector3f(1, 2, 1),
                new Vector3f(1, 0, 1)
        }));

        model.polygons = new ArrayList<>(List.of(
                new Polygon(), new Polygon(), new Polygon(),
                new Polygon(), new Polygon(), new Polygon()
        ));

        model.polygons.get(0).setVertexIndices(new ArrayList<>(List.of(new Integer[]{0, 1, 2, 3})));
        model.polygons.get(1).setVertexIndices(new ArrayList<>(List.of(new Integer[]{0, 4, 5, 1})));
        model.polygons.get(2).setVertexIndices(new ArrayList<>(List.of(new Integer[]{3, 7, 4, 0})));
        model.polygons.get(3).setVertexIndices(new ArrayList<>(List.of(new Integer[]{2, 6, 5, 1})));
        model.polygons.get(4).setVertexIndices(new ArrayList<>(List.of(new Integer[]{3, 7, 6, 2})));
        model.polygons.get(5).setVertexIndices(new ArrayList<>(List.of(new Integer[]{7, 4, 5, 6})));


        return model;
    }

    private static Model constructPyramidModel() {
        Model model = new Model();

        model.vertices = new ArrayList<>(List.of(new Vector3f[]{
                new Vector3f(0, 0, 0),
                new Vector3f(2, 0, 0),
                new Vector3f(1, 2, 0),
                new Vector3f(1, 1, 1)
        }));

        model.polygons = new ArrayList<>(List.of(
                new Polygon(), new Polygon(),
                new Polygon(), new Polygon()
        ));

        model.polygons.get(0).setVertexIndices(new ArrayList<>(List.of(new Integer[]{1, 0, 2})));
        model.polygons.get(1).setVertexIndices(new ArrayList<>(List.of(new Integer[]{0, 3, 1})));
        model.polygons.get(2).setVertexIndices(new ArrayList<>(List.of(new Integer[]{2, 3, 0})));
        model.polygons.get(3).setVertexIndices(new ArrayList<>(List.of(new Integer[]{1, 3, 2})));

        return model;
    }

    @Test
    public void normalToVertex1() {
        Model model = constructBrickModel();
        model.recalculateNormals();
        Vector3f result = model.normals.get(7);
        Vector3f expected = new Vector3f((float) -1 / 3, (float) -1 / 3, (float) -1 / 3).nor();
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void normalToVertex2() {
        Model model = constructPyramidModel();
        model.recalculateNormals();
        Vector3f result = model.normals.get(3);
        Vector3f expected = new Vector3f(
                0,
                (float) (1 / Math.sqrt(2)) - (float) (2 / Math.sqrt(6)),
                (float) -(1 / Math.sqrt(2)) - (float) (2 / Math.sqrt(6))
        ).div(3).nor();

        Assert.assertTrue(expected.equals(result));
    }


}
