
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Projet;
import model.Tache;
import view.FileEvent;
import view.MessageBoxes;

/**
 *
 * @author boughriba
 */

public class FileHandling {
    
    public static Projet new_project= null;
    public static Tache task= null;
    
    public static void load_file(FileEvent f, String type)
    {
        File file = f.getFile();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(file);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            String objectif  ="";
            Date date = null;            
            int budget = 0;
            int compt = 1;
                if (type.equalsIgnoreCase("projects"))
                {
                    while ((line = br.readLine()) != null )
                    {if(compt == 2)
                        objectif = line;
                    if(compt == 4)
                       date = (Date) df.parse(line);

                    if(compt == 6)
                        budget = Integer.parseInt(line.trim());
                    
                    ++compt;
                    }
                    new_project = new Projet(objectif, date ,budget);
                    System.out.println("le budget  :" + new_project.getBudget());
                }
                else
                {
                    task = new Tache();
                    compt = 1;
                    while ((line = br.readLine()) != null )
                    {
                        if(compt == 2)
                            task.setContenu(line);
                        if(compt == 4)
                        {
                            date = (Date) df.parse(line);
                            if(new_project.getDateFinale().before(date))
                                MessageBoxes.incorrectDate();
                            else
                                task.setDateFinale(date);
                        }
                        if(compt == 6)
                            task.setDuree(Integer.parseInt(line.trim()));
                        
                        ++compt;
                    }  
                    System.out.println(task.getDate());
                    new_project.taches.add(task);
                    ProjetCreationController pcc = new ProjetCreationController(new_project);
                    pcc.stockerProjet();                    
                }                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
