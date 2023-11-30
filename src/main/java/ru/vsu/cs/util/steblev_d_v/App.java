package ru.vsu.cs.util.steblev_d_v;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("C:\\JavaUniversity\\SearchNormal\\test.obj");
        String fileContent = Files.readString(fileName);

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);
        model.recalculatePolygonNormals();

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());

        System.out.println(model.normals);
    }
}


