/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd.dto;

/**
 *
 * @author Olayinka
 */
public class Dvd {
    private String title;
    private String releaseDate;
    private String rating;
    private String directorsName;
    private String studio;
    private String dvdId;

    
    
    
    public Dvd(String dvdId){
        this.dvdId = dvdId;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the directorsName
     */
    public String getDirectorsName() {
        return directorsName;
    }

    /**
     * @param directorsName the directorsName to set
     */
    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    /**
     * @return the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * @return the notes
     */
   
    
    public String getDvdId(){
        return dvdId;
    }
}
