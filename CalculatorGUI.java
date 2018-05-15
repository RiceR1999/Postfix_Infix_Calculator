import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Constructs a functional gui the utilizes infix converter and post fix calculator
 * @author Ryan Rice
 * @version 04.24.2018
 */
public class CalculatorGUI {
	
	private JFrame frame;
	private JPanel topPanel;
	private JPanel centerTopPanel;
	private JPanel bottomPanel;
	private JPanel bottomPanel2;
	private JPanel bottomPanel3;
	private JPanel bottomPanel4;
	private JPanel bottomPanel5;
	private JLabel inputLabel;
	private JLabel outputLabel;
	private JTextField inputField;
	private JTextField outputField;
	private JRadioButton infixButton;
	private JRadioButton postfixButton;
	private ButtonGroup group;
	private JButton jb0;
	private JButton jb1;
	private JButton jb2;
	private JButton jb3;
	private JButton jb4;
	private JButton jb5;
	private JButton jb6;
	private JButton jb7;
	private JButton jb8;
	private JButton jb9;
	private JButton jbEqual;
	private JButton jbAdd;
	private JButton jbSubtract;
	private JButton jbMult;
	private JButton jbDivide;
	private JButton jbClear;
	private JButton jbDot;
	private JButton jbExp;
	private JButton jbPL;
	private JButton jbPR;
	private JButton jbSpace;
	private JToggleButton shift;
	private JMenuBar menuBar;
	private JMenu optionMenu;
	private JMenu fileMenu;
	private JMenuItem resetColor;
	private JMenuItem red, blue, green, black, yellow;
	private JMenuItem redX, blueX, greenX, blackX, yellowX;
	private JMenuItem DarkerIn, LighterIn, DarkerOut, LighterOut;
	private JMenuItem quit;
	private JMenu inpColor;
	private JMenu outColor;
	
		/**
		 * Constructor for CalculatorGUI
		 */
		public CalculatorGUI(){
			makeComponents();
			makePanels();
			makeFrame();
			
		}
		
		/**
		 * Constructs the frame for the GUI
		 */
		private void makeFrame(){
			frame = new JFrame("Calculator");	
			Container contentPane = frame.getContentPane();
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
			
			contentPane.add(topPanel);
			contentPane.add(centerTopPanel);
			contentPane.add(bottomPanel);
			contentPane.add(bottomPanel2);
			contentPane.add(bottomPanel3);
			contentPane.add(bottomPanel4);
			contentPane.add(bottomPanel5);
			
			menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			fileMenu = new JMenu("File");
			menuBar.add(fileMenu);
			quit = new JMenuItem("Quit");
			fileMenu.add(quit);
			quit.addActionListener(e -> quit());
			
			optionMenu = new JMenu("Options");
			menuBar.add(optionMenu);
			outColor = new JMenu("Change Output Color");
			optionMenu.add(outColor);
			inpColor = new JMenu("Change Input Color");
			optionMenu.add(inpColor);
			resetColor = new JMenuItem("Reset Text Color");
			resetColor.addActionListener(e -> resetColor());
			optionMenu.add(resetColor);
			black = new JMenuItem("Black");
			inpColor.add(black);
			black.addActionListener(e -> changeInColorB());
			blue = new JMenuItem("Blue");
			inpColor.add(blue);
			blue.addActionListener(e -> changeInColorBl());
			red = new JMenuItem("Red");
			inpColor.add(red);
			red.addActionListener(e -> changeInColorR());
			green = new JMenuItem("Green");
			inpColor.add(green);
			green.addActionListener(e -> changeInColorG());
			yellow = new JMenuItem("Yellow");
			inpColor.add(yellow);
			yellow.addActionListener(e -> changeInColorY());
			blackX = new JMenuItem("Black");
			outColor.add(blackX);
			blackX.addActionListener(e -> changeOutColorB());
			blueX = new JMenuItem("Blue");
			outColor.add(blueX);
			blueX.addActionListener(e -> changeOutColorBl());
			redX = new JMenuItem("Red");
			outColor.add(redX);
			redX.addActionListener(e -> changeOutColorR());
			greenX = new JMenuItem("Green");
			outColor.add(greenX);
			greenX.addActionListener(e -> changeOutColorG());
			yellowX= new JMenuItem("Yellow");
			outColor.add(yellowX);
			yellowX.addActionListener(e -> changeOutColorY());
			
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			}
		
