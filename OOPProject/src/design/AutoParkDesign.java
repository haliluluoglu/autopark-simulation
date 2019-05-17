package design;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import oop.AutoPark;
import oop.Date;
import oop.OfficialVehicle;
import oop.RegularVehicle;
import oop.SubscribedVehicle;
import oop.Subscription;
import oop.Time;

import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class AutoParkDesign {

	private JFrame frame;
	private JTextField carPlateText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private boolean[] labelEmpty = new boolean[5];

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
		Arrays.fill(labelEmpty, false);
		initialize();
	}
	
	public boolean getLabelEmpty(int i) {
		return labelEmpty[i];
	}

	public void setLabelEmpty(int i,boolean bool) {
		this.labelEmpty[i] = bool;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Halil Ýbrahim Uluoðlu");
		frame.setBounds(600, 100, 1037, 809);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel carPlateLabel = new JLabel("Car Plate-->");
		carPlateLabel.setBounds(10, 11, 77, 14);
		frame.getContentPane().add(carPlateLabel);
		
		carPlateText = new JTextField();
		carPlateText.setBounds(84, 8, 100, 20);
		frame.getContentPane().add(carPlateText);
		carPlateText.setColumns(10);
		
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
		officialCheck.setBounds(395, 7, 119, 23);
		frame.getContentPane().add(officialCheck);

		JCheckBox subscribedCheck = new JCheckBox("Subscribed Vehicle");
		subscribedCheck.setBounds(570, 7, 175, 23);
		frame.getContentPane().add(subscribedCheck);
		buttonGroup.add(regularCheck);
		buttonGroup.add(officialCheck);
		buttonGroup.add(subscribedCheck);
		
		JLabel enterDateLabel = new JLabel("Enter Date-->");
		enterDateLabel.setBounds(10, 40, 77, 14);
		frame.getContentPane().add(enterDateLabel);
		
		JComboBox<String> enterDateCombo = new JComboBox<String>();
		enterDateCombo.setBounds(84, 40, 126, 20);
		enterDateCombo.addItem("10 October 2020");
		enterDateCombo.addItem("28 February 2021");
		enterDateCombo.addItem("29 February 2020");
		enterDateCombo.addItem("31 August 2050");
		enterDateCombo.addItem("1 Ocak 1999");
		enterDateCombo.setSelectedItem(null);
		frame.getContentPane().add(enterDateCombo);
		
		JLabel exitDateLabel = new JLabel("Exit Date-->");
		exitDateLabel.setBounds(10, 72, 77, 14);
		frame.getContentPane().add(exitDateLabel);
		
		JComboBox<String> exitDateCombo = new JComboBox<String>();
		exitDateCombo.setBounds(84, 72, 126, 20);
		exitDateCombo.setSelectedItem(null);
		frame.getContentPane().add(exitDateCombo);
		
		JLabel enterTimeLabel = new JLabel("Enter Time-->");
		enterTimeLabel.setBounds(10, 104, 77, 14);
		frame.getContentPane().add(enterTimeLabel);
		
		JComboBox<String> enterTimeCombo = new JComboBox<String>();
		enterTimeCombo.setBounds(84, 104, 126, 20);
		enterTimeCombo.addItem("09:05");
		enterTimeCombo.addItem("12:15");
		enterTimeCombo.addItem("22:00");
		enterTimeCombo.addItem("05:55");
		enterTimeCombo.addItem("19:20");
		enterTimeCombo.setSelectedItem(null);
		frame.getContentPane().add(enterTimeCombo);
		
		JLabel exitTimeLabel = new JLabel("Exit Time-->");
		exitTimeLabel.setBounds(10, 136, 77, 14);
		frame.getContentPane().add(exitTimeLabel);
		
		JComboBox<String> exitTimeCombo = new JComboBox<String>();
		exitTimeCombo.setBounds(84, 136, 126, 20);
		frame.getContentPane().add(exitTimeCombo);
		
		
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
		
		JLabel slotLabel1 = new JLabel("Slot1");
		slotLabel1.setBackground(Color.WHITE);
		slotLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		slotLabel1.setBounds(0, 260, 175, 175);
		frame.getContentPane().add(slotLabel1);
		frame.getContentPane().add(slotLabel1);
		frame.getContentPane().add(slotLabel1);
		frame.getContentPane().add(slotLabel1);
		frame.getContentPane().add(slotLabel1);
		frame.getContentPane().add(slotLabel1);
		
		JButton exitButton1 = new JButton("Exit");
		exitButton1.setBounds(40, 446, 90, 30);
		frame.getContentPane().add(exitButton1);
		
		JLabel slotLabel2 = new JLabel("Slot2");
		slotLabel2.setBackground(Color.WHITE);
		slotLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		slotLabel2.setBounds(200, 260, 175, 175);
		frame.getContentPane().add(slotLabel2);
		
		JButton exitButton2 = new JButton("Exit");
		exitButton2.setBounds(240, 446, 90, 30);
		frame.getContentPane().add(exitButton2);
		
		JLabel slotLabel3 = new JLabel("Slot3");
		slotLabel3.setBackground(Color.WHITE);
		slotLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		slotLabel3.setBounds(400, 260, 175, 175);
		frame.getContentPane().add(slotLabel3);
		
		JButton exitButton3 = new JButton("Exit");
		exitButton3.setBounds(440, 446, 90, 30);
		frame.getContentPane().add(exitButton3);
		
		JLabel slotLabel4 = new JLabel("Slot4");
		slotLabel4.setBackground(Color.WHITE);
		slotLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		slotLabel4.setBounds(0, 540, 175, 175);
		frame.getContentPane().add(slotLabel4);
		
		JButton exitButton4 = new JButton("Exit");
		exitButton4.setBounds(40, 727, 90, 30);
		frame.getContentPane().add(exitButton4);
		
		JLabel slotLabel5 = new JLabel("Slot5");
		slotLabel5.setBackground(Color.WHITE);
		slotLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		slotLabel5.setBounds(200, 540, 175, 175);
		frame.getContentPane().add(slotLabel5);
		
		JButton exitButton5 = new JButton("Exit");
		exitButton5.setBounds(240, 727, 90, 30);
		frame.getContentPane().add(exitButton5);
		
		
		Image im1 = new ImageIcon(this.getClass().getResource("/1.png")).getImage();
		slotLabel1.setIcon(new ImageIcon(im1));
		Image im2 = new ImageIcon(this.getClass().getResource("/2.png")).getImage();
		slotLabel2.setIcon(new ImageIcon(im2));
		Image im3 = new ImageIcon(this.getClass().getResource("/3.png")).getImage();
		slotLabel3.setIcon(new ImageIcon(im3));
		Image im4 = new ImageIcon(this.getClass().getResource("/4.png")).getImage();
		slotLabel4.setIcon(new ImageIcon(im4));
		Image im5 = new ImageIcon(this.getClass().getResource("/5.png")).getImage();
		slotLabel5.setIcon(new ImageIcon(im5));
		
		buttonGroup2.add(exitButton1);
		buttonGroup2.add(exitButton2);
		buttonGroup2.add(exitButton3);
		buttonGroup2.add(exitButton4);
		buttonGroup2.add(exitButton5);
				
		
		carPlateText.setToolTipText("Vehicle plate format must not empty and it's length must be bigger equal than 8 and smaller equal than 10");

		
		Date enterDate = new Date(0, 0, 0);
		Date exitDate = new Date(0, 0, 0);
		enterDateCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(enterDateCombo.getSelectedItem() == "10 October 2020")
				{
					exitDateCombo.removeAllItems();
					exitDateCombo.addItem("20 October 2020");
					enterDate.setYear(2020);
					enterDate.setMonth(10);
					enterDate.setDay(10);
					
					exitDate.setYear(2020);
					exitDate.setMonth(10);
					exitDate.setDay(20);
				}
				else if(enterDateCombo.getSelectedItem() == "28 February 2021")
				{
					exitDateCombo.removeAllItems();
					exitDateCombo.addItem("5 March 2021");
					enterDate.setYear(2021);
					enterDate.setMonth(2);
					enterDate.setDay(28);
					
					exitDate.setYear(2021);
					exitDate.setMonth(3);
					exitDate.setDay(5);
				}
				else if(enterDateCombo.getSelectedItem() == "29 February 2020")
				{
					exitDateCombo.removeAllItems();
					exitDateCombo.addItem("10 May 2020");
					enterDate.setYear(2020);
					enterDate.setMonth(2);
					enterDate.setDay(29);
					
					exitDate.setYear(2020);
					exitDate.setMonth(5);
					exitDate.setDay(10);
				}
				else if(enterDateCombo.getSelectedItem() == "31 August 2050")
				{
					exitDateCombo.removeAllItems();
					exitDateCombo.addItem("7 September 2050");
					enterDate.setYear(2050);
					enterDate.setMonth(8);
					enterDate.setDay(31);
					
					exitDate.setYear(2050);
					exitDate.setMonth(9);
					exitDate.setDay(7);
				}
				else if(enterDateCombo.getSelectedItem() == "1 Ocak 1999")
				{
					exitDateCombo.removeAllItems();
					exitDateCombo.addItem("10 Ocak 1999");
					enterDate.setYear(1999);
					enterDate.setMonth(1);
					enterDate.setDay(1);
					
					exitDate.setYear(1999);
					exitDate.setMonth(1);
					exitDate.setDay(10);
				}
				else
				{
					exitDateCombo.setSelectedItem(null);
				}
			}
		});
		
		Time enterTime = new Time(0, 0);
		Time exitTime = new Time(0,0);
		

	
		enterTimeCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(enterTimeCombo.getSelectedItem() == "09:05")
				{
					exitTimeCombo.removeAllItems();
					exitTimeCombo.addItem("12:05");
					enterTime.setHour(9);
					enterTime.setMinute(05);
					
					
					exitTime.setHour(12);
					exitTime.setMinute(05);
				}
				else if(enterTimeCombo.getSelectedItem() == "12:15")
				{
					exitTimeCombo.removeAllItems();
					exitTimeCombo.addItem("22:15");
					enterTime.setHour(12);
					enterTime.setMinute(15);
					
					exitTime.setHour(22);
					exitTime.setMinute(15);
				}
				else if(enterTimeCombo.getSelectedItem() == "22:00")
				{
					exitTimeCombo.removeAllItems();
					exitTimeCombo.addItem("04:55");
					enterTime.setHour(22);
					enterTime.setMinute(00);
					
					exitTime.setHour(04);
					exitTime.setMinute(55);
				}
				else if(enterTimeCombo.getSelectedItem() == "05:55")
				{
					exitTimeCombo.removeAllItems();
					exitTimeCombo.addItem("13:45");
					enterTime.setHour(5);
					enterTime.setMinute(55);
					
					exitTime.setHour(13);
					exitTime.setMinute(45);
				}
				else if(enterTimeCombo.getSelectedItem() == "19:20")
				{
					exitTimeCombo.removeAllItems();
					exitTimeCombo.addItem("16:00");
					enterTime.setHour(19);
					enterTime.setMinute(20);
					
					exitTime.setHour(16);
					exitTime.setMinute(00);
				}
				else
				{
					enterDateCombo.setSelectedItem(null);
				}
			}
		});
		
		
		AutoPark HalilAutoPark = new AutoPark(10.0, 5);
		RegularVehicle aRegularVehicle = new RegularVehicle("");
		OfficialVehicle aOfficialVehicle = new OfficialVehicle("");
		SubscribedVehicle aSubscribedVehicle = new SubscribedVehicle("", null);
		
		
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				if((carPlateText.getText() != null)  && (carPlateText.getText().length()>=8 &&	 carPlateText.getText().length()<=10) )
				{
					String plate = carPlateText.getText();
					
					if(enterDateCombo.getSelectedItem() != null && exitDateCombo.getSelectedItem() != null && enterTimeCombo.getSelectedItem() !=null && exitTimeCombo.getSelectedItem() != null)
					{
						if(regularCheck.isSelected())
						{
							aRegularVehicle.setPlate(plate);
							if(HalilAutoPark.vehicleEnters(plate, enterTime, false))
							{
								System.out.println("panpi");
								while(labelEmpty[i] == true)
								{
									i++;
									System.out.println(i);
								}
								switch (i) {
								case 0:
									Image im10 = new ImageIcon(this.getClass().getResource("/tesla.png")).getImage();
									slotLabel1.setIcon(new ImageIcon(im10));
									setLabelEmpty(0, true);
									break;
								case 1:
									Image im11 = new ImageIcon(this.getClass().getResource("/tesla.png")).getImage();
									slotLabel2.setIcon(new ImageIcon(im11));
									setLabelEmpty(1, true);
									break;
									
								case 2:
									Image im12 = new ImageIcon(this.getClass().getResource("/tesla.png")).getImage();
									slotLabel3.setIcon(new ImageIcon(im12));
									setLabelEmpty(2, true);
									break;
								case 3:
									Image im13 = new ImageIcon(this.getClass().getResource("/tesla.png")).getImage();
									slotLabel4.setIcon(new ImageIcon(im13));
									setLabelEmpty(3, true);
									break;
								case 4:
									Image im14 = new ImageIcon(this.getClass().getResource("/tesla.png")).getImage();
									slotLabel5.setIcon(new ImageIcon(im14));
									setLabelEmpty(4, true);
									break;
								default:
									break;
							}
							
							String message = "[ADDED]!Your vehicle has been created." + "\n";
							JOptionPane.showMessageDialog(new JFrame(), message, "CONGRATULATIONS!",JOptionPane.INFORMATION_MESSAGE);
							
						}
						else if(officialCheck.isSelected())
						{
							
						}
						else if(subscribedCheck.isSelected())
						{
							
						}
						else 
						{
							String message = "Please, you have to check one of them.";
							JOptionPane.showMessageDialog(new JFrame(), message, "Vehicle check error",JOptionPane.ERROR_MESSAGE);		
						}
					}
					else
					{
						String message = "Please, you have to choose some enter/exit date or enter/exit time.";
						JOptionPane.showMessageDialog(new JFrame(), message, "Plate date/time error",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{	
					String message = "Please, you give wrong vehicle plate format.Please, enter a valid vehicle plate format.To check right format look at the hint ";
					JOptionPane.showMessageDialog(new JFrame(), message, "Plate format error",JOptionPane.ERROR_MESSAGE);				
				}	
			}
			}
		
		});
	
		exitButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(labelEmpty[0] == true)
				{	
					if(HalilAutoPark.vehicleEnters(HalilAutoPark.getParkRecords().get(0).getVehicle().getPlate(), HalilAutoPark.getParkRecords().get(0).getEnterTime(), 
							HalilAutoPark.getParkRecords().get(0).getVehicle().isOfficial()))
					{
						String message = "Vehicle with this plate: " + HalilAutoPark.getParkRecords().get(0).getVehicle().getPlate() + " exiting from the autopark.";
						message = "\n" + "Vehicle park fee is: " + HalilAutoPark.getHourlyFee();
						JOptionPane.showMessageDialog(new JFrame(), message, "Plate format error",JOptionPane.INFORMATION_MESSAGE);	
					}
					
					
				}
				else
				{
					String message = "Please, add some vehicle at first.";
					JOptionPane.showMessageDialog(new JFrame(), message, "Empty slot Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}
		
}