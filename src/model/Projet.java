package model;

import java.util.ArrayList;
import java.util.Date;

public class Projet {
    //public static int compteur = 1;
    //private int id;
    private String objectif;
    private Date date_finale;
    private int budget;
    private String service;
    public ArrayList<Materiel> materiels;
    public ArrayList<Tache> taches;
    public ArrayList<Licence> licences;
    
    public Projet()
    {
        //id = compteur;
        //++compteur;
        materiels = new ArrayList<Materiel>();
        taches = new ArrayList<Tache>();
        licences = new ArrayList<Licence>();
    }
    
    public Projet(String o, Date d, int b)
    {
        this.objectif = o;
        this.date_finale = d;
        this.budget = b;
        materiels = new ArrayList<Materiel>();
        taches = new ArrayList<Tache>();
        licences = new ArrayList<Licence>();
    }
    
    public void setObjectif(String o)
    {
        this.objectif = o;
    }
    
    public void setDateFinale(Date d)
    {
        this.date_finale = d;
    }
    
    public Date getDateFinale()
    {
        return this.date_finale;
    }
    
    public void setBudget(int b)
    {
        this.budget = b;
    }
    
    public int getBudget()
    {
        return this.budget;
    }
    
    public String getObjectif()
    {
        return this.objectif;
    }
    
    //public int getId()
    //{
    //    return this.id;
    //}
}