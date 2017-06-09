/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author boughriba
 */
import javax.swing.JOptionPane;

public class MessageBoxes 
{
	public static void usernameDoesntExist()
	{
			JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
			"Le nom d'utilisateur saisi n'existe pas !",
		    "Inane error",
		    JOptionPane.ERROR_MESSAGE);
	}
	public static void incorrectPassword()
	{
		JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
		"Mot de passe incorrecte !",
	    "Inane error",
	    JOptionPane.ERROR_MESSAGE);
	}
        public static void incorrectDuree()
        {
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
		"Renseignez une durée de plus de 15 jours (commencant d'aujourd'hui)",
	    "Inane error",
            JOptionPane.ERROR_MESSAGE);
        }
        public static void incorrectObjectif()
        {
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
		"champ objectif doit etre renseigné",
	    "Inane error",
            JOptionPane.ERROR_MESSAGE);
        }
        public static void incorrectBudget()
        {
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
		"Entrez un budget",
	    "Inane error",
            JOptionPane.ERROR_MESSAGE);
        }
        public static void incorrectContenuTache()
        {
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
		"Entrez une description (contenu) de la tâche",
	    "Inane error",
            JOptionPane.ERROR_MESSAGE);
        }
        public static void incorrectDureeTache()
        {
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
		"Entrez une durée raisonnable pour la tâche",
	    "Inane error",
            JOptionPane.ERROR_MESSAGE);
        }
        public void incorrectDate()
        {
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(), "Entrez un date inférieure à la date finale du projet",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
        }
}
