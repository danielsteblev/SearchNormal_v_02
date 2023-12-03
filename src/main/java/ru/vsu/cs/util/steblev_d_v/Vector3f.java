package ru.vsu.cs.util.steblev_d_v;

// Это заготовка для собственной библиотеки для работы с линейной алгеброй
public class Vector3f {
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Vector3f other) {
        // todo: желательно, чтобы это была глобальная константа
        final float eps = 1e-7f;
        return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps && Math.abs(z - other.z) < eps;
    }

    public Vector3f sub(Vector3f v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        return this;
    }

    public float dot(Vector3f v) { // Скалярное
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public Vector3f crs(Vector3f v) { // Векторное
        float ax = this.x;
        float ay = this.y;
        float az = this.z;
        this.x = ay * v.z - az * v.y;
        this.y = az * v.x - ax * v.z;
        this.z = ax * v.y - ay * v.x;
        return this;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y+ "," +  z + ")";
    }

    public Vector3f nor() {
        if (x == 0.0f && y == 0.0f && z == 0.0f) return this;

        float len = len();
        this.x /= len;
        this.y /= len;
        this.z /= len;
        return this;
    }

    public float len() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3f add(Vector3f v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    public Vector3f div(float scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
        return this;
    }

    float x, y, z;
}
