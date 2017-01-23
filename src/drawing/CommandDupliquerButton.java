package drawing;

/**
 * Created by Quentin on 03/01/2017.
 */
public class CommandDupliquerButton implements Command {
    private Drawing drawing;
    private Shape shape;
    private Shape cloneShape;

    public CommandDupliquerButton(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        for (Shape shape : drawing) {
            if(shape.isSelected) {
                this.shape = shape;
            }
        }
        cloneShape = this.shape.clone();
       drawing.addShape(cloneShape);
    }

    @Override
    public void unexecute() {
        drawing.removeShape(cloneShape);
    }

}
