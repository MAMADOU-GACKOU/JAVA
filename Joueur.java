
package jeuplateau;


public class Joueur {
  
  private String m_nom; // contient le nom du joueur
  private long m_score; // contient le score actuel du joueur
  // constructeur
  Joueur(String nom){
    setNom(nom);
    setScore(0);
  }
  // accesseurs en lecture
  public String getNom(){return m_nom;}
  public long getScore(){return m_score;}
  public void joue(Plateau p, NiveauJeu n){
    //simule le deroulement d'un tour
    Case[] c = new Case[2];
    int i = 0, j = 0, k;
    int d;
    boolean b;
    Output.afficheLigne(Output.jaune("C'est A  " + getNom() + " de jouer."));
    p.affiche();
    // demande au joueur de selectionner deux cases
    for(k = 0; k < 2; k++){
      b = true;
      Output.afficheLigne(Output.jaune("Selectionnez la " + (k == 0 ?
          "première" : "seconde") + " case."));
      while(b){
        Output.afficheLigne(Output.jaune("Entrez un numero de ligne :"));
        j = Lire.getInt(1, p.getHauteur()) - 1;
        Output.afficheLigne(Output.jaune("Entrez un numero de colonne :"));
        i = Lire.getInt(1, p.getLargeur()) - 1;
        if(b = p.getCase(i, j).isCaseDecouverte()){
          Output.afficheErreur("Cette case a deja été devoilée. " +
              "Choisissez-en une autre !");
        }
      }
      c[k] = p.getCase(i, j);
      System.out.println(""+p.getCase(i, j).getValeur());
      if(c[0].equals(c[1])){
        Output.afficheErreur("Vous devez choisir deux cases distinctes.");
        k = 0;
      }
    }
    // affiche les indices des cases
    for(k = 0; k < 2; k++){
      d = 0;
      try{
        d = (int)Indice.getResultat(c[k], c[(k + 1) % 2]);
      }catch(Exception e){
        Output.afficheErreur(e);
      }finally{
        Output.afficheLigne(Output.magenta("Indice de la " + (k == 0 ?
            "première" : "seconde") + " case : " + d));
      }
    }
    // propose au joueur de faire une hypothèse
    Output.afficheLigne(Output.magenta("Faire une hypothèse ?"));
    if(Lire.getConfirmation()){
      i = 0;
      for(k = 0; k < 2; k++){
        Output.afficheLigne(Output.magenta(
            "Entrez la valeur hypothétique de la " + (k == 0 ? "première" :
            "seconde") + " case."));
        i += c[k].isValeur(Lire.getInt(0, n.getValeurMax())) ? 1 : 0;
      }
      switch(i){
        case 2:
          Output.afficheLigne(
              Output.magenta("Les deux hypothèses sont justes."));
          reussi(c[0].getValeur() + c[1].getValeur());
          for(k = 0; k < 2; k++){
          c[k].setCaseDecouverte(true);
        
            
          }
          break;
        case 1:
          Output.afficheLigne(
              Output.vert("L'une des deux hypothèses est fausse ou toutes les deux .."));
          break;
        default:
          Output.afficheLigne(
              Output.vert("Les deux hypothèses sont fausses."));
      }
    }
    
  }
  public void reussi(long s){
    // ajoute un entier s au score actuel du joueur
    setScore(getScore() + s);
  }
  // accesseurs en Ã©criture
  private void setNom(String n){m_nom = n;}
  private void setScore(long s){m_score = s;}
  public String toString(){
    // retourne les caractÃ©ristiques du joueur sous forme d'une chaine de
    // caractÃ¨res
    return Output.magenta("Nom : " + getNom() + "\t[Score : " +
    getScore() + "]");
  }
}
