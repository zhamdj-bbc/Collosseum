package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Controller.GameController;
import Model.EnumBodyPart;
import Model.EnumFighter;
import View.MainFrame.State;

public class MainFrame extends JFrame {

	public enum State
	{
		WaitForLeftAttack,
		WaitForRightDefense,
		WaitForRightAttack,
		WaitForLeftDefense,	
	}
	
	// JPanels
	private JPanel dropDownMenu 			= new JPanel();
	private JPanel actionButtonLeft 		= new JPanel();
	private JPanel actionButtonRight 		= new JPanel();
	private JPanel battle 					= new JPanel();
	private JPanel fighterLeft 				= new JPanel();
	private JPanel actionSymbol 			= new JPanel();
	private JPanel fighterRight 			= new JPanel();
	private JPanel southPanelLeft 			= new JPanel();
	private JPanel verticalLeft				= new JPanel();
	private JPanel southPanelRight 			= new JPanel();
	private JPanel verticalRight			= new JPanel();
	private JPanel hpPanelLeft				= new JPanel();
	private JPanel hpPanelRight				= new JPanel();
	private State currentState;
	
	// Lists & Combo Boxes for dropDownMenu
	String[] playermodel1 					= { "Katharina", "Thellux", "Taeljam" };
	String[] playermodel2 					= { "Occultus", "Lahzey", "Rufus" };
	String[] backgrounds 					= { "Forsaken Temple", "Lost Desert", "Out in Space" };
	
	private JComboBox player1 				= new JComboBox(playermodel1);
	private JComboBox player2 				= new JComboBox(playermodel2);
	private JComboBox arena 				= new JComboBox(backgrounds);

	// Buttons for actionButtonLeft
	private JButton headLeft 				= new JButton();
	private JButton torsoLeft 				= new JButton();
	private JButton legsLeft 				= new JButton();
		
	// Buttons for actionButtonRight
	private JButton headRight 				= new JButton();
	private JButton torsoRight 				= new JButton();
	private JButton legsRight 				= new JButton();

	// Progress Bars for hpBar
	private JProgressBar hpBarLeft 			= new JProgressBar(0, 50);
	private JProgressBar hpBarRight 		= new JProgressBar(0, 50);


	// Loading Images
	private JLabel fighterLeftImage 		= loadJLabel("/characters/katharina.png");
	private JLabel fighterRightImage 		= loadJLabel("/characters/rufus.png");

	private JLabel headSymbolLeft 			= loadJLabel("/symbols/sword.png");
	private JLabel torsoSymbolLeft 			= loadJLabel("/symbols/empty.png");
	private JLabel legsSymbolLeft 			= loadJLabel("/symbols/empty.png");
	private JLabel headSymbolRight 			= loadJLabel("/symbols/empty.png");
	private JLabel torsoSymbolRight 		= loadJLabel("/symbols/shield.png");
	private JLabel legsSymbolRight 			= loadJLabel("/symbols/empty.png");

	private JLabel hpBarVerticalBlind		= loadJLabel("/symbols/hpBarVerticalBlind.png");
	private JLabel hpBarHorizontalBlind01	= loadJLabel("/symbols/hpBarHorizontalBlind.png");
	private JLabel hpBarHorizontalBlind02	= loadJLabel("/symbols/hpBarHorizontalBlind.png");
	private JLabel hpBarHorizontalBlind03	= loadJLabel("/symbols/hpBarHorizontalBlind.png");
	private JLabel hpBarHorizontalBlind04	= loadJLabel("/symbols/hpBarHorizontalBlind.png");