		/**
		 * Constructs the panels for the GUI
		 */
		private void makePanels()
	    {
	        topPanel = new JPanel();
	        topPanel.add(inputField);
	        centerTopPanel = new JPanel();
	        centerTopPanel.add(infixButton);
	        centerTopPanel.add(postfixButton); 
	        centerTopPanel.add(shift); 
	        
	        bottomPanel = new JPanel();
	        bottomPanel.add(outputLabel);	        
	        bottomPanel.add(outputField);
	        
	        bottomPanel2 = new JPanel();
	        bottomPanel2.add(jb7);
	        bottomPanel2.add(jb8);
	        bottomPanel2.add(jb9);
	        bottomPanel2.add(jbEqual);
	        
	        bottomPanel3 = new JPanel();
	        bottomPanel3.add(jb4);
	        bottomPanel3.add(jb5);
	        bottomPanel3.add(jb6);
	        bottomPanel3.add(jbMult);
	        bottomPanel3.add(jbSpace);
	       
	        bottomPanel4 = new JPanel();
	        bottomPanel4.add(jb1);
	        bottomPanel4.add(jb2);
	        bottomPanel4.add(jb3);
	        bottomPanel4.add(jbDivide);
	        bottomPanel4.add(jbExp);
	        
	        bottomPanel5 = new JPanel();
	        bottomPanel5.add(jb0);
	        bottomPanel5.add(jbDot);
	        bottomPanel5.add(jbSubtract);
	        bottomPanel5.add(jbAdd);
	        bottomPanel5.add(jbClear);
	        bottomPanel5.add(jbPL);
	        bottomPanel5.add(jbPR);
	        
	        jbClear.setVisible(false);
    		jbPL.setVisible(false);
    		jbPR.setVisible(false);
    		jbSpace.setVisible(false);
    		jbExp.setVisible(false);
	    }
		
