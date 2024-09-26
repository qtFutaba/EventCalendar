import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventListPanel extends JPanel implements ListSelectionListener, ActionListener, ItemListener
{
    ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox sortDropDown;
    JCheckBox filterDisplay;
    JButton addEventButton;
    JList eventListDisplay;
    EventPanel eventPanel;

    private DefaultListModel eventList;


    public EventListPanel()
    {
        //---------------------------------------------------------------------------
        //DISPLAY FOR CONTROLS UP TOP FIRST
        //---------------------------------------------------------------------------
        controlPanel = new JPanel(); //PANEL FOR THE CONTROLS (ADD, FILTER)
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS)); //THIS ALLOWS THINGS TO STACK ON TOP OF ONE ANOTHER

        sortDropDown = new JComboBox(); //FILTERS FOR SORTING
        sortDropDown.setPreferredSize(new Dimension(200,20));

        filterDisplay = new JCheckBox("Filter");
        addEventButton = new JButton("Add New Event");

        addEventButton.addActionListener(this);
        filterDisplay.addItemListener(this);

        //PANEL TO LINE UP THE FILTER DROPDOWN AND CHECKBOX SIDE BY SIDE
        JPanel filterPanel = new JPanel();

        filterPanel.add(sortDropDown);
        filterPanel.add(filterDisplay);


        //ADD THE "ADD EVENT" BUTTON, AND THEN ADD THE FILTER PANEL TO CONTROL PANEL BELOW IT
        controlPanel.add(addEventButton);
        controlPanel.add(filterPanel);



        //---------------------------------------------------------------------------
        //DISPLAY EVENTS AND RELEVANT INFORMATION
        //---------------------------------------------------------------------------
        displayPanel = new JPanel(); //PANEL FOR DISPLAYING INFO ABOUT EVENT
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));

        events = new ArrayList<>(); //INITIALIZE EVENT LIST

        eventList = new DefaultListModel(); //INITIALIZE EVENT LIST FOR DISPLAY

        eventListDisplay = new JList(eventList);
        JScrollPane scrollPane = new JScrollPane(eventListDisplay); //CREATE THE DISPLAY WITH A SCROLL
        displayPanel.add(scrollPane);

        eventListDisplay.addListSelectionListener(this);

        //DEFAULT PANEL FOR EVENT
        eventPanel = new EventPanel();
        displayPanel.add(eventPanel);

        //ADD BOTH PANELS TO THE EVENT LIST PANEL FOR DISPLAY
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(controlPanel);
        this.add(displayPanel);

        //COLOR :)
        controlPanel.setBackground(new Color(208, 255, 249));
        displayPanel.setBackground(new Color(208, 255, 249));
        filterPanel.setBackground(new Color(208, 255, 249));
        filterDisplay.setBackground(new Color(208, 255, 249));

        //FORMATTING!



        //TEST
        LocalDateTime start = LocalDateTime.of(2024, 10, 7, 15, 0);
        LocalDateTime end = LocalDateTime.of(2024, 10, 7, 16, 0);
        LocalDateTime endworld = LocalDateTime.of(2000, 1, 1, 0, 0);

        Event endOfTheWorld = new Deadline("End of the World", endworld);
        Event partyTime = new Meeting("Party Time!", start, end, "My place :)" );
        events.add(partyTime);
        events.add(endOfTheWorld);

        for (Event event : events)
        {
            eventList.addElement(event.getName());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(addEventButton))
        {
            AddEventModal addEvent = new AddEventModal();
            addEvent.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            addEvent.pack();
            addEvent.setVisible(true);
            
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource().equals(eventListDisplay))
        {

        }

        //else if (e.getSource().equals(filterDisplay))
        //{

        //}
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        displayPanel.remove(eventPanel);
        int index = eventListDisplay.getSelectedIndex();

        eventPanel = new EventPanel(events.get(index));

        displayPanel.add(eventPanel);

        displayPanel.revalidate();
        displayPanel.repaint();
    }
}
