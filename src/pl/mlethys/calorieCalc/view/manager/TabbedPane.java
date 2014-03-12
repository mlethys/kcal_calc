/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mlethys.calorieCalc.view.manager;

import javax.swing.JButton;


/**
 *
 * @author mlethys
 */
public interface TabbedPane 
{
    public void addTab();
    public JButton createTabButton(final String TITLE);
}
