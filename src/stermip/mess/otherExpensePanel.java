package stermip.mess;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import stermip.mess.functions.otherExpenseCheck;
import stermip.mess.functions.managerCheck;
import stermip.mess.functions.memberCheck;
import stermip.myApi.imageLabel;

public class otherExpensePanel extends JPanel {
	Image bgimage = null;
	otherExpensePanel(){
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
		    JLabel picLabel = imageLabel.getImageLabel("picture//otherExpense.png");
		    
		    JPanel north = new JPanel();
		    north.add(picLabel);
		    JPanel nb= new JPanel(new BorderLayout());
		    nb.add(north,BorderLayout.NORTH);
		    JButton view = new JButton("Previous Records");
		    JPanel bb = new JPanel();
		    bb.add(view);
		    bb.setOpaque(false);
		    nb.add(bb,BorderLayout.SOUTH);
		    nb.setOpaque(false);
		    north.setOpaque(false);
		    this.add(nb, BorderLayout.NORTH);
		    
		    
		    
		    JPanel center = new JPanel();
		    GridBagLayout gbl = new GridBagLayout();
		    GridBagConstraints gbc = new GridBagConstraints();
		    center.setLayout(gbl);
		    gbc.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		    //gbc.anchor = GridBagConstraints.PAGE_START;
		    gbc.fill = GridBagConstraints.BOTH;
		    //gbc.gridheight = 2;
		    //gbc.gridwidth = 2;
		    gbc.gridx = GridBagConstraints.RELATIVE;
		    gbc.gridy = GridBagConstraints.RELATIVE;
		    gbc.insets = new Insets(10, 1, 0, 0);
		    gbc.gridheight = GridBagConstraints.RELATIVE;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    
		    final JTextField memberChoice = new JTextField(20);
		    
		    final JTextField amountTf=new JTextField(20);
		    final Choice dateChoice = new Choice();
		    int dateCount = managerCheck.getNumberOfDays();
		    for(int i=1;i<=dateCount;i++){
		    	dateChoice.add(""+i);
		    }
		    
		    
		    gbl.setConstraints(memberChoice, gbc);
		    gbl.setConstraints(amountTf, gbc);
		    gbl.setConstraints(dateChoice, gbc);
		    
		    gbc.gridwidth = GridBagConstraints.RELATIVE;
		    JLabel memberLabel = new JLabel("Name of cost");
		    JLabel amountLabel = new JLabel("Amount in Tk");
		    JLabel dateLabel = new JLabel("Date");
		    gbl.setConstraints(memberLabel, gbc);
		    gbl.setConstraints(amountLabel, gbc);
		    gbl.setConstraints(dateLabel, gbc);
		    center.add(memberLabel);
		    center.add(memberChoice);
		    center.add(amountLabel);
		    center.add(amountTf);
		    center.add(dateLabel);
		    center.add(dateChoice);
		    center.setOpaque(false);
		    this.add(center,BorderLayout.CENTER);
		    JPanel south = new JPanel();
		    JButton confirm = new JButton("OK");
		    JButton back = new JButton("cancel");
		    south.add(confirm);
		    south.add(back);
		    south.setOpaque(false);
		    this.add(south, BorderLayout.SOUTH);
		    
		    back.addActionListener(new ActionListener() {
		    	 
	            public void actionPerformed(ActionEvent e)
	            {
	                
	            	
	            		welcome k = welcome.ex;
		            	k.remove(welcome.body);
		            	welcome.body = new menuWindow();
		            	k.add(welcome.body);
		            	k.refresh();
	            }
	        });     
		    
		    
		    confirm.addActionListener(new ActionListener() {
		    	 
	            public void actionPerformed(ActionEvent e)
	            {
	                	if(otherExpenseCheck.performInsertion(memberChoice,dateChoice,amountTf)){
	                		welcome k = welcome.ex;
			            	k.remove(welcome.body);
			            	welcome.body = new menuWindow();
			            	k.add(welcome.body);
			            	k.refresh();
	                	}else{
	                		welcome k = welcome.ex;
			            	k.remove(welcome.body);
			            	welcome.body = new otherExpensePanel();
			            	k.add(welcome.body);
			            	k.refresh();
	                	}
	            		
	            }
	        });     
		    view.addActionListener(new ActionListener() {
		    	 
	            public void actionPerformed(ActionEvent e)
	            {
	                
	            	
	            		welcome k = welcome.ex;
		            	k.remove(welcome.body);
		            	welcome.body = new viewOtherExpensePanel();
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
