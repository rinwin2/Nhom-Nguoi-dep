package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu{
    protected String title;// tiêu de cua menu
    protected ArrayList<String> mChon;// danh sach cac chuc nang
    
    public Menu(){}
    public Menu(String td, String[] mc){
        title=td;
        mChon= new ArrayList<>();
        for(String s:mc) mChon.add( s);
    }
//-------------------------------------------
    public void display(){// hien thi danh sach cac chuc nang cua Menu
        System.out.println(title);
        System.out.println("--------------------------------");
        for(int i=0; i<mChon.size();i++)
            System.out.println((i+1)+"."+mChon.get(i));
        System.out.println("--------------------------------");
    }
//-------------------------------------------
    public int getSelected(){// doc lua chon nguoi dung
        display();
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter selection..");
        return sc.nextInt();
    }
//-------------------------------------------
    public abstract void execute(int n);//thi hanh menu
//-------------------------------------------
    public void run(){// chay Menu
        while(true){
            int n=getSelected();
            execute(n);
            if(n>mChon.size()) break;
        }
    }
//-------------------------------------------    
}