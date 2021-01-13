import net.sf.json.processors.JsonBeanProcessor;

import java.io.IOException;
import java.util.ArrayList;

public class AlbumStats {
    public static void main(String[] args) {
        String filename = "collection.json";

        try{
            ArrayList<Album> albums = JsonParser.jsonFileToAlbum(filename);
            stat(albums);

        }catch(IOException e ){
            e.printStackTrace();
        }
    }

    private static void stat (ArrayList<Album> albums){
        int nbAlbums = 0;
        int nbSingles=0;
        int depuis2003 = 0;
        int note5 = 0;

        for(Album album : albums) {
            if (album.getType().equals("albums"))
                nbAlbums++;
            else
                nbSingles++;
            if (album.getPublication() >= 2003)
                depuis2003++;
            if (album.getRating() == 5)
                note5++;
        }
        System.out.printf("Nombre d'albums : %d%nNombre d'album depuis 2003 : %d%nNombre d'album avec la note 5 : %d%n"
                ,nbAlbums, depuis2003, note5);
        }

    }

