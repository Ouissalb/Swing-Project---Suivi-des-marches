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
}
