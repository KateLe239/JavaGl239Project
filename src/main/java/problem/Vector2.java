package problem;
class Vector2 {
    public double x;
    public double y;
    public Vector2() {
        x = 1;
        y = 0;
    }

    public Vector2(double x, double y) {
        this.x =x ;
        this.y = y;
    }
    public Vector2(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double len() {
        return Math.sqrt(x*x + y*y);
    }
    public void x(double k) {
        this.x = x * k;
        this.y = y * k;
    }
    public void plus(Vector2 v) {
        this.x = x + v.x;
        this.y = y + v.y;
    }
    public void minus(Vector2 v) {
        this.x = x - v.x;
        this.y = y - v.y;
    }
    public Vector2 sum(Vector2 v) {
        Vector2 l = new Vector2(0,0);
        l.x = x + v.x;
        l.y = y + v.y;
        return l;
    }
    public static Vector2 sum(Vector2 m, Vector2 n) {
        Vector2 l = new Vector2(0,0);
        l.x = m.x + n.x;
        l.y = m.y + n.y;
        return l;
    }
    public Vector2 mult(double k) {
        Vector2 l = new Vector2(0,0);
        l.x = x * k;
        l.y = y * k;
        return l;
    }
    public double mult(Vector2 v) {
        return v.x*x + v.y*y;
    }
    public static double mult(Vector2 m, Vector2 n) {
        return m.x*n.x + m.y*n.y;
    }
    public static Vector2 mult(Vector2 m, double n) {
        Vector2 l = new Vector2(0,0);
        l.x = m.x * n;
        l.y = m.y * n;
        return l;
    }
    public void normalize() {
        double len = Math.sqrt(x*x + y*y);
        this.x = x/len;
        this.y = y/len;
        if (len == 0) {
            this.x = 0;
            this.y = 0;
        }
    }
    public Vector2 norm() {
        Vector2 l = new Vector2(0,0);
        double len = Math.sqrt(x*x + y*y);
        l.x = x/len;
        l.y = y/len;
        if (len == 0) {
            l.x = 0;
            l.y = 0;
        }
        return l;
    }
    public void rotate(double p) {
        double k = x;
        this.x = x*Math.cos(p) - y*Math.sin(p);
        this.y = y*Math.cos(p) + k*Math.sin(p);
    }
    public Vector2 rotated(double p) {
        Vector2 l = new Vector2(x,y);
        l.x = x*Math.cos(p) - y*Math.sin(p);
        l.y = y*Math.cos(p) + x*Math.sin(p);
        return l;
    }

    public Vector2 ort() {
        double x1 = x;
        double y1 = y;
        Vector2 m = new Vector2(x1, y1);
        double len = Math.sqrt(x*x + y*y);
        m.x = -x/len;
        m.y = y/len;
        if ((x == 1)||(y==0)) {
            x = 0;
            y = 1;
        }
        return m;
    }
    public double phi() {
        double len = Math.sqrt(x*x + y*y);
        double k = 0;
        if (y < 0) k = -Math.acos(x/len);
        else k = Math.acos(x/len);
        if ((x < 0) && (y < 0)) k = -Math.acos(-x/len);
        return k;
    }
    public int getQuarte() {
        int k = 0;
        if ((x>0) && (y>0)) k = 1;
        if ((x>0) && (y<0)) k = 4;
        if ((x<0) && (y<0)) k = 3;
        if ((x<0) && (y>0)) k = 2;
        return k;
    }
    public boolean equals(Vector2 l) {
        boolean k = false;
        if ((x==l.x) && (y==l.y)) k = true;
        return k;
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}