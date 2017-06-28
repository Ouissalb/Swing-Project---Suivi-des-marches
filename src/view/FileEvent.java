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
import javax.swing.*;
import java.io.File;
import java.util.EventObject;

public class FileEvent extends EventObject {
    private File file ;
    private JButton sourceBtn;

    public JButton getSourceBtn() {
        return sourceBtn;
    }

    public File getFile() {
        return file;
    }

    public FileEvent(Object o) {
        super(o);
    }

    public FileEvent(Object o, File file, JButton source)
    {
        super(o);
        this.file = file;
        this.sourceBtn = source;
    }

}