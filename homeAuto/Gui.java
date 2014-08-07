import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.*;
/*
 * Gui.java requires the following file:
 *    images/wavy.gif
 */
public class Gui extends JPanel {
    protected JButton livingRoom, kitchen, bedroom, bathroom, office, familyRoom;
    protected JLabel tv, cable, xbox;
    protected String radioSetting = "";
    //RadioListener myListener = null;
    public Gui() {
        super(new GridLayout(1,0));
        
        //Keep references to the next few borders,
        //for use in titles and compound borders.
        Border blackline, raisedetched, loweredetched,
               raisedbevel, loweredbevel, empty;

        //A border that puts 10 extra pixels at the sides and
        //bottom of each pane.
        Border paneEdge = BorderFactory.createEmptyBorder(0,10,10,10);

        blackline = BorderFactory.createLineBorder(Color.black);
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        empty = BorderFactory.createEmptyBorder();

        //First pane: simple borders
        //On top of that: gridlayout
        JPanel simpleBorders = new JPanel();
        JPanel gridlayout = new JPanel();
        //Grid Layout(rows, columns,xpadding, ypadding
        gridlayout.setLayout(new GridLayout(5,1,5,5));
        //gridlayout.getColumnModel().getColumn(0).setPreferredWidth(270);
        //gridlayout.getColumnModel().getColumn(1).setPreferredWidth(120);
        //gridlayout.getColumnModel().getColumn(2).setPreferredWidth(100);
        //gridlayout.getColumnModel().getColumn(3).setPreferredWidth(90);
        gridlayout.setSize(15,15);
        simpleBorders.setBorder(paneEdge);
        simpleBorders.setLayout(new BoxLayout(simpleBorders,
                                              BoxLayout.Y_AXIS));
        
        
        /*livingRoom.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                if (livingRoom.getText() == "Living Room"){
                    livingRoom.setText("Yay! It works! ");}
                else if (livingRoom.getText() == "Yay! It works! "){
                    livingRoom.setText("Living Room");}
            }
        }); */  
        
        JPanel tvPanel = new JPanel();
        tvPanel.setLayout(new GridLayout(1,3));
        tv = new JLabel("T.V.:");
        tvPanel.add(tv);
        final JRadioButton tvOn = new JRadioButton("On");
        final JRadioButton tvOff = new JRadioButton("Off");
        tvOn.setSelected(true);
        tvPanel.add(tvOff);
        tvPanel.add(tvOn);
        tvPanel.setSize(15,15);
        
        JPanel cablePanel = new JPanel();
        cablePanel.setLayout(new GridLayout(1,3));
        cable = new JLabel("CableBox:");
        cablePanel.add(cable);
        final JRadioButton cableOn = new JRadioButton("On");
        final JRadioButton cableOff = new JRadioButton("Off");
        cableOn.setSelected(true);
        cablePanel.add(cableOff);
        cablePanel.add(cableOn);
        cablePanel.setSize(15,15);
        
        JPanel xboxPanel = new JPanel();
        xboxPanel.setLayout(new GridLayout(1,3));
        xbox = new JLabel("XBox:");
        xboxPanel.add(xbox);
        final JRadioButton xboxOn = new JRadioButton("On");
        final JRadioButton xboxOff = new JRadioButton("Off");
        xboxOn.setSelected(true);
        xboxPanel.add(xboxOff);
        xboxPanel.add(xboxOn);
        xboxPanel.setSize(15,15);
        
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridLayout(5,5));
        final JLabel results = new JLabel(radioSetting);
        resultsPanel.add(results);
        
        ButtonGroup tvGroup = new ButtonGroup();
        tvGroup.add(tvOff);
        tvGroup.add(tvOn);
        ButtonGroup cableGroup = new ButtonGroup();
        cableGroup.add(cableOff);
        cableGroup.add(cableOn);
        ButtonGroup xboxGroup = new ButtonGroup();
        xboxGroup.add(xboxOff);
        xboxGroup.add(xboxOn);
        
