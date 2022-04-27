package stinkymonkey.NeuralNetwork;

import java.awt.Color;

public class MColor {
	private int red, green, blue, alpha;
	
	public MColor(int red, int green, int blue, int alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
	
	public MColor(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		alpha = 255;
	}
	
	public MColor(Color color) {
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		alpha = color.getAlpha();
	}
	
	public void toBlackWhite() {
		int con = (red + green + blue) / 3;
		
		red = con;
		green = con;
		blue = con;
	}
	
	public int getRed() {
		return red;
	}
	
	public void setRed(int r) {
		red = r;
	}
	
	public int getGreen() {
		return green;
	}
	
	public void setGreen(int g) {
		green = g;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public void setBlue(int b) {
		blue = b;
	}
	
	public int getAlpha() {
		return alpha;
	}
	
	public void setAlpha(int a) {
		alpha = a;
	}
	
	public Color getColor() {
		return new Color(red, green, blue, alpha);
	}
	
	public void setColor(Color color) {
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		alpha = color.getAlpha();
	}
}