package View;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout.Constraints;

public class MainFrame extends JFrame {

	
	// JPanels
	private JPanel dropDownMenu 		= new JPanel();
	private JPanel actionButtonLeft 	= new JPanel();
	private JPanel actionButtonRight 	= new JPanel();
	private JPanel battle 				= new JPanel();
	private JPanel fighterLeft 			= new JPanel();
	private JPanel actionSymbol 		= new JPanel();
	private JPanel fighterRight 		= new JPanel();
	private JPanel southPanelLeft 		= new JPanel();
	private JPanel verticalLeft			= new JPanel();
	private JPanel southPanelRight 		= new JPanel();
	private JPanel verticalRight		= new JPanel();
	
	// Lists & Combo Boxes for dropDownMenu
	String[] playermodel1 	= { "Katharina", "Thellux", "Taeljam" };
	String[] playermodel2 	= { "Occultus", "Lahzey", "Rufus" };
	String[] backgrounds 	= { "Forsaken Temple", "Lost Desert", "Out in Space" };
	
	private JComboBox player1 	= new JComboBox(playermodel1);
	private JComboBox player2 	= new JComboBox(playermodel2);
	private JComboBox arena 	= new JComboBox(backgrounds);
	

	// Buttons for actionButtonLeft
	private JButton headLeft 	= new JButton("Head");
	private JButton torsoLeft 	= new JButton("Torso");
	private JButton legsLeft 	= new JButton("Legs");

	
	// Buttons for actionButtonRight
	private JButton headRight 	= new JButton("Head");
	private JButton torsoRight 	= new JButton("Torso");
	private JButton legsRight 	= new JButton("Legs");

	
	// Progress Bars for hpBar
	private JProgressBar hpBarLeft 	= new JProgressBar();
	private JProgressBar hpBarRight = new JProgressBar();

	
	// Loading Images
	private JLabel fighterLeftImage = loadJLabel("/characters/katharina.png");
	private JLabel fighterRightImage = loadJLabel("/characters/rufus.png");

	private JLabel headSymbolLeft 	= loadJLabel("/symbols/sword.png");
	private JLabel torsoSymbolLeft 	= loadJLabel("/symbols/empty.png");
	private JLabel legsSymbolLeft 	= loadJLabel("/symbols/empty.png");
	private JLabel headSymbolRight 	= loadJLabel("/symbols/empty.png");
	private JLabel torsoSymbolRight = loadJLabel("/symbols/shield.png");
	private JLabel legsSymbolRight 	= loadJLabel("/symbols/empty.png");

	private JLabel background 		= loadJLabel("/backgrounds/space.jpg");

	
	// Adding Buttons to Panels and Panels to MainFrame
	
	public MainFrame() {

		
		// Default Implementations
		setTitle						("Collosseum");
		setDefaultCloseOperation		(EXIT_ON_CLOSE);

		
		// Layout Settings
		dropDownMenu.setLayout			(new FlowLayout(FlowLayout.LEFT));
		dropDownMenu.setOpaque			(false);
		battle.setLayout				(new BorderLayout());
		battle.setOpaque				(false);
		actionSymbol.setLayout			(new GridLayout(3, 2));
		actionSymbol.setOpaque			(false);
		actionButtonLeft.setLayout		(new BoxLayout(actionButtonLeft, BoxLayout.Y_AXIS));
		actionButtonLeft.setOpaque		(false);
		actionButtonRight.setLayout		(new BoxLayout(actionButtonRight, BoxLayout.Y_AXIS));
		actionButtonRight.setOpaque		(false);
		setLayout						(new BorderLayout());
		fighterLeft.setLayout			(new GridLayout(1, 2));
		fighterLeft.setOpaque			(false);
		fighterRight.setLayout			(new GridLayout(1, 2));
		fighterRight.setOpaque			(false);
		southPanelLeft.setLayout		(new BorderLayout());
		southPanelLeft.setOpaque		(false);
		verticalLeft.setLayout			(new BoxLayout(verticalLeft, BoxLayout.Y_AXIS));
		verticalLeft.setOpaque			(false);
		southPanelRight.setLayout		(new BorderLayout());
		southPanelRight.setOpaque		(false);
		verticalRight.setLayout			(new BoxLayout(verticalRight, BoxLayout.Y_AXIS));
		verticalRight.setOpaque			(false);

		
		// Background
		setContentPane					(background);
		setLayout						(new BorderLayout());

		
		// adding Inputs to dropDownMenu
		dropDownMenu.add				(player1);
		dropDownMenu.add				(player2);
		dropDownMenu.add				(arena);
		add								(dropDownMenu, BorderLayout.NORTH);

		
		// adding Inputs to VerticalLeft and southPanelLeft
		verticalLeft.add				(headLeft);
		verticalLeft.add				(torsoLeft);
		verticalLeft.add				(legsLeft);
		southPanelLeft.add				(verticalLeft, BorderLayout.SOUTH);
		add								(southPanelLeft, BorderLayout.WEST);

		
		// adding HP-Bars, Fighters and Action Symbols to battle
		fighterLeft.add					(hpBarLeft);
		fighterLeft.add					(fighterLeftImage);
		battle.add						(fighterLeft, BorderLayout.WEST);

		actionSymbol.add				(headSymbolRight);
		actionSymbol.add				(headSymbolLeft);
		actionSymbol.add				(torsoSymbolRight);
		actionSymbol.add				(torsoSymbolLeft);
		actionSymbol.add				(legsSymbolRight);
		actionSymbol.add				(legsSymbolLeft);
		battle.add						(actionSymbol, BorderLayout.CENTER);

		fighterRight.add				(hpBarRight);
		fighterRight.add				(fighterRightImage);
		battle.add						(fighterRight, BorderLayout.EAST);

		add								(battle, BorderLayout.CENTER);

		
		// adding Inputs to VerticalRight and southPanelRight
		verticalRight.add				(headRight);
		verticalRight.add				(torsoRight);
		verticalRight.add				(legsRight);
		southPanelRight.add				(verticalRight, BorderLayout.SOUTH);
		add								(southPanelRight, BorderLayout.EAST);

	}	
	
	
	//Abkürzung für Image Loader
	private static JLabel loadJLabel(String iconName) {
		final URL resource = MainFrame.class.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println(
					"Error in " + MainFrame.class.getName() + ": Icon /images/" + iconName + " could not be loaded.");
			return new JLabel(new ImageIcon());
		}
		return new JLabel(new ImageIcon(resource));
	}
	
	
	//Main Methode
	public static void main(String[] args) {
		MainFrame gui = new MainFrame();
		gui.setSize(1920, 1080);
		gui.setVisible(true);
		gui.setResizable(false);
		gui.setLocationRelativeTo(null);
		gui.setSize(399, 399);
		gui.setSize(1920, 1080);

		// ___________________________________________

	}

}