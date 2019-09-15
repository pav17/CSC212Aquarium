package edu.smith.cs.csc212.aquarium;

import java.util.Random;
import java.awt.Graphics2D;

public class BubbleSystem {
	
	Bubble[] bubbleArray;
	int currentBubble;
	Random r = new Random();
	
	public BubbleSystem() {
		bubbleArray = new Bubble[10];
		this.currentBubble = 0;
		bubbleGen();
	}
	
	void bubbleGen() {
		for (int i = 0; i < 10; i++) {
			this.bubbleArray[i] = new Bubble(250, 550);
		}
	}
	
	void bubbleSpawn() {
		if (this.bubbleArray[this.currentBubble].y < -300) {
			this.currentBubble = r.nextInt(10);
			this.bubbleArray[this.currentBubble].y = 550;
		}
	}
	
	void bubbleDraw(Graphics2D g) {
		System.out.println(this.currentBubble);
		this.bubbleArray[this.currentBubble].draw(g);
	}
}
