
package jeuplateau;

public class Plateau {
    // reprÃ©sente le plateau du jeu et le gÃ¨re
  private Case[][] m_cases; // le plateau en question
  private int m_largeur, // largeur du plateau
              m_hauteur; // hauteur du plateau
  // constructeur
  Plateau(int largeur, int hauteur, int valeurMax,
      boolean indicesVisibles){
    setLargeur(largeur);
    setHauteur(hauteur);
    setCases(new Case[getLargeur()][getHauteur()]);
    for (largeur = 0; largeur < getLargeur(); largeur++){
      for (hauteur = 0; hauteur < getHauteur(); hauteur++){
        setCase(largeur, hauteur, new Case(valeurMax, indicesVisibles));
      }
    }
  }
  public void affiche(){
    // affiche les cases du plateau
    Output.affiche(toString());
  }
  // accesseurs en lecture
  public Case getCase(int x, int y){return getCases()[x][y];}
  private Case[][] getCases(){return m_cases;}
  public int getHauteur(){return m_hauteur;}
  public int getLargeur(){return m_largeur;}
  // accesseurs en écriture
  private void setCase(int x, int y, Case c){getCases()[x][y] = c;}
  private void setCases(Case[][] c){m_cases = c;}
  private void setHauteur(int h){m_hauteur = h;}
  private void setLargeur(int l){m_largeur = l;}
  public String toString(){
    // renvoit une chaine de caractère contenant la représentation du plateau
    String r = "";
    int i, j;
    for (j = 0; j < getHauteur(); j++){
      for (i = 0; i < getLargeur(); i++){
        r += getCase(i, j).isCaseDecouverte() ?
            Output.rouge(getCase(i, j).toString()) + " " :
            Output.blanc(getCase(i, j).toString()) + " ";
      }
      r += "\n";
    }
    return r;
  }
  public boolean toutesLesCasesSontDecouvertes(){
    // la methode qui vérifie si toutes les cases du plateau ont été decouverte
    int i, j;
    boolean r = true;
    for(i = 0; i < getLargeur(); i++){
      for(j = 0; j < getHauteur(); j++){
        r &= getCase(i, j).isCaseDecouverte();
      }
    }
    return r;
  }
}
