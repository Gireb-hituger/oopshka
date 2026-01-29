package Cinema;

public class Placement extends Cinema{
    private int placementCount;

    public Placement(int id, String name, int hallsCount, int placementCount){
        super(id, name, hallsCount);
        this.placementCount = placementCount;
    }

    public void setPlacementCount(int placementCount) {
        this.placementCount = placementCount;
    }

    public int getplacementCount(){
        return placementCount;
    }
}
