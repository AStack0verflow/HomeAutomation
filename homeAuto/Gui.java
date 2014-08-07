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
 *    Nothing
 */
public class Gui extends JPanel {
    protected JButton livingRoom, kitchen, bedroom, bathroom, office, familyRoom;
    protected JLabel tv, cable, xbox, statusLabel, lightsLabel, lightsLabelP2;
    protected String radioSetting = "";
    protected JScrollBar lights, lightsP2;
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
        JPanel overPanel = new JPanel();
        overPanel.setLayout(new GridLayout(1,1));
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
        
        JPanel tvPanel = new JPanel();
        tvPanel.setLayout(new GridLayout(1,3));
        tv = new JLabel("T.V.:", SwingConstants.RIGHT);
        tvPanel.add(tv);
        final JRadioButton tvOn = new JRadioButton("On");
        final JRadioButton tvOff = new JRadioButton("Off");
        tvOn.setSelected(true);
        tvPanel.add(tvOff);
        tvPanel.add(tvOn);
        tvPanel.setSize(15,15);
        
        JPanel cablePanel = new JPanel();
        cablePanel.setLayout(new GridLayout(1,3));
        cable = new JLabel("CableBox:", SwingConstants.RIGHT);
        cablePanel.add(cable);
        final JRadioButton cableOn = new JRadioButton("On");
        final JRadioButton cableOff = new JRadioButton("Off");
        cableOn.setSelected(true);
        cablePanel.add(cableOff);
        cablePanel.add(cableOn);
        cablePanel.setSize(15,15);
        
        JPanel xboxPanel = new JPanel();
        xboxPanel.setLayout(new GridLayout(1,3));
        xbox = new JLabel("XBox:", SwingConstants.RIGHT);
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
        final JLabel resultsP2 = new JLabel(radioSetting);
        resultsPanel.add(resultsP2);
        
        ButtonGroup tvGroup = new ButtonGroup();
        tvGroup.add(tvOff);
        tvGroup.add(tvOn);
        ButtonGroup cableGroup = new ButtonGroup();
        cableGroup.add(cableOff);
        cableGroup.add(cableOn);
        ButtonGroup xboxGroup = new ButtonGroup();
        xboxGroup.add(xboxOff);
        xboxGroup.add(xboxOn);
        
        
        final JScrollBar lights = new JScrollBar(JScrollBar.HORIZONTAL);
        //lights.setPreferredSize(new Dimension(200, 10));
        lights.setMaximum (110);
        lights.setMinimum (0);
        
        final JLabel statusLabel = new JLabel();
        //lightsLabel = new JLabel("Lights: ", SwingConstants.RIGHT);
        //simpleBorders.add(lightsLabel);
        simpleBorders.add(statusLabel);
        simpleBorders.add(lights);
      
        lights.addAdjustmentListener(new AdjustmentListener() {

         @Override
         public void adjustmentValueChanged(AdjustmentEvent e) {
            statusLabel.setText("Lights: "
               +lights.getValue() 
               +"%");
            }
        });
        JPanel blankPanel1 = new JPanel();
        JPanel blankPanel2 = new JPanel();
        JPanel blankPanel3 = new JPanel();
        JPanel blankPanel4 = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel blankPanel5 = new JPanel();
        final JLabel filler = new JLabel("               ");
        blankPanel5.add(filler);
        
