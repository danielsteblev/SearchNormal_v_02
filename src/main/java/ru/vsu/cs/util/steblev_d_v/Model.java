package ru.vsu.cs.util.steblev_d_v;

import java.util.*;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();

    public void recalculateNormals() {
        normals.clear();
        for (Polygon polygon : polygons) {
            Vector3f v1 = vertices.get(polygon.getVertexIndices().get(0));
            Vector3f v2 = vertices.get(polygon.getVertexIndices().get(1));
            Vector3f v3 = vertices.get(polygon.getVertexIndices().get(2));

            Vector3f v4 = v2.sub(v1);
            Vector3f v5 = v3.sub(v1);

            Vector3f normal = v4.crs(v5);
            normals.add(normal.nor());
        }
        ArrayList<Vector3f> normalsForVertices = new ArrayList<Vector3f>();
        for (int i = 0; i < vertices.size(); i++) {
            List<Vector3f> normalsVeric = new ArrayList<>();
            for (int j = 0; j < polygons.size(); j++) {
                for (int k = 0; k < polygons.get(j).getVertexIndices().size(); k++) {
                    if (vertices.get(i).equals(vertices.get(polygons.get(j).getVertexIndices().get(k)))) {
                        normalsVeric.add(normals.get(j));
                    }
                }
            }
            Vector3f normalForVert = getNormalForVert(normalsVeric);
            normalsForVertices.add(normalForVert);
        }
        normals.clear();
        normals.addAll(normalsForVertices);
    }

    public Vector3f getNormalForVert(List<Vector3f> norlamsVeric) {
        Vector3f normal = new Vector3f(0, 0, 0);
        for (int i = 0; i < norlamsVeric.size(); i++) {
            normal.add(norlamsVeric.get(i));
        }
        normal.div(norlamsVeric.size());
        return normal;
    }


}