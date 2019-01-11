package stermip.mess.functions;

import java.awt.Component;

import javax.swing.JOptionPane;

public class warningMsg {
	public static String msg = "";
	public static void showWarning(Component com){
		JOptionPane.showMessageDialog(com,msg);
	}
}
