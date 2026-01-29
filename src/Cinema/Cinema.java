package Cinema;

public class Cinema {
    private int id;
    private String name;
    private int hallsCount;

    public Cinema(int id, String name, int hallsCount) {
        this.id = id;
        this.name = name;
        this.hallsCount = hallsCount;
    }

    public Cinema(String name, int hallsCount) {
        this.name = name;
        this.hallsCount = hallsCount;
    }

    public void setId(int id) { this.id = id; }

    public void setName(String name){
        this.name = name;
    }

    public void setHallsCount(int hallsCount){
        this.hallsCount = hallsCount;
    }

    public String getName(){
        return name;
    }

    public int getHallsCount(){
        return hallsCount;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return "id: " + id + " name: " + name;
    }
}
