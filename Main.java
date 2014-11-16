package variable_changer_program;

import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.JFileChooser;

//program to open lots of files and replaces a value
//hold ctrl to open multable files in file viewer

// oliver greaney

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;

		String string_to_find = "int x = 1001;"; //origionl value		show in gui
		String string_to_replace = "int x = 1002;"; //the new value		show in gui
		int count = 0;
		
		
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);  //open multable files using ctrl
		chooser.showOpenDialog(null);

		
		
		String folder_location = chooser.getCurrentDirectory().toString(); // show in gui
		
		// Retrieve the selected files.
		File[] files = chooser.getSelectedFiles();

		for (File value : files) {
			
			try {
				File the_file = value;
				FileReader file = new FileReader(the_file);
				BufferedReader br = new BufferedReader(file);

				// read
				while ((line = br.readLine()) != null) {
					if (line.contains(string_to_find)){
						line = line.replace(string_to_find, string_to_replace);
					count++;
					}
					lines.add(line);
				}
				file.close();
				br.close();

				// write
				FileWriter fw = new FileWriter(the_file);
				BufferedWriter bw = new BufferedWriter(fw);

				for (String s : lines) {
					bw.write(s + "\n");
				}

				bw.flush();
				bw.close();
				lines.clear();

				
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		String amount_lines_changed = ("amount of lines changed: " + count); //put in gui
		//System.out.println(amount_lines_changed);
		
	}

}