	private JLabel background 				= loadJLabel("/backgrounds/space.jpg");

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private BufferedImage headLeftIcon;
	private BufferedImage headRightIcon;
	private BufferedImage torsoLeftIcon;
	private BufferedImage torsoRightIcon;
	private BufferedImage legsLeftIcon;
	private BufferedImage legsRightIcon;
	private GameController gameController;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Adding Buttons to Panels and Panels to MainFrame
	public MainFrame() {

		this.gameController = new GameController(this); 
		this.gameController.startBattle(EnumFighter.LEFT);
		currentState = State.WaitForLeftAttack;
		
		this.setButtonAccessibility(currentState);
		
		ActionListener fightButtonActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	JButton button = (JButton)event.getSource();

            	EnumFighter currentFighter = gameController.getCurrentFighter();

            	EnumBodyPart bodyPart = null;
            	boolean leftButtonsClicked = false;
            	
            	
            	if (button.getName() == "headLeft")
            	{
            		bodyPart = EnumBodyPart.HEAD;
            		leftButtonsClicked = true;
            	}
            	else if (button.getName() == "torsoLeft")
            	{
            		bodyPart = EnumBodyPart.TORSO;
            		leftButtonsClicked = true;
            	}
            	else if (button.getName() == "legsLeft")
            	{
            		bodyPart = EnumBodyPart.LEGS;
            		leftButtonsClicked = true;
            	}
            	else if (button.getName() == "headRight")
            	{
            		bodyPart = EnumBodyPart.HEAD;
            		leftButtonsClicked = false;
            	}
            	else if (button.getName() == "torsoRight")
            	{
            		bodyPart = EnumBodyPart.TORSO;
            		leftButtonsClicked = false;
            	}
            	else if (button.getName() == "legsRight")
            	{
            		bodyPart = EnumBodyPart.LEGS;
            		leftButtonsClicked = false;
            	}
            	else
            	{
            		return;
            	}
            	
        		if (currentFighter == EnumFighter.LEFT && leftButtonsClicked)
        		{
        			gameController.setAttack(bodyPart);
        		}
        		else if (currentFighter == EnumFighter.LEFT && leftButtonsClicked == false)
        		{
        			gameController.setDefense(bodyPart);
        			gameController.handleBattle();
        			hpBarRight.setValue(gameController.getHealthFromRightFighter());
        			repaint();
        			gameController.startBattle(EnumFighter.RIGHT);
        			try {
        			    Thread.sleep(1000);                 //1000 milliseconds is one second.
        			} catch(InterruptedException ex) {
        			    Thread.currentThread().interrupt();
        			}
        		}
        		else if (currentFighter == EnumFighter.RIGHT && leftButtonsClicked == false)
        		{
        			gameController.setAttack(bodyPart);
        		}
        		else if (currentFighter == EnumFighter.RIGHT && leftButtonsClicked)
        		{
        			gameController.setDefense(bodyPart);
        			gameController.handleBattle();
        			hpBarLeft.setValue(gameController.getHealthFromLeftFighter());
        			repaint();
        			gameController.startBattle(EnumFighter.LEFT);
        			try {
        			    Thread.sleep(1000);                 //1000 milliseconds is one second.
        			} catch(InterruptedException ex) {
        			    Thread.currentThread().interrupt();
        			}
        		}
        		
        		currentState = this.getNextState();
        		setButtonAccessibility(currentState);
            }

