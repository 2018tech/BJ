/**
* File: Cell.java
* Author: Jon Lee
* Date: 09/29/2018
* Class: CS231
*/

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

public class Cell{
	//fields are private
	private boolean alive;

	//constructor set to false by default
	public Cell(){
		this.alive = false;
	}

	//another constructor you can use to make the cell alive
	public Cell(boolean alive){
		this.alive = alive;
	}


	/*
	*toString method for Java
	*/
	public String toString(){
		if(this.alive){
			return "It's alive";
		}else
		return "It's dead";
	}

	/*
	*is the cell alive or not?
	*/
	public boolean getAlive(){
		return this.alive;
	}

	/*
	*sets the alive field to whatever you want.
	*/
	public void setAlive(boolean alive){
		this.alive = alive;
	}

	/*
	*returns whether its alive or not
	*/
	public boolean reset(){
		this.alive = false;
		return this.alive;
	}

	/*
	*parameter takes in an ArrayList of Cell. If a cell returns the toString method of "It's  alive"
	then isitlive int gets incremented
	*/
	public void updateState( ArrayList<Cell> neighbors ){
		int isitlive = 0;
		// int countSpy = 0;
		for(int i=0; i< neighbors.size(); i++){
			if(neighbors.get(i).toString() == "It's alive"){
				isitlive++;
			}
		}
		if (this.alive == true) {
			if(isitlive ==2 || isitlive ==3){
				this.alive = true;
			}
			else{
				this.alive = false;
			}
		}
		else if (this.alive == false){
			if(isitlive == 3){
				this.alive = true;
			}
			else{
				this.alive = false;
			}
		}
	}

	/*
	*draw method in cell.
	*/
	public void draw( Graphics g, int x, int y, int scale ){
		g.drawRect(x,y, scale, scale);

		if(this.toString() == "It's alive"){
			g.setColor(Color.BLACK);
		}
		if(this.toString() == "It's dead"){
			g.setColor(Color.WHITE);
		}
		g.fillRect(x,y, scale, scale);
	}

	public static void main( String[] args) {
		Cell newCell = new Cell(true);
	}
}
