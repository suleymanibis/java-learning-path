package Character_String_Math;

import java.util.Scanner;

public class EduMailGenerator {
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);

        System.out.print("Adınızı ve soyadınızı giriniz: ");
        String fullname = inp.nextLine();

        String name = fullname.substring(0, fullname.indexOf(" "));
        String surname = fullname.substring(fullname.indexOf(" ") + 1);

        System.out.print("Mühendislik fakültesinde misiniz? (evet/hayir): ");
        String choice = inp.nextLine().toLowerCase();

        String mail = "";

        if (choice.equals("evet")) {
            mail = name.toLowerCase().charAt(0) + "." + surname.toLowerCase() + "@muh.edu.tr";
            System.out.println("Oluşturulan e-posta: " + mail);
        } else if (choice.equals("hayir")){
            mail = name.toLowerCase().charAt(0) + "." + surname.toLowerCase() + "@ogr.edu.tr";
            System.out.println("Oluşturulan e-posta: " + mail);
        } else {
            System.out.println("Geçersiz işlem.");
        }
    }
}
