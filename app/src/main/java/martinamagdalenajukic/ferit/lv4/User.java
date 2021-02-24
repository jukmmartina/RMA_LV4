package martinamagdalenajukic.ferit.lv4;

public class User {
    private int id;
    //@SerializedName("namexyz") da se tako zove u JSON a mi zelimo samo ime
    private String name;
    private  Address address;
    @Override
    public String toString(){
        return id + '\n' + name + '\n' + address;
    }
}
