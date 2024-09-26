import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AddEventModal extends JDialog implements ItemListener, ActionListener
{
    JPanel mainPanel = new JPanel();
    JLabel eventTypeLabel = new JLabel("Event Type");
    String eventType[] = {"Meeting", "Deadline"};
    JComboBox eventTypeComboBox = new JComboBox(eventType);

    JTextField eventName = new JTextField(20);
    JSpinner startDate = new JSpinner(new SpinnerDateModel());
    JSpinner endDate = new JSpinner(new SpinnerDateModel());
    JTextField location = new JTextField(20);

    JButton submit = new JButton("Submit");

    Event event;
    private int state = 1;

    public AddEventModal()
    {
        //TRIED AND TRUE LINE FORMAT
        JPanel line1 = new JPanel();
        JPanel line2 = new JPanel();
        JPanel line3 = new JPanel();
        JPanel line4 = new JPanel();
        JPanel line5 = new JPanel();

        //LINE 1 (Event Type)
        line1.add(eventTypeLabel);
        line1.add(eventTypeComboBox);

        //LINE 2 (Event Name)
        JLabel eventNameLabel = new JLabel("Event Name");
        line2.add(eventNameLabel);
        line2.add(eventName);

        //LINE 3 (Event Start Date)
        JLabel startDateLabel = new JLabel("Start Date");
        line3.add(startDateLabel);
        line3.add(startDate);

        //LINE 4 (Event End Date)
        JLabel endDateLabel = new JLabel("End Date");
        line4.add(endDateLabel);
        line4.add(endDate);

        //LINE 5 (Event Location)
        JLabel locationLabel = new JLabel("Location");
        line5.add(locationLabel);
        line5.add(location);

        //ADD TO PANEL
        mainPanel.add(line1);
        mainPanel.add(line2);
        mainPanel.add(line3);
        mainPanel.add(line4);
        mainPanel.add(line5);
        mainPanel.add(submit);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //ADD TO DIALOG
        this.add(mainPanel);

        //LISTENERS
        eventTypeComboBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (eventTypeComboBox.getSelectedItem().equals("Deadline"))
                {
                    endDate.setEnabled(false);
                    location.setEnabled(false);

                    endDate.setVisible(false);
                    location.setVisible(false);
                    endDateLabel.setVisible(false);
                    locationLabel.setVisible(false);
                }
                else if (eventTypeComboBox.getSelectedItem().equals("Meeting"))
                {
                    endDate.setEnabled(true);
                    location.setEnabled(true);

                    endDate.setVisible(true);
                    location.setVisible(true);
                    endDateLabel.setVisible(true);
                    locationLabel.setVisible(true);
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                state = 0;
            }
        });
    };

    public Event showEventAdder()
    {
        state = 1;
        this.setVisible(true);

        setModal(true);

        return event;
    }



    public void actionPerformed(ActionEvent e)
    {

    }

    public void itemStateChanged(ItemEvent e)
    {

    }
}