        JPanel blankPanel1 = new JPanel();
        JPanel blankPanel2 = new JPanel();
        JPanel blankPanel3 = new JPanel();
        
        final JButton submitButton = new JButton(" Submit ");
        submitButton.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                radioSetting = "";
                int temp = 10;
                results.setText(radioSetting);
                if (tvOff.isSelected())                    
                    temp -= 1;
                else if (tvOn.isSelected())                   
                    temp += 1;                                 
                if (cableOff.isSelected())                    
                    temp -= 2;                
                else if (cableOn.isSelected())
                    temp += 2;
                if (xboxOff.isSelected())                    
                    temp -= 3;                
                else if (xboxOn.isSelected())
                    temp += 3;
                
                switch (temp) {
                    case 16:  radioSetting = "Everything is on! ";
                         break;
                    case 10:  radioSetting = "The T.V. is on, the Cable is on, and the Xbox is off." ;
                         break;
                    case 12:  radioSetting = "The T.V. is off, the Cable is off, and the Xbox is on.";
                         break;
                    case 6:  radioSetting = "The T.V. is on, the Cable is off, and the Xbox is off." ;
                         break;
                    case 14:  radioSetting = "The T.V. is off, the Cable is on, and the Xbox is on.";
                         break;
                    case 8:  radioSetting = "The T.V. is off, the Cable is on, and the Xbox is off." ;
                         break;
                    case 4:  radioSetting = "Everything is off!" ;
                         break;
                    default: radioSetting = "How did you do that...";
                }
                if (temp == 10){
                    if (tvOn.isSelected() && cableOn.isSelected() && xboxOff.isSelected())
                        radioSetting = "The T.V. is on, the Cable is on, and the Xbox is off";
                    else if (tvOff.isSelected() && cableOff.isSelected() && xboxOn.isSelected())
                        radioSetting = "The T.V. is off, the Cable is off, and the Xbox is on";
                    else
                        radioSetting = "How did you do that...";
                    }
                results.setText(radioSetting + "   ");
            }
        });
        JButton buttonExit = new JButton(" Exit ");
        buttonExit.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        
        gridlayout.add(tvPanel);
        gridlayout.add(blankPanel1);
        gridlayout.add(cablePanel);
        gridlayout.add(blankPanel2);
        gridlayout.add(xboxPanel);
        gridlayout.add(blankPanel3);
        gridlayout.add(submitButton);
        gridlayout.add(buttonExit);
        simpleBorders.add(resultsPanel);
        //now add the gridlayout to the simpleBorders
        simpleBorders.add(gridlayout, BorderLayout.CENTER);
        simpleBorders.add(resultsPanel, BorderLayout.SOUTH);


        JPanel matteBorders = new JPanel();
        matteBorders.setBorder(paneEdge);
        matteBorders.setLayout(new BoxLayout(matteBorders,
                                              BoxLayout.Y_AXIS));

        ImageIcon icon = createImageIcon("images/wavy.gif",
                                         "wavy-line border icon"); //20x22
        Border border = BorderFactory.createMatteBorder(-1, -1, -1, -1, icon);
        if (icon != null) {
            addCompForBorder(raisedbevel, "Family Room",
                         simpleBorders);
        } else {
            addCompForBorder(raisedbevel, "Family Room",
                         matteBorders);
        }
        border = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red);
        addCompForBorder(raisedbevel, "Family Room",
                         matteBorders);

        border = BorderFactory.createMatteBorder(0, 20, 0, 0, icon);
        if (icon != null) {
            addCompForBorder(raisedbevel, "Family Room",
                         matteBorders);
        } else {
            addCompForBorder(raisedbevel, "Family Room",
                         matteBorders);
        }

        //Third pane: titled borders
        JPanel titledBorders = new JPanel();
        titledBorders.setBorder(paneEdge);
        titledBorders.setLayout(new BoxLayout(titledBorders,
                                              BoxLayout.Y_AXIS));
        TitledBorder titled;

        titled = BorderFactory.createTitledBorder("title");
        addCompForBorder(titled,
                         "default titled border"
                         + " (default just., default pos.)",
                         titledBorders);

        titled = BorderFactory.createTitledBorder(
                              blackline, "title");
        addCompForTitledBorder(titled,
                               "titled line border"
                                   + " (centered, default pos.)",
                               TitledBorder.CENTER,
                               TitledBorder.DEFAULT_POSITION,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(loweredetched, "title");
        addCompForTitledBorder(titled,
                               "titled lowered etched border"
                                   + " (right just., default pos.)",
                               TitledBorder.RIGHT,
                               TitledBorder.DEFAULT_POSITION,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(
                        loweredbevel, "title");
        addCompForTitledBorder(titled,
                               "titled lowered bevel border"
                                   + " (default just., above top)",
                               TitledBorder.DEFAULT_JUSTIFICATION,
                               TitledBorder.ABOVE_TOP,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(
                        empty, "title");
        addCompForTitledBorder(titled, "titled empty border"
                               + " (default just., bottom)",
                               TitledBorder.DEFAULT_JUSTIFICATION,
                               TitledBorder.BOTTOM,
                               titledBorders);

        //Fourth pane: compound borders
        JPanel compoundBorders = new JPanel();
        compoundBorders.setBorder(paneEdge);
        compoundBorders.setLayout(new BoxLayout(compoundBorders,
                                              BoxLayout.Y_AXIS));
        Border redline = BorderFactory.createLineBorder(Color.red);

        Border compound;
        compound = BorderFactory.createCompoundBorder(
                                  raisedbevel, loweredbevel);
        addCompForBorder(compound, "compound border (two bevels)",
                         compoundBorders);

        compound = BorderFactory.createCompoundBorder(
                                  redline, compound);
        addCompForBorder(compound, "compound border (add a red outline)",
                         compoundBorders);

        titled = BorderFactory.createTitledBorder(
                                  compound, "title",
                                  TitledBorder.CENTER,
                                  TitledBorder.BELOW_BOTTOM);
        addCompForBorder(titled, 
                         "titled compound border"
                         + " (centered, below bottom)",
                         compoundBorders);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Living Room", null, simpleBorders, null);
        tabbedPane.addTab("Kitchen", null, matteBorders, null);
        tabbedPane.addTab("Bedroom", null, titledBorders, null);
        tabbedPane.addTab("Bathroom", null, compoundBorders, null);
        tabbedPane.setSelectedIndex(0);
        String toolTip = new String("<html>Blue Wavy Line border art crew:<br>&nbsp;&nbsp;&nbsp;Bill Pauley<br>&nbsp;&nbsp;&nbsp;Cris St. Aubyn<br>&nbsp;&nbsp;&nbsp;Ben Wronsky<br>&nbsp;&nbsp;&nbsp;Nathan Walrath<br>&nbsp;&nbsp;&nbsp;Tommy Adams, special consultant</html>");
        tabbedPane.setToolTipTextAt(1, toolTip);

        add(tabbedPane);
    }

    void addCompForTitledBorder(TitledBorder border,
                                String description,
                                int justification,
                                int position,
                                Container container) {
        border.setTitleJustification(justification);
        border.setTitlePosition(position);
        addCompForBorder(border, description,
                         container);
    }

    void addCompForBorder(Border border,
                          String description,
                          Container container) {
        JPanel comp = new JPanel(new GridLayout(1, 1), false);
        JLabel label = new JLabel(description, JLabel.CENTER);
        comp.add(label);
        comp.setBorder(border);

        container.add(Box.createRigidArea(new Dimension(0, 10)));
        container.add(comp);
    }


    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = Gui.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.setSize(350, 400);

        //Create and set up the content pane.
        Gui newContentPane = new Gui();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
