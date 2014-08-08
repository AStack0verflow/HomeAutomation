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
 * Write a description of class bathroomPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BathroomPanel
{
    // instance variables - replace the example below with your own
    protected static Component BathroomPanel() {
        //Tab 2 --------------------------------------------
        JPanel bathroomPanel = new JPanel();
        bathroomPanel.setLayout(new BoxLayout(bathroomPanel,
                                              BoxLayout.Y_AXIS));                       
        JPanel lightsPanel = new JPanel();
        lightsPanel.setLayout(new BoxLayout(lightsPanel,
                                              BoxLayout.Y_AXIS));                                   
        final JLabel statusLabel = new JLabel("Lights: ", SwingConstants.RIGHT);
        //statusLabel = new JLabel("Lights: ", SwingConstants.RIGHT);
        final JScrollBar lights = new JScrollBar(JScrollBar.HORIZONTAL);
        lights.setMaximum (110);
        lights.setMinimum (0);
        lightsPanel.add(lights);
        lightsPanel.add(statusLabel);
      
        lights.addAdjustmentListener(new AdjustmentListener() {
        
         @Override
         public void adjustmentValueChanged(AdjustmentEvent e) {
            statusLabel.setText("Lights: "
               +lights.getValue() 
               +"%");
            }
        });
        JPanel finished = new JPanel();
        final JButton submitButton = new JButton(" Submit ");
        submitButton.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                statusLabel.setText(" The lights are now at: " + lights.getValue() +"%. ");
            }
        });
        JButton buttonExit = new JButton(" Exit ");
        buttonExit.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        finished.add(submitButton);
        finished.add(buttonExit);
        bathroomPanel.add(lightsPanel);
        bathroomPanel.add(finished);
      
       return bathroomPanel;
    }
}
