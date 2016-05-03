import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class GUI extends JFrame {

	private JPanel contentPane;
	
	private static final long serialVersionUID = -4428903142547077832L;
	static JTextField folderName = new JTextField();
	private JTextField dir = new JTextField();
	public static String fileDirectory;
	public static String fileName;

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
		setTitle("PxlWriter - JBerben");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImportAndConvert = new JButton("Import and Convert");
		btnImportAndConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser c = new JFileChooser();
			      // Demonstrate "Open" dialog:	
			      int rVal = c.showOpenDialog(GUI.this);
			      if (rVal == JFileChooser.APPROVE_OPTION) {
			        fileName = c.getSelectedFile().getAbsolutePath();
			        System.out.println(PixelEditing.codeFile);
			        System.out.println(fileName);
			        PixelEditing.ImportConvert(); // Runs the conversion process
			        JOptionPane.showMessageDialog(contentPane, "Process complete!");
			      }
			      if (rVal == JFileChooser.CANCEL_OPTION) {
			        dir.setText("");
			        
		btnImportAndConvert.setBounds(240, 93, 173, 29);
		contentPane.add(btnImportAndConvert);
	}
			}
		});
		btnImportAndConvert.setBounds(15, 93, 173, 29);
		contentPane.add(btnImportAndConvert);
		
		JLabel lblOutputFolder = new JLabel("Output Folder");
		lblOutputFolder.setBounds(15, 16, 114, 20);
		contentPane.add(lblOutputFolder);
		
		folderName = new JTextField();
		folderName.setBounds(15, 41, 398, 26);
		contentPane.add(folderName);
		folderName.setColumns(10);
		
		JButton btnNewButton = new JButton("Browse Output");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser c = new JFileChooser();
			      // Demonstrate "Open" dialog:
				  c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);	
			      int rVal = c.showOpenDialog(GUI.this);
			      if (rVal == JFileChooser.APPROVE_OPTION) {
			        folderName.setText(c.getSelectedFile().getAbsolutePath());
			        dir.setText(c.getCurrentDirectory().toString());
			        PixelEditing.codeFile = c.getSelectedFile().getAbsolutePath();
			        fileDirectory = folderName.getText();
			      }
			      if (rVal == JFileChooser.CANCEL_OPTION) {
			        folderName.setText("Click browse to add a file.");
			        dir.setText("");
			      }
			}
		});
		btnNewButton.setBounds(240, 93, 173, 29);
		contentPane.add(btnNewButton);
	}

}
