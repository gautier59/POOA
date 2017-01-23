package drawing;

import java.awt.*;

/**
 * Created by Quentin on 03/01/2017.
 */
public class CommandDeplacer implements Command {
    private Drawing drawing;
    private Shape currentShape;
    private Point startPoint;
    private Point endPoint;

    public CommandDeplacer(Drawing drawing, Shape shape,Point point) {
        this.drawing = drawing;
        this.currentShape = shape;
        this.startPoint = point;
        this.endPoint = currentShape.origin;
    }

    @Override
    public void execute() {
        currentShape.setOrigin(endPoint);
        drawing.repaint();
    }

    @Override
    public void unexecute() {
        currentShape.setOrigin(startPoint);
        drawing.repaint();
    }
}
