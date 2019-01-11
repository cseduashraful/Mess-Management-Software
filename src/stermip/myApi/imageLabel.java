package stermip.myApi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class imageLabel {
	public static JLabel getImageLabel(String path){
		BufferedImage myPicture=null;
		try {
			myPicture = ImageIO.read(new File(path));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	    return picLabel;
	}
}
