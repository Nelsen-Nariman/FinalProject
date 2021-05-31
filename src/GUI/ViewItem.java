package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.MenuDAO;

public class ViewItem extends JFrame implements ActionListener, MouseListener{

	private JTable table;
	
	private JScrollPane scroll;
	
//	private Form form;
	
	private JButton backBtn;
	
	private MenuDAO dao;
	
//	private JPopupMenu popUp;
	
	private DefaultTableModel model ;
	
	private Vector<String> titleColumn ;
	
	public ViewItem() {
		dao = new MenuDAO();
//		form = new Form();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		initTable();
//		this.add(form);
		
		initButton();
		
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initButton() {
		
		backBtn = new JButton("Back");
//		updateBtn = new JButton("Update");
//		discardBtn  = new JButton("Discard Change");
//		
		backBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout());
		
		panel.add(backBtn);
		panel.add(Box.createHorizontalStrut(100));
//		panel.add(updateBtn);
//		panel.add(discardBtn);
		
		
		this.add(panel);
	}
	
	private void initTable() {
		
		titleColumn = new Vector<String>();
		titleColumn.add("Kode");
		titleColumn.add("Nama");
		titleColumn.add("Harga");
		titleColumn.add("Stok");
		
//		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
//		Vector<String> sub1 = new Vector<String>();
//		sub1.add("Kucing Super");
//		sub1.add("Male");
//		sub1.add("5");
//		sub1.add("Foody, Clingy");
//		Vector<String> sub2 = new Vector<String>();
//		sub2.add("Kucing Tidak");
//		sub2.add("Female");
//		sub2.add("10");
//		sub2.add("Adventure, Foody");
		
//		data.add(sub1);
//		data.add(sub2);
//		
//		popUp = new JPopupMenu();
//		deleteBtn = new JButton("Delete");
		
//		deleteBtn.addActionListener(this);
		
//		popUp.add(deleteBtn);
		
		model = new DefaultTableModel(dao.getMenus(), titleColumn) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		
//		table.setComponentPopupMenu(popUp);
		
		table.addMouseListener(this);
		
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			new Home();
			this.dispose();
		}
//		else if(e.getSource() == deleteBtn) {
//			
//			int r = table.getSelectedRow();
//			
//			String id = table.getValueAt(r, 0).toString();
//			
//			dao.delete(id);
//			
//			JOptionPane.showMessageDialog(null, "Success to delete "+ id);
//		
//			model.setDataVector(dao.getMenus(), titleColumn);
//		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("mouse clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("mouse pressed");
		
		int r = table.rowAtPoint(e.getPoint()); //utk ngambil index baris dari table yang diklik
		
		if(r>=0 && r< table.getRowCount()) { // cek apakah si 'r' itu dicakupan baris
			table.setRowSelectionInterval(r, r); // nambah seleksi di baris r			
		}else {
			table.clearSelection(); //hapus seleksi
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

