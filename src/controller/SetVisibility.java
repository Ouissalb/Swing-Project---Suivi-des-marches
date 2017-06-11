package controller;

import java.awt.Component;
import java.awt.Container;

public class SetVisibility {
	public static void setComponentVisibility(Container container,
	        Class<? extends Component> componentClass, boolean visible) {
	    for (Component c : container.getComponents()) {
	        if (componentClass.isAssignableFrom(c.getClass())) {
	            c.setVisible(visible);
	        } else if (c instanceof Container) {
	            setComponentVisibility((Container)c, componentClass, visible);
	        }
	    }
	}

}
