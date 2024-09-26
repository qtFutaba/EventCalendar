import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

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
    DefaultListModel eventList;
    AddEventModal addEvent;

    //DEFAULT CONSTRUCTOR
    public EventListPanel()
    {
        //---------------------------------------------------------------------------
        //PANEL FOR CONTROLS UP TOP FIRST
        //---------------------------------------------------------------------------

        //PANEL FOR THE CONTROLS (ADD, FILTER)
        controlPanel = new JPanel();
        //THIS ALLOWS THINGS TO STACK ON TOP OF ONE ANOTHER
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        //FILTERS FOR EVENTS
        String filterType[] = {"Default Sorting", "Deadlines Only", "Meetings Only", "Incomplete", "Alphabetical", "Reversed Alphabetical"};
        sortDropDown = new JComboBox(filterType);
        sortDropDown.setPreferredSize(new Dimension(200,20));

        filterDisplay = new JCheckBox("Filter");
        addEventButton = new JButton("Add New Event");

        //ADD EVENT MODAL ON STANDBY
        addEvent = new AddEventModal();
        addEvent.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        addEvent.pack();
        addEvent.setVisible(false);

        //ADD LISTENERS
        addEventButton.addActionListener(this);
        addEvent.submit.addActionListener(this);
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
        //PANEL FOR DISPLAYING INFO ABOUT EVENT
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));

        //INITIALIZE EVENT LIST
        events = new ArrayList<>();

        //INITIALIZE EVENT LIST FOR DISPLAY
        eventList = new DefaultListModel();

        eventListDisplay = new JList(eventList);
        JScrollPane scrollPane = new JScrollPane(eventListDisplay); //CREATE THE DISPLAY WITH A SCROLL IN CASE SOMEONE WANTED TO ADD A BUNCH OF EVENTS
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

        //TEST EVENTS
        LocalDateTime start = LocalDateTime.of(2024, 10, 7, 15, 0);
        LocalDateTime end = LocalDateTime.of(2024, 10, 7, 16, 0);
        LocalDateTime endworld = LocalDateTime.of(2000, 1, 1, 0, 0);

        Event endOfTheWorld = new Deadline("The End of the World!", endworld);
        Event partyTime = new Meeting("Party Time!", start, end, "My place :)" );
        events.add(partyTime);
        events.add(endOfTheWorld);

        for (Event event : events)
        {
            eventList.addElement(event.getName());
        }
    }

    @Override
    //BUTTONS
    public void actionPerformed(ActionEvent e)
    {
        //OPEN UP ADD EVENT PANEL
        if (e.getSource().equals(addEventButton))
        {
            addEvent.setVisible(true);
        }
        //ADD EVENT PANEL: NEW EVENT SUBMITTED
        else if(e.getSource().equals(addEvent.submit))
        {
            //DEADLINE SELECTED
            if (addEvent.eventTypeComboBox.getSelectedItem().equals("Deadline"))
            {
                //I USED A JSPINNER WITH DATE FORMAT- IT OUTPUTS A STANDARD JAVA.UTIL.DATE.
                //CONVERT THAT TO AN INSTANT WHICH CAN BE CONVERTED TO LOCALDATETIME.
                Date dateconvert = (Date) addEvent.startDate.getValue();
                LocalDateTime date = dateconvert.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                //CREATE DEADLINE
                addEvent.event = new Deadline(addEvent.eventName.getText(), date);
            }

            //MEETING SELECTED
            else if (addEvent.eventTypeComboBox.getSelectedItem().equals("Meeting"))
            {
                //I USED A JSPINNER WITH DATE FORMAT- IT OUTPUTS A STANDARD JAVA.UTIL.DATE.
                //CONVERT THAT TO AN INSTANT WHICH CAN BE CONVERTED TO LOCALDATETIME.
                Date startConvert = (Date) addEvent.startDate.getValue();
                LocalDateTime start = startConvert.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                //DO THE SAME THING FOR THE END DATE.
                Date endConvert = (Date) addEvent.endDate.getValue();
                LocalDateTime end = endConvert.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                //CREATE MEETING
                addEvent.event = new Meeting(addEvent.eventName.getText(), start, end, addEvent.location.getText());
            }

            //CLOSE THE ADD EVENT PANEL
            addEvent.setVisible(false);

            //ADD THE NEWLY CREATED EVENT TO OUR ARRAY AND LIST
            events.add(addEvent.event);
            eventList.addElement(addEvent.event.getName());
        }

    }

    @Override
    //FILTER ACTIVATION
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource().equals(filterDisplay))
        {

        }
    }

    @Override
    //DISPLAY AN EVENT
    public void valueChanged(ListSelectionEvent e)
    {
        //GET RID OF THE OLD EVENT INFO
        displayPanel.remove(eventPanel);

        //GET THE NEW EVENT INFO
        int index = eventListDisplay.getSelectedIndex();
        eventPanel = new EventPanel(events.get(index));

        //PUT INTO THE PANEL
        displayPanel.add(eventPanel);

        //REPAINT
        displayPanel.revalidate();
        displayPanel.repaint();
    }
}