        final JButton submitButton = new JButton(" Submit ");
        submitButton.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                radioSetting = "";
                int temp = 10;
                results.setText(radioSetting);
                //resultsP2.setText(String(lights.getValue()));
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
                    case 16:  radioSetting = "Everything is on!               ";
                         break;
                    case 10:  radioSetting = "The T.V. and Cable are on, and the Xbox is off. \n" ;
                         break;
                    case 12:  radioSetting = "The T.V. and Cable are  off, and the Xbox is on. \n";
                         break;
                    case 6:  radioSetting = "The T.V. is on, and the Cable and Xbox are off.\n" ;
                         break;
                    case 14:  radioSetting = "The T.V. is off, and the Cable and Xbox is on.\n";
                         break;
                    case 8:  radioSetting = "The T.V. and Xbox are  off, and the Cable is off.\n" ;
                         break;
                    case 4:  radioSetting = "Everything is off!                      " ;
                         break;
                    default: radioSetting = "How did you do that...    ";
                }
                if (temp == 10){
                    if (tvOn.isSelected() && cableOn.isSelected() && xboxOff.isSelected())
                        radioSetting = "The T.V. and Cable are on, and the Xbox is off.\n";
                    else if (tvOff.isSelected() && cableOff.isSelected() && xboxOn.isSelected())
                        radioSetting = "The T.V. and Cable are  off, and the Xbox is on.\n";
                    else
                        radioSetting = "How did you do that...";
                    }
                results.setText("\n" + radioSetting);
                resultsP2.setText("The lights are at: " + lights.getValue() +"%. ");
            }
        });
        
        
        
        JButton buttonExit = new JButton(" Exit ");
        buttonExit.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        //gridlayout.add(blankPanel4);
        gridlayout.add(tvPanel);
        gridlayout.add(blankPanel1);
        gridlayout.add(cablePanel);
        gridlayout.add(blankPanel2);
        gridlayout.add(xboxPanel);
        gridlayout.add(blankPanel3);
        overPanel.add(gridlayout);
        //gridlayout.add(blankPanel4);
        bottomPanel.add(submitButton);
        bottomPanel.add(buttonExit);
        bottomPanel.add(blankPanel5);
        bottomPanel.add(resultsPanel);
        //simpleBorders.add(bottomPanel);
        //now add the gridlayout to the simpleBorders
        simpleBorders.add(overPanel);
        simpleBorders.add(bottomPanel, BorderLayout.SOUTH);
        /*
        gridlayout.setBorder(BorderFactory.createLineBorder(Color.black));
        resultsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        tvPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        cablePanel.setBorder(BorderFactory.createLineBorder(Color.red));
        xboxPanel.setBorder(BorderFactory.createLineBorder(Color.green));
        blankPanel1.setBorder(BorderFactory.createLineBorder(Color.white));
        blankPanel2.setBorder(BorderFactory.createLineBorder(Color.white));
        blankPanel3.setBorder(BorderFactory.createLineBorder(Color.white));
        blankPanel4.setBorder(BorderFactory.createLineBorder(Color.white));
        blankPanel5.setBorder(BorderFactory.createLineBorder(Color.white));
        */
        
        //Tab 2 --------------------------------------------
        /*JPanel kitchenPanel = new JPanel();
        kitchenPanel.setLayout(new BoxLayout(kitchenPanel,
                                              BoxLayout.Y_AXIS));
        JPanel lightsPanelP2 = new JPanel();
        lightsPanelP2.setLayout(new BoxLayout(kitchenPanel,
                                              BoxLayout.Y_AXIS));                                   
        final JLabel statusLabelP2 = new JLabel("Lights: ", SwingConstants.RIGHT);
        //statusLabelP2 = new JLabel("Lights: ", SwingConstants.RIGHT);
        lightsPanelP2.add(statusLabelP2);
        final JScrollBar lightsP2 = new JScrollBar(JScrollBar.HORIZONTAL);
        lightsP2.setMaximum (110);
        lightsP2.setMinimum (0);
        lightsPanelP2.add(lightsP2);
        lightsPanelP2.add(statusLabelP2);
      
        lightsP2.addAdjustmentListener(new AdjustmentListener() {

         @Override
         public void adjustmentValueChanged(AdjustmentEvent e) {
            statusLabelP2.setText("Lights: "
               +lightsP2.getValue() 
               +"%");
            }
        });
        JPanel finishedP2 = new JPanel();
        final JButton submitButtonP2 = new JButton(" Submit ");
        submitButtonP2.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                //resultsP2.setText(" The lights are at: " + lights.getValue() +"%. ");
            }
        });
        JButton buttonExitP2 = new JButton(" Exit ");
        buttonExitP2.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        finishedP2.add(submitButtonP2);
        finishedP2.add(buttonExitP2);
        kitchenPanel.add(lightsPanelP2);
        kitchenPanel.add(finishedP2);
        */
        
        
        
        
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
       

        titled = BorderFactory.createTitledBorder(loweredetched, "title");
        

        titled = BorderFactory.createTitledBorder(
                        loweredbevel, "title");
        

        titled = BorderFactory.createTitledBorder(
                        empty, "title");
        

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
        tabbedPane.addTab("Kitchen", null, KitchenPanel.KitchenPanel(), null);
        tabbedPane.addTab("Bedroom", null, titledBorders, null);
        tabbedPane.addTab("Bathroom", null, compoundBorders, null);
        tabbedPane.setSelectedIndex(0);
        String toolTip = new String("<html>Blue Wavy Line border art crew:<br>&nbsp;&nbsp;&nbsp;Bill Pauley<br>&nbsp;&nbsp;&nbsp;Cris St. Aubyn<br>&nbsp;&nbsp;&nbsp;Ben Wronsky<br>&nbsp;&nbsp;&nbsp;Nathan Walrath<br>&nbsp;&nbsp;&nbsp;Tommy Adams, special consultant</html>");
        tabbedPane.setToolTipTextAt(1, toolTip);

        add(tabbedPane);
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

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.setSize(5, 5);

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
