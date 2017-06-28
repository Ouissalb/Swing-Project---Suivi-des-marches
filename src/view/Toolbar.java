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
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Toolbar extends JPanel {
    private JFileChooser fileChooser ;
    private FileListener fl ;

    private JButton load_btn ;
    private JButton load_tasks ;

    public void setFileListener(FileListener f)
    {
        this.fl = f;
    }

    public JButton getLoad_btn() {
        return load_btn;
    }

    public JButton getLoad_tasks() {
        return load_tasks;
    }

    public Toolbar()
    {
        setLayout(new FlowLayout());
        fileChooser = new JFileChooser();


        load_btn = new JButton("Load Projet");
        load_tasks = new JButton("Load Tache");
        add(load_tasks);
        add(load_btn);

        load_tasks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (fileChooser.showOpenDialog(Toolbar.this) == JFileChooser.APPROVE_OPTION)
                {
                    File selected = fileChooser.getSelectedFile();
                    FileEvent fe = new FileEvent(this, selected, load_tasks);

                    fl.fileChoosed(fe);
                }
            }
        });

        load_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (fileChooser.showOpenDialog(Toolbar.this) == JFileChooser.APPROVE_OPTION)
                {
                    File selected = fileChooser.getSelectedFile();
                    FileEvent fe = new FileEvent(this, selected, load_btn);
                    fl.fileChoosed(fe);
                }
            }
        });
    }
}
