package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Home extends JFrame implements ActionListener {

	private JLabel label1;

	private JMenuBar menuBar;
	
	private JMenuItem insertmenubaru , viewMenu, updateMenu, deleteMenu;
	
//	private JMenuItem kodeMenu, namaMenu, hargaMenu, stokMenu, deletedMenu;
	
	public Home() {
		// JFrame
//		JFrame frame = new JFrame();
//		frame.setVisible(true);
		// JLabel bisa nyimpan tulisan atau gambar

//		this.setLayout(new FlowLayout(FlowLayout.TRAILING));

		initMenuBar();
		
//		label1.setIcon(image);
		ImageIcon image = new ImageIcon("icon.png");
		this.setIconImage(image.getImage());
		
		
		initLabel();

//		this.add(new JLabel("test 1 "));
//		this.add(new JLabel("test 2 "));
//		this.add(new JLabel("test 3 "));
//		this.add(new JLabel("test 4 "));
//		this.add(new JLabel("test 5 "));
//		this.add(new JLabel("test 6 "));
//		this.add(new JLabel("test 7 "));
//		this.add(new JLabel("test 8 "));
//		this.add(new JLabel("label east"), BorderLayout.EAST);
//		this.add(new JLabel("label north"), BorderLayout.NORTH);
//		this.add(new JLabel("label south"), BorderLayout.SOUTH);
//		this.add(new JLabel("label west"), BorderLayout.WEST);
		this.setTitle("BobaCool");
//		this.setSize(500, 500);
		this.pack(); // supaya size nya sesuai dengan isi didalam
		this.setLocationRelativeTo(null); // supaya posisi window berada di tengah
		this.setResizable(false);
//		this.setSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // munculin , biar nampak

		// default layout -> BorderLayout
	}

	private void initLabel() {
		label1 = new JLabel();

		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalTextPosition(JLabel.TOP);
		label1.setText("BobaCool");

		label1.setForeground(new Color(0, 0, 255));
		label1.setFont(new Font("Chiller", Font.ITALIC, 100));
		label1.setBackground(Color.white);
		label1.setOpaque(true);

		try {
			Image image2 = ImageIO.read(new File("icon.png"));
			Image image3 = image2.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(image3);
			label1.setIcon(icon);
		} catch (IOException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.add(label1);
	}

	private void initMenuBar() {

		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		insertmenubaru = new JMenuItem("Insert");
		viewMenu = new JMenuItem("View");
		updateMenu = new JMenuItem("Update");
		deleteMenu = new JMenuItem("Delete");
		
//		kodeMenu = new JMenuItem("Kode Menu");
//		viewItem = new JMenuItem("View Pets");
//		exitItem = new JMenuItem("Exit");
//		aboutItem = new JMenuItem("About");
		
//		exitItem.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
		
		insertmenubaru.addActionListener(this);
		viewMenu.addActionListener(this);
		updateMenu.addActionListener(this);
		deleteMenu.addActionListener(this);
//		JMenu test = new JMenu("Test");
//		test.add(new JMenuItem("Test1"));
//		test.add(new JMenuItem("Test2"));
		
//		menuHome.add(test);
		
//		menuHome.add(addItem);
//		menuHome.add(viewItem);
//		menuHome.add(exitItem);
//		
//		menuHelp.add(aboutItem);
		
		menuBar.add(insertmenubaru);
		menuBar.add(viewMenu);
		menuBar.add(updateMenu);
		menuBar.add(deleteMenu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == insertmenubaru) {
			new InsertItem();
			this.dispose();
		}else if(e.getSource() == viewMenu) {
			new ViewItem();
			this.dispose(); //biar yg di home ke close
		}else if(e.getSource() == updateMenu) {
			new UpdateItem();
			this.dispose();
		}else if(e.getSource() == deleteMenu) {
			new DeleteItem();
			this.dispose(); //biar yg di home ke close
		}
		
	}
}

