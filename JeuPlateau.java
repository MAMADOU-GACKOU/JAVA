
package jeuplateau;
import java.util.ArrayList;
public class JeuPlateau {
    public static void main(String[] args) {
    ArrayList<Joueur> u = new ArrayList<Joueur>();//une liste qui contiendra les nom des joueur de la partie
    String s;// création de variable  qui stockera les joueurs.l
    int i;// variable de type integer qui servira de test sur les niveau de jeu.
    boolean c = true;   // boolean qui sert a tester les entrer au clavier
    while (c){
      
      while(c){
        s = "";
        while(c){
          Output.afficheLigne(Output.magenta("Entrez le nom du joueur."));
          s = Lire.getString().trim();
          if(c = s.equals("")){
            Output.afficheErreur("Veuillez entrer un nom valide.");
          }
        }
        u.add(new Joueur(s)); 
        Output.afficheLigne(Output.jaune(
            "Voulez-vous ajouter un autre joueur ?"));
        c = Lire.getConfirmation();
      }
      // choix de niveau de jeu
      Output.afficheLigne(Output.magenta("Choisissez un Niveau de Jeu qui vous convient! :"));
      for (i = 0; i < NiveauJeu.values().length; i++){
        Output.afficheLigne(Output.rouge("  " + i + " - " +
            NiveauJeu.values()[i].toString()));
      }
      // création du jeu et début de la partie
      new Jeu(u, NiveauJeu.values()[Lire.getInt(0, NiveauJeu.values().length - 1)]).joue();
      // demande à l'utilisateur s'il souhaite rejouer
      Output.afficheLigne(
          Output.vert("Voulez-vous faire une nouvelle partie ?"));
      c = Lire.getConfirmation();
    }
    }
    
}
