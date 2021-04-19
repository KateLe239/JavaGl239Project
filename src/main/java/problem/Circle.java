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
        double x = random.nextDouble() * 1.8 - 0.9;
        double y = random.nextDouble() * 1.8 - 0.9;
        return new Circle(new Vector2(x, y), rad);
    }

//     public double OLength(Circle w) {
//         if (pos.distanceTo(w.pos) > rad + w.rad || pos.distanceTo(w.pos) + w.rad < rad || pos.distanceTo(w.pos) + rad < w.rad) {
//             return -1;
//         }
//         else if (pos.distanceTo(w.pos) == rad + w.rad || pos.distanceTo(w.pos) == rad - w.rad || pos.distanceTo(w.pos) == w.rad - rad) {
//             return 0;
//         }
//         else{
//             double a = 2*(w.pos.x - pos.x);
//             double b = 2*(w.pos.y - pos.y);
//             double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
//             double a0 = 1 + a*a/b/b,  b0 = -2*pos.x + 2*a*c/b/b + 2*pos.y*a/b, c0 = pos.x*pos.x + c*c/b/b + 2*pos.y*a/b + pos.y*pos.y - rad*rad;
//             double ax,ay,bx,by;
//             ax = -b0/a0/2 + Math.sqrt(b0*b0 - 4*a0*c0)/2/a0;
//             bx = -b0/a0/2 - Math.sqrt(b0*b0 - 4*a0*c0)/2/a0;
//             ay = -(a*ax + c)/b;
//             by = -(a*bx + c)/b;
//             return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));



//         }
//     }

//     public Vector2 A(Circle w) {
//         double a = 2*(w.pos.x - pos.x);
//         double b = 2*(w.pos.y - pos.y);
//         double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
//         double a0 = 1 + a*a/b/b,  b0 = -2*pos.x + 2*a*c/b/b + 2*pos.y*a/b, c0 = pos.x*pos.x + c*c/b/b + 2*pos.y*a/b;
//         double ax,ay,bx,by;
//         ax = -b0/a0/2 + Math.sqrt(b0*b0 - 4*a0*c0)/2/a0;
//         bx = -b0/a0/2 - Math.sqrt(b0*b0 - 4*a0*c0)/2/a0;
//         ay = -(a*ax + c)/b;
//         by = -(a*bx + c)/b;
//             Vector2 lol = new Vector2(ax, ay);
//             return lol;
//     }

//     public Vector2 B(Circle w) {
//         double a = 2*(w.pos.x - pos.x);
//         double b = 2*(w.pos.y - pos.y);
//         double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
//         double a0 = 1 + a*a/b/b,  b0 = -2*pos.x + 2*a*c/b/b + 2*pos.y*a/b, c0 = pos.x*pos.x + c*c/b/b + 2*pos.y*a/b;
//         double ax,ay,bx,by;
//         ax = -b0/a0/2 + Math.sqrt(b0*b0 - 4*a0*c0)/2/a0;
//         bx = -b0/a0/2 - Math.sqrt(b0*b0 - 4*a0*c0)/2/a0;
//         ay = -(a*ax + c)/b;
//         by = -(a*bx + c)/b;
//         Vector2 lol = new Vector2(bx, by);
//         return lol;
//     }
    
    
    
    
    
        public double OLength(Circle w) {
        if (pos.distanceTo(w.pos) > rad + w.rad || pos.distanceTo(w.pos) + w.rad < rad || pos.distanceTo(w.pos) + rad < w.rad) {
            return -1;
        }
        else if (pos.distanceTo(w.pos) == rad + w.rad || pos.distanceTo(w.pos) == rad - w.rad || pos.distanceTo(w.pos) == w.rad - rad) {
            return 0;
        }
        else{
            double a = 2*(w.pos.x - pos.x);
            double b = 2*(w.pos.y - pos.y);
            double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
            double rast = Math.abs(a*pos.x + b*pos.y + c)/Math.sqrt(a*a + b*b);
            return Math.sqrt(rad*rad - rast*rast)*2;
        }
    }

    public Vector2 A(Circle w) {
            double a = 2*(w.pos.x - pos.x);
            double b = 2*(w.pos.y - pos.y);
            double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
            double rast1 = Math.abs(a*pos.x + b*pos.y + c)/Math.sqrt(a*a + b*b);
            double dist = Math.sqrt(rad*rad - rast1*rast1);
            return dist*2;
            double rast2 = Math.abs(a*w.pos.x + b*w.pos.y + c)/Math.sqrt(a*a + b*b);
            double cy = pos.y + (w.pos.y - pos.y)*rast1/(rast1 + rast2);
            double cx = pos.x + (w.pos.x - pos.x)*rast1/(rast1 + rast2);
            double ax = cx + dist*a/Math.sqrt(a*a + b*b);
            double ay = cy + dist*b/Math.sqrt(a*a + b*b);
            Vector2 lol = new Vector2(ax, ay);
            return lol;
        
    }

    public Vector2 B(Circle w) {
            double a = 2*(w.pos.x - pos.x);
            double b = 2*(w.pos.y - pos.y);
            double c = w.rad*w.rad - rad*rad + pos.x * pos.x - w.pos.x * w.pos.x + pos.y * pos.y - w.pos.y * w.pos.y;
            double rast1 = Math.abs(a*pos.x + b*pos.y + c)/Math.sqrt(a*a + b*b);
            double dist = Math.sqrt(rad*rad - rast1*rast1);
            return dist*2;
            double rast2 = Math.abs(a*w.pos.x + b*w.pos.y + c)/Math.sqrt(a*a + b*b);
            double cy = pos.y + (w.pos.y - pos.y)*rast1/(rast1 + rast2);
            double cx = pos.x + (w.pos.x - pos.x)*rast1/(rast1 + rast2);
            double ax = cx - dist*a/Math.sqrt(a*a + b*b);
            double ay = cy - dist*b/Math.sqrt(a*a + b*b);
            Vector2 lol = new Vector2(ax, ay);
            return lol;
    }
    
}
