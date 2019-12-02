package com.antra.phonepad.combination;

import java.io.IOException;
import java.util.ArrayList;

public class Greeting {

   // private long id;
    private ArrayList<String> id;

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id) throws IOException {
//        ArrayList<String> list = new ArrayList<>();
        GFG temp = new GFG();
        this.id = temp.printKeyWords(id.get(0));
    }

}
