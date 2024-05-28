/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package survey;

/**
 *
 * @author Simamkele Ndwandwa
 */
public class Survey {
   private int id;
    private String fullName;
    private int age;
    private boolean likesPizza;
    private boolean likesPasta;
    private boolean likesPapAndWors;
    private boolean likesOther;
    private int ratingMovies;
    private int ratingRadio;
    private int ratingEatingOut;
    private int ratingTV;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public boolean isLikesPizza() {
        return likesPizza;
    }

    public boolean isLikesPasta() {
        return likesPasta;
    }

    public boolean isLikesPapAndWors() {
        return likesPapAndWors;
    }

    public boolean isLikesOther() {
        return likesOther;
    }

    public int getRatingMovies() {
        return ratingMovies;
    }

    public int getRatingRadio() {
        return ratingRadio;
    }

    public int getRatingEatingOut() {
        return ratingEatingOut;
    }

    public int getRatingTV() {
        return ratingTV;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLikesPizza(boolean likesPizza) {
        this.likesPizza = likesPizza;
    }

    public void setLikesPasta(boolean likesPasta) {
        this.likesPasta = likesPasta;
    }

    public void setLikesPapAndWors(boolean likesPapAndWors) {
        this.likesPapAndWors = likesPapAndWors;
    }

    public void setLikesOther(boolean likesOther) {
        this.likesOther = likesOther;
    }

    public void setRatingMovies(int ratingMovies) {
        this.ratingMovies = ratingMovies;
    }

    public void setRatingRadio(int ratingRadio) {
        this.ratingRadio = ratingRadio;
    }

    public void setRatingEatingOut(int ratingEatingOut) {
        this.ratingEatingOut = ratingEatingOut;
    }

    public void setRatingTV(int ratingTV) {
        this.ratingTV = ratingTV;
    }

    
}


