/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.*;

/**
 *
 * @author boughriba
 */
public class TacheCreationController {
    private Tache tache;
    
    public int getNumTache()
    {
        return this.tache.getNumero();
    }
    
    public TacheCreationController()
    {
        tache = new Tache();
    }
    
    public void destroy()
    {
        --Tache.compteur;
    }
    
     public void setContenu(String c)
    {
        tache.setContenu(c);
    }   
    
    public void setDate(Date d)
    {
        this.tache.setDateFinale(d);
    }
    
    public void setDuree(int j)
    {
        tache.setDuree(j);
    }
      
    public Tache getTache()
    {
        return this.tache;
    }
}
