package importer;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import Types.Coordinate;

public class Importer {
	
	private String path = "";
	private String[] readLine;
	
	private Integer[] parameters; //Rows, columns, vehicles in fleet, ride count, ride bonus, number of steps
	
	public Importer() {
		this("./a_example.in");
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
						this.parameters = new Integer[params.length];
						for (int i = 0; i < params.length; i++) {
							this.parameters[i] = new Integer(params[i]);
						}
						firstLine = false;
						for (int i = 0; i < parameters.length; i++) {
							System.out.println(parameters[i]);
						}
					} else {
						String[] params;
						params = line.split(" ");
						Coordinate start = new Coordinate(new Integer(params[0]), new Integer(params[1]));
						Coordinate finish = new Coordinate(new Integer(params[2]), new Integer(params[3]));
						Integer startEarliest = new Integer(params[4]);
						Integer endLatest = new Integer(params[5]);
						
						System.out.println("Start: " + start.toString() + ". End: " + finish.toString() + ". Earliest start is " + startEarliest + ". Latest finish is " + endLatest);
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
