package connect4;

public class Player {
    //create name object
    private String name;

    public Player(String name)
    {
        this.name = name;
    }

    public void reset()
    {
        name = "";
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName()
    {
         return name;
    }
}
