

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import net.miginfocom.swing.MigLayout;



public class FileEditiorGUI {	
	public static void main(String[] args) {
		
		final Main m = new Main();
		File[] files;
		
		
		JFrame frame = new JFrame("File Editor");
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();		
		panel.setBorder(BorderFactory.createTitledBorder("file editor "));
		frame.add(panel);
		
		panel.setLayout(new MigLayout("","[]10[] ", "[] [] []" ));
		
		
		JLabel FindLabel = new JLabel("Find");		
		JLabel ReplaceLabel = new JLabel("Replace With");
		JLabel ChangesLabel = new JLabel("Changes Made to file(s)");		
				
		
		final JTextField FindTextField = new JTextField(20);
		JTextField FilePathTextField = new JTextField(20); 
		final JTextField ReplaceTextField = new JTextField(20);		
		
		final JTextArea ChangesTextArea = new JTextArea(30,20);
		ChangesTextArea.setBorder(BorderFactory.createEtchedBorder());
		
		JButton openBtn = new JButton("Select Files");
		JButton SelectFile = new JButton("Select File");
		JButton executeBtn = new JButton("Execute");		
		
		panel.add(openBtn,"left, sg 1, split 2");
		panel.add(FilePathTextField,"pushx, growx, wrap");
		
		panel.add(FindLabel,"left, sg 1, split 2");
		panel.add(FindTextField,"push, growx, wrap");
		
		panel.add(ReplaceLabel,"left, sg 1, split 3");
		panel.add(ReplaceTextField,"pushx, growx, wrap");
		panel.add(executeBtn,"wrap");
		
		panel.add(ChangesLabel,"wrap, sg 1, split 2");		
		panel.add(ChangesTextArea," wrap, wrap, wrap");
		
		frame.pack();
		frame.setLocation(300,300);
		frame.setSize(450, 400);		
		frame.setVisible(true);
				

		//System.out.println(files.toString());
				
		openBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.getFiles();
				
			}
		});
		
		while(m.filesChoosen()==false)
		{					
		}
		
		files=m.collectFiles();
		String file_path =files[0].getParent();
		FilePathTextField.setText(files.length + " File(s) Seleceted. PATH: " + file_path);										
		
		executeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String find = FindTextField.getText();
				String replace = ReplaceTextField.getText();
				String s=m.start(find,replace);
				ChangesTextArea.setText(s);
			}
		});
										
	}

}
