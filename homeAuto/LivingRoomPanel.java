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
/**
 * Write a description of class LivingRoomPanel here.
 * 
 * @authorEverettWilliams
 * @version8-07-14
 */
public class LivingRoomPanel
{
    // instance variables - replace the example below with your own
    protected static Component LivingRoomPanel() {
        JPanel LivingRoomPanel = new JPanel();
        JButton livingRoom, kitchen, bedroom, bathroom, office, familyRoom;
        JLabel tv, cable, xbox, lightsLabel, lightsLabelP2;
        final JLabel statusLabel;
        final JScrollBar lights, lightsP2;
        final String radioSetting = "";

        //Keep references to the next few borders,
        //for use in titles and compound borders.
        Border paneEdge = BorderFactory.createEmptyBorder(0,10,10,10);
        JPanel simpleBorders = new JPanel();
        JPanel gridlayout = new JPanel();
        JPanel overPanel = new JPanel();
        overPanel.setLayout(new GridLayout(1,1));
        //Grid Layout(rows, columns,xpadding, ypadding
        gridlayout.setLayout(new GridLayout(5,1,5,5));
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
        
        lights = new JScrollBar(JScrollBar.HORIZONTAL);
        lights.setMaximum (110);
        lights.setMinimum (0);
        
        statusLabel = new JLabel();
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
        bottomPanel.setLayout(new GridLayout(2,2));
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1,1));
                
        final JButton submitButton = new JButton(" Submit ");
        submitButton.setPreferredSize(new Dimension(15, 25));
        submitButton.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                int temp = 10;
                String temp2 = radioSetting;
                results.setText(temp2);
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
                    case 16:  temp2 = "Everything is on!               ";
                         break;
                    case 10:  temp2 = "The T.V. and Cable are on, and the Xbox is off. " ;
                         break;
                    case 12:  temp2 = "The T.V. and Cable are  off, and the Xbox is on. ";
                         break;
                    case 6:  temp2 = "The T.V. is on, and the Cable and Xbox are off." ;
                         break;
                    case 14:  temp2 = "The T.V. is off, and the Cable and Xbox is on.";
                         break;
                    case 8:  temp2 = "The T.V. and Xbox are  off, and the Cable is off." ;
                         break;
                    case 4:  temp2 = "Everything is off!                      " ;
                         break;
                    default: temp2 = "How did you do that...    ";
                }
                if (temp == 10){
                    if (tvOn.isSelected() && cableOn.isSelected() && xboxOff.isSelected())
                        temp2 = "The T.V. and Cable are on, and the Xbox is off.";
                    else if (tvOff.isSelected() && cableOff.isSelected() && xboxOn.isSelected())
                        temp2 = "The T.V. and Cable are  off, and the Xbox is on.";
                    else
                        temp2 = "How did you do that...";
                    }
                results.setText("" + temp2);
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
//         gridlayout.setBorder(BorderFactory.createLineBorder(Color.black));
//         tvPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//         blankPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
//         cablePanel.setBorder(BorderFactory.createLineBorder(Color.black));
//         xboxPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//         bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//         textPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//         simpleBorders.setBorder(BorderFactory.createLineBorder(Color.black));
//         blankPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
//         blankPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
//         blankPanel4.setBorder(BorderFactory.createLineBorder(Color.black));
        gridlayout.add(tvPanel);
        gridlayout.add(blankPanel1);
        gridlayout.add(cablePanel);
        gridlayout.add(blankPanel2);
        gridlayout.add(xboxPanel);
        gridlayout.add(blankPanel3);
        overPanel.add(gridlayout);
        bottomPanel.add(submitButton);
        bottomPanel.add(buttonExit);
        //bottomPanel.add(blankPanel5);
        textPanel.add(resultsPanel);
        simpleBorders.add(overPanel);
        simpleBorders.add(bottomPanel, BorderLayout.SOUTH);        
        simpleBorders.add(textPanel);
        //LivingRoomPanel.add(simpleBorders);
        return simpleBorders;
    }
}
