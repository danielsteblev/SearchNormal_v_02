package ru.vsu.cs.util.steblev_d_v;
import java.util.*;

import static java.lang.Math.sqrt;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();

    public void recalculatePolygonNormals(){
        normals.clear();
       for(Polygon polygon : polygons){
           Vector3f v1 = vertices.get(polygon.getVertexIndices().get(0));
           Vector3f v2 = vertices.get(polygon.getVertexIndices().get(1));
           Vector3f v3 = vertices.get(polygon.getVertexIndices().get(2));

           Vector3f v4 = v2.sub(v1);
           Vector3f v5 = v3.sub(v1);

           Vector3f normal = v4.crs(v5);
           normals.add(normal.nor());
       }
    }
}