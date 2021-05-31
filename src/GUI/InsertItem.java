package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dao.MenuDAO;
import Model.Menu;

public class InsertItem extends JFrame implements ActionListener{

	private JPanel panel5;
	
	private JButton cancelBtn , addBtn;
	
	private Form form;
//	private JTextArea descText;
	
	private MenuDAO dao;
	
	public InsertItem() {
		dao = new MenuDAO();
		form = new Form();
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		
		panel5 = new JPanel(new FlowLayout(FlowLayout.TRAILING, 20, 10));
		
		//panel5
		
		cancelBtn = new JButton("Cancel");
		addBtn = new JButton("Add");
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		panel5.add(cancelBtn);
		panel5.add(addBtn);
		
		this.add(form);
		this.add(panel5);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn) {
			new Home();
			this.dispose();
		}else if(e.getSource()== addBtn) {
			
			Menu newMenu = form.getNewMenu();
			
			if(newMenu == null) {
				JOptionPane.showMessageDialog(null, "Error!!!\nAll the field must be fill!");
			}else {
				
				dao.insert(newMenu);
				
				JOptionPane.showMessageDialog(null, "Success to add "+ newMenu.getNama() + " !");
				
				form.clearForm();
				
			}
			
		}
		
	}
	
}