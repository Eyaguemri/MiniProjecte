package train;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class GestionTicketsTrain {

	private JFrame frmGestionTicketsTrain;
	private JTextField show_comboBox_1_selected_item;
	private JTextField show_comboBox_selected_item;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionTicketsTrain window = new GestionTicketsTrain();
					window.frmGestionTicketsTrain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionTicketsTrain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionTicketsTrain = new JFrame();
		frmGestionTicketsTrain.setTitle("Gestion Tickets Train");
		frmGestionTicketsTrain.getContentPane().setForeground(new Color(0, 102, 255));
		frmGestionTicketsTrain.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
		frmGestionTicketsTrain.setBounds(100, 100, 638, 550);
		frmGestionTicketsTrain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionTicketsTrain.getContentPane().setLayout(null);
		
		Label label = new Label("Réservation Tickets");
		label.setBounds(0, 10, 624, 81);
		label.setFont(new Font("Dialog", Font.BOLD, 27));
		label.setForeground(Color.BLUE);
		label.setAlignment(Label.CENTER);
		label.setBackground(new Color(255, 255, 255));
		frmGestionTicketsTrain.getContentPane().add(label);
		
		ScrollPane scrollPane_2 = new ScrollPane();
		scrollPane_2.setBounds(190, 367, 100, 0);
		frmGestionTicketsTrain.getContentPane().add(scrollPane_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(474, 243, 0, 19);
		frmGestionTicketsTrain.getContentPane().add(textPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = comboBox.getSelectedItem().toString();
				String value=(String)comboBox.getSelectedItem();
				show_comboBox_selected_item.setText(value);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"","Gabes", "Tunis", "Gafsa", "sousse", "Nabeul"}));
		comboBox.setBounds(388, 192, 226, 27);
		frmGestionTicketsTrain.getContentPane().add(comboBox);
		//comboBox.setToolTipText("");
		//comboBox.setMaximumRowCount(1);
		
		JLabel lblNewLabel_1 = new JLabel("Ville Arrivée :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(247, 196, 144, 13);
		frmGestionTicketsTrain.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = comboBox_1.getSelectedItem().toString();
				String value=(String)comboBox_1.getSelectedItem();
				show_comboBox_1_selected_item.setText(value);
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"","Tunis", " Sousse", " Mahdia", "Mounastir", "Nabeul"}));
		comboBox_1.setBounds(388, 155, 226, 27);
		frmGestionTicketsTrain.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Ville Depart :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(229, 144, 174, 38);
		frmGestionTicketsTrain.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Calculer !");
		
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(272, 268, 153, 38);
		frmGestionTicketsTrain.getContentPane().add(btnNewButton);
		
		String[] values = new String[] {"premiere", "deuxieme", "confort"};
		JList list = new JList(values);
		list.setSelectedIndex(1);
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setToolTipText("premiere \r\ndeuxieme\r\nconfort");
		list.setBounds(20, 155, 137, 94);
		frmGestionTicketsTrain.getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Reserver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connexion = null;
		        PreparedStatement preparedStatement = null;
		        
		        if(((String)comboBox_1.getSelectedItem()).length()<2 || ((String)comboBox.getSelectedItem()).length()< 2 )
		        {
		        	JOptionPane.showMessageDialog(frmGestionTicketsTrain,"champs vide","Inane warning",JOptionPane.WARNING_MESSAGE);
		        }
		        else
		        {
		        	if (((String)comboBox.getSelectedItem()) == ((String)comboBox_1.getSelectedItem()))
		        	{
		        		JOptionPane.showMessageDialog(frmGestionTicketsTrain,"le meme ville","Inane warning",JOptionPane.WARNING_MESSAGE);
		        		
		        	}
			        try {
			            //connexion = connexion.getConnection();
			        	connexion =DriverManager.getConnection("jdbc:mysql://localhost:3306/train","root","");  
	
			            String query = "INSERT INTO reservation (villeDepart,villeArriver,class) VALUES (?,?,?)";//? placeholder bech tarja3 aala l prepared statement hasb l position mte3ha
			            preparedStatement = connexion.prepareStatement(query);//nhadhroha bch nhotou feha l fonctionnement bch nhotouha f conx entre l base de donnee w code java
			            preparedStatement.setString(1,(String) comboBox_1.getSelectedItem());
			            preparedStatement.setString(2,(String) comboBox.getSelectedItem());
			            preparedStatement.setString(3,(String) list.getSelectedValue());
			           preparedStatement.executeUpdate();
			           System.out.println("Données enregistrées avec succès dans la base de données !");
			        } catch (SQLException e1) {// bch nchedou l cnx sart wala le 
			            e1.printStackTrace();
			        } finally {
			            try {// bch nsakrou l cnx w preparedStatment
			               if (preparedStatement != null) {
			                    preparedStatement.close();
			                }
			                if (connexion != null) {
			                   connexion.close();
			               }
			            } catch (SQLException e1) {
			            	e1.printStackTrace();
			            }
			        }
		        }
			}
			
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setBounds(449, 268, 165, 38);
		frmGestionTicketsTrain.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u00E9stination", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_1.setBounds(202, 120, 422, 250);
		frmGestionTicketsTrain.getContentPane().add(scrollPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("Voyage de :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(20, 422, 90, 50);
		frmGestionTicketsTrain.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Vers :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(216, 422, 64, 50);
		frmGestionTicketsTrain.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Montant :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(384, 433, 90, 28);
		frmGestionTicketsTrain.getContentPane().add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remise");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(46, 280, 111, 21);
		frmGestionTicketsTrain.getContentPane().add(chckbxNewCheckBox);
		
		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remise:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_1_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1_1_1.setBounds(0, 390, 624, 123);
		frmGestionTicketsTrain.getContentPane().add(scrollPane_1_1_1);
		
		show_comboBox_1_selected_item = new JTextField();
		show_comboBox_1_selected_item.setBounds(120, 433, 96, 39);
		frmGestionTicketsTrain.getContentPane().add(show_comboBox_1_selected_item);
		show_comboBox_1_selected_item.setColumns(10);
		
		show_comboBox_selected_item = new JTextField();
		show_comboBox_selected_item.setBounds(290, 433, 81, 39);
		frmGestionTicketsTrain.getContentPane().add(show_comboBox_selected_item);
		show_comboBox_selected_item.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(492, 431, 111, 39);
		frmGestionTicketsTrain.getContentPane().add(textField);
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 120, 182, 250);
		frmGestionTicketsTrain.getContentPane().add(scrollPane_1_1);
		scrollPane_1_1.setToolTipText("premiere");
		scrollPane_1_1.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Classe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
		
				Connection connexion;
				try 
				{
					connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/train","root","");
					
					PreparedStatement preparedStatement = connexion.prepareStatement("Select PRIXX FROM PRIX WHERE villeDepart in (?,?) AND villeArriver in (?,?) ;");
					preparedStatement.setString(1,(String)comboBox_1.getSelectedItem());
					preparedStatement.setString(2,(String)comboBox.getSelectedItem());
					preparedStatement.setString(3,(String)comboBox_1.getSelectedItem());
					preparedStatement.setString(4,(String)comboBox.getSelectedItem());
					
					ResultSet rs = preparedStatement.executeQuery();
					double prix = 0;
					while(rs.next())
					{
						prix = rs.getDouble(1);
					}
					
					lblNewLabel_2.setText(lblNewLabel_2.getText()+(String)comboBox_1.getSelectedItem());
					lblNewLabel_3.setText(lblNewLabel_3.getText()+(String)comboBox.getSelectedItem());
					textField .setText(Double.toString(calculerMontant(prix,list,chckbxNewCheckBox)));
					
					
					preparedStatement.close();
					connexion.close();
					
				} catch (SQLException e1)
				{
					
					e1.printStackTrace();
				}
				
					
			}

			double calculerMontant(double m,JList list,JCheckBox remise) 
			{
				double prixCalcu = 0;
				
				if(list.getSelectedValue().equals("premiere"))
				{
					prixCalcu = m + (m * 0.3);
				}
				else if (list.getSelectedValue().equals("confort"))
						{
					prixCalcu = m + (m * 0.5);
				}
				else
				{
					prixCalcu = m;
				}
				
				if(remise.isSelected())
				{
					prixCalcu = prixCalcu - (prixCalcu * 0.05);
				}
				
				return prixCalcu;
				
			}
		});
		
	
	}
}
