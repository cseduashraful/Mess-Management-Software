package stermip.mess;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import stermip.mess.functions.signupFunc;
import stermip.mess.functions.warningMsg;
import stermip.myApi.imageLabel;

public class signUpPanel extends JPanel{
	Image bgimage = null;
	  
	  signUpPanel()  {
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
		    JLabel picLabel = imageLabel.getImageLabel("picture//signup.png");
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
		    gbc.insets = new Insets(1, 1, 0, 0);
		    
		    gbc.gridheight = GridBagConstraints.RELATIVE;
		    gbc.gridwidth = GridBagConstraints.RELATIVE;
		    JLabel yourNamePic = imageLabel.getImageLabel("picture//yourName.png");
		    JLabel passwordPic = imageLabel.getImageLabel("picture//password.png");
		    JLabel confirmPasswordPic = imageLabel.getImageLabel("picture//confirmPassword.png");
		    JLabel monthOfManagementPic = imageLabel.getImageLabel("picture//monthOfManagement.png");
		    JLabel yearOfManagementPic = imageLabel.getImageLabel("picture//yearOfManagement.png");
		    JLabel numberOfMembersPic = imageLabel.getImageLabel("picture//numberOfMembers.png");
		    
		    gbl.setConstraints(yourNamePic, gbc);		   
		    gbl.setConstraints(passwordPic, gbc);
		    gbl.setConstraints(confirmPasswordPic, gbc);
		    gbl.setConstraints(monthOfManagementPic, gbc);
		    gbl.setConstraints(yearOfManagementPic, gbc);
		    gbl.setConstraints(numberOfMembersPic, gbc);
		    
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    final JTextField yourName = new JTextField(20);
		    final JPasswordField password = new JPasswordField(20);
		    final  JPasswordField confirmPassword = new JPasswordField(20);
		    final Choice monthOfManagement = new Choice();
		    monthOfManagement.add("January");
		    monthOfManagement.add("February");
		    monthOfManagement.add("March");
		    monthOfManagement.add("April");
		    monthOfManagement.add("May");
		    monthOfManagement.add("June");
		    monthOfManagement.add("July");
		    monthOfManagement.add("August");
		    monthOfManagement.add("September");
		    monthOfManagement.add("October");
		    monthOfManagement.add("November");
		    monthOfManagement.add("December");
		    final JTextField yearOfManagement = new JTextField(20);
		    final JTextField nubmerOfMembers = new JTextField(20);
		    
		    
		    gbl.setConstraints(yourName, gbc);
		    gbl.setConstraints(password, gbc);
		    gbl.setConstraints(confirmPassword, gbc);
		    gbl.setConstraints(monthOfManagement, gbc);
		    gbl.setConstraints(yearOfManagement, gbc);
		    gbl.setConstraints(nubmerOfMembers, gbc);
		    
		    center.add(yourNamePic);
		    center.add(yourName);
		    center.add(passwordPic);
		    center.add(password);
		    center.add(confirmPasswordPic);
		    center.add(confirmPassword);
		    center.add(monthOfManagementPic);
		    center.add(monthOfManagement);
		    center.add(yearOfManagementPic);
		    center.add(yearOfManagement);
		    center.add(numberOfMembersPic);
		    center.add(nubmerOfMembers);
		    
		    
		    JButton confirmReg = new JButton("Confirm");
		    JButton backToWelcome = new JButton("Back");
		    JPanel south = new JPanel();
		    south.setLayout(new FlowLayout(FlowLayout.CENTER));
		    south.add(backToWelcome);
		    south.add(confirmReg);
		    south.setOpaque(false);
		    add(south,BorderLayout.SOUTH);
		    //center.add();
		    
		    
		    center.setOpaque(false);
		    this.add(center,BorderLayout.CENTER);
		    
		    backToWelcome.addActionListener(new ActionListener() {
		    	 
	            public void actionPerformed(ActionEvent e)
	            {
	                
	            	
	            	//Execute when button is pressed
	            	welcome k = welcome.ex;
	            	k.remove(welcome.body);
	            	welcome.body = new ContentPanel();
	            	k.add(welcome.body);
	            	k.refresh();
	            }
	        });     
		    
		    confirmReg.addActionListener(new ActionListener() {
		    	 
	            public void actionPerformed(ActionEvent e)
	            {
	                //Execute when button is pressed
	            	boolean signupDone = signupFunc.signupProcess(yourName.getText(),password.getText(),confirmPassword.getText(),monthOfManagement.getSelectedItem(),yearOfManagement.getText(),nubmerOfMembers.getText() );
	            	
	            	
	            	
	            	if(signupDone){
	            		welcome k = welcome.ex;
		            	k.remove(welcome.body);
		            	welcome.body = new ContentPanel();
		            	k.add(welcome.body);
		            	k.refresh();
	            	}else{
	            		warningMsg.showWarning(welcome.body);
	            	}
	            	
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
