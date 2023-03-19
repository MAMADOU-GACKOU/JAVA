
package jeuplateau;
import java.util.Random;
public class Case {
  // représente une case du plateau
  private Indice m_indice; // indice de la case
  private int m_valeur; // valeur de la case
      private int   m_valeur_max; // valeur maximale que peut prendre la case
       private boolean m_indice_visible; // vaut true si  l'indice doit être affiché
       private boolean m_case_decouverte; // vaut true si  la case est découverte
  // constructeur de la classe
  Case(int max, boolean indiceVisible){
    setValeurMax(max);
    setCaseDecouverte(false);
    setIndiceVisible(indiceVisible);
    genCase();
  }
 private void genCase(){
    // génère la case aléatoirement dans un intervalle de 0 à 1.
    Random r = new Random();
    // choisi un indice parmi ceux présents dans l'énumération
    setIndice(Indice.values()[r.nextInt(Indice.values().length)]);
    setValeur(r.nextInt(10));// elle donne une valeur aléatoire entre 0  et 9 inclus .
  }
  // Presentatino des accesseurs en lecture
  public Indice getIndice(){return m_indice;}
  public int getValeur(){return m_valeur;}
  private int getValeurMax(){return m_valeur_max;}
  public boolean isCaseDecouverte(){return m_case_decouverte;}
  private boolean isIndiceVisible(){return m_indice_visible;}
  public boolean isValeur(int v){return getValeur() == v;} // vérifie si la valeur de la case est égale à la valeur passée en paramètre
  // accesseurs en écriture
  public void setCaseDecouverte(boolean d){m_case_decouverte = d;}
  private void setIndice(Indice i){m_indice = i;}
  private void setIndiceVisible(boolean iv){m_indice_visible = iv;}
  private void setValeur(int v){m_valeur = v;}
  private void setValeurMax(int vm){m_valeur_max = vm;}
  @Override
  public String toString(){ // cette methode renvois la presentation du tableau en totalité .
    String r = "";
    int i;
    if(isCaseDecouverte()){
      // ajoute un nombre d'espace avant la valeur pour coller avec un affichage
      // sous forme de tableau
      for(i = 0; i < Tool.getNbChiffre(getValeurMax()) - Tool.getNbChiffre(getValeur()); r += " ", i++)
      // ajoute la valeur sous forme de chaine
      r += "" + getValeur();
    }else{
      // ajoute le nombre de '#' correspondant Ã  la valeur la plus grande
      // possible pour la case
      for(i = 0; i < Tool.getNbChiffre(getValeurMax()); r += "&", i++);
    }
    // ajoute l'indice selon s'il doit etre represente ou non
    r += isIndiceVisible() || isCaseDecouverte() ? getIndice().toString() : "&";
    return r;
  }
}
