package View;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
	private JPanel dropDownMenu = new JPanel();
	private JPanel actionButtonLeft = new JPanel();
	private JPanel actionButtonRight = new JPanel();
	private JPanel battle = new JPanel();
	private JPanel hpBar = new JPanel();
	private JPanel fighterLeft = new JPanel();
	private JPanel actionSymbol = new JPanel();
	private JPanel fighterRight = new JPanel();

	// Combo Boxes for dropDownMenu
	String[] playermodel1 = {"Katharina", "Thellux", "Taeljam"};
	String[] playermodel2 = {"Occultus", "Lahzey", "Rufus"};
	String[] backgrounds = {"Forsaken Temple", "Lost Desert"};
	private JComboBox player1 = new JComboBox(playermodel1);
	private JComboBox player2 = new JComboBox(playermodel2);
	private JComboBox background = new JComboBox(backgrounds);

	// Buttons for actionButtonLeft
	private JButton headLeft = new JButton("Head");
	private JButton torsoLeft = new JButton("Torso");
	private JButton legsLeft = new JButton("Legs");

	// Buttons for actionButtonRight
	private JButton headRight = new JButton("Head");
	private JButton torsoRight = new JButton("Torso");
	private JButton legsRight = new JButton("Legs");

	// Progress Bars for hpBar
	private JProgressBar hpBarLeft = new JProgressBar();
	private JProgressBar hpBarRight = new JProgressBar();

	// Images for fighters
	private JLabel fighterLeftImage = loadIcon("/characters/character1.jpg");
	private JLabel fighterRightImage = loadIcon("/characters/character2.jpg");

	// Images for actionSymbols
	private JLabel headSymbolLeft = loadIcon("/symbols/swordLeft.png");
	private JLabel torsoSymbolLeft = loadIcon("/symbols/swordLeft.png");
	private JLabel legsSymbolLeft = loadIcon("/symbols/swordLeft.png");

	private JLabel headSymbolRight = loadIcon("/symbols/swordRight.png");
	private JLabel torsoSymbolRight = loadIcon("/symbols/swordRight.png");
	private JLabel legsSymbolRight = loadIcon("/symbols/swordRight.png");
	
	
	
	// Adding Buttons to Panels and Panels to MainFrame
	public MainFrame() {

		// Default Implementations
		setTitle("Collosseum");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Layout Settings
		dropDownMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
		battle.setLayout(new BorderLayout());
		hpBar.setLayout(new GridLayout());
		actionSymbol.setLayout(new GridLayout(3, 2));
		actionButtonLeft.setLayout(new BoxLayout(actionButtonLeft, BoxLayout.Y_AXIS));
		actionButtonRight.setLayout(new BoxLayout(actionButtonRight, BoxLayout.Y_AXIS));

		// adding Inputs to dropDownMenu
		dropDownMenu.add(player1);
		dropDownMenu.add(player2);
		dropDownMenu.add(background);
		add(dropDownMenu, BorderLayout.NORTH);

		// adding Inputs to actionButtonLeft
		actionButtonLeft.add(headLeft);
		actionButtonLeft.add(torsoLeft);
		actionButtonLeft.add(legsLeft);
		add(actionButtonLeft, BorderLayout.WEST);

		// adding HP-Bars, Fighters and Action Symbols to battle
		hpBar.add(hpBarLeft);
		hpBar.add(hpBarRight);
		battle.add(hpBar, BorderLayout.NORTH);

		fighterLeft.add(fighterLeftImage);
		battle.add(fighterLeft, BorderLayout.WEST);

		actionSymbol.add(headSymbolRight);
		actionSymbol.add(headSymbolLeft);
		actionSymbol.add(torsoSymbolRight);
		actionSymbol.add(torsoSymbolLeft);
		actionSymbol.add(legsSymbolRight);
		actionSymbol.add(legsSymbolLeft);
		battle.add(actionSymbol, BorderLayout.CENTER);

		fighterRight.add(fighterRightImage);
		battle.add(fighterRight, BorderLayout.EAST);

		add(battle, BorderLayout.CENTER);

		// adding Inputs to actionButtonRight
		actionButtonRight.add(headRight);
		actionButtonRight.add(torsoRight);
		actionButtonRight.add(legsRight);
		add(actionButtonRight, BorderLayout.EAST);
		
		

		
		
	}

	private static JLabel loadIcon(String iconName) {
		final URL resource = MainFrame.class.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println(
					"Error in " + MainFrame.class.getName() + ": Icon /images/" + iconName + " could not be loaded.");
			return new JLabel(new ImageIcon());
		}
		return new JLabel(new ImageIcon(resource));
	}

}