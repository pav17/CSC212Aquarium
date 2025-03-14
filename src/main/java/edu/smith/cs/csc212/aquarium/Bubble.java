package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

public class Bubble {
	
	public int x;
	public int y;
	int wiggle;
	float size;
	
	//all bubbles use the same instance of random
	static Random r = new Random();
	
	public Bubble(int startX, int startY) {
		this.x = startX;
		this.y = startY;
		this.wiggle = 0;
		this.size = r.nextFloat() * 100.0f;
	}
	
	//draw the bubble as an O character with a random size.
	public void draw(Graphics2D g) {
		Font f = g.getFont();
		g.setFont(f.deriveFont(this.size));
		g.setColor(Color.white);
		g.drawString("o", this.x + this.wiggle, this.y);
		
		animate();
	}
	
	//wiggle the bubble
	public void animate() {
		this.y -= 2;
		this.wiggle =  (int)(30 * Math.sin(this.y / 60.0));
	}
}
