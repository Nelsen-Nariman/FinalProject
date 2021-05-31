package GUI;

import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Model.Menu;

public class Form extends JPanel {
//	Random random = new Random();
	
	private JPanel panel1, panel2, panel3, panel4;

	private JTextField namaText, hargaText, stokText;

//	private JRadioButton maleRadio, femaleRadio;
//
//	private ButtonGroup genderGroup;
//
//	private JComboBox ageCombo;
//
//	private JCheckBox clingyChx, noisyChx, adventureChx, foodyChx;

	public Form() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		panel1 = createPanel();
		panel2 = createPanel();
		panel3 = createPanel();
//		panel4 = createPanel();

		// panel1

		namaText = new JTextField(20);
//				descText = new JTextArea(2, 20);

		panel1.add(new JLabel("Nama Menu"));
		panel1.add(namaText);
//				panel1.add(descText);

		// panel2
		
		hargaText = new JTextField(20);
		panel2.add(new JLabel("Harga Menu"));
		panel2.add(hargaText);

//		maleRadio = new JRadioButton("Male");
//		femaleRadio = new JRadioButton("Female");
//
//		maleRadio.setActionCommand("Male");
//		femaleRadio.setActionCommand("Female");
//
//		panel2.add(new JLabel("Gender"));
//		panel2.add(maleRadio);
//		panel2.add(femaleRadio);
//
//		genderGroup = new ButtonGroup();
//		genderGroup.add(maleRadio);
//		genderGroup.add(femaleRadio);

		// panel3
		
		stokText = new JTextField(20);
		panel3.add(new JLabel("Stok Menu"));
		panel3.add(stokText);

//		Integer[] ageData = { 1, 3, 5, 5, 7, 8 };
//
//		ageCombo = new JComboBox(ageData);
//
//		panel3.add(new JLabel("Age"));
//		panel3.add(ageCombo);

		// panel4

//		clingyChx = new JCheckBox("Clingy");
//		noisyChx = new JCheckBox("Noisy");
//		adventureChx = new JCheckBox("Adventure");
//		foodyChx = new JCheckBox("Foody");

//		panel4.add(new JLabel("Traits"));
//		panel4.add(clingyChx);
//		panel4.add(noisyChx);
//		panel4.add(adventureChx);
//		panel4.add(foodyChx);

		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
//		this.add(panel4);

	}

	public void clearForm() {

		namaText.setText("");
		hargaText.setText("");
		stokText.setText("");

//		noisyChx.setSelected(false);
//		adventureChx.setSelected(false);
//		foodyChx.setSelected(false);
//		clingyChx.setSelected(false);

//		genderGroup.clearSelection();
//
//		ageCombo.setSelectedIndex(0);

	}

	public Menu getNewMenu() {
		boolean valid = true;

		String nama = namaText.getText();
		if (nama.trim().isEmpty()) {
			valid = false;
		}
		
		String harga = hargaText.getText();
		if (harga.trim().isEmpty()) {
			valid = false;
		}
		
		String stok = stokText.getText();
		if (stok.trim().isEmpty()) {
			valid = false;
		}

//		String gender = "";
//
//		if (genderGroup.getSelection() == null) {
//			valid = false;
//		} else {
//			gender = genderGroup.getSelection().getActionCommand();
//		}
//
//		int age = (int) ageCombo.getSelectedItem();
//
//		String traits = "";
//
//		if (!noisyChx.isSelected() && !adventureChx.isSelected() && !foodyChx.isSelected() && !clingyChx.isSelected()) {
//			valid = false;
//		} else {
//
//			if (noisyChx.isSelected()) {
//				traits += noisyChx.getText() + ",";
//			}
//
//			if (adventureChx.isSelected()) {
//				traits += adventureChx.getText() + ",";
//			}
//
//			if (clingyChx.isSelected()) {
//				traits += clingyChx.getText() + ",";
//			}
//
//			if (foodyChx.isSelected()) {
//				traits += foodyChx.getText() + ",";
//			}
//
//			traits = traits.substring(0, traits.length() - 1); // utk hapus koma diakhir
//		}

		if (valid) {
//			String kode = "BC-";
//			for(int idx=0; idx<3; idx++) {
//				kode+=random.nextInt(10);
//			}
			return new Menu(nama, harga, stok); //kode
		} else {
			return null;
		}
	}

	private JPanel createPanel() {
		return new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 10));
	}

	public JTextField getNamaText() {
		return namaText;
	}
	
	public JTextField getHargaText() {
		return hargaText;
	}
	
	public JTextField getStokText() {
		return stokText;
	}

//	public JRadioButton getMaleRadio() {
//		return maleRadio;
//	}
//
//	public JRadioButton getFemaleRadio() {
//		return femaleRadio;
//	}
//
//	public ButtonGroup getGenderGroup() {
//		return genderGroup;
//	}
//
//	public JComboBox getAgeCombo() {
//		return ageCombo;
//	}
//
//	public JCheckBox getClingyChx() {
//		return clingyChx;
//	}
//
//	public JCheckBox getNoisyChx() {
//		return noisyChx;
//	}
//
//	public JCheckBox getAdventureChx() {
//		return adventureChx;
//	}
//
//	public JCheckBox getFoodyChx() {
//		return foodyChx;
//	}

}
