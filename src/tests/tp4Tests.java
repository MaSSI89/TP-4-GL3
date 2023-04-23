// package tests;
// import org.junit.Test;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.MatcherAssert.assertThat;

// import static org.hamcrest.CoreMatchers.*;

// import tp41.Annuaire;
// import tp41.Fiche;



// public class tp4Tests {
    
//     @Test
//     public void testAddFiche() {
//         Annuaire annuaire = new Annuaire();
//         Fiche fiche = new Fiche(1, "John", "123 Main St");
//         annuaire.addFiche(fiche);
//         assertThat(annuaire.getHmap(), hasKey("John"));
//         assertThat(annuaire.getHmap().get("John"), equalTo(fiche));
//     }
    
//     @Test
//     public void testChercherFiche() {
//         Annuaire annuaire = new Annuaire();
//         Fiche fiche = new Fiche(1, "noFile", "123 Main St");
//         annuaire.addFiche(fiche);
//         assertThat(annuaire.chercherFiche("noFile"), equalTo(fiche));
//         assertThat(annuaire.chercherFiche("Unknown"), nullValue());
//     }
    
//     @Test
//     public void testAfficherFiche() {
//         Annuaire annuaire = new Annuaire();
//         Fiche fiche1 = new Fiche(1, "John", "123 Main St");
//         Fiche fiche2 = new Fiche(2, "Jane", "456 Elm St");
//         annuaire.addFiche(fiche1);
//         annuaire.addFiche(fiche2);
//         assertThat(annuaire.afficherFiche(), containsString(fiche1.toString()));
//         assertThat(annuaire.afficherFiche(), containsString(fiche2.toString()));
//     }
    
//     @Test
//     public void testAfficherFicheTriee() {
//         Annuaire annuaire = new Annuaire();
//         Fiche fiche1 = new Fiche(1, "John", "123 Main St");
//         Fiche fiche2 = new Fiche(2, "Jane", "456 Elm St");
//         annuaire.addFiche(fiche1);
//         annuaire.addFiche(fiche2);
//         assertThat(annuaire.afficherFicheTriee(), containsString(fiche2.toString()));
//         assertThat(annuaire.afficherFicheTriee(), containsString(fiche1.toString()));
//     }
// }