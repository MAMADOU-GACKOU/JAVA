/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuplateau;


public enum Color {
     // couleur d'écriture dans le terminal
  NOIR("\u001B[30m"),
  ROUGE("\u001B[31m"),
  VERT("\u001B[32m"),
  JAUNE("\u001B[33m"),
  BLEU("\u001B[34m"),
  MAGENTA("\u001B[35m"),
  CYAN("\u001B[36m"),
  BLANC("\u001B[37m"),
  REINITIALISATION("\u001B[39m");
  private String m_couleur; // sert à contenir la séquence d'échappement
  // constructeur
  Color(String couleur){
    setCouleur(couleur);
  }
  // accesseur en lecture
  private String getCouleur(){return m_couleur;}
  // accesseur en écriture
  private void setCouleur(String c){m_couleur = c;}
  public String toString(){
    // renvoie la séquence d'échappement
    return getCouleur();
  }
}
