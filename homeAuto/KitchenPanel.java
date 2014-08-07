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
 * Write a description of class kitchenPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KitchenPanel
{
    // instance variables - replace the example below with your own
    protected static Component KitchenPanel() {
        //Tab 2 --------------------------------------------
        JPanel kitchenPanel = new JPanel();
        kitchenPanel.setLayout(new BoxLayout(kitchenPanel,
                                              BoxLayout.Y_AXIS));
        JPanel lightsPanelP2 = new JPanel();
        /*lightsPanelP2.setLayout(new BoxLayout(kitchenPanel,
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
//             statusLabelP2.setText("Lights: "
//                +lightsP2.getValue() 
//                +"%");
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
       return kitchenPanel;
    }
}
