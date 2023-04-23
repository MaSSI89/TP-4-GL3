package tp41;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.io.Serializable;

public class TP4 implements Serializable {
  public static void main(String[] args) {
    Annuaire a = new Annuaire();

    Scanner reader = new Scanner(System.in);
    System.out.println("Enter a command: ");
    String cmd = reader.nextLine();

    while (!cmd.startsWith(".")) {
        if (cmd.startsWith("+")) {
            System.out.println("Enter the number of the contact: ");
            int no = Integer.parseInt(reader.nextLine());
            System.out.println("Enter the address of the contact: ");
            String adr = reader.nextLine();
            a.addFiche(new Fiche(no, cmd.substring(1), adr));
            System.out.println("The contact has been successfully added!");

        } else {
            if (cmd.startsWith("?")) {
                Fiche f = a.chercherFiche(cmd.substring(1));
                if (f != null) {
                    System.out.println(f);
                } else {
                    System.out.println("The contact was not found in the directory.");
                }
            } else {
                if (cmd.startsWith("!")) {
                    System.out.println("----- Before Sorting --------");
                    a.afficherFiche();
                    System.out.println("----- After Sorting --------");
                    a.afficherFicheTriee();
                } else {
                    System.out.print("Error: Invalid command!");
                }
            }
        }
        System.out.println("Enter a command: ");
        cmd = reader.nextLine();
    }
    reader.close();
    a.Serialize();
}
}
