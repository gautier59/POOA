package drawing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Listener pour g�rer la souris dans la zone de dessin
 */
public class DrawingMouseListener implements MouseMotionListener, MouseListener {

	Drawing drawing;
	Shape currentShape = null;
    Point dernierPoint;
	Invoker invoker;
    CommandDeplacer deplacer;
    Point startPoint;
	
	public DrawingMouseListener(Drawing d,Invoker inv){
		this.invoker = inv;
		drawing = d;
	}
	
	/**
	 * Bouge la forme s�lectionn�e (si une forme est s�lectionn�e)
	 */
	public void mouseDragged(MouseEvent e) {
        if(currentShape != null){
			currentShape.setOrigin(e.getPoint());
			drawing.repaint();
		}
	}
	
	/**
	 * S�lectionne la forme sur laquelle l'utilisateur a cliqu�
	 */
	public void mousePressed(MouseEvent e) {
        dernierPoint = e.getPoint();
		for(Shape s : drawing){
			if(s.isOn(e.getPoint())){
				currentShape = s;
                startPoint = currentShape.origin;
                currentShape.isSelected = true;
                System.out.println("Forme selectionné.");
                break;
			}
		}
	}

	/**
	 * D�s�lectionne la forme
	 */
	public void mouseReleased(MouseEvent e) {
        if(currentShape != null) {
            deplacer = new CommandDeplacer(drawing,currentShape,startPoint);
            invoker.doAction(deplacer);
        }
        currentShape = null;
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
