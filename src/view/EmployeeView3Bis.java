/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DataProc;
import model.DatabaseQueries;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import javax.swing.*;

/**
 *
 * @author boughriba
 */
public class EmployeeView3Bis {
    
    public static JFrameWithBackgroundImage employeeView3;
    public static int[] etats ;

        public DataProc dp = new DataProc();
        public static int num_tache = 1;
        public static int id_tache;
        
	public EmployeeView3Bis() {
		initialize();
		System.out.println("ID TACHE : "+id_tache);
                etats = dp.getCommsEtat(id_tache);
                for(int i = 0 ; i < etats.length; i++)
                    System.out.println("etats : "+ etats[i]);
	}
        
        public void initialize()
        {
            employeeView3 = new JFrameWithBackgroundImage("/blue3.png");
            employeeView3.setBounds(100, 100, 900, 600);
            employeeView3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            employeeView3.setLocationRelativeTo(null);
            employeeView3.getContentPane().setLayout(null);
            
            JTabbedPane tp = new JTabbedPane();
                        
            employeeView3.setVisible(true);
            
            JPanel p1=new JPanel();
            p1.setLayout(null);
            
          //  JTextField etat = new JTextField("ajout colimn etat...");
          //  JLabel etatt = new JLabel("Etat :");
            JLabel label1 = new JLabel("Objectif :");
            JLabel label2 = new JLabel("Budget (MDH) :");
            JLabel label4 = new JLabel("Date de fin :");            
            JLabel label5 = new JLabel("Materiels :");
            JLabel label6 = new JLabel("Licences :");

            JTextField tf1 = new JTextField("objectif");            
            JTextField tf2 = new JTextField("tf budget");
            JTextField tf3 = new JTextField("dtae1");

            String[] materiels = dp.getMateriels(EmployeeView1.index);
                
            DefaultListModel<String> list1model = new DefaultListModel();
            
            for(int i = 0; i < materiels.length; i++)
                if(materiels[i] != null)
                    list1model.addElement("materiel "+i+" : "+materiels[i]);
                
            JList list1 = new JList(list1model);
            
            String[] licences = dp.getLicences(EmployeeView1.index);
                
            DefaultListModel<String> list2model = new DefaultListModel();
            for(int i = 0; i < licences.length; i++)
                if(licences[i] != null)
                    list2model.addElement("licence "+i+" : "+licences[i]+"\n");    
            
            JList list2 = new JList(list2model);
            
       /*     etatt.setBounds (0, 40 , 210, 20);
            p1.add(etatt);*/
            
       /*     etat.setBounds(219 , 40, 210 ,20);
            p1.add(etat);*/
            
            label1.setBounds(0, 80, 210, 20);
            p1.add(label1);
            
            tf1.setBounds(219 , 80, 210, 20);
            p1.add(tf1);
            
            label2.setBounds(0, 120, 210,20);
            p1.add(label2);
            
            tf2.setBounds(219, 120 , 210, 20);
            p1.add(tf2);
            
            label4.setBounds(0,160, 210, 20);
            p1.add(label4);
            
            tf3.setBounds(219, 160, 210, 20);
            p1.add(tf3);
            
            label5.setBounds(0, 200, 210 ,20);
            p1.add(label5);
            
            list1.setBounds(0,240,210,100);
            p1.add(list1);
            
            label6.setBounds(300,200,210,20);
            p1.add(label6);
            
            list2.setBounds(300,240,210,100);
            p1.add(list2);
            
            
            JPanel p2=new JPanel();  
            p2.setLayout(null);
            
            JLabel ntache = new JLabel("N° Tache : "+num_tache);
            
            ntache.setBounds(300,10,210,20);
            p2.add(ntache);
                
            String[] task_contenu = dp.getTasksContenu(EmployeeView1.index);
            
            JLabel contenu = new JLabel("Contenu :");
            contenu.setBounds(0,40,210,20);
            p2.add(contenu);
            
            JTextField tfc = new JTextField("");
            tfc.setBounds(219,40,210,20);
            p2.add(tfc);
            
            tfc.setText(task_contenu[num_tache-1]);
            
            String[] task_date = dp.getTasksDate(EmployeeView1.index);
            
            JLabel datef = new JLabel("Date finale :");
            datef.setBounds(0,80,210,20);
            p2.add(datef);
            
            JTextField df = new JTextField(task_date[num_tache-1]);
            df.setBounds(219,80,210,20);
            p2.add(df);
            
            JLabel etat_tache = new JLabel("etat :");
            etat_tache.setBounds(0,120,210,20);
            p2.add(etat_tache);
            
            String[] task_etat = dp.getTasksEtat(EmployeeView1.index);            
            
            JTextField tfet = new JTextField("");
            
            if(task_etat[num_tache-1].equals("0"))
                tfet.setText("en cours");
            else
                tfet.setText("terminée");
            
            tfet.setBounds(219,120,210,20);
            p2.add(tfet);
            
            JLabel a = new JLabel("commentaires :");
            a.setBounds(300,160,210,20);
            p2.add(a);
            
            DefaultListModel<String> comlistmodel = new DefaultListModel();
            
            id_tache = dp.getIdTache(task_contenu[num_tache-1],task_date[num_tache-1]);
            System.out.println("ID TACHE 2"+ id_tache );
            String[] comms = dp.getCommentaires(EmployeeView1.index,id_tache);
            
            System.out.println(comms[0]);
            for(int i = 0; i < licences.length; i++)
                if(comms[i] != null)
                {
                    System.out.println(comms[i]);
                    comlistmodel.addElement(""+(i+1)+" : "+comms[i]+" %\n");
                }    
                            
            JList commentaires = new JList(comlistmodel);
            commentaires.setCellRenderer( new WhiteYellowCellRenderer() );

            commentaires.setBounds(50,180,600,200);
            p2.add(commentaires);
            
            commentaires.setLayoutOrientation(JList.VERTICAL);
            
            JTextField un_commentaire = new JTextField();
            un_commentaire.setBounds(50,420,400,40);
            p2.add(un_commentaire);
            
            JButton commenter = new JButton("commenter");
            commenter.setBounds(450,420,100,40);
            p2.add(commenter);
            
            JButton annuler = new JButton("Annuler");
            annuler.setBounds(550,420,100,40);
            p2.add(annuler);
            
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(3,1));
            
