package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Circle {
    Vector2 pos;
    double rad;

    public Circle(Vector2 pos, double rad) {
        this.pos = pos;
        this.rad = rad;
    }

    public void render(GL2 gl) {
        Figures.renderCircle(gl, pos, rad, false);
    }

    public static Circle getRandomCircle() {
        Random random = new Random();
        double rad = random.nextDouble() * 0.3;
        double x = random.nextDouble() * 2 - 1;
        double y = random.nextDouble() * 2 - 1;
        return new Circle(new Vector2(x, y), rad);
    }

    public double OLength(Circle w) {
        if (pos.distanceTo(w.pos) > rad + w.rad) {
            return 0;
        }
        else if (pos.distanceTo(w.pos) == rad + w.rad) {
            return 1;
        }
        else{

        }
    }
}
