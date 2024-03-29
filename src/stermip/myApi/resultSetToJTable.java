package stermip.myApi;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class resultSetToJTable {
	 //TableModel model = new DefaultTableModel() 
	
	
	
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
    throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
		    Vector<Object> vector = new Vector<Object>();
		    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		        vector.add(rs.getObject(columnIndex));
		    }
		    data.add(vector);
		}

		return new DefaultTableModel(data, columnNames){
		      public boolean isCellEditable(int rowIndex, int mColIndex) {
			        return false;
			      }
			    };

	}
	
	public static JTable getJTable(ResultSet rs){
		try{
			return new JTable(buildTableModel(rs));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}
