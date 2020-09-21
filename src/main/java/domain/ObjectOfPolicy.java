package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectOfPolicy {

    private String name;
    private List<SubObject> subObjects;

    public ObjectOfPolicy (String name, SubObject...subObjects){
        this.name = name;
        this.subObjects = new ArrayList<>(Arrays.asList(subObjects));
    }

    public List<SubObject> getSubObjects(){
        return subObjects;
    }

}
