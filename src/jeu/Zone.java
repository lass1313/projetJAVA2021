package jeu;
import java.util.HashMap;
/**
 * cette classe gère les zones  
 *  une zone contient  une description et un nom d'image
 * */

public class Zone 
{
    private String description;
    private String nomImage;
    /**
     * un hashMap qui contient l'ensemble de zone 
     * 
     * les valeurs sont des objets zone(description + nomImage)
     * */
    private HashMap<String,Zone> sorties;  

    public Zone(String description, String image) {
        this.description = description;
        nomImage = image;
        sorties = new HashMap<>();
    }
    /**
     * ajoute une sortie 
     * @param sortie la sortie de la zone 
     * @pram zoneVosine la zone vosine 
     * */

    public void ajouteSortie(Sortie sortie, Zone zoneVoisine) {
        sorties.put(sortie.name(), zoneVoisine);
    }
    /**
     * cette methode retoure le nom de l'image
     * */
    
    public String nomImage() {
        return nomImage;
    }
     
    public String toString() {
        return description;
    }
    /**
     * cette methode retoure la description longue 
     * */

    public String descriptionLongue()  {
        return "   " + description + "\n   Sorties : " + sorties();
    }
    /**
     * cette methode retoure  la sortie tapée 
     * */
    private String sorties() {
        return sorties.keySet().toString();
    }
    /**
     * permet de sortir 
     * @param direction la direction de la sortie 
     * */

    public Zone obtientSortie(String direction) {
    	return sorties.get(direction);
    }
}

