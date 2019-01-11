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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import stermip.mess.functions.checkPassword;
import stermip.mess.functions.managerCheck;
import stermip.mess.functions.warningMsg;

public class welcome extends JFrame /*implements MyFrame*/ {
	public static JPanel body;
	public static JPanel header;
	public static welcome ex;
    welcome() {
       setTitle("Mess Management Software");
       setLayout(new BorderLayout());
       ImageIcon img = new ImageIcon("picture//icon.png");
       this.setIconImage(img.getImage());
       
	    setBackground(Color.blue);
	    
	    header = new headerPanel();
	    add(header,BorderLayout.NORTH);
	    body = new ContentPanel();
	    add(body);
       
       
       setSize(700,700);
       
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);       
       //setResizable(false);
    }
     public static void showMe() {
       ex = new welcome();
       ex.setVisible(true);
    }
     public  void refresh() {
    	 revalidate();
    	 repaint();
	}
     
}

class headerPanel extends JPanel{
	headerPanel(){
	      BufferedImage myPicture=null;
			try {
				myPicture = ImageIO.read(new File("picture//stermipsoft.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		    setBackground(Color.BLUE);
		    setLayout(new FlowLayout(FlowLayout.RIGHT));
		    add(picLabel);
	}
	
}

 class ContentPanel extends JPanel {
	  Image bgimage = null;
	  
	  ContentPanel()  {
	    MediaTracker mt = new MediaTracker(this);
	    JButton login = new JButton("Sign in");
	    JButton signup = new JButton("Sign UP");
	    FlowLayout fll = new FlowLayout(FlowLayout.CENTER);
	    fll.addLayoutComponent("", login);
	    final JTextField pass = new JPasswordField(13);
	    Label passl= new Label("Password",Label.RIGHT);
	    GridBagLayout gbl = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(gbl);
	    gbc.anchor = GridBagConstraints.PAGE_START;
	    gbc.fill = GridBagConstraints.BOTH;
	    //gbc.gridheight = 2;
	    //gbc.gridwidth = 2;
	    gbc.gridx = GridBagConstraints.RELATIVE;
	    gbc.gridy = GridBagConstraints.RELATIVE;
	    gbc.insets = new Insets(1, 1, 0, 0);
	    
	    //gbc.ipadx = 200;
	    //gbc.ipady = 100;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	   
	    
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.gridwidth = GridBagConstraints.RELATIVE;
	    gbl.setConstraints(passl, gbc);
	    gbc.gridwidth = GridBagConstraints.RELATIVE;
	    gbl.setConstraints(pass, gbc);
	    
	    gbc.gridwidth = GridBagConstraints.RELATIVE;
	    gbl.setConstraints(login, gbc);
	    
	    
	    /**
	     * Action events
	     */
	    login.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                String passText = pass.getText();
                
                if(checkPassword.isMatched(passText)){
                	
                	welcome k = welcome.ex;
                	k.remove(welcome.body);
                	//k.remove(welcome.header);
                	//welcome.body = new signUpPanel();
                	welcome.body = new menuWindow();
                	//welcome.header = new headerPanel();
                	
                	//k.add(welcome.header);
                	k.add(welcome.body);
                	
                	k.refresh();
                	
                	
               }
                else {
                	pass.setText("");
                	warningMsg.showWarning(welcome.ex);
                }
            }
        });     
	    
	    signup.addActionListener(new ActionListener() {
	    	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	welcome k = welcome.ex;
            	k.remove(welcome.body);
            	welcome.body = new signUpPanel();
            	k.add(welcome.body);
            	k.refresh();
            }
        });     
	    if(managerCheck.isManagerFixed()){
	    	add(passl);
	 	   	add(pass);
	 	   add(login);
	    }
	    else add(signup);
	    bgimage = Toolkit.getDefaultToolkit().getImage("picture//background.png");
	    mt.addImage(bgimage, 0);
	    
	    try {
	      mt.waitForAll();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
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