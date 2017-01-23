package drawing;

/**
 * Created by Quentin on 13/12/2016.
 */
public interface Command {
    void execute();
    void unexecute();
}
