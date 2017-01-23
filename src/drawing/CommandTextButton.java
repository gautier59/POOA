package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Quentin on 23/01/2017.
 */
public class CommandTextButton implements Command {
    private Drawing drawing;
    private JFrame frame;
    private Shape currentShape;
    private String currentName;
    private DecorateurShape decorateurShape;

    public CommandTextButton(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        for(Shape shape : drawing) {
            if(shape.isSelected) {
                currentShape = shape;
                decorateurShape = new DecorateurShape(currentShape);
                showFrameText();
            }
        }
    }

    @Override
    public void unexecute() {
        drawing.removeShape(decorateurShape);
        drawing.addShape(currentShape);
        drawing.repaint();
    }

    private void showFrameText() {
        frame = new JFrame();
        frame.setTitle("Insert text");
        frame.setSize(160, 80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton textButton = new JButton("Text");
        JButton cancelButton = new JButton("Cancel");
        JTextField textField = new JTextField();

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(textButton);
        buttonPanel.add(cancelButton);

        textButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentName = decorateurShape.getText();
                decorateurShape.setText(textField.getText());
                drawing.removeShape(currentShape);
                drawing.addShape(decorateurShape);
                drawing.repaint();
                frame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textField, BorderLayout.CENTER);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(textPanel, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
