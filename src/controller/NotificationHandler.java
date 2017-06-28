/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template f    ile, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.DatabaseQueries;
import view.MessageBoxes;

/**
 *
 * @author boughriba
 */
public class NotificationHandler {
    
    public DatabaseQueries db  = new DatabaseQueries();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    
    public void start_handling()
    {
        Multithreading a = new Multithreading();
        a.start();
    }
    
    private class Multithreading extends Thread {
        @Override
        public void run()
        {
            String[] dates = db.getTacheFinaleDate();  

                Date today = new Date();
                Date in_15_days = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 15));
                for(int i = 0 ; i < dates.length ; i++)
                {
                    try {
                        System.out.println("ééééé "+ in_15_days + "aaaandd : "+df.parse(dates[i]));

                        if(in_15_days.after(df.parse(dates[i])))
                        {
                            MessageBoxes.notification();
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(NotificationHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
    }
}
