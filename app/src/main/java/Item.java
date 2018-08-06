import android.provider.Telephony;

import java.io.BufferedReader;

public class Item {
    static private float price;
    private String name;
    private String id;
    static private int count;


    public float getPrice(){
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    //Первая инициализация товара
    public Item(float price, String name, String currentId){
        this.name = name;

//        int tmpId = Integer.parseInt(currentId);
//        tmpId++;
//        this.id = String.valueOf(tmpId);



    }

    public Item(float price, String name, String currentId, int count){
        this.name = name;

    }




}
