package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;

class Album {
    private List<Photo> photos;

    Album() {
        photos = new ArrayList<>();
    }

    void addPhoto(Photo photo) {
        photos.add(photo);
    }

    List<Photo> getPhotos() {
        return photos;
    }
}