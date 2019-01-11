package stermip.mess;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;


import stermip.mess.functions.getResultSet;

import stermip.myApi.imageLabel;
import stermip.myApi.resultSetToJTable;

public class viewMealPanel extends JPanel {
	Image bgimage = null;
	viewMealPanel(){
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
		
		    JLabel picLabel = imageLabel.getImageLabel("picture//meal.png");
		    JPanel north = new JPanel();
		    north.add(picLabel);
		    north.setOpaque(false);
		    this.add(north, BorderLayout.NORTH);
		    
		    
		    	ResultSet rs = getResultSet.executeQuery("SELECT date,name,mealCount FROM meals order by date");
		    	final JTable table = resultSetToJTable.getJTable(rs);
		    	//JOptionPane.showMessageDialog(null, new JScrollPane(table));
		    	JPanel jpl = new JPanel();
		    	jpl.add(new JScrollPane(table));
		    	jpl.setOpaque(false);
		    	this.add(jpl, BorderLayout.CENTER);
		    
		    
		    
		    
		    
		    JPanel south = new JPanel();
		    JButton back = new JButton("Back to Menu");
		    JButton edit = new JButton("Edit");
		    south.add(back);
		    south.add(edit);
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
		    
		    edit.addActionListener(new ActionListener() {
		    	 
	            public void actionPerformed(ActionEvent e)
	            {
	                
	            		int row = table.getSelectedRow();
	            		int date = Integer.parseInt(table.getValueAt(row, 0).toString());
	            		String name = table.getValueAt(row, 1).toString();
	            		String val = JOptionPane.showInputDialog("Name:"+name+"\nDate:"+date+"\nEnter Meal");
	            		if(val!=null){
	            			try{
		            			double d = Double.parseDouble(val);
		            			String update = "update meals set mealCount="+d+" where date="+date+" and name='"+name+"'"; 
		            			getResultSet.updateQuery(update);
		            		}catch(Exception ee){
		            			JOptionPane.showMessageDialog(null, ee);
		            		}
	            		}
	            		
	            	
	            		welcome k = welcome.ex;
		            	k.remove(welcome.body);
		            	welcome.body = new viewMealPanel();
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
