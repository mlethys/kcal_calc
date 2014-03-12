package pl.mlethys.calorieCalc.view.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductPanel extends JPanel
{
    private final int WIDTH = 800;
    private final int HEIGHT = 500;
    private ProductsTabbedPane productsTabbedPane;
    private JButton doneButton;
   
    public ProductPanel(final JFrame PARENT)
    {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        productsTabbedPane = new ProductsTabbedPane();
        add(productsTabbedPane);
        
        doneButton = new JButton("Done!");
        doneButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                PARENT.dispose();
            }
        });
        add(doneButton, BorderLayout.SOUTH);
    }
}
