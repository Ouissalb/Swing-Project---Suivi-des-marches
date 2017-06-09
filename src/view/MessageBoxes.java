package view;

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
	    "Erreur",
            JOptionPane.ERROR_MESSAGE);
        }
        public static void incorrectDureeTache()
        {
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
		"Entrez une durée raisonnable pour la tâche",
	    "Erreur",
            JOptionPane.ERROR_MESSAGE);
        }
        public void incorrectDate()
        {
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(), "Entrez un date inférieure à la date finale du projet",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
        public static void vousAvezUneNotification()
        {
        	
            JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(),
            		// This should be a variable instead, that will show whether or not he has new notifications
		"Vous avez de nouvelles notifications");
        }
        
}