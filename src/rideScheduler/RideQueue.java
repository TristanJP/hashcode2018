package rideScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

import importer.Importer;
import trip.Ride;

public class RideQueue  {
	
	private Importer importer = Importer.getInstance();

	private ArrayBlockingQueue<Ride> queue = new ArrayBlockingQueue(importer.getRides().size());
	
	public RideQueue() {
		ArrayList<Ride> rides = importer.getRides();
		
		ArrayList<ArrayList<Ride>> orderedRides = new ArrayList<>();
		
		for (int i = 0; i < importer.getNumberOfSteps(); i++) {
			orderedRides.add(i, new ArrayList<Ride>());
		}
		
		for (Ride ride : rides) {
			int startEarliest = ride.getEarliestStep();
			orderedRides.get(startEarliest).add(ride);
		}
		
		for (int i = 0; i < importer.getNumberOfSteps(); i++) {
			ArrayList<Ride> ridesToSort = orderedRides.get(i);
			if (ridesToSort != null) {
				Ride[] availableRides = new Ride[ridesToSort.size()];
				for (int j = 0; j < availableRides.length; j++) {
					availableRides[j] = ridesToSort.get(j);
				}
				int[] distance = new int[ridesToSort.size()];
				Ride[] availableRidesOrdered = new Ride[ridesToSort.size()];
				
				for (int j = 0; j < availableRides.length; j++) {
					distance[j] = availableRides[j].getDistance();
				}
				for (int j = 0; j < availableRides.length; j++) {
					int smallest = 0;
					for (int k = 0; k < availableRides.length; k++) {
						if (distance[k] < distance[smallest]) {
							smallest = k;
						}
					}
					availableRidesOrdered[j] = availableRides[smallest];
					distance[smallest] = Integer.MAX_VALUE;
				}
				for (int j = 0; j < availableRides.length; j++) {
					try {
						queue.put(availableRidesOrdered[j]);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			/*while (queue.peek() != null) {
				try {
					Ride ride = queue.take();
					System.out.println("Starting at " + ride.getEarliestStep() + ", lasting for " + ride.getDistance() + " steps.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}*/
		}
	}
	
	public ArrayBlockingQueue getQueue() {
		return queue;
	}
	
}
