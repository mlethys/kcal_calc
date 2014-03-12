package pl.mlethys.calorieCalc.view.manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author mlethys
 * @version
 */
public class TabBody extends JPanel
{
    private JButton addButton;
    private JButton detailsButton;
    private JButton editButton;
    
    public TabBody()
    {
        super();
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ProductFrame();
            }
        });
        add(addButton, c);
    }
}