		/**
		 * Constructs the panels for the GUI
		 */
		private void makeComponents(){
			inputLabel = new JLabel("Input:");
			outputLabel = new JLabel("Result:");
			inputField = new JTextField(15);
			outputField = new JTextField(15);
			inputField.setEditable(false);
			outputField.setEditable(false);
			
			infixButton = new JRadioButton("Infix");
			postfixButton = new JRadioButton("Postfix");
			infixButton.addActionListener(e -> change());
			postfixButton.addActionListener(e-> change());
			ButtonGroup group = new ButtonGroup();
			group.add(infixButton);
			group.add(postfixButton);
			
			
			jb0 = new JButton("0");
			jb1 = new JButton("1");
			jb2 = new JButton("2");
			jb3 = new JButton("3");
			jb4 = new JButton("4");
			jb5 = new JButton("5");
			jb6 = new JButton("6");
			jb7 = new JButton("7");
			jb8 = new JButton("8");
			jb9 = new JButton("9");
			jbDivide = new JButton("/");
			jbAdd = new JButton("+");
			jbSubtract = new JButton("-");
			jbExp = new JButton("^");
			jbMult = new JButton("*");
			jbEqual = new JButton("=");
			jbClear = new JButton("C");
			jbSpace = new JButton("_");
			jbPL = new JButton("(");
			jbPR = new JButton(")");
			jbDot = new JButton(".");
			shift = new JToggleButton("Shift");
			shift.addActionListener(e -> shiftToggle());
			
			JPopupMenu popMenu = new JPopupMenu();
			JPopupMenu popOutMenu = new JPopupMenu();
			 DarkerIn = new JMenuItem("Darker");  
		     LighterIn = new JMenuItem("Lighter");  
		     DarkerOut = new JMenuItem("Darker");  
		     LighterOut = new JMenuItem("Lighter"); 
		     DarkerIn.addActionListener(z -> DarkerInput());
		     LighterIn.addActionListener(z -> LighterInput());
		     DarkerOut.addActionListener(z -> DarkerOutput());
		     LighterOut.addActionListener(z -> LighterOutput());
			 popMenu.add(DarkerIn);
			 popMenu.add(LighterIn);
			 popOutMenu.add(DarkerOut);
			 popOutMenu.add(LighterOut);
			 
			 
			  inputField.addMouseListener(new MouseAdapter() 
		        {  
		           public void mouseClicked(MouseEvent e) 
		           {              
		               if(e.getModifiers() == MouseEvent.BUTTON3_MASK && e.getClickCount() == 1)
		               {
		            	   popMenu.show(inputField , e.getX(), e.getY());  
		               }
		           }                 
		        });
		        inputField.add(popMenu);  
		        
		        outputField.addMouseListener(new MouseAdapter() 
		        {  
		           public void mouseClicked(MouseEvent e) 
		           {              
		               if(e.getModifiers() == MouseEvent.BUTTON3_MASK && e.getClickCount() == 1)
		               {
		            	   popOutMenu.show(outputField , e.getX(), e.getY());  
		               }
		           }                 
		        });
		        
		        jb0.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb0.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb1.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb1.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb2.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb2.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb3.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb3.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb4.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb4.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb5.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb5.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb6.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb6.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb7.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb7.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb8.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb8.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jb9.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jb9.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbAdd.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jbAdd.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbMult.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jbMult.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbDivide.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jbDivide.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbSubtract.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jbSubtract.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbDot.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jbDot.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbSpace.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + " ";
		        		inputField.setText(Num);
		        	}
		        });
		        jbExp.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jbExp.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbPL.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jbPL.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbPR.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		String Num = inputField.getText() + jbPR.getText();
		        		inputField.setText(Num);
		        	}
		        });
		        jbClear.addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent e)
		        	{
		        		inputField.setText(null);
		        		outputField.setText(null);
		        	}
		        });
		        jbEqual.addActionListener(z -> calculate());
		        
		        

			
		}
		
		/**
		 * Calculates the given infix or post fix expression
		 */
		private void calculate(){
			boolean infixBut = infixButton.isSelected();
			boolean postfixBut = postfixButton.isSelected();
			
			if(infixBut){
				String input = inputField.getText();
				
				InfixConverter converter = new InfixConverter();
				outputField.setText(converter.converter(input));
			}
			else
		    if(postfixBut){
		    	String input = inputField.getText();
		    	
		    	PostfixCalculator calculator = new PostfixCalculator();
		    	outputField.setText(calculator.Calculate(input));
		    }
			if(!infixBut && !postfixBut){
				outputField.setText("Please select and option");
			}
		}
		
		/**
		 * Lightens the output text
		 */
		private void LighterOutput(){
			Color color = inputField.getBackground();
	    	color = color.brighter();
	    	inputField.setBackground(color);
		}
		/**
		 * Lightens the input text
		 */
		private void LighterInput(){
			Color color = inputField.getBackground();
	    	color = color.brighter();
	    	inputField.setBackground(color);
		}
		/**
		 * Darkens the output text
		 */
		private void DarkerOutput(){
			Color color = inputField.getBackground();
	    	color = color.darker();
	    	inputField.setBackground(color);
		}
		/**
		 * Darkens the input text
		 */
		private void DarkerInput(){
			Color color = inputField.getBackground();
	    	color = color.darker();
	    	inputField.setBackground(color);
		}
		
		/**
		 * Changes the calculator buttons once shift is pressed
		 */
		private void shiftToggle(){
			boolean isShifted = shift.isSelected();
			if(isShifted){
				
				jbSubtract.setVisible(false);
				jbDot.setVisible(false);
				jbAdd.setVisible(false);
				jbMult.setVisible(false);
				jbDivide.setVisible(false);
				jbClear.setVisible(true);
				jbPL.setVisible(true);
				jbSpace.setVisible(true);
				jbPR.setVisible(true);
				jbExp.setVisible(true);
				
			}
			else{
				jbAdd.setVisible(true);
				jbDot.setVisible(true);
				jbSubtract.setVisible(true);
				jbMult.setVisible(true);
				jbDivide.setVisible(true);
				jbClear.setVisible(false);
				jbPL.setVisible(false);
				jbSpace.setVisible(false);
				jbPR.setVisible(false);
				jbExp.setVisible(false);
			}
		}
		/**
		 * Clears the fields
		 */
		private void change(){
			boolean button = infixButton.isSelected();
			if(button){
				inputField.setText(null);
				outputField.setText(null);
			}
			else{
				inputField.setText(null);
				outputField.setText(null);
			}
		}
		
		/**
		 * Changes output field color to yellow
		 */
		private void changeOutColorY(){
			String x = inputField.getText();
			inputField.setForeground(Color.yellow);
			inputField.setText(x);
			
		}
		/**
		 * Changes output field color to green
		 */
		private void changeOutColorG(){
			String x = inputField.getText();
			inputField.setForeground(Color.green);
			inputField.setText(x);
		}
		/**
		 * Changes output field color to red
		 */
		private void changeOutColorR(){
			String x = inputField.getText();
			inputField.setForeground(Color.red);
			inputField.setText(x);
		}
		/**
		 * Changes output field color to blue
		 */
		private void changeOutColorBl(){
			String x = inputField.getText();
			inputField.setForeground(Color.blue);
			inputField.setText(x);
		}
		/**
		 * Changes output field color to black
		 */
		private void changeOutColorB(){
			String x = inputField.getText();
			inputField.setForeground(Color.black);
			inputField.setText(x);
		}
		/**
		 * Changes input field color to yellow
		 */
		private void changeInColorY(){
			String x = inputField.getText();
			inputField.setForeground(Color.yellow);
			inputField.setText(x);
		}
		/**
		 * Changes input field color to green
		 */
		private void changeInColorG(){
			String x = inputField.getText();
			inputField.setForeground(Color.green);
			inputField.setText(x);
		}
		/**
		 * Changes input field color to red
		 */
		private void changeInColorR(){
			String x = inputField.getText();
			inputField.setForeground(Color.red);
			inputField.setText(x);
		}
		/**
		 * Changes input field color to blue
		 */
		private void changeInColorBl(){
			String x = inputField.getText();
			inputField.setForeground(Color.blue);
			inputField.setText(x);
		}
		/**
		 * Changes input field color to black
		 */
		private void changeInColorB(){
			String x = inputField.getText();
			inputField.setForeground(Color.black);
			inputField.setText(x);
		}
		/**
		 * Resets color to default black
		 */
		private void resetColor(){
			outputField.setForeground(Color.black);
			inputField.setBackground(Color.black);
		}
		/**
		 * Exit option
		 */
		private void quit(){
			System.exit(0);
		}
}
