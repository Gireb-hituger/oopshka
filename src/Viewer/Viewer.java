package Viewer;
import Movie.Movie;

public class Viewer {
    private int id;
    private String firstName;
    private String lastName;
    private String movie;

    public Viewer(int id, String firstName, String lastName, String movie){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movie = movie;
    }

    public Viewer(String firstName, String lastName, String movie) {
        this(0, firstName, lastName, movie);
    }

    public void setId(int id) { this.id = id; }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public int getId(){
        return id;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setMovie(String movie){
        this.movie = movie;
    }


    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getMovie(){
        return movie;
    }

    @Override
    public String toString(){
        return "id: " + id + " firstName: " + firstName + " lastName: " + lastName + " Movie: " + movie;
    }

}
