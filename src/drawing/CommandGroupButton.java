package drawing;

/**
 * Created by Quentin on 03/01/2017.
 */
public class CommandGroupButton implements Command {
    private Drawing drawing;
    private CompositeShape compositeShape;

    public CommandGroupButton(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        compositeShape = new CompositeShape();
        for (Shape shape : drawing) {
            if (shape.isSelected) {
                compositeShape.addShape(shape);
            }
        }

        for(Shape shape : compositeShape.getShapes()) {
            drawing.removeShape(shape);
        }
        drawing.addShape(compositeShape);
        System.out.println("Groupe crée");
    }

    @Override
    public void unexecute() {
        for(Shape shape : compositeShape.getShapes()) {
            drawing.addShape(shape);
        }
        drawing.removeShape(compositeShape);
    }
}
