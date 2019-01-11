package stermip.mess;

import java.awt.BorderLayout;
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

import javax.swing.*;

import stermip.mess.functions.memberCheck;
import stermip.mess.functions.registerMember;
import stermip.myApi.imageLabel;

public class addMemberPanel  extends JPanel{
	Image bgimage = null;
	  
	addMemberPanel()  {
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
		    JLabel picLabel = imageLabel.getImageLabel("picture//enterMemberName.png");
		    this.add(picLabel, BorderLayout.NORTH);
		    
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
		    final int nom = memberCheck.getMemberCount(); 
		    final JTextField[] memberList = new JTextField [nom];
		    for(int i=0;i<nom;i++){
		    	memberList[i] = new JTextField(25);
		    	gbl.setConstraints(memberList[i], gbc);
		    	center.add(memberList[i]);
		    }
		    center.setOpaque(false);
		    this.add(center,BorderLayout.CENTER);
		    JPanel south = new JPanel();
		    JButton confirm = new JButton("OK");
		    JButton back = new JButton("cancel");
		    south.add(confirm);
		    south.add(back);
		    south.setOpaque(false);
		    this.add(south, BorderLayout.SOUTH);
		    
		    
		    
		    
		    
		    confirm.addActionListener(new ActionListener() {
		    	 
	            public void actionPerformed(ActionEvent e)
	            {
	                
	            	boolean isDone  = registerMember.register(memberList,nom);
	            	//Execute when button is pressed
	            	if(isDone){
	            		
	            		welcome k = welcome.ex;
		            	k.remove(welcome.body);
		            	welcome.body = new menuWindow();
		            	k.add(welcome.body);
		            	k.refresh();
	            	}
	            }
	        });   
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
		    
		    
	  }
	 protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    //int scrWidth = 
		    int imwidth = bgimage.getWidth(null);
		    int imheight = bgimage.getHeight(null);
		    Toolkit tk = Toolkit.getDefaultToolkit();
		    Dimension d = tk.getScreenSize();
		    g.drawImage(bgimage, 1, 1, d.width,d.height,null);
		    //g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
		  }
}
