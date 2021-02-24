package martinamagdalenajukic.ferit.lv4;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @Override
    public String toString(){
        return street+'\n'+suite+'\n'+city+'\n'+zipcode;
    }
}
