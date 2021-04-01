package problem;

import  java.util.Random;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class Figures {

    public static void renderPoint(GL2 gl, Vector2 pos, float size){
        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(pos.x,pos.y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Vector2 pos1, Vector2 pos2, float width){
        gl.glLineWidth(width);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(pos1.x,pos1.y);
        gl.glVertex2d(pos2.x,pos2.y);
        gl.glEnd();
    }

    public static void renderTriangle(GL2 gl, Vector2 pos1, Vector2 pos2, Vector2 pos3, boolean filled) {
        if (filled) {
            gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3d(1, 0, 0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(1, 1, 0);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(0.3, 0.3, 1);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glEnd();
        } else {
            gl.glLineWidth(10);
            gl.glBegin(GL.GL_LINE_LOOP);
            gl.glColor3d(1, 0, 0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(1, 1, 0);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(0.3, 0.3, 1);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glEnd();
        }
    }

    public static void renderQuad(GL2 gl, Vector2 pos1, Vector2 pos2, Vector2 pos3, Vector2 pos4, boolean filled){
        if(filled) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3d(1,0,0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(1,1,0);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(0.3,0.3,1);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glColor3d(1,0.3,1);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glEnd();
        }
        else {
            gl.glLineWidth(10);

            gl.glBegin(GL.GL_LINE_LOOP);
            gl.glColor3d(1,0,0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(1,1,0);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(0.3,0.3,1);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glColor3d(1,0.3,1);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glEnd();
        }
    }

    public static void renderCircle(GL2 gl, Vector2 pos, double rad, boolean filled) {
        if(!filled){
            gl.glLineWidth(1);
            gl.glBegin(GL.GL_LINE_LOOP);
            double a, b, c;

            Random random = new Random();
            a = (double)random.nextInt(100)/100;

            Random random1 = new Random();
            b = (double)random1.nextInt(100)/100;

            Random random2 = new Random();
            c = (double)random2.nextInt(100)/100;
            //gl.glColor3d(a, b, c);

            for(int i = 0; i < 256; i++){
                gl.glVertex2d(pos.x + Math.sin(Math.PI/512*i)*rad, pos.y - Math.cos(Math.PI/512*i)*rad);

            }
            for(int i = 0; i < 256; i++){
                gl.glVertex2d(pos.x + Math.sin(Math.PI/512*(256 - i))*rad, pos.y + Math.cos(Math.PI/512*(256 - i))*rad);
            }
            for(int i = 0; i < 256; i++){
                gl.glVertex2d(pos.x - Math.sin(Math.PI/512*i)*rad, pos.y + Math.cos(Math.PI/512*i)*rad);
            }

            for(int i = 0; i < 256; i++){
                gl.glVertex2d(pos.x - Math.sin(Math.PI/512*(256 - i))*rad, pos.y - Math.cos(Math.PI/512*(256 - i))*rad);
            }
            gl.glEnd();



        }

        else{
            double theta;
            double step = 1;
            gl.glBegin(GL.GL_TRIANGLE_FAN);
            for(double a=0; a<360; a += step) {
                theta = 2 * Math.PI * a / 180;
                gl.glColor3d((360 - a)/360, 0, a/360);
                gl.glVertex3d(rad * Math.cos(theta), rad * Math.sin(theta), 0);
            }
            gl.glEnd();

        }
    }



}
