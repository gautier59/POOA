package drawing;

import java.awt.*;

/**
 * Created by Quentin on 13/12/2016.
 */
public class CommandCircleButton extends ShapeButtonListener {
    private Circle c;

    public CommandCircleButton(Drawing drawing) {
        super(drawing);
    }

    @Override
    protected Shape createShape() {
        double width = Math.abs(destination.getX()-origin.getX());
        double height = Math.abs(destination.getY()-origin.getY());
        double radius = Math.max(width, height)/2;
        double centerX = (destination.getX()+origin.getX())/2;
        double centerY = (destination.getY()+origin.getY())/2;
        Point center = new Point((int)centerX, (int)centerY);
        c = new Circle(center, radius, Color.RED);
        return c;
    }

    @Override
    public void unexecute() {
        drawing.removeShape(c);
    }
}
