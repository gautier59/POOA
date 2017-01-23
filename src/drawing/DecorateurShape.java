package drawing;

import java.awt.*;

/**
 * Created by Quentin on 23/01/2017.
 */
public class DecorateurShape extends Shape {
    private String label = "";
    private Shape shape;

    public DecorateurShape(Shape shape) {
        this.shape = shape;
        this.origin = shape.getPoint();
    }

    public void setText(String myLabel) {
        this.label = myLabel;
    }


    public String getText() {
        return label;
    }


    @Override
    public void paint(Graphics g) {
        if (label != null) {
            shape.paint(g);
            g.drawString(label, shape.getPoint().x, shape.getPoint().y);
        }
    }

    @Override
    public void setOrigin(Point p) {
        origin = p;
        shape.setOrigin(p);
    }

    @Override
    public boolean isOn(Point p) {
        return shape.isOn(p);
    }

    @Override
    public Shape clone() {
        return shape.clone();
    }
}
