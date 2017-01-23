package drawing;

/**
 * Created by Quentin on 03/01/2017.
 */
public class CommandDegroupButton implements Command {
    private Drawing drawing;
    private CompositeShape compositeShape;

    public CommandDegroupButton(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        for (Shape shape : drawing) {
            if(shape.isSelected && shape instanceof CompositeShape) {
                compositeShape = (CompositeShape) shape;;
            }
        }
        for(Shape shape2 : compositeShape.getShapes()) {
            drawing.addShape(shape2);
        }
        drawing.removeShape(compositeShape);
        System.out.println("Degroup");
    }

    @Override
    public void unexecute() {
        for(Shape shape : compositeShape.getShapes()) {
            drawing.removeShape(shape);
        }
        drawing.addShape(compositeShape);
    }
}
