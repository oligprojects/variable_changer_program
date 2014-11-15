import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import net.miginfocom.swing.MigLayout;

public class FileEditiorGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("File Editor");
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("file editor "));
		frame.add(panel);
		
		panel.setLayout(new MigLayout("","[]10[] ", "[] [] []" ));
		
		
		JLabel FindLabel = new JLabel("Find");
		JLabel WordCountLabel = new JLabel("Word Count");
		JLabel ReplaceLabel = new JLabel("Replace With");
		JLabel ChangesLabel = new JLabel("Changes Made to file(s)");
		JLabel FilePathLabel = new JLabel("Changes Made to file(s)");
		
		JTextField FindTextField = new JTextField(20);
		JTextField FilePathTextField = new JTextField(20);
		JTextField ReplaceTextField = new JTextField(20);
		JTextField WordCountTextField = new JTextField(20);
		
		JTextArea ChangesTextArea = new JTextArea(30,20);
		ChangesTextArea.setBorder(BorderFactory.createEtchedBorder());
		
		JButton SelectFile = new JButton("Select File");
		JButton Execute = new JButton("Execute");
		JButton SaveChanges = new JButton("Save Changes");
		
		panel.add(FilePathLabel,"left, sg 1, split 2");
		panel.add(FilePathTextField,"pushx, growx, wrap");
		
		panel.add(FindLabel,"left, sg 1, split 2");
		panel.add(FindTextField,"pushx, growx, wrap");
		
		panel.add(WordCountLabel,"left, sg 1, split 2");
		panel.add(WordCountTextField,"pushx, growx, wrap");
		
		panel.add(ReplaceLabel,"left, sg 1, split 3");
		panel.add(ReplaceTextField,"pushx, growx, wrap");
		panel.add(Execute,"wrap");
		
		panel.add(ChangesLabel,"wrap, sg 1, split 2");
		panel.add(SaveChanges,"wrap");
		panel.add(ChangesTextArea," span, push, grow");
		
		
		
		frame.pack();
		frame.setLocation(300,300);
		frame.setVisible(true);
		
	}

}
