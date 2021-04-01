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
            return -1;
        }
        else if (pos.distanceTo(w.pos) == rad + w.rad) {
            return 0;
        }
        else{
            double a = 2*(w.pos.x - pos.x);
            double b = 2*(w.pos.y - pos.y);
            double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
            double x0 = -a*c/(a*a+b*b),  y0 = -b*c/(a*a+b*b);
            double d = rad*rad - c*c/(a*a+b*b);
            double mult = Math.sqrt(d / (a*a+b*b));
            double ax,ay,bx,by;
            ax = x0 + b * mult;
            bx = x0 - b * mult;
            ay = y0 - a * mult;
            by = y0 + a * mult;
            return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
        }
    }

    public Vector2 A(Circle w) {
            double a = 2*(w.pos.x - pos.x);
            double b = 2*(w.pos.y - pos.y);
            double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
            double x0 = -a*c/(a*a+b*b),  y0 = -b*c/(a*a+b*b);
            double d = rad*rad - c*c/(a*a+b*b);
            double mult = Math.sqrt(d / (a*a+b*b));
            double ax,ay,bx,by;
            ax = x0 + b * mult;
            bx = x0 - b * mult;
            ay = y0 - a * mult;
            by = y0 + a * mult;
            Vector2 lol = new Vector2(ax, ay);
            return lol;
    }

    public Vector2 B(Circle w) {
        double a = 2*(w.pos.x - pos.x);
        double b = 2*(w.pos.y - pos.y);
        double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
        double x0 = -a*c/(a*a+b*b),  y0 = -b*c/(a*a+b*b);
        double d = rad*rad - c*c/(a*a+b*b);
        double mult = Math.sqrt(d / (a*a+b*b));
        double ax,ay,bx,by;
        ax = x0 + b * mult;
        bx = x0 - b * mult;
        ay = y0 - a * mult;
        by = y0 + a * mult;
        Vector2 lol = new Vector2(bx, by);
        return lol;
    }
}
