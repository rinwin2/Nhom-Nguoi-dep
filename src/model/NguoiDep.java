package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;


public class NguoiDep {
    private ArrayList<Clothe> clothes = new ArrayList<>();
 
    public NguoiDep() throws ParseException {
        clothes.add(new Clothe("001001", "Blue Shirt", "M", "23/3/2024"));
        clothes.add(new Clothe("002002", "Black T-Shirt", "L", "23/3/2023"));
        clothes.add(new Clothe("003003", "Summer Dress", "S", "12/4/2023"));
        clothes.add(new Clothe("001004", "White Shirt", "XL", "18/5/2024"));
        clothes.add(new Clothe("002005", "Graphic T-Shirt", "M", "22/3/2022"));
    }

    public ArrayList<Clothe> getClothes() {
        return clothes;
    }

    public void setClothes(ArrayList<Clothe> clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "NguoiDep{" + "clothes=" + clothes + '}';
    }
    public void sort(Comparator<Clothe> c){
        Collections.sort(clothes, c);
    }
    public boolean deleteClothe(Predicate<Clothe> predicate) {
    return clothes.removeIf(predicate);
    }
    public static final Comparator<Clothe> BY_SIZE = new Comparator<Clothe>() {
    @Override
    public int compare(Clothe c1, Clothe c2) {
        String[] orderedSizes = {"S", "M", "L", "XL", "XXL"};
        int index1 = java.util.Arrays.asList(orderedSizes).indexOf(c1.getSize());
        int index2 = java.util.Arrays.asList(orderedSizes).indexOf(c2.getSize());
        return Integer.compare(index1, index2);
    }
};
    public ArrayList<Clothe> search(Predicate<Clothe> p){
        ArrayList<Clothe> rs = new ArrayList<>();
        for(Clothe c : clothes){
            if(p.test(c)) rs.add(c);
        }
        return rs;
    }
    public boolean remove(Clothe clothe) {
        return clothes.remove(clothe); 
    }
}