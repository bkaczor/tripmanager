package pl.edu.agh.mwo;
import java.util.*;

class TripManager {
	private HashMap<String,Trip> tripList;
	
	TripManager() {
		tripList = new HashMap<>();
	}
	
	void add(Trip trip) throws TripAlreadyExistsException {
		if (tripAlreadyExist(trip))
			throw new TripAlreadyExistsException();
		tripList.put(trip.getName(),trip);
	}

	HashMap<String,Trip> getTrips() {
		return tripList;
	}

	Trip findTrip(String keyWord) {
		if (keyWord == null || keyWord.isEmpty())
			return null;

		return findTripViaTripNames(keyWord.toLowerCase());
	}

	private Trip findTripViaTripNames(String key) {
		for (String tripName: tripList.keySet()) {
			if(tripName.toLowerCase().contains(key)) {
				return tripList.get(tripName);
			}
		}
		return findTripViaDescription(key);
	}

	private Trip findTripViaDescription(String key) {
		for (String tripName: tripList.keySet()) {
			Trip trip = tripList.get(tripName);

			if (trip.getDescription().toLowerCase().contains(key))
				return trip;
		}
		return findTripViaPhotoComment(key);
	}

	private Trip findTripViaPhotoComment(String key) {
		for (String tripName: tripList.keySet()) {
			Trip trip = tripList.get(tripName);

			for (Photo photo: trip.getAlbum().getPhotos()) {
				if(photo.getComment().toLowerCase().contains(key))
					return trip;
			}
		}
		return null;
	}

	void remove(String name) {
		tripList.remove(name);
	}

	private boolean tripAlreadyExist(Trip trip) {
		return tripList.containsKey(trip.getName());
	}

}