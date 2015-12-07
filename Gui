import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
public class Gui {
	
	JFrame mainFrame = new JFrame("SWE");
	public Gui(){
		mainFrame.add(new TabbedPane());
		mainFrame.setVisible(true);
		mainFrame.setSize(800,500);

	}
}


class TabbedPane extends JPanel {
	static Object[][] data ;
	static String[] columnNames = {"Number",
            "File Name",
            "Publishing Date","Publisher"};
	static JTable table = new JTable(data, columnNames);
	static DefaultTableModel model = new DefaultTableModel(data, columnNames);
	static Object[][] categoryData ;
	static JTable categoryTable = new JTable();
	static DefaultTableModel categoryModel = new DefaultTableModel(categoryData,new String[] {"Category"});

    
    public TabbedPane() {
        super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent homePanel = new JPanel(new GridLayout(2,1));
        JPanel innerTopPanle = new JPanel(new FlowLayout());
        JButton browseButton = new JButton("Browse (folder)");
        // btn function 
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					Main.openChoser();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        innerTopPanle.add(browseButton);
        tabbedPane.addTab("Home",homePanel);
        JPanel innerButomPanel = new JPanel(new BorderLayout(1,0));
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        table.setModel(model);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        innerButomPanel.add(scrollPane);
        homePanel.add(innerTopPanle);
        homePanel.add(innerButomPanel);
        //// end of home page 
        JComponent refPanel = new JPanel(new FlowLayout());
        tabbedPane.addTab("Ref",refPanel);
        JComponent cardsPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Cards",cardsPanel);
        add(tabbedPane);
        
        /////start of index tab
        JPanel cardsCenter = new JPanel();
        JTextField searchBox = new JTextField();
        searchBox.setPreferredSize(new Dimension(200,30));
        cardsCenter.add(searchBox);
        JButton searchBtn = new JButton("SEARCH");
        cardsCenter.add(searchBtn,BorderLayout.CENTER);
        JPanel cardsLeft = new JPanel();
        cardsLeft.setPreferredSize(new Dimension(100,500));
        JButton addCardBtn = new JButton("ADD CARD");
        cardsLeft.add(addCardBtn);
        
        	/// start of Category Table 
        categoryTable.setPreferredScrollableViewportSize(new Dimension(100,400));
        categoryTable.setFillsViewportHeight(true);
        categoryTable.setModel(categoryModel);
        JScrollPane categoryTableScrollPane = new JScrollPane(categoryTable);
        cardsLeft.add(categoryTableScrollPane);
        	//// end of table 
        cardsPanel.add(cardsLeft,BorderLayout.WEST);
        cardsPanel.add(cardsCenter);

        
        
    }
    
   
    

}
