package drawing;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Quentin on 22/11/2016.
 */
public class CompositeShape extends Shape {
    private ArrayList<Shape> Lst_Shape = new ArrayList<>();

    public void addShape(Shape shape) {
        Lst_Shape.add(shape);
    }

    public void removeShape(Shape shape) {
        Lst_Shape.remove(shape);
    }

    public int sizeComposite() {
        return Lst_Shape.size();
    }

    public ArrayList<Shape> getShapes() {
        return Lst_Shape;
    }


    @Override
    public void setOrigin(Point p)
    {
        if(this.origin != null) {
            int xD = this.origin.x - p.x;
            int yD = this.origin.y - p.y;

            for(Shape s : Lst_Shape) {
                Point newPos = new Point(s.origin.x - xD, s.origin.y - yD);
                s.setOrigin(newPos);
            }
        }
        this.origin = p;
    }

    @Override
    public void paint(Graphics g) {
        for(Shape s : Lst_Shape) {
            s.paint(g);
        }
    }

    @Override
    public boolean isOn(Point p) {
        for (Shape s : Lst_Shape) {
            if (s.isOn(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Shape clone() {
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.origin = this.origin;
        for(Shape shape : Lst_Shape) {
            compositeShape.addShape(shape.clone());
        }
        return compositeShape;
    }
}
