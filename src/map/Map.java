package map;

import java.util.ArrayList;
import java.util.HashMap;

import Types.Coordinate;

public class Map {
	
	private HashMap<Coordinate, ArrayList<String>> map;
	
	public Map(Integer rows, Integer columns) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				Coordinate coordinate = new Coordinate(r, c);
				map.put(coordinate, new ArrayList<String>());
			}
		}
	}
	
}