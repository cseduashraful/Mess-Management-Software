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

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



import stermip.mess.functions.managerCheck;

import stermip.mess.report.bazar;
import stermip.mess.report.manager;
import stermip.mess.report.meal;
import stermip.mess.report.member;
import stermip.mess.report.memberHistory;
import stermip.myApi.doubleFormat;
import stermip.myApi.imageLabel;

public class reportPanel extends JPanel {
	Image bgimage = null;
	reportPanel(){
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
		    
		    JLabel picLabel = imageLabel.getImageLabel("picture//report.png");
		    JPanel north = new JPanel();
		    north.add(picLabel);
		    north.setOpaque(false);
		    this.add(north, BorderLayout.NORTH);
		    
		    
		    manager man = managerCheck.getManager();
		    double totalBazar = bazar.getTotalBazar();
		    double totalMeal=meal.getTotalMeal();
		    double mealRate = totalBazar/totalMeal;
		    double otherExpense=stermip.mess.report.otherExpense.getTotalOtherExpense();
		    ArrayList<member>members = memberHistory.getMemberHistory();
		    int nom = members.size();
		    
		    JPanel center = new JPanel();
		    GridBagLayout gbl = new GridBagLayout();
		    GridBagConstraints gbc = new GridBagConstraints();
		    center.setLayout(gbl);  
		    gbc.fill = GridBagConstraints.BOTH; 
		    gbc.insets = new Insets(10, 1, 0, 0);
		    
		    JLabel time1 = new JLabel("Management Period:");
		    JLabel time2 = new JLabel(""+man.getMonth()+","+man.getYear());
		    
		    JLabel mang1 = new JLabel("Manager:");
		    JLabel mang2 = new JLabel(""+man.getName());
		    
		    
		   JLabel totalBazar1 = new JLabel("Total Bazar:");
		   JLabel totalBazar2 = new JLabel(""+totalBazar);
		   JLabel totalMeal1 = new JLabel("Total Meal:");
		   JLabel totalMeal2 = new JLabel(""+totalMeal);
		   JLabel mRate1 = new JLabel("Meal Rate:");
		   JLabel mRate2 = new JLabel(""+mealRate);
		   JLabel oExpense1 = new JLabel("Other Expense:");
		   JLabel oExpense2 = new JLabel(""+otherExpense);
		   
		   gbc.gridwidth = GridBagConstraints.RELATIVE;
		   gbl.setConstraints(oExpense1, gbc);
		   gbl.setConstraints(mRate1, gbc);
		   gbl.setConstraints(totalMeal1, gbc);
		   gbl.setConstraints(totalBazar1, gbc);
		   gbl.setConstraints(time1, gbc);
		   gbl.setConstraints(mang1, gbc);
		   
		   
		   gbc.gridwidth = GridBagConstraints.REMAINDER;
		   gbl.setConstraints(oExpense2, gbc);
		   gbl.setConstraints(mRate2, gbc);
		   gbl.setConstraints(totalMeal2, gbc);
		   gbl.setConstraints(totalBazar2, gbc);
		   gbl.setConstraints(time2, gbc);
		   gbl.setConstraints(mang2, gbc);
		   
		   
		   center.add(time1);
		   center.add(time2);
		   center.add(mang1);
		   center.add(mang2);
		   center.add(totalBazar1);
		   center.add(totalBazar2);
		   center.add(totalMeal1);
		   center.add(totalMeal2);
		   center.add(mRate1);
		   center.add(mRate2);
		   center.add(oExpense1);
		   center.add(oExpense2);
		   center.setOpaque(false);
		   
		   

		   
		   Object columnNames[] = { "Name", "Deposit", "Meal", "Meal Cost", "Total Cost","Balance" };
		 
		   String rowData[][] = new String[nom+1][];
		   double tD=0,tM=0,tMC=0,tTC=0,tB=0;
		   for(int i=0;i<nom;i++){
			   double depositD=members.get(i).getTotalDeposit();
			   tD+=depositD;
			   double totalMealD=members.get(i).getTotalMeal();
			   tM+=totalMealD;
			   double mCostD = doubleFormat.transform(totalMealD*mealRate, 2);
			   tMC+=mCostD;
			   double tCostD = doubleFormat.transform(mCostD+(otherExpense/nom), 2);
			   tTC+=tCostD;
			   double balanceD= depositD-tCostD;
			   
			   rowData[i] = new String[6];
			   rowData[i][0]=members.get(i).getName();
			   rowData[i][1]=""+depositD;
			   rowData[i][2]=totalMealD+"";
			   rowData[i][3]=mCostD+"";
			   rowData[i][4]=tCostD+"";
			   rowData[i][5]=balanceD+"";
			   
		   }
		   int i=nom;
		   rowData[i] = new String[6];
		   rowData[i][0]="TOTAL";
		   rowData[i][1]=""+tD;
		   rowData[i][2]=tM+"";
		   rowData[i][3]=tMC+"";
		   rowData[i][4]=tTC+"";
		   rowData[i][5]=(tD-tTC)+"";
		   JTable table = new JTable(rowData, columnNames);
		  
		   JScrollPane scrollPane = new JScrollPane(table);
		   scrollPane.setPreferredSize(new  Dimension(500, 200));
		   JPanel center2 = new JPanel();
		   center2.add(scrollPane);
		   center2.setOpaque(false);
		   
		   
		   
		   
		   
		   JPanel flow = new JPanel();
		   flow.setLayout(new BorderLayout());
		   flow.setOpaque(false);
		   flow.add(center,BorderLayout.NORTH);
		   flow.add(center2,BorderLayout.CENTER);
		   
		   
		   
		   
		   
		   
		    

		    
		    //center.add(new JButton("what"));
		    this.add(flow,BorderLayout.CENTER);
		    JPanel south = new JPanel();
		  
		    JButton back = new JButton("Back to Menu");
		 
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
		    
		    
		    
		    
	}
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    int imwidth = bgimage.getWidth(null);
	    int imheight = bgimage.getHeight(null);
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    g.drawImage(bgimage, 1, 1, d.width,d.height,null);
	  }
}
