package pl.edu.agh.mwo;

class Trip {
	private String name;
	private String description;
	private Album tripAlbum;
	
	Trip(String name, String description) {
		this.name = name;
		this.description = description;
		tripAlbum = new Album();
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getDescription() {
		return description;
	}

	void setDescription(String description) {
		this.description = description;
	}

	void addPhotoToTripAlbum(Photo photo) {
		tripAlbum.addPhoto(photo);
	}

	Album getAlbum() {
		return tripAlbum;
	}
}