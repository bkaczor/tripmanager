package pl.edu.agh.mwo;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.*;

public class TripTest {
    private Trip trip;

    @Before
    public void setUp() {
        trip = new Trip("nazwa", "opis");
    }

    @Test
    public void testConstructor() {
        
        assertEquals("nazwa", trip.getName());
        assertEquals("opis", trip.getDescription());
    }

    @Test
    public void testSetName_whenNameIsSetToBartek(){
        
        trip.setName("Bartek");

        assertEquals(trip.getName(), "Bartek");
    }

    @Test
    public void testSetDescription_whenDescriptionIsSetToDefaultDesc(){
        
        final String desc = "DEFAULT DESC";

        trip.setDescription(desc);

        assertEquals(trip.getDescription(), desc);
    }

    @Test
    public void testAddPhoto_thenGetPhotos(){
        
        Photo photo = new Photo.Builder().takePhoto();
        trip.addPhotoToTripAlbum(photo);
        Album album = trip.getAlbum();
        List<Photo> photos = album.getPhotos();

        assertEquals(photos.get(0), photo);
    }
}