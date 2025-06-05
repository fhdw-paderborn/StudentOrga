package _demo;

import javax.swing.*;

import _demo.point.Point;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SwingDemoShapes {

    private static final int SHAPE_SIZE = 60;
    private static List<Shape> shapes = new ArrayList<>();
    private static Shape selectedShape = null;
    private static Point offset = new Point();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shapes Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Control Panel mit Buttons
        JPanel controlPanel = new JPanel();
        JButton circleButton = new JButton("Kreis");
        JButton rectangleButton = new JButton("Rechteck");
        JButton squareButton = new JButton("Quadrat");
        
        controlPanel.add(circleButton);
        controlPanel.add(rectangleButton);
        controlPanel.add(squareButton);

        // Canvas zum Zeichnen der Shapes
        DrawingCanvas canvas = new DrawingCanvas();
        canvas.setBackground(Color.WHITE);

        // Event-Handler für Buttons
        circleButton.addActionListener(e -> {
            shapes.add(new Circle(50, 50));
            canvas.repaint();
        });
        
        rectangleButton.addActionListener(e -> {
            shapes.add(new Rectangle(50, 50));
            canvas.repaint();
        });
        
        squareButton.addActionListener(e -> {
            shapes.add(new Square(50, 50));
            canvas.repaint();
        });

        // Layout
        frame.setLayout(new BorderLayout());
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(canvas, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Canvas zum Zeichnen
    static class DrawingCanvas extends JPanel {
        public DrawingCanvas() {
            // Mouse-Listener für Drag & Drop
            MouseAdapter adapter = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // Überprüfen, ob ein Shape angeklickt wurde
                    for (int i = shapes.size() - 1; i >= 0; i--) {
                        Shape shape = shapes.get(i);
                        if (shape.contains(e.getPoint())) {
                            selectedShape = shape;
                            offset.x = e.getX() - shape.x;
                            offset.y = e.getY() - shape.y;
                            break;
                        }
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (selectedShape != null) {
                        selectedShape.x = e.getX() - offset.x;
                        selectedShape.y = e.getY() - offset.y;
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    selectedShape = null;
                }
            };

            addMouseListener(adapter);
            addMouseMotionListener(adapter);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            // Anti-Aliasing für glattere Formen
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                 RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Alle Shapes zeichnen
            for (Shape shape : shapes) {
                shape.draw(g2d);
            }
        }
    }

    // Abstrakte Basisklasse für alle Shapes
    static abstract class Shape {
        int x, y;
        Color color;

        public Shape(int x, int y) {
            this.x = x;
            this.y = y;
            // Zufällige Farbe
            this.color = new Color(
                (int)(Math.random() * 200) + 55,
                (int)(Math.random() * 200) + 55,
                (int)(Math.random() * 200) + 55
            );
        }

        public abstract void draw(Graphics2D g);
        public abstract boolean contains(Point p);
    }

    // Konkrete Shape-Klassen
    static class Circle extends Shape {
        public Circle(int x, int y) {
            super(x, y);
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(color);
            g.fillOval(x, y, SHAPE_SIZE, SHAPE_SIZE);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, SHAPE_SIZE, SHAPE_SIZE);
        }

        @Override
        public boolean contains(Point p) {
            int centerX = x + SHAPE_SIZE / 2;
            int centerY = y + SHAPE_SIZE / 2;
            double distance = Math.sqrt(
                Math.pow(p.x - centerX, 2) + 
                Math.pow(p.y - centerY, 2)
            );
            return distance <= SHAPE_SIZE / 2;
        }
    }

    static class Rectangle extends Shape {
        public Rectangle(int x, int y) {
            super(x, y);
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(color);
            g.fillRect(x, y, SHAPE_SIZE + 30, SHAPE_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, SHAPE_SIZE + 30, SHAPE_SIZE);
        }

        @Override
        public boolean contains(Point p) {
            return p.x >= x && p.x <= x + SHAPE_SIZE + 30 &&
                   p.y >= y && p.y <= y + SHAPE_SIZE;
        }
    }

    static class Square extends Shape {
        public Square(int x, int y) {
            super(x, y);
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(color);
            g.fillRect(x, y, SHAPE_SIZE, SHAPE_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, SHAPE_SIZE, SHAPE_SIZE);
        }

        @Override
        public boolean contains(Point p) {
            return p.x >= x && p.x <= x + SHAPE_SIZE &&
                   p.y >= y && p.y <= y + SHAPE_SIZE;
        }
    }
}