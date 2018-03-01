package importer;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Importer {
	
	private String path = "";
	private String[] readLine;
	
	private Integer[] parameters;
	
	public Importer() {
		this("a_example.in");
	}

	public Importer(String path) {
		this.path = path;
		this.read();
	}

	/**
	 * 
	 */
	public void read() {
		if (!this.path.equals("")) {
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				boolean firstLine = true;
				String line;
				while ((line = br.readLine()) != null) {
					if (firstLine) {
						String[] params;
						params = line.split(" ");
						this.parameters = new Integer[params.length - 1];
						for (int i = 0; i < params.length - 1; i++) {
							this.parameters[i] = new Integer(params[i]);
						}
						firstLine = false;
					} else {
						
					}
				}
			} catch (FileNotFoundException ex) {
				System.out.println("No file is present at this path.");
			} catch (IOException ex) {
				System.out.println("Input/Output exceception");
			}
		}
	}
	
	
}
