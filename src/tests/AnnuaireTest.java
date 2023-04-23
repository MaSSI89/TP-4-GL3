package tests;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.*;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;


import static org.hamcrest.CoreMatchers.*;

import tp41.Annuaire;
import tp41.Fiche;


public class AnnuaireTest {
    private Annuaire annuaire;
    private Fiche f1,f2,f3;

    @Before
    public void prepareforTests(){
        annuaire = new Annuaire();
        f1 = new Fiche(1, "allal", "Alger");
        f2 = new Fiche(2, "Massi", "Tipaza");
        f3 = new Fiche(5, "mahdi", "BOumerdes");
    }
    
    @Test
    public void testCOnstructor(){
        assertNotNull(annuaire.getHmap());
        assertTrue( annuaire.getHmap().isEmpty());
        // assertThat(annuaire.getHmap(), empty());
        annuaire.addFiche(f1);
        assertThat(annuaire.getHmap(), hasEntry("allal", f1));

        assertThat(annuaire.getHmap(), hasKey("allal"));
        annuaire.addFiche(f2);
        assertThat(annuaire.getHmap(), hasKey("Massi"));

        // assertThat(annuaire.getHmap(), hasValue("allal"));
        assertThat(annuaire.getHmap(), hasValue(1));
        assertThat(annuaire.getHmap(), hasValue("Alger"));

        File file = new File("Annuaire.obj");
        if (file.exists()){
            assertTrue(file.delete());
        }

        annuaire.Serialize();
        // DESERIALIZE
        annuaire = new Annuaire();
        assertThat(annuaire.getHmap(), notNullValue());
        assertThat(annuaire.getHmap().size(), is(1));
    }
    
   

    @Test
    public void testAddFiche() {
        // assertThat(annuaire.getHmap(), empty());
        annuaire.addFiche(f1);
        // assertThat(annuaire.getHmap(), hasKey("John"));
        assertThat(annuaire.getHmap().get("allal"), equalTo(f1));
        annuaire.addFiche(f2);
        assertThat(annuaire.getHmap().size(), is(2));
        assertThat(annuaire.getHmap().get("Massi"), equalTo(f2));
        annuaire.addFiche(f3);
        assertThat(annuaire.getHmap().size(), equalTo(3));
        assertThat(annuaire.getHmap().get("mahdi"), equalTo(f3));
    }

    @Test
    public void testChercheFiche(){
        annuaire.addFiche(f1);
        annuaire.addFiche(f2);

        Fiche f = annuaire.chercherFiche("allal");
        assertThat(f, equalTo(f1));
        f = annuaire.chercherFiche("Massi");
        assertThat(f, equalTo(f2));

        f = annuaire.chercherFiche("Non Existing Fiche");
        assertThat(f, nullValue());
    }

    @Test
    public void testAfficherFiche(){
        String expected = "After Sorting:\n";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        annuaire.afficherFicheTriee();
        assertThat(out.toString(), equalTo(expected));
        
        annuaire.addFiche(f1);
        annuaire.addFiche(f2);
        expected = "Fiche No: 1 Nom allal Adresse Alger\n" 
                    +"Fiche No: 2 Nom Massi Adresse Tipaza\n";
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        annuaire.afficherFiche();
        assertThat(out.toString(), equalTo(expected));
    }
    
    @Test
    public void testAfficherFicheTriee(){
        String expected = "After Sorting:\n";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        annuaire.afficherFicheTriee();
        assertThat(out.toString(), equalTo(expected));
        
        annuaire.addFiche(f1);
        annuaire.addFiche(f2);
        annuaire.addFiche(f3);
        expected = "After Sorting:\n"
                    + "Fiche No: 2 Nom Massi Adresse Tipaza\n"
                    + "FIche No: 1 Nom allal Adresse Alger\n"
                    + "Fiche No: 5 Nom mahdi Adresse BOumerdes\n";

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        annuaire.afficherFicheTriee();
        assertThat(out.toString(), equalTo(expected));
        
    }

}