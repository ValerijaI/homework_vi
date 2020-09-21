package domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Policy {

    private String number;
    private String status;
    private List <ObjectOfPolicy> objects;

    public Policy (String number, String status, ObjectOfPolicy...objects){
        this.number = number;
        this.status = status.toUpperCase();
        this.objects = new ArrayList<>(Arrays.asList(objects));
    }

    public List <ObjectOfPolicy> getObjects(){
        return objects;
    }

}
