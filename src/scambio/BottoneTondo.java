package scambio;

import javax.swing.JFrame;



public class BottoneTondo extends javax.swing.JButton {
java.awt.Shape shape = null;
private boolean fieldFocusable = false;
/**
* BottoneTondo constructor comment.
*/
public BottoneTondo() {
super();
ridimensiona();
}
/**
* BottoneTondo constructor comment.
* @param text java.lang.String
*/
public BottoneTondo(String text) {
super(text);
ridimensiona();
}
/**
* BottoneTondo constructor comment.
* @param text java.lang.String
* @param icon javax.swing.Icon
*/
public BottoneTondo(String text, javax.swing.Icon icon) {
super(text, icon);
ridimensiona();
}
/**
* BottoneTondo constructor comment.
* @param icon javax.swing.Icon
*/
public BottoneTondo(javax.swing.Icon icon) {
super(icon);
ridimensiona();
}
/**
* Insert the method's description here.
* Creation date: (24/02/01 15.06.14)
* @return boolean
* @param x int
* @param y int
*/
public boolean contains(int x, int y) {
if (shape == null || !shape.getBounds().equals(getBounds())){
shape = new java.awt.geom.Ellipse2D.Float(0,0,getWidth(),getHeight());
}
return shape.contains(x,y);
}
/**
* Gets the focusable property (boolean) value.
* @return The focusable property value.
* @see #setFocusable
*/
public boolean getFocusable() {
return fieldFocusable;
}
/**
* Insert the method's description here.
* Creation date: (31/07/2003 12.50.23)
* @return boolean
*/
public boolean isFocusTraversable() {
return getFocusable();
}
/**
* Insert the method's description here.
* Creation date: (24/02/01 12.43.53)
* @param g java.awt.Graphics
*/
public void paintComponent(java.awt.Graphics g) {
java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
java.awt.Color c1 = new java.awt.Color(100,100,100);
java.awt.Color c2 = java.awt.Color.white;
java.awt.Color b1 = getBackground();
int red = b1.getRed();
int gre = b1.getGreen();
int blu = b1.getBlue();
java.awt.Color newC = new java.awt.Color(red-30,gre-30,blu-30);
if (getModel().isPressed()){
java.awt.Color ap = c2;
c2 = c1;
c1 = ap;
b1 = newC;
}
java.awt.GradientPaint gr = new java.awt.GradientPaint(0+10,0+10,c2,getSize().width-10,getSize().height-10,c1);
g2.setPaint(gr);
g2.fillOval(0,0,getSize().width-1,getSize().height-1);
g2.setColor(b1);
g2.fillOval(0+4,0+4,getSize().width-8,getSize().height-8);

super.paintComponent(g);


}
/**
* Insert the method's description here.
* Creation date: (24/02/01 12.58.57)
*/
private void ridimensiona() {
java.awt.Dimension d = getPreferredSize();
d.width = d.height = Math.max(d.width,d.height);
setPreferredSize(d);
setContentAreaFilled(false);
setBorderPainted(false);

}
/**
* Sets the focusable property (boolean) value.
* @param focusable The new value for the property.
* @see #getFocusable
*/
public void setFocusable(boolean focusable) {
fieldFocusable = focusable;
}

public static void main(String args[]){
	JFrame frame = new JFrame();
	frame.getContentPane().add(new BottoneTondo("TONDO"));
	frame.setVisible(true);
}
} 