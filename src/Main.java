import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    //Calling app class
    public static void main(String[] args) {
        app obj = new app();
    }
}

class app   {

    public app(){
        //Creating new frame
        JFrame x = new JFrame("Prometheus IDE");
        JTextArea textArea = new JTextArea(45,140);

// Add the text area to the center of the layout
        x.add(textArea, BorderLayout.CENTER);

        ActionListener ax = new ActionListener() {
            //Calling app method again for new file option
            public void actionPerformed(ActionEvent e) {
                app newobj = new app();
            }
        };

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Saving text as txt file
                String body = textArea.getText();
                filesaver fs = new filesaver(body);
            }
        };

        ActionListener ab= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app newoby = new app();
                fileopener obj2 = new fileopener(textArea);
            }
        };

        ActionListener bc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame z = new JFrame("Info");
                JLabel l2= new JLabel("Prometheus IDE v1.0");
                JLabel l3= new JLabel("Created by SpaciousCoder78 @ GitHub ");
                z.add(l2);
                z.add(l3);
                z.setLayout(new FlowLayout());
                z.setVisible(true);
                z.setSize(400,400);


            }
        };



        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File"); //Menu bar item: File
        JMenu info = new JMenu("Info");// Menu bar item: Info
        JMenu run = new JMenu("Run");//menu bar run item
        //adding them to menubar
        menuBar.add(fileMenu);
        menuBar.add(run);
        menuBar.add(info);

        //**********File menu option**************
        JMenuItem saveMenuItem = new JMenuItem("Save File");// File menu option: Save file
        JMenuItem newMenuItem = new JMenuItem("New File");// File menu option:New file
        JMenuItem OpenFileItem = new JMenuItem("Open File");// File menu option: Open File
        fileMenu.add(newMenuItem);//adding all the options to file menu
        fileMenu.add(saveMenuItem);
        fileMenu.add(OpenFileItem);
        //*********Info menu options************
        JMenuItem infobox = new JMenuItem("Info");
        info.add(infobox);
        //***********Run menu options************
        JMenuItem runCode = new JMenuItem("Run Code");
        run.add(runCode);
        x.setJMenuBar(menuBar);

        //*********Adding action listeners to buttons***********
        saveMenuItem.addActionListener(al);//calling saving menu
        newMenuItem.addActionListener(ax);//calling new file
        OpenFileItem.addActionListener(ab);
        infobox.addActionListener(bc);

        x.setLayout(new FlowLayout());

// Create a text area


        x.setVisible(true);
        x.setSize(400,400);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class fileopener {
    public fileopener(JTextArea textArea) {
        // Open a file chooser dialog and allow the user to select a text file to open
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open .HC File");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Read the contents of the selected file and display them in the text area
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                textArea.setText(""); // clear the text area
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (Exception e) {

            }
        }
    }

}

class filesaver {
    //String body;
    JFrame frame;

    public filesaver(String body) {
        //this.body = body;
        frame = new JFrame("Prometheus IDE");

        JLabel l2= new JLabel("Enter the file name: ");
        JTextField t3 = new JTextField(20);
        JButton b= new JButton("Save file");
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setSize(400,400);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filepath=t3.getText();
                try (FileOutputStream fos = new FileOutputStream(filepath)) {
                    FileWriter fw = new FileWriter(filepath, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println(body);
                    pw.flush();
                    pw.close();
                    JOptionPane.showMessageDialog(null,"Record Saved");

                }
                catch (Exception x){
                }
            }
        });

        frame.pack();
        frame.add(l2);
        frame.add(t3);
        frame.add(b);
    }
}