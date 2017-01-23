package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Quentin on 13/12/2016.
 */
public class Invoker implements ActionListener {
    Drawing drawing;
    private ArrayList<Command> Lst_Commande;
    private ArrayList<Command> Lst_RedoCommand;

    public Invoker(Drawing drawing) {
        this.drawing = drawing;
        Lst_Commande = new ArrayList<>();
        Lst_RedoCommand = new ArrayList<>();
    }

    public void doAction(Command c) {
        Lst_Commande.add(c);
        c.execute();
    }


    public void executeCommand(String command) {
        switch (command) {
            case "Circle":
                doAction(new CommandCircleButton(drawing));
                break;
            case "Rectangle":
                doAction(new CommandRectangleButton(drawing));
                break;
            case "Grouper":
                doAction(new CommandGroupButton(drawing));
                break;
            case "Degrouper":
                doAction(new CommandDegroupButton(drawing));
                break;
            case "Dupliquer":
                doAction(new CommandDupliquerButton(drawing));
                break;
            case "Undo":
                if (Lst_Commande.size() > 0) {
                    Lst_RedoCommand.add(Lst_Commande.get(Lst_Commande.size() - 1));
                    Lst_Commande.get(Lst_Commande.size() - 1).unexecute();
                    Lst_Commande.remove(Lst_Commande.size() - 1);
                }
                break;
            case "Redo":
                if (Lst_RedoCommand.size() > 0) {
                    Lst_RedoCommand.get(Lst_RedoCommand.size() - 1).execute();
                    Lst_Commande.add(Lst_RedoCommand.get(Lst_RedoCommand.size() - 1));
                    Lst_RedoCommand.remove(Lst_RedoCommand.size() - 1);
                }
                break;
            case "Text":
                doAction(new CommandTextButton(drawing));
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Command : " + e.getActionCommand());
        executeCommand(e.getActionCommand());
    }
}