            JButton next = new JButton("next");
            JButton valider = new JButton("valider");
            
            p.add(valider);
            p.add(next);
            
            p.setBounds(600,40,210,100);
            p2.add(p);
            
            JRadioButton radio1 = new JRadioButton("Urgent");
            JRadioButton radio2 = new JRadioButton("Quotidien",true);
            JRadioButton radio3 = new JRadioButton("Informatif");
            
            ButtonGroup rg = new ButtonGroup();
            rg.add(radio1);
            rg.add(radio2);
            rg.add(radio3);
            
            JPanel rbg = new JPanel();
            rbg.add(radio1);
            rbg.add(radio2);
            rbg.add(radio3);
            
            rbg.setBounds(50,460,400,40);
            
            p2.add(rbg);
            
            tp.setBounds(5,5,900, 600);  
            tp.add("Informations Générales",p1);  
            tp.add("Les Tâches",p2);  
            
            String[] objectifs = dp.getObjectif(EmployeeView1.index);
            tf1.setText(objectifs[0]);                                               
            
            tf2.setText(dp.getBudget(EmployeeView1.index));
            
            tf3.setText(dp.getDate(EmployeeView1.index));
            
            employeeView3.add(tp);
            
            next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(dp.countTasks(EmployeeView1.index) - num_tache != 0)
                {
                    ++num_tache;
                    initialize();
                    etats = dp.getCommsEtat(id_tache);
                    for(int i = 0 ; i < etats.length; i++)
                        System.out.println("etats : "+ etats[i]);
                }
                else
                {
                    JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(), "Il n y a plus de taches",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
            });
            
            commenter.addActionListener( new ActionListener(){
                @Override 
                public void actionPerformed(ActionEvent e)
                {
                    if(radio1.isSelected())
                        dp.setCommentaire(EmployeeView1.index, id_tache, un_commentaire.getText(),1); 
                    if(radio2.isSelected())
                        dp.setCommentaire(EmployeeView1.index, id_tache, un_commentaire.getText(),2); 
                    if(radio3.isSelected())                
                        dp.setCommentaire(EmployeeView1.index, id_tache, un_commentaire.getText(),3); 
                    
                    comlistmodel.addElement(un_commentaire.getText());
                    commentaires.setModel(comlistmodel);
                    un_commentaire.setText("");
                }
            });
            
            un_commentaire.addFocusListener( new FocusListener(){
                @Override
                public void focusGained(FocusEvent e) {
                    if(radio1.isSelected())
                        un_commentaire.setBackground(Color.RED);
                    if(radio2.isSelected())
                        un_commentaire.setBackground(Color.white);
                    if(radio3.isSelected())
                        un_commentaire.setBackground(Color.GREEN);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    un_commentaire.setBackground(Color.white);
                }
                
            });
            
            annuler.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    un_commentaire.setText("");
                }
            });
            valider.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                	DatabaseQueries.validerTacheEmp(dp.getIdTache(task_contenu[num_tache-1],task_date[num_tache-1]));
                	//DatabaseQueries.projetValide(Sproject.index);
                }
            });
            
        }
        public static class WhiteYellowCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
          
            System.out.println(etats[index]);
            if(etats[index] == 1)
                c.setBackground(Color.RED);
            if(etats[index] == 2)
                c.setBackground(Color.white);
            if(etats[index] == 3)
                c.setBackground(Color.GREEN);
          
            return c;
        }
    }
}
