package drawing;

import java.awt.*;

public class Circle extends Shape{
	private Color color;
	
	private double radius;
	
	public Circle(Point origin, double radius, Color color){
		this.origin = origin;
		this.radius = radius;
		this.color = color;
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
		g.setColor(Color.BLACK);
		g.drawOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
	}
	
	public boolean isOn(Point p) {
		return distanceToCenter(p)<radius;		
	}

	@Override
	public Shape clone() {
		Circle cercle = new Circle(this.origin,this.radius,this.color);
		return cercle;
	}

	private double distanceToCenter(Point p){
		return this.origin.distance(p);
	}





}
