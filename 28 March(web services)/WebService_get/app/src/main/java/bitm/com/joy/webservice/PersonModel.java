package bitm.com.joy.webservice;

/**
 * Created by BITM Trainer 401 on 3/5/2016.
 */
public class PersonModel {
    private String name;
    private String id;

    public PersonModel(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public PersonModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return id;
    }

    public void setLocation(String id) {
        this.id = id;
    }
}
