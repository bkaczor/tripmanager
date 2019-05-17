package pl.edu.agh.mwo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.*;

public class TripManagerTest {
    TripManager tripManager;
    Trip trip;

    @Before
    public void setUp() {
        tripManager = new TripManager();
        trip = new Trip("nazwa", "opis");
    }

    @Test
    public void testAdd() throws TripAlreadyExistsException {
        assertEquals(0, tripManager.getTrips().size());
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
    }

    @Test(expected = TripAlreadyExistsException.class)
    public void testAddTripTwice() throws TripAlreadyExistsException {
        assertEquals(0, tripManager.getTrips().size());
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
        tripManager.add(trip);
    }

    @Test
    public void testRemoveTrip() throws Exception {
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
        tripManager.remove(trip.getName());
        assertEquals(0, tripManager.getTrips().size());
    }

    @Test
    public void testFindTrip_whenWordIsPartOfTripName() throws TripAlreadyExistsException {
        
        Trip tripCroatia = new Trip("Chorwacja", "Bardzo pi�kny kraj");
        Trip tripItaly = new Trip("W�ochy", "Lubi� je�� makaron");
        tripManager.add(tripCroatia);
        tripManager.add(tripItaly);
        Trip result = tripManager.findTrip("W�ochy");

        assertEquals(result.getName(), "W�ochy");
    }

    @Test
    public void testFindTrip_whenKeyIsPartOfTripDescription() throws TripAlreadyExistsException {
       
    	Trip tripCroatia = new Trip("Chorwacja", "Bardzo pi�kny kraj");
        Trip tripItaly = new Trip("W�ochy", "Lubi� je�� makaron");
        tripManager.add(tripCroatia);
        tripManager.add(tripItaly);
        Trip result = tripManager.findTrip("makaron");

        assertEquals(result.getName(), "W�ochy");
    }

    @Test
    public void testFindTrip_whenKeyIsPartOfPhotoComment() throws TripAlreadyExistsException {
       
        Photo photo1 = new Photo.Builder().addComment("Morze Adriatyckie jest pi�kne.").takePhoto();
        Photo photo2 = new Photo.Builder().addComment("Morze i zaraz obok pi�kne g�ry.").takePhoto();
        Photo photoItaly= new Photo.Builder().addComment("Dania z makaronem s� wy�mienite.").takePhoto();

        Trip tripCroatia = new Trip("Chorwacja", "Stolic� Chorwacji jest Zagrzeb");
        Trip tripItaly = new Trip("Japonia", "Stolic� W�och jest Rzym");
        tripCroatia.addPhotoToTripAlbum(photo1);
        tripCroatia.addPhotoToTripAlbum(photo2);
        tripItaly.addPhotoToTripAlbum(photoItaly);

        tripManager.add(tripCroatia);
        tripManager.add(tripItaly);

        Trip result = tripManager.findTrip("g�ry");

        assertEquals(result.getName(), "Chorwacja");
    }

    @Test
    public void testFindTrip_whenKeyCannotBeFound() throws TripAlreadyExistsException {
        
    	Trip tripCroatia = new Trip("Chorwacja", "Stolic� Chorwacji jest Zagrzeb");
        Trip tripItaly = new Trip("Japonia", "Stolic� W�och jest Rzym");
        tripManager.add(tripCroatia);
        tripManager.add(tripItaly);

        Trip result = tripManager.findTrip("g�ry");

        assertNull(result);
    }

    @Test
    public void testFindTrip_whenKeyIsNull() throws TripAlreadyExistsException {
        
    	Trip tripCroatia = new Trip("Chorwacja", "Stolic� Chorwacji jest Zagrzeb");
        Trip tripItaly = new Trip("Japonia", "Stolic� W�och jest Rzym");
        tripManager.add(tripCroatia);
        tripManager.add(tripItaly);

        Trip result = tripManager.findTrip(null);

        assertNull(result);
    }

    @Test
    public void testFindTrip_whenKeyIsEmpty() throws TripAlreadyExistsException {
        
    	Trip tripCroatia = new Trip("Chorwacja", "Stolic� Chorwacji jest Zagrzeb");
        Trip tripItaly = new Trip("Japonia", "Stolic� W�och jest Rzym");
        tripManager.add(tripCroatia);
        tripManager.add(tripItaly);

        Trip result = tripManager.findTrip("");

        assertNull(result);
    }
}
