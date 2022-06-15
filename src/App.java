import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame fr = createWindow();
        createMenuBar(fr);
        fr.setVisible(true);
    }
    
    public static JFrame createWindow() {
        //Creating the window
        JFrame frame = new JFrame("Manga App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        return frame;
    }

    public static void createMenuBar(JFrame frame) {
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        mb.add(m1);
        JMenuItem i1 = new JMenuItem(new AbstractAction("Open") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Open FIle
                System.out.println("Opening FIle");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = filechooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = filechooser.getSelectedFile();
                    System.out.println(selectedFile);
                }
            }
        });
        JMenuItem i2 = new JMenuItem("Save");
        JMenuItem i3 = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Exit the app
                frame.dispose();
            }
            
        });
        m1.add(i1);
        m1.add(i2);
        m1.add(i3);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
    }
}
