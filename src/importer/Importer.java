package importer;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Types.Coordinate;
import trip.Ride;

public class Importer {
	
	private static Importer instance = null;
	
	private String path = "";
	private String[] readLine;
	
	private ArrayList<Ride> rides = new ArrayList<>();
	
	private Integer[] parameters; //Rows, columns, vehicles in fleet, ride count, ride bonus, number of steps
	
	public static Importer getInstance() {
		if (instance == null) {
			instance = new Importer();
		}
		return instance;
	}
	
	private Importer() {
		//this("./a_example.in");
		//this("./b_should_be_easy.in");
		//this("./c_no_hurry.in");
		this("./d_metropolis.in");
		//this("./e_high_bonus.in");
	}

	private Importer(String path) {
		this.path = path;
		this.read();
	}

	/**
	 * 
	 */
	public void read() {
		if (!this.path.equals("")) {
			int currentLine = 0;
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
						//for (int i = 0; i < parameters.length; i++) {
						//	System.out.println(parameters[i]);
						//}
					} else {
						String[] params;
						params = line.split(" ");
						Coordinate start = new Coordinate(new Integer(params[0]), new Integer(params[1]));
						Coordinate finish = new Coordinate(new Integer(params[2]), new Integer(params[3]));
						Integer startEarliest = new Integer(params[4]);
						Integer endLatest = new Integer(params[5]);
						
						Ride ride = new Ride(currentLine, start, finish, startEarliest, endLatest);
						rides.add(ride);
						
						currentLine++;
						//System.out.println("Start: " + start.toString() + ". End: " + finish.toString() + ". Earliest start is " + startEarliest + ". Latest finish is " + endLatest);
						//create vehicles
						//ride bonus
						//number of steps
					}
				}
				//System.out.println("File Imported");
			} catch (FileNotFoundException ex) {
				System.out.println("No file is present at this path.");
			} catch (IOException ex) {
				System.out.println("Input/Output exceception");
			}
		}
	}
	
	public int getNumberOfVehicles() {
		return this.parameters[2];
	}
	
	public int getRideBonus() {
		return this.parameters[4];
	}
	
	public int getNumberOfSteps() {
		return this.parameters[5];
	}
	
	public ArrayList<Ride> getRides() {
		return this.rides;
	}
	
	
}
