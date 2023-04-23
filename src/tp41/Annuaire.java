 /*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tp41;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
/**
*
* @author wahab
*/
public class Annuaire implements Serializable {
   HashMap<String, Fiche> hmap;

   public Annuaire() {
       hmap = new HashMap<String, Fiche>();
       File f = new File("annuaire.obj");
       if (f.exists()) {
           // De-serialize
           try {
               FileInputStream fis = new FileInputStream("annuaire.obj");
               ObjectInputStream ois = new ObjectInputStream(fis);
               hmap = (HashMap) ois.readObject();
               ois.close();
               fis.close();
           } catch (IOException ioe) {
               ioe.printStackTrace();
               return;
           } catch (ClassNotFoundException c) {
               System.out.println("Class not found");
               c.printStackTrace();
               return;
           }
           System.out.println("HashMap Deserialized..");
           // hmap=map;
       }
   }
   
   public HashMap<String, Fiche> getHmap() {
       return hmap;
   }
   
   public void addFiche(Fiche f) {
       this.hmap.put(f.getNom(), f);
   }
   
   public Fiche chercherFiche(String key) {
       return (this.hmap.get(key));
   }
   
   public void afficherFiche() {
       Set set = this.hmap.entrySet();
       Iterator iterator = set.iterator();
   
       while (iterator.hasNext()) {
           Map.Entry mentry = (Map.Entry) iterator.next();
           System.out.println(mentry.getValue());
       }
   }
   
   public void afficherFicheTriee() {
       Map<String, Fiche> map = new TreeMap<String, Fiche>(this.hmap);
       System.out.println("After Sorting:");
       Set set2 = map.entrySet();
       Iterator iterator2 = set2.iterator();
       while (iterator2.hasNext()) {
           Map.Entry me2 = (Map.Entry) iterator2.next();
           System.out.println(me2.getValue());
       }
   }
   
   public void Serialize() {
       // Serialize
       try {
           FileOutputStream fos = new FileOutputStream("annuaire.obj");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(hmap);
           oos.close();
           fos.close();
           System.out.println("Serialized HashMap data is saved in annuaire.obj");
       } catch (IOException ioe) {
           ioe.printStackTrace();
       }
   }
   
 
} 
    

