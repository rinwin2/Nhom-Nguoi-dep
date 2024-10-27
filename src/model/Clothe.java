package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Clothe implements Comparable<Clothe>{
    private String clotheID;
    private String name;
    private String size;
    private String type;
    private Date productionDate;

   
    public Clothe(String clotheID, String name, String size, String productionDate) throws ParseException {
        this.clotheID = clotheID;
        this.name = name;
        this.size = size;
        this.productionDate = setProductionDate(productionDate);
        this.type = checkAndReturnType(clotheID);
    }

  
    public String getClotheID() { 
        return clotheID; 
    }
    public void setClotheID(String clotheID) { 
        this.clotheID = clotheID; 
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name;
    }

    public String getSize() {
        return size; 
    }
    public void setSize(String size) { 
        this.size = size;
    }

    public String getType() { 
        return type; 
    }

    public String getProductionDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        return sdf.format(productionDate); 
    }

    public Date setProductionDate(String productionDate) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        return sdf.parse(productionDate);
    }
    public Date getProductionDateObject() {
    return productionDate;
    }
    
    private String checkAndReturnType(String id) {
        if (id.startsWith("001")) return "Shirt";
        if (id.startsWith("002")) return "T-Shirt";
        if (id.startsWith("003")) return "Dress";
        return "Unknown";
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-15s | %-15s | %-15s ",clotheID,name,size,type,getProductionDate());


    }

    @Override
    public int compareTo(Clothe c) {
        return this.name.compareToIgnoreCase(c.name);
    }

}