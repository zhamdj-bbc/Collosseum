package View;

import java.awt.BorderLayout;
import javax.swing.*;

public class MainFrame extends JFrame {
	
	//Panels
	private JPanel dropDownMenu = new JPanel();
	private JPanel actionButtonLeft = new JPanel();
	private JPanel actionButtonRight = new JPanel();
	private JPanel fighter  = new JPanel();
	
	//Combo Boxes for dropDownMenu
	private JComboBox player1 = new JComboBox();
	private JComboBox player2 = new JComboBox();
	private JComboBox background = new JComboBox();
	
	//Buttons for actionButtonLeft
	private JButton headLeft = new JButton("Head");
	private JButton torsoLeft = new JButton("Torso");
	private JButton legsLeft = new JButton("Legs");
	
	//Buttons for actionButtonRight
	private JButton headRight = new JButton("Head");
	private JButton torsoRight = new JButton("Torso");
	private JButton legsRight = new JButton("Legs");
	
	
	//Adding Buttons to Panels and Panels to MainFrame
	public MainFrame() {
		
		setTitle("Collosseum");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//adding Inputs to dropDownMenu
		dropDownMenu.add(player1);
		dropDownMenu.add(player2);
		dropDownMenu.add(background);
		add(dropDownMenu, BorderLayout.NORTH);
		
		//adding Inputs to actionButtonLeft
		actionButtonLeft.add(headLeft);
		actionButtonLeft.add(torsoLeft);
		actionButtonLeft.add(legsLeft);
		add(actionButtonLeft, BorderLayout.WEST);
		
		add(fighter, BorderLayout.CENTER);
		
		//adding Inputs to actionButtonLeft
		actionButtonRight.add(headRight);
		actionButtonRight.add(torsoRight);
		actionButtonRight.add(legsRight);
		add(actionButtonRight, BorderLayout.WEST);
		
		add(actionButtonRight, BorderLayout.EAST);
	}

}