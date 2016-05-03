import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;


public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4428903142547077832L;
	static JTextField filename = new JTextField();
	private JTextField dir = new JTextField();
	private boolean fileSelected = false;
	public static String fileDirectory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setTitle("Margeritas in Monaco 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 250);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser c = new JFileChooser();
			      // Demonstrate "Open" dialog:
			      int rVal = c.showOpenDialog(GUI.this);
			      if (rVal == JFileChooser.APPROVE_OPTION) {
			        filename.setText(c.getSelectedFile().getAbsolutePath());
			        dir.setText(c.getCurrentDirectory().toString());
			        fileSelected = true;
			        fileDirectory = filename.getText();
			      }
			      if (rVal == JFileChooser.CANCEL_OPTION) {
			        filename.setText("Click browse to add a file.");
			        dir.setText("");
			      }
			}
		});
		btnBrowse.setBounds(15, 137, 130, 60);
		contentPane.add(btnBrowse);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Converter.Replace();
				if (fileSelected) {
					JOptionPane.showMessageDialog(contentPane, "Files converted.");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Cannot convert. No file to convert.");
				}
			}
		});
		btnConvert.setBounds(328, 137, 130, 60);
		contentPane.add(btnConvert);
		
		filename = new JTextField();
		filename.setBounds(15, 87, 443, 34);
		filename.setEditable(false);
		contentPane.add(filename);
		
		
		
		JLabel lblFilePath = new JLabel("File Path");
		lblFilePath.setBounds(15, 51, 69, 20);
		contentPane.add(lblFilePath);
		
		JLabel lblMadeByJosh = new JLabel("Made by Josh Berben");
		lblMadeByJosh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMadeByJosh.setBounds(15, 16, 200, 20);
		contentPane.add(lblMadeByJosh);
	}
}
