
package jeuplateau;

public enum NiveauJeu {
 DEBUTANT("Débutant", 4, 4, 20, true),
  FACILE("Facile", 6, 6, 49, true),
  MOYEN("Moyen", 8, 8, 99, true),
  DIFFICILE("Difficile", 12, 12, 99, false),
  EXTREME("Extrême", 16, 16, 999, false),
  IMPOSSIBLE("Impossible", 16, 32, 99999, false);
  private String m_niveau; // nom du niveau
  private int m_largeur, // largeur du plateau
              m_hauteur, // hauteur du plateau
              m_valeurMax; // valeur maximale que peut prendre une case
  private boolean m_indicesVisibles; // indique si les indices des cases doivent
  // être visibles ou non
  // constructeur
  NiveauJeu(String niveau, int largeur, int hauteur, int valeurMax,
      boolean indicesVisibles){
    setNiveau(niveau);
    setLargeur(largeur);
    setHauteur(hauteur);
    setValeurMax(valeurMax);
    setIndicesVisibles(indicesVisibles);
  }
  // accesseurs en lecture
  public int getHauteur(){return m_hauteur;}
  public int getLargeur(){return m_largeur;}
  private String getNiveau(){return m_niveau;}
  public int getValeurMax(){return m_valeurMax;}
  public boolean isIndicesVisibles(){return m_indicesVisibles;}
  // accesseurs en écriture
  public void setHauteur(int h){m_hauteur = h;}
  public void setIndicesVisibles(boolean iv){m_indicesVisibles = iv;}
  public void setLargeur(int l){m_largeur = l;}
  private void setNiveau(String n){m_niveau = n;}
  public void setValeurMax(int vm){m_valeurMax = vm;}
  public String toString(){
    // renvoie le nom du niveau sous forme de chaine
    return getNiveau();
  }
}
