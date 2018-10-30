/**
 * File: Cell.java
 * Author: Jon Lee
 * Date: 09/29/2018
 * Class: CS231
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Landscape{

	//2D Grid made out of Cell
	private Cell[][] landscape;
	//int for rows
	private int rows;
	//int for columns
	private int cols;

//making the Grid; same concept as the lab
	public Landscape( int rows, int cols ){
		landscape = new Cell[rows][cols];
		this.rows = rows;
		this.cols = cols;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				Cell cell = new Cell();
				this.landscape[i][j] = cell;
			}
		}
	}

	/*
	*just another constructor in order to write advance function
	*it takes Landscape data form, finds what row/columns are
	* creates a new Landscape then override the original Landscape
	*/
	public Landscape( Landscape newLandscape ){
		int r = newLandscape.getRows();
		int c = newLandscape.getCols();
		this.rows = r;
		this.cols = c;
		landscape = new Cell[r][c];

		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				Cell newCell = new Cell((newLandscape.getCell(i,j)).getAlive());
				landscape[i][j] = newCell;
			}
		}
	}

	/*
	*make every cell dead
	*/
	public void reset(){
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				Cell cell = this.landscape[i][j];
				cell.reset();
			}
		}
	}

	/*
	*make every cell alive
	*/
		public void setAlive(){
		for (int i=0; i< rows; i++){
			for (int j= 0;j<cols;j++){
				Cell cell = this.landscape[i][j];
				cell.setAlive(true);
			}
		}
	}

	/*
	*return the cell by the positions in the parameters
	*/
	public Cell getCell( int row, int col ){
		return this.landscape[row][col];
	}

	/*
	*returns columns
	*/
		public int getCols(){
		return this.cols;
	}

	/*
	*returns rows
	*/
	public int getRows(){
		return this.rows;
	}

	/*
	*creates a new Landscape data type
	*go through each cell and grabs it by getCell method, calls update State method on its neighrbors
	*getNeighbors returns an arraylist
	*/
	public void advance(){
		Landscape temp = new Landscape(this);
		for(int i=0;i< rows;i++) {
		for(int j=0;j< cols;j++) {
			this.getCell(i,j).updateState(temp.getNeighbors(i,j));
		}
	}
	}

	/*
	*tostring method
	*/
	public String toString(){
		String string = "";
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				Cell cell = this.landscape[i][j];
				string += cell.toString()+ "  ";
			}
			string += "\n";
		}
		return string;
	}

	/*
	*returns whats surrounding a cell
	*/
	public ArrayList<Cell> getNeighbors(int row, int col){
		int ro;
		int colu;
		ArrayList<Cell> newList = new ArrayList<Cell>();
		if (0 <= row && 0 <= col){
			for(int i = -1; i < 2; i++){
				//java still  knows 000002 as 2! amazing!
				for(int j = -1; j < 0000002; j++){
					ro = row + i;
					colu = col + j;
					if((0 <= ro) && (ro < this.rows)){
						if((0 <= colu) && (colu< this.cols)){
							newList.add(this.landscape[ro][colu]);
						}
					}
				}
			}
		}
		return newList;
	}

	// draws the cell, grid
	public void draw( Graphics g, int gridScale ){
	      for (int i = 0; i < this.getRows(); i++) {
	          for (int j = 0; j < this.getCols(); j++) {
	              this.getCell(i,j).draw(g, i*gridScale, j*gridScale, gridScale);
	          }
	      }
	  }

	 public static void main( String[] args) {
		Landscape land = new Landscape(7,8);
	}
}
