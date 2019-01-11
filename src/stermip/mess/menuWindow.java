package stermip.mess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.MediaTracker;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import stermip.mess.functions.managerCheck;
import stermip.mess.functions.memberCheck;
import stermip.mess.functions.signupFunc;
import stermip.mess.functions.warningMsg;
import stermip.myApi.imageLabel;

public class menuWindow extends JPanel {
	  Image bgimage = null;
	  
	  menuWindow()  {
		System.out.print("Reached here");
		 MediaTracker mt = new MediaTracker(this);
		    
		    bgimage = Toolkit.getDefaultToolkit().getImage("picture//background.png");
		    mt.addImage(bgimage, 0);
		    try {
			      mt.waitForAll();
			    } catch (InterruptedException e) {
			      e.printStackTrace();
			    }
	    
			    BorderLayout bdl = new BorderLayout();
			    setLayout(bdl);
			    JLabel picLabel = imageLabel.getImageLabel("picture//menuWindow.png");
			    this.add(picLabel, BorderLayout.NORTH);
			    
	    GridBagConstraints gbc = new GridBagConstraints();
	    GridBagLayout gbl= new GridBagLayout();
	    JButton deposit = new JButton("Deposit");
	    JButton bazarlist = new JButton("Bazar List");
	    JButton other_expense = new JButton("Other Expense");
	    JButton report = new JButton("Report");
	    JButton meal = new JButton("Meal");
	    JButton addMembers = new JButton("Add Members");
	   
	    JPanel center = new JPanel();
	    center.setOpaque(false);
	    center.setLayout(gbl);
	    //gbc.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
	    //gbc.anchor = GridBagConstraints.PAGE_START;
	    gbc.fill = GridBagConstraints.BOTH;
	    //gbc.gridheight = 2;
	    //gbc.gridwidth = 2;
	    //gbc.gridx = GridBagConstraints.RELATIVE;
	    //gbc.gridy = GridBagConstraints.RELATIVE;
	    gbc.insets = new Insets(30, 10, 0, 0);
	    
	    //gbc.gridheight = GridBagConstraints.RELATIVE;
	    gbc.gridwidth = GridBagConstraints.RELATIVE;
	    
	    gbl.setConstraints(deposit, gbc);
	    
	    gbl.setConstraints(other_expense, gbc);
	    gbl.setConstraints(addMembers, gbc);
	    gbc.gridwidth= GridBagConstraints.REMAINDER;
	    gbl.setConstraints(bazarlist, gbc);
	    gbl.setConstraints(meal, gbc);
	    gbl.setConstraints(report, gbc);
	    
	   if(memberCheck.registered()){
		   center.add(deposit);
		    center.add(bazarlist);
		    center.add(meal);
		    center.add(other_expense);
		    center.add(report);
	   } else
	    center.add(addMembers);
	   
	    this.add(center,BorderLayout.CENTER);
	    
	    
	    
	    
	    deposit.addActionListener(new ActionListener() {
	    	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	welcome k = welcome.ex;
            	k.remove(welcome.body);
            	welcome.body = new depositPanel();
            	k.add(welcome.body);
            	k.refresh();
            	
            }
        });  
	    
	    
	    report.addActionListener(new ActionListener() {
	    	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	welcome k = welcome.ex;
            	k.remove(welcome.body);
            	welcome.body = new reportPanel();
            	k.add(welcome.body);
            	k.refresh();
            	
            }
        });  
	    
	    
	    
	    bazarlist.addActionListener(new ActionListener() {
	    	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	welcome k = welcome.ex;
            	k.remove(welcome.body);
            	welcome.body = new bazarlistPanel();
            	k.add(welcome.body);
            	k.refresh();
            	
            }
        });  
	    
	    
	    other_expense.addActionListener(new ActionListener() {
	    	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	welcome k = welcome.ex;
            	k.remove(welcome.body);
            	welcome.body = new otherExpensePanel();
            	k.add(welcome.body);
            	k.refresh();
            	
            }
        });  
	    
	    
	    meal.addActionListener(new ActionListener() {
	    	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	welcome k = welcome.ex;
            	k.remove(welcome.body);
            	welcome.body = new mealPanel();
            	k.add(welcome.body);
            	k.refresh();
            	
            }
        });  
	    
	    
	    
	    
	    
	    addMembers.addActionListener(new ActionListener() {
	    	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	welcome k = welcome.ex;
            	k.remove(welcome.body);
            	welcome.body = new addMemberPanel();
            	k.add(welcome.body);
            	k.refresh();
            	
            }
        });     
	    
	  }
	  
	  
	 
	  
	  
	  

	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    int imwidth = bgimage.getWidth(null);
	    int imheight = bgimage.getHeight(null);
	    //g.drawImage(bgimage, 1, 1, null);
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    g.drawImage(bgimage, 1, 1, d.width,d.height,null);
	  }
	}