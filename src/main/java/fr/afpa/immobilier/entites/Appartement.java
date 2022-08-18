package fr.afpa.immobilier.entites;

public class Appartement {
    private int numAppart;
    private String numImmeuble;
    private int nbPieces;
    private int prix;
    private float surface;

    public Appartement(int numAppart, String numImmeuble, int nbPieces, int prix, float surface) {
        this.numAppart = numAppart;
        this.numImmeuble = numImmeuble;
        this.nbPieces = nbPieces;
        this.prix = prix;
        this.surface = surface;
    }

    public int getNumAppart() {
        return numAppart;
    }

    public void setNumAppart(int numAppart) {
        this.numAppart = numAppart;
    }

    public String getNumImmeuble() {
        return numImmeuble;
    }

    public void setNumImmeuble(String numImmeuble) {
        this.numImmeuble = numImmeuble;
    }

    public int getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }
}
