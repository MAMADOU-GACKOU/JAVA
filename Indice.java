
package jeuplateau;


public enum Indice {
  SOMME("+"),
  DIFFERENCE("-"),
  PRODUIT("*"),
  QUOTIENT("/"),
  RESTE("%"),
  PUISSANCE("^"),
  MINIMUM("<"),
  MAXIMUM(">");
  private String m_indice; // sert à contenir la chaine représentant l'indice
  // constructeur
  Indice(String indice){
    setIndice(indice);
  }
  // accesseur en lecture
  private String getIndice(){return m_indice;}
  public static double getResultat(Case c1, Case c2)
      throws RuntimeException, ArithmeticException{
    // renvoie la valeur de l’indice entre c1 et c2 selon l’indice de c1
    int  r =  c1.getValeur(), s =  c2.getValeur();
    switch (c1.getIndice()){
      case SOMME:
        r += s;
        break;
      case DIFFERENCE:
        r -= s;
        break;
      case PRODUIT:
        r *= s;
        break;
      case QUOTIENT:
        if (s != 0){
          r /= s;
        }else{
          r = 0;
          throw new ArithmeticException("Erreur : Division par 0.");
        }
        break;
      case RESTE:
        r %= s;
        break;
      case PUISSANCE:
        r =(int) Math.pow(r, s);
        break;
      case MAXIMUM:
        r = r > s ? r : s;
        break;
      case MINIMUM:
        r = r < s ? r : s;
        break;
      default:
        r = 0;
        throw new RuntimeException("Opération inconnue.");
    }
    return r;
  }
  // accesseur en écriture
  private void setIndice(String i){m_indice = i;}
  public String toString(){
    // renvoie l'indice sous forme d'une chaine de caractères
    return getIndice();
  }
}
