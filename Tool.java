/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuplateau;

/**
 *
 * @author 33758
 */
public class Tool {
   // cette classe sert de fourre-tout à méthodes diverses
  public static int getNbChiffre(long i){
    // renvoie le nombre de chiffres que possède un entier dans sa
    // représentation décimale
    int r = 1;
    if(i != 0){
      for(r = 0; i != 0; i /= 10, ++r);
    }
    return r;
  }
}
