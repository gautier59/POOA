package drawing;

import java.awt.*;

/**
 * Created by Quentin on 13/12/2016.
 */
public class CommandRectangleButton extends ShapeButtonListener  {
    private Rectangle r;

    public CommandRectangleButton(Drawing drawing) {
        super(drawing);
    }

    @Override
        protected Shape createShape() {
            double width = Math.abs(destination.getX()-origin.getX());
            double height = Math.abs(destination.getY()-origin.getY());
            r = new Rectangle(origin, (int)width, (int)height, Color.BLUE);
            return r;
        }

    @Override
    public void unexecute() {
        drawing.removeShape(r);
    }
}
