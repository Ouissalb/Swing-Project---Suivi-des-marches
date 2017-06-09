package model;

import java.util.ArrayList;
import java.util.Date;


public class Tache {
    public static int compteur = 1;
    private int numero;
    private Date date_finale;
    private int duree;
    private String etat;
    private String contenu;
    private ArrayList<Commentaire> commentaires;
    private int id_projet_relatif;

    public Tache()
    {
        numero = compteur;
        ++compteur;
        commentaires = new ArrayList<Commentaire>();
    }    
    
    public Date getDate()
    {
        return this.date_finale;
    }
    
    public int getNumero()
    {
        return this.numero;
    }    
    
    public void setContenu(String c)
    {
        this.contenu = c;
    }
    
    public String getContenu()
    {
        return this.contenu;
    }
    
    public String getEtat()
    {
        return this.etat;
    }
    
    public void setDuree(int j)
    {
        this.duree = j;
    }
    
    public int getDuree()
    {
        return this.duree;
    }
    
    public void setDateFinale(Date f)
    {
        date_finale = f ;
    }
}