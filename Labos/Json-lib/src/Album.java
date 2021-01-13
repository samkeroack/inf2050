public class Album {
    private String type;
    private String titre;
    private String artiste;
    private int publication;
    private int rating;

    public Album (String type, String titre, String artiste, int publication, int rating){
        this.type=type;
        this.titre=titre;
        this.artiste=artiste;
        this.publication=publication;
        this.rating=rating;
    }

    public String getType() {
        return type;
    }

    public String getTitre() {
        return titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public int getPublication() {
        return publication;
    }

    public int getRating() {
        return rating;
    }


}
