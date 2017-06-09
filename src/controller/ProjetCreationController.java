package controller;

import java.util.Date;
import model.*;
import model.Projet;

public class ProjetCreationController {
    
    private DatabaseQueries dbQuerie = new DatabaseQueries();
    private Projet projet;
    
    public ProjetCreationController()
    {
        projet = new Projet();
    }
    
    public void setObjectif(String o)
    {
        projet.setObjectif(o);        
    }
    
    public void setDateFinale(Date d)
    {
        projet.setDateFinale(d);
    }
    
    public void setBudget(int b)            
    {
        projet.setBudget(b);
    }       
    
    public void ajouterTache(Tache t)
    {
        projet.taches.add(t);
    }
    
    public void addMaterial(Materiel m)
    {
        projet.materiels.add(m);
    }
    
    public void addLicence(Licence l)
    {
        this.projet.licences.add(l);
    }
    
    public Date getDateFinale()
    {
        return this.projet.getDateFinale();
    }
    
    public void stockerProjet()
    {
        if(this.dbQuerie.setProjetInDB(projet))
        {
            System.out.println("projet stored ok!");
            for(int i = 0 ; i < this.projet.taches.size() ; i++)
                if(!dbQuerie.setTache(this.projet.taches.get(i)))
                {
                    break;
                }
        }        
        System.out.println("le compte est bon");
    }
    
}

//employee plus service
//projet plus service id not autoincrement to keep trace of it in code
//tache with extern key : projet_id, plus contenu