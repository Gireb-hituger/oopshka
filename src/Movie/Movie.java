package Movie;

public class Movie {
    private int id;
    private String name;
    private String duration;
    private Integer year;
    private String description;

    public Movie(String name, String duration, String description, Integer year) { // INSERT
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.year = year;
    }

    public Movie() {}

    public void setDescription(String description) {
        this.description = description;
    }



    public Movie(int id, String name, String duration, String description, int year) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.year = year;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id) { this.id = id; }

    public int getId(){
        return id;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getName(){
        return name;
    }

    public String getDuration(){
        return duration;
    }

    public Integer getYear(){
        return year;
    }


    @Override
    public String toString(){
        return "id: " + id + " name: " + name + " year: " + year + " duration: " + duration;
    }
}
