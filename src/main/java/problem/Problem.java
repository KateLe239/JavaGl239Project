package problem;

import java.util.Random;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "На плоскости задано множество окружностей. \n" +
            "Найти такую пару пересекающихся окружностей,  \n" +
            "что длина отрезка, проведенного от одной точки  \n" +
            "пересечения этих двух окружностей до другой, максимальна.";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученицы 10-1 Катирины Ле";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;

    private ArrayList<Circle> circles;

    private Circle resultCircle1;
    private Circle resultCircle2;
    private int solve;

    Vector2 posA;
    Vector2 posB;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        circles = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x      координата X точки
     * @param y      координата Y точки
     * @param setVal номер множества
     */
    public void addPoint(double x, double y, int setVal) {
        Point point = new Point(x, y, setVal);
        points.add(point);
    }

    /**
     * Решить задачу
     */

    public void solve() {
        solve = 0;
        resultCircle1 = null;
        resultCircle2 = null;
        Vector2 t1 = new Vector2(0, 0);
        Vector2 t2 = new Vector2(0, 0);
        double rad1 = 0;
        double rad2 = 0;
        double maxLength = -1;

        // перебираем пары кругов
        for (int i = 0; i < circles.size(); i++) {
            for (int j = i + 1; j < circles.size(); j++) {
                Circle c = circles.get(i);
                Circle c2 = circles.get(j);

                if (!Double.isNaN(c.OLength(c2)) && c.OLength(c2) > maxLength && !c.pos.equals(c2.pos)) {
                    System.out.println(c.OLength(c2));
                    System.out.println(c2.OLength(c));
                    resultCircle1 = c;
                    resultCircle2 = c2;
//                    t1 = c.pos;
//                    t2 = c2.pos;
//                    rad1 = c.rad;
//                    rad2 = c2.rad;
                    System.out.println(c.rad);
                    System.out.println(c2.rad);
                    maxLength = c.OLength(c2);

//                    posA = new Vector2(0.0, 0.0);
//                    posB = new Vector2(0.1, 0.3);
                    posA = c.A(c2);
                    posB = c.B(c2);
                }
            }
        }
        if (maxLength == -1) {
            solve = 1;
        } else {
//            resultCircle1 = new Circle(t1, rad1);
//            resultCircle2 = new Circle(t2, rad2);

        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        circles.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double rad = sc.nextDouble();
                Vector2 pos = new Vector2(x, y);

                sc.nextLine();
                Circle circle = new Circle(pos, rad);
                circles.add(circle);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Circle circle : circles) {
                out.printf("%.2f %.2f %.2f\n", circle.pos.x, circle.pos.y, circle.rad);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Circle p = Circle.getRandomCircle();
            circles.add(p);
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        circles.clear();
        resultCircle1 = null;
        resultCircle2 = null;
        posA = null;
        posB = null;
        solve = 0;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        gl.glColor3d(1, 0, 0);
        for (Circle circle : circles)
            circle.render(gl);
        gl.glColor3d(0, 1, 0);
        if (resultCircle1 != null) {
            resultCircle1.render(gl);
            resultCircle2.render(gl);
        }
        if (posA != null) {
            Figures.renderLine(gl, posA, posB, 3);
        }
        if (solve == 1) {
            Figures.renderPoint(gl, new Vector2(0, 0), 10);
        }
    }
}
