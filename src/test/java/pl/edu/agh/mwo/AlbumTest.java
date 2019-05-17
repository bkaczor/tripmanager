package pl.edu.agh.mwo;

import java.util.List;
import org.junit.*;

public class AlbumTest {

    @Test
    public void testCreationEmptyAlbum_returnAlbum(){
        
        Album album = new Album();
        List<Photo> photos = album.getPhotos();

        Assert.assertTrue(photos.isEmpty());
    }

    @Test
    public void testAddingPhotosToAlbym_returnPhotos(){
        
        Album album = new Album();
        Photo photo = new Photo.Builder().takePhoto();
        album.addPhoto(photo);
        List<Photo> photos = album.getPhotos();

        Assert.assertEquals(photos.get(0), photo);
    }
}