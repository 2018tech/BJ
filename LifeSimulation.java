/**
 * File: Cell.java
 * Author: Jon Lee
 * Date: 09/29/2018
 * Class: CS231
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JOptionPane;


public class LifeSimulation{

	public static void main(String args[])  {

		//Read the grid size and the number of time steps from the GUI
		JOptionPane.showMessageDialog(null, "Welcome to Conway's Game of Life");
    String inp = JOptionPane.showInputDialog("How big do you want your grid to be? 10 is a good size");
    int size = Integer.parseInt(inp);

		//Jpane to determine size
		int rows;
		int cols;
			rows = Integer.parseInt(inp);
			cols = Integer.parseInt(inp);
	
			//how big do you want the size of the grid?
				Landscape scape = new Landscape(size, size);
		    String inpu = JOptionPane.showInputDialog("How many time steps do you want? Please enter an integer. I'd say ~200 is appropriate to really visualize it");
		    int newInt = Integer.parseInt(inpu);

				//random cell generator
        Random random = new Random();
        double dens = 0.4;
        for (int i = 0; i < scape.getRows(); i++) {
            for (int j = 0; j < scape.getCols(); j++ ) {
                scape.getCell( i, j ).setAlive( random.nextDouble() <= dens );
            }
        }

        LandscapeDisplay newDisplay = new LandscapeDisplay(scape, size);
				newDisplay.repaint();

				//however many times the user want to run this conway game of life.
				for (int i = 0; i < newInt; i++){
						scape.advance();
            newDisplay.repaint();
            newDisplay.saveImage( "data/life_frame_" + String.format( "%03d", i ) + ".png" );

        }
    }
}
