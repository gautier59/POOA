package drawing;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint implements Observable {

    private JFrame frame;
    private JButton clearButton;
    private JButton circleButton;
    private JButton rectangleButton;
    private JButton groupButton;
    private JButton degroupButton;
    private JButton dupliquerButton;
    private JButton undoButton;
    private JButton redoButton;
    private JButton textButton;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private Drawing drawing;
    private JPanel statusPanel;
    private JLabel statusLabel;
    static ElementCounter counter = new ElementCounter();

    public static void main(String[] args) {
        Paint app = new Paint();
        app.run();
    }

    public void run() {
        frame = new JFrame("Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel(new BorderLayout());

        drawing = new Drawing(this);
        drawing.setBackground(Color.WHITE);
        clearButton = new JButton("Clear");
        circleButton = new JButton("Circle");
        rectangleButton = new JButton("Rectangle");
        groupButton = new JButton("Grouper");
        degroupButton = new JButton("Degrouper");
        dupliquerButton = new JButton("Dupliquer");
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");
        textButton = new JButton("Text");

        statusPanel = new JPanel();
        statusLabel = new JLabel("Elements : 0");
        counter.addObserver(this);

        buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(circleButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(groupButton);
        buttonPanel.add(degroupButton);
        buttonPanel.add(dupliquerButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);
        buttonPanel.add(textButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(drawing, BorderLayout.CENTER);

        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);


        //listeners pour les boutons
        Invoker inv = new Invoker(drawing);
        clearButton.addActionListener(new ClearButtonListener(drawing));
        circleButton.addActionListener(inv);
        rectangleButton.addActionListener(inv);
        groupButton.addActionListener(inv);
        degroupButton.addActionListener(inv);
        dupliquerButton.addActionListener(inv);
        undoButton.addActionListener(inv);
        redoButton.addActionListener(inv);
        textButton.addActionListener(inv);

        //listeners pour la zone de dessin
        DrawingMouseListener l = new DrawingMouseListener(drawing,inv);
        drawing.addMouseListener(l);
        drawing.addMouseMotionListener(l);

        frame.getContentPane().add(mainPanel);
        frame.setSize(740, 500);
        frame.setVisible(true);
    }

    @Override
    public void update(int value) {
        statusLabel.setText("Elements draw " + value);
    }

     static ElementCounter getCompteur() {
        return  counter;
    }


}
