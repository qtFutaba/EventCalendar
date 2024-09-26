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

    JButton submitButton = new JButton("Submit");

    Event event;

    public AddEventModal()
    {

        JPanel line1 = new JPanel();
        JPanel line2 = new JPanel();
        JPanel line3 = new JPanel();
        JPanel line4 = new JPanel();
        JPanel line5 = new JPanel();

        line1.add(eventTypeLabel);
        line1.add(eventTypeComboBox);

        JLabel eventNameLabel = new JLabel("Event Name");
        line2.add(eventNameLabel);
        line2.add(eventName);

        JLabel startDateLabel = new JLabel("Start Date");
        line3.add(startDateLabel);
        line3.add(startDate);

        JLabel endDateLabel = new JLabel("End Date");
        line4.add(endDateLabel);
        line4.add(endDate);

        JLabel locationLabel = new JLabel("Location");
        line5.add(locationLabel);
        line5.add(location);

        mainPanel.add(line1);
        mainPanel.add(line2);
        mainPanel.add(line3);
        mainPanel.add(line4);
        mainPanel.add(line5);
        mainPanel.add(submitButton);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.add(mainPanel);

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
                }
                else if (eventTypeComboBox.getSelectedItem().equals("Meeting"))
                {
                    endDate.setEnabled(true);
                    location.setEnabled(true);

                    endDate.setVisible(true);
                    location.setVisible(true);
                }
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (eventTypeComboBox.getSelectedItem().equals("Deadline"))
                {
                    Date dateconvert = (Date) startDate.getValue();
                    LocalDateTime date = dateconvert.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();

                    event = new Deadline(eventName.getText(), date);
                }
                else if (eventTypeComboBox.getSelectedItem().equals("Meeting"))
                {
                    Date startConvert = (Date) startDate.getValue();
                    LocalDateTime start = startConvert.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();

                    Date endConvert = (Date) endDate.getValue();
                    LocalDateTime end = endConvert.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();

                    event = new Meeting(eventName.getText(), (LocalDateTime) start, end,location.getText());
                }

                setVisible(false);
            }
        });
    };

    @Override
    public void itemStateChanged(ItemEvent e)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
