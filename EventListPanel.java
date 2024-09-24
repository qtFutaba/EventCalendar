import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel
{
    ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox sortDropDown;
    JCheckBox filterDisplay;
    JButton addEventButton;

    public EventListPanel()
    {
        events = new ArrayList<>();
        displayPanel = new JPanel();
        controlPanel = new JPanel();
        sortDropDown = new JComboBox();

        sortDropDown.setPreferredSize(new Dimension(200,20));

        filterDisplay = new JCheckBox("Filter");
        addEventButton = new JButton("Add New Event");

        //THIS ALLOWS THINGS TO STACK ON TOP OF ONE ANOTHER
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        //LINE THESE UP SIDE BY SIDE ON ONE PANEL
        JPanel filterPanel = new JPanel();

        filterPanel.add(sortDropDown);
        filterPanel.add(filterDisplay);

        //ADD TO CONTROL PANEL STACKED ON TOP OF EACHOTHER
        controlPanel.add(addEventButton);
        controlPanel.add(filterPanel);

        this.add(controlPanel);
        this.add(displayPanel);
    }
}
