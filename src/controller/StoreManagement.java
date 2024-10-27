package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Clothe;
import model.NguoiDep;
import view.Menu;
import view.Utils;

public class StoreManagement extends Menu{
    static String[] mainMenu = {"Display all clothes", "Add new clothe","Delete a clothe","Search clothes","Sort clothes","Exit" };
    private NguoiDep nguoiDep;
 
  
    public StoreManagement() throws ParseException{
        super("\n--- Clothes Management ---", mainMenu);
        nguoiDep = new NguoiDep();
    }
    
    @Override
    public void execute(int n) {
         switch (n) {
            case 1:
                displayClothes();
                break;
            case 2:
             {
                 try {
                     addClothes();
                 } catch (ParseException ex) {
                     Logger.getLogger(StoreManagement.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
            case 3:
                doDeleteClothe();
                break;
            case 4:
                searchClothes();
                break;
            case 5:
                sortClothes();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("invalid choice");
        }  
    }
    public void displayClothes(){
        System.out.println("List of all clothes:");
        System.out.println("----------------------------------------------------------------------------------");
        for(Clothe cl : nguoiDep.getClothes()){
            System.out.println(cl);
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Total : " + nguoiDep.getClothes().size() + " Clothes. ");
    }
    public static void main(String[] args) throws ParseException {
    new StoreManagement().run();
    }
    public void addClothes()throws ParseException{
        try {
            String id = Utils.getValue("Enter clothe's id: ");
            String name = Utils.getValue("Enter clothe's name: ");
            String size = Utils.getValue("Enter clothe's size(M,S,X,XL,XXL): ");
            String productionDate = Utils.getValue("Enter clothe's production date(dd/mm/yyyy): ");
            Clothe clt = new Clothe(id, name, size, productionDate);
            nguoiDep.getClothes().add(clt);
        } catch (ParseException e) {
            System.out.println("Wrong input, please try again!");
        }
    }
    public void doDeleteClothe() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the clothe ID to delete: ");
    String clotheID = scanner.nextLine();
    
    boolean isDeleted = nguoiDep.deleteClothe(c -> c.getClotheID().equals(clotheID));

        if (isDeleted) {
            System.out.println("Cloth deleted successfully.");
        } else {
            System.out.println("Cloth not found.");
        }
    }
    public void sortClothes() {
    String[] sortMenu = {"Sort by ID", "Sort by Name", "Sort by Size", "Sort by Production Date", "Press 5 to Return"};
    Menu subMenu = new Menu("Sort Clothes", sortMenu) {
        @Override
        public void execute(int n) {
            switch(n) {
                case 1: { 
                    nguoiDep.sort((c1, c2) -> c1.getClotheID().compareTo(c2.getClotheID()));
                    break;
                }
                case 2: { 
                    nguoiDep.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
                    break;
                }
                case 3: {
                    nguoiDep.sort(NguoiDep.BY_SIZE);
                    break;
                }
                case 4: { 
                    nguoiDep.sort((c1, c2) -> c1.getProductionDateObject().compareTo(c2.getProductionDateObject()));
                    break;
                }
                case 5: { 
                    return;
                }
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            displayClothes(); 
        }
    };
    subMenu.run();
    }
    public void searchClothes() {
        String[] searchMenu = {"Search by ID", "Search by Name", "Search by Production date", "Press 4 to return"};
        Menu subMenu = new Menu("Search Clothes", searchMenu) {

            @Override
            public void execute(int n) {
                ArrayList<Clothe> rs = null;
                switch (n) {
                    case 1: {
                        String id = Utils.getValue("Enter ID");
                        rs = nguoiDep.search(p -> p.getClotheID().equalsIgnoreCase(id));
                        break;
                    }
                    case 2: {
                        String name = Utils.getValue("Enter Name");
                        rs = nguoiDep.search(p -> p.getName().equalsIgnoreCase(name));
                        break;
                    }
                    case 3: {
                        String productionDate = Utils.getValue("Enter Phone");
                        rs = nguoiDep.search(p -> p.getProductionDateObject().equals(productionDate));
                        break;
                    }
                    case 4: {
                        return;
                    }     
                    default:
                        System.out.println("Invalid search criteria.");
                        return;
                }
                if (rs != null && !rs.isEmpty()) {
                System.out.println("Found the following items:");
                for (Clothe clothe : rs) {
                    System.out.println(clothe);
                }
                } else {
                    System.out.println("No items found.");
                }
            }
        };

        subMenu.run();
    }
    public void deleteClothes() {
    String id = Utils.getValue("Enter ID");
    ArrayList<Clothe> rs = nguoiDep.search(p -> p.getClotheID().equalsIgnoreCase(id));

    if (rs != null && !rs.isEmpty()) {
        for (Clothe clothe : rs) {
            boolean removed = nguoiDep.remove(clothe); 
            if (removed) {
                System.out.println("Deleted item: " + clothe); 
            } else {
                System.out.println("Failed to delete item: " + clothe);
            }
        }
        System.out.println("Item(s) with ID " + id + " have been deleted.");
    } else {
        System.out.println("No items found with ID " + id + ".");
    }
}
}

