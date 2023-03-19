
package jeuplateau;


public class Output {
   // cette classe gère l'affichage dans le terminal
  public static void affiche(Object x){
    // un enrobeur pour System.out.print() sensé être plus court à écrire
    System.out.print(x.toString());
  }
  public static void afficheErreur(Object e){
    // affiche une erreur dans le terminal
    afficheLigne(rouge("---- ERREUR ---------------------------------\n  " +
    e.toString() + "\n---------------------------------------------"));// elle retour les eurreur dans le code du programme 
  }
  public static void afficheLigne(Object x){
    // un enrobeur pour System.out.println() sensé être plus court à écrire
    affiche(x.toString() + "\n");
  }
  // ces méthodes servent à changer la couleur d'affichage d'un texte dans le
  // terminal (ex: blanc(Object) change le texte en blanc)
  public static String blanc(Object x){
    return Color.BLANC + x.toString() + Color.REINITIALISATION;
  }
  public static String bleu(Object x){
    return Color.BLEU + x.toString() + Color.REINITIALISATION;
  }
  public static String cyan(Object x){
    return Color.CYAN + x.toString() + Color.REINITIALISATION;
  }
  public static String jaune(Object x){
    return Color.JAUNE + x.toString() + Color.REINITIALISATION;
  }
  public static String magenta(Object x){
    return Color.MAGENTA + x.toString() + Color.REINITIALISATION;
  }
  public static String noir(Object x){
    return Color.NOIR + x.toString() + Color.REINITIALISATION;
  }
  public static String rouge(Object x){
    return Color.ROUGE + x.toString() + Color.REINITIALISATION;
  }
  public static String vert(Object x){
    return Color.VERT + x.toString() + Color.REINITIALISATION;
  }
}
