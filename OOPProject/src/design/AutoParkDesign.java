package design;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class AutoParkDesign {

	private JFrame frame;
	private JTextField textField;
	private JTextField enterDateText;
	private JTextField exitDateText;
	private JTextField enterTimeText;
	private JTextField exitTimeText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoParkDesign window = new AutoParkDesign();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AutoParkDesign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1037, 809);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel carPlateLabel = new JLabel("Car Plate-->");
		carPlateLabel.setBounds(10, 11, 77, 14);
		frame.getContentPane().add(carPlateLabel);
		
		textField = new JTextField();
		textField.setBounds(84, 8, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel teslaLabel = new JLabel("Tesla Car");
		teslaLabel.setBounds(220, 40, 175, 175);
		frame.getContentPane().add(teslaLabel);
		Image teslaImage = new ImageIcon(this.getClass().getResource("/tesla.png")).getImage();
		teslaLabel.setIcon(new ImageIcon(teslaImage));
		frame.getContentPane().add(teslaLabel);
		
		JLabel policeLabel = new JLabel("Police Car");
		policeLabel.setBounds(395, 40, 175, 175);
		frame.getContentPane().add(policeLabel);
		Image policeImage = new ImageIcon(this.getClass().getResource("/police.png")).getImage();
		policeLabel.setIcon(new ImageIcon(policeImage));
		frame.getContentPane().add(policeLabel);
		
		
		JLabel subscribedLabel = new JLabel("Subscribed Vehicle");
		subscribedLabel.setBounds(570, 40, 175, 175);
		frame.getContentPane().add(subscribedLabel);
		Image subscribedImage = new ImageIcon(this.getClass().getResource("/subscribed.png")).getImage();
		subscribedLabel.setIcon(new ImageIcon(subscribedImage));
		frame.getContentPane().add(subscribedLabel);
		
		JCheckBox regularCheck = new JCheckBox("Regular Vehicle");
		regularCheck.setBounds(220, 7, 125, 23);
		frame.getContentPane().add(regularCheck);
		
		JCheckBox officialCheck = new JCheckBox("Official Vehicle");
		officialCheck.setBounds(395, 7, 97, 23);
		frame.getContentPane().add(officialCheck);
		
		JCheckBox subscribedCheck = new JCheckBox("Subscribed Vehicle");
		subscribedCheck.setBounds(570, 7, 134, 23);
		frame.getContentPane().add(subscribedCheck);
		buttonGroup.add(regularCheck);
		buttonGroup.add(officialCheck);
		buttonGroup.add(subscribedCheck);
		
		JLabel lblNewLabel = new JLabel("Slot1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 260, 175, 175);
		frame.getContentPane().add(lblNewLabel);
		
		JButton exit1 = new JButton("Exit");
		exit1.setBounds(40, 446, 90, 30);
		frame.getContentPane().add(exit1);
		
		JLabel enterDateLabel = new JLabel("Enter Date-->");
		enterDateLabel.setBounds(10, 40, 77, 14);
		frame.getContentPane().add(enterDateLabel);
		
		enterDateText = new JTextField();
		enterDateText.setColumns(10);
		enterDateText.setBounds(84, 40, 100, 20);
		frame.getContentPane().add(enterDateText);
		
		JLabel exitDateLabel = new JLabel("Exit Date-->");
		exitDateLabel.setBounds(10, 72, 77, 14);
		frame.getContentPane().add(exitDateLabel);
		
		exitDateText = new JTextField();
		exitDateText.setColumns(10);
		exitDateText.setBounds(84, 72, 100, 20);
		frame.getContentPane().add(exitDateText);
		
		JLabel enterTimeLabel = new JLabel("Enter Time-->");
		enterTimeLabel.setBounds(10, 104, 77, 14);
		frame.getContentPane().add(enterTimeLabel);
		
		enterTimeText = new JTextField();
		enterTimeText.setColumns(10);
		enterTimeText.setBounds(84, 104, 100, 20);
		frame.getContentPane().add(enterTimeText);
		
		JLabel exitTimeLabel = new JLabel("Exit Time-->");
		exitTimeLabel.setBounds(10, 136, 77, 14);
		frame.getContentPane().add(exitTimeLabel);
		
		exitTimeText = new JTextField();
		exitTimeText.setColumns(10);
		exitTimeText.setBounds(84, 136, 100, 20);
		frame.getContentPane().add(exitTimeText);
		
		
		JButton enterButton = new JButton("Enter Vehicle");
		enterButton.setBounds(783, 130, 175, 85);
		frame.getContentPane().add(enterButton);
		
		JTextArea warningText = new JTextArea();

		warningText.setForeground(new Color(255, 0, 0));
		warningText.setFont(new Font("Arial", Font.BOLD, 16));
		warningText.setLineWrap(true);
		warningText.setText("To make proper adding progress,you must add car plate, enter/exit date, enter/exit time and type of vehicle.");
		
		warningText.setBounds(783, 0, 175, 118);
		frame.getContentPane().add(warningText);
		Image otoparkImage = new ImageIcon(this.getClass().getResource("/otoparkNumaralý.png")).getImage();
	}
}
