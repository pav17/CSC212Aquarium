package edu.smith.cs.csc212.aquarium;

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class BubbleSystem {
	
	Bubble[] bubbleArray;
	int currentBubble;
	Random r = new Random();
	
	public BubbleSystem() {
		bubbleArray = new Bubble[10];
		this.currentBubble = 0;
		bubbleGen();
	}
	
	//create the array of ten randomly sized bubbles
	void bubbleGen() {
		for (int i = 0; i < 10; i++) {
			this.bubbleArray[i] = new Bubble(250, 380);
		}
	}
	
	//spawn a random bubble from the array if the current bubble has gone off screen by enough
	void bubbleSpawn() {
		if (this.bubbleArray[this.currentBubble].y < -300) {
			this.currentBubble = r.nextInt(10);
			this.bubbleArray[this.currentBubble].y = 380;
		}
	}
	
	//draw the current bubble
	void bubbleDraw(Graphics2D g) {
		this.bubbleArray[this.currentBubble].draw(g);
	}
	
	void drawChest(Graphics2D g) {
		g.setColor(Color.gray);
		Shape mainRect = new Rectangle2D.Double(150, 400, 200, 100);
		g.fill(mainRect);
		g.setColor(Color.darkGray);
		Shape lid = new Ellipse2D.Double(150, 375, 200, 50);
		g.fill(lid);
		
	}
}