			private State getNextState() {

				switch (currentState) {
					case WaitForLeftAttack:
						return State.WaitForRightDefense;
					case WaitForRightDefense:
						return State.WaitForRightAttack;
					case WaitForRightAttack:
						return State.WaitForLeftDefense;
					case WaitForLeftDefense:
						return State.WaitForLeftAttack;
				}
				
				throw new RuntimeException("Invalid State!");
			}
        };

        ItemListener comboBoxListenerPlayer1 = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				fighterLeftImage = loadJLabel("characters/" + player1.getSelectedItem() + ".png");
			}
		};
            
		headLeft.setName("headLeft");
		torsoLeft.setName("torsoLeft");
		legsLeft.setName("legsLeft");
		headRight.setName("headRight");
		torsoRight.setName("torsoRight");
		legsRight.setName("legsRight");
        
		headLeft.addActionListener(fightButtonActionListener);
		torsoLeft.addActionListener(fightButtonActionListener);
		legsLeft.addActionListener(fightButtonActionListener);
		headRight.addActionListener(fightButtonActionListener);
		torsoRight.addActionListener(fightButtonActionListener);
		legsRight.addActionListener(fightButtonActionListener);
		
		player1.addItemListener(comboBoxListenerPlayer1);
		player2.addItemListener(comboBoxListenerPlayer1);

		
		
		
		
		
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
		fighterLeft.setLayout			(new BorderLayout());
		fighterLeft.setOpaque			(false);
		fighterRight.setLayout			(new BorderLayout());
		fighterRight.setOpaque			(false);
		southPanelLeft.setLayout		(new BorderLayout());
		southPanelLeft.setOpaque		(false);
		verticalLeft.setLayout			(new BoxLayout(verticalLeft, BoxLayout.Y_AXIS));
		verticalLeft.setOpaque			(false);
		southPanelRight.setLayout		(new BorderLayout());
		southPanelRight.setOpaque		(false);
		verticalRight.setLayout			(new BoxLayout(verticalRight, BoxLayout.Y_AXIS));
		verticalRight.setOpaque			(false);
		hpBarLeft.setValue				(gameController.getHealthFromLeftFighter());
		hpBarRight.setValue				(gameController.getHealthFromRightFighter());
		headLeft.setOpaque				(false);
		headRight.setOpaque				(false);
		torsoLeft.setOpaque				(false);
		torsoRight.setOpaque			(false);
		legsLeft.setOpaque				(false);
		legsRight.setOpaque				(false);
		hpPanelLeft.setLayout			(new BorderLayout());
		hpPanelLeft.setOpaque			(false);
		hpPanelRight.setLayout			(new BorderLayout());
		hpPanelRight.setOpaque			(false);
		
		// Background
		setContentPane					(background);
		setLayout						(new BorderLayout());

		// adding Inputs to dropDownMenu
		dropDownMenu.add				(player1);
		dropDownMenu.add				(player2);
		dropDownMenu.add				(arena);
		add								(dropDownMenu, BorderLayout.NORTH);
	
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			headLeftIcon 		= ImageIO.read(new File("src/images/symbols/headLeftIcon.png"));
			headRightIcon 		= ImageIO.read(new File("src/images/symbols/headLeftIcon.png"));
			torsoLeftIcon 		= ImageIO.read(new File("src/images/symbols/headLeftIcon.png"));
			torsoRightIcon		= ImageIO.read(new File("src/images/symbols/headLeftIcon.png"));
			legsLeftIcon 		= ImageIO.read(new File("src/images/symbols/headLeftIcon.png"));
			legsRightIcon 		= ImageIO.read(new File("src/images/symbols/headLeftIcon.png"));
			
		} catch (IOException e) {
			
		}
		headLeft.setIcon(new ImageIcon(headLeftIcon));
		headRight.setIcon(new ImageIcon(headRightIcon));
		torsoLeft.setIcon(new ImageIcon(torsoLeftIcon));
		torsoRight.setIcon(new ImageIcon(torsoRightIcon));
		legsLeft.setIcon(new ImageIcon(legsLeftIcon));
		legsRight.setIcon(new ImageIcon(legsRightIcon));
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		// adding Inputs to VerticalLeft and southPanelLeft
		verticalLeft.add				(headLeft);
		verticalLeft.add				(torsoLeft);
		verticalLeft.add				(legsLeft);
		southPanelLeft.add				(verticalLeft, BorderLayout.SOUTH);
		add								(southPanelLeft, BorderLayout.WEST);

		
		// Adding Progress Bar and empty Pictures to hpPanel
		hpPanelLeft.add						(hpBarHorizontalBlind01, BorderLayout.WEST);
		hpPanelLeft.add						(hpBarLeft, BorderLayout.CENTER);
		hpPanelLeft.add						(hpBarHorizontalBlind02, BorderLayout.EAST);
		
		hpPanelRight.add					(hpBarHorizontalBlind03, BorderLayout.WEST);
		hpPanelRight.add					(hpBarRight, BorderLayout.CENTER);
		hpPanelRight.add					(hpBarHorizontalBlind04, BorderLayout.EAST);
		
		Border HPBorder = new LineBorder(Color.DARK_GRAY, 2);
		
		hpBarLeft.setForeground(Color.GREEN);
		hpBarLeft.setBackground(Color.LIGHT_GRAY);
		hpBarLeft.setBorder(HPBorder);
		
		hpBarRight.setForeground(Color.GREEN);
		hpBarRight.setBackground(Color.LIGHT_GRAY);
		hpBarRight.setBorder(HPBorder);
		
		
		// adding HP Panels, Fighters and Action Symbols to battle
		battle.add						(hpBarVerticalBlind, BorderLayout.NORTH);
		
		fighterLeft.add					(hpPanelLeft, BorderLayout.NORTH);
		fighterLeft.add					(fighterLeftImage, BorderLayout.CENTER);
		battle.add						(fighterLeft, BorderLayout.WEST);

		actionSymbol.add				(headSymbolRight);
		actionSymbol.add				(headSymbolLeft);
		actionSymbol.add				(torsoSymbolRight);
		actionSymbol.add				(torsoSymbolLeft);
		actionSymbol.add				(legsSymbolRight);
		actionSymbol.add				(legsSymbolLeft);
		battle.add						(actionSymbol, BorderLayout.CENTER);

		fighterRight.add				(hpPanelRight, BorderLayout.NORTH);
		fighterRight.add				(fighterRightImage, BorderLayout.CENTER);
		battle.add						(fighterRight, BorderLayout.EAST);

		add								(battle, BorderLayout.CENTER);

		// adding Inputs to VerticalRight and southPanelRight
		verticalRight.add				(headRight);
		verticalRight.add				(torsoRight);
		verticalRight.add				(legsRight);
		southPanelRight.add				(verticalRight, BorderLayout.SOUTH);
		add								(southPanelRight, BorderLayout.EAST);

	}	
	
	private void setButtonAccessibility(State currentState2) {
		switch (currentState) {
		case WaitForLeftAttack:
		case WaitForLeftDefense:
			
			headRight.setEnabled(false);
			torsoRight.setEnabled(false);
			legsRight.setEnabled(false);
			headLeft.setEnabled(true);
			torsoLeft.setEnabled(true);
			legsLeft.setEnabled(true);
			
			break;
		case WaitForRightDefense:
		case WaitForRightAttack:
			
			headRight.setEnabled(true);
			torsoRight.setEnabled(true);
			legsRight.setEnabled(true);
			headLeft.setEnabled(false);
			torsoLeft.setEnabled(false);
			legsLeft.setEnabled(false);
			
			break;
		}
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
	}

}