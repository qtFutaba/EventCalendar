import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPanel extends JPanel
{
    Event event;
    JButton completeButton;

    public EventPanel()
    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(175,300));

        //DEFAULT
        JPanel line1 = new JPanel();
        JPanel line2 = new JPanel();
        JPanel line3 = new JPanel();
        JPanel line4 = new JPanel();


        //LINE 1 (Event Name)
        JLabel eventName = new JLabel("Select an event.");
        eventName.setFont(new Font("Arial",Font.BOLD,18));

        line1.add(eventName);

        //LINE 2 (Type of Event)
        JLabel eventTitle = new JLabel("Or add a new one!");
        line2.add(eventTitle);

        //LINE 3 (Date)
        JLabel eventDateLabel = new JLabel("Date:");
        JLabel eventDate = new JLabel("N/A");

        line3.add(eventDateLabel);
        line3.add(eventDate);

        //LINE 4 (Completion)
        JLabel completeStatusLabel = new JLabel("Completed?");
        JCheckBox completeStatus = new JCheckBox();
        completeStatus.setEnabled(false);

        line4.add(completeStatusLabel);
        line4.add(completeStatus);

        this.add(line1);
        this.add(line2);
        this.add(line3);
        this.add(line4);

        line1.setBackground(Color.WHITE);
        line2.setBackground(Color.WHITE);
        line3.setBackground(Color.WHITE);
        line4.setBackground(Color.WHITE);
        completeStatus.setBackground(Color.WHITE);
    }

    public EventPanel(Event event)
    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(175,300));

        //DISPLAYING A MEETING
        if (event instanceof Meeting)
        {
            Meeting meeting = (Meeting) event;

            JPanel line1 = new JPanel();
            JPanel line2 = new JPanel();
            JPanel line3 = new JPanel();
            JPanel line4 = new JPanel();
            JPanel line5 = new JPanel();
            JPanel line6 = new JPanel();
            JPanel line7 = new JPanel();


            //LINE 1 (Event Name)
            JLabel eventName = new JLabel(meeting.getName());
            eventName.setFont(new Font("Arial",Font.BOLD,18));

            line1.add(eventName);

            //LINE 2 (Type of Event)
            JLabel eventTitle = new JLabel("Meeting");
            line2.add(eventTitle);

            //LINE 3 (Start Date)
            JLabel startTimeLabel = new JLabel("Start Time:");
            JLabel startTime = new JLabel(meeting.getDateTime().toString());

            line3.add(startTimeLabel);
            line3.add(startTime);

            //LINE 4 (End Date)
            JLabel endTimeLabel = new JLabel("End Time:");
            JLabel endTime = new JLabel(meeting.getEndDateTime().toString());

            line4.add(endTimeLabel);
            line4.add(endTime);

            //LINE 5 (Duration)
            JLabel eventDurationLabel = new JLabel("Duration:");
            JLabel eventDuration = new JLabel(String.valueOf(meeting.getDuration()));

            line5.add(eventDurationLabel);
            line5.add(eventDuration);

            //LINE 6 (Location)
            JLabel eventLocationLabel = new JLabel("Location:");
            JLabel eventLocation = new JLabel(meeting.getLocation());

            line6.add(eventLocationLabel);
            line6.add(eventLocation);

            //LINE 7 (Completion)
            JLabel completeStatusLabel = new JLabel("Completed?");
            JCheckBox completeStatus = new JCheckBox();
            completeStatus.setSelected(meeting.complete);
            completeStatus.setEnabled(false);

            line7.add(completeStatusLabel);
            line7.add(completeStatus);

            //ADD LINES TO PANEL
            this.add(line1);
            this.add(line2);
            this.add(line3);
            this.add(line4);
            this.add(line5);
            this.add(line6);
            this.add(line7);

            line1.setBackground(new Color(113, 175, 170));
            line2.setBackground(Color.WHITE);
            line3.setBackground(Color.WHITE);
            line4.setBackground(Color.WHITE);
            line5.setBackground(Color.WHITE);
            line6.setBackground(Color.WHITE);
            line7.setBackground(Color.WHITE);
            completeStatus.setBackground(Color.WHITE);
        }

        //DISPLAYING A DEADLINE
        else if(event instanceof Deadline)
        {
            Deadline deadline = (Deadline) event;

            JPanel line1 = new JPanel();
            JPanel line2 = new JPanel();
            JPanel line3 = new JPanel();
            JPanel line4 = new JPanel();


            //LINE 1 (Event Name)
            JLabel eventName = new JLabel(deadline.getName());
            eventName.setFont(new Font("Arial",Font.BOLD,18));

            line1.add(eventName);

            //LINE 2 (Type of Event)
            JLabel eventTitle = new JLabel("Deadline");
            line2.add(eventTitle);

            //LINE 3 (Date)
            JLabel eventDateLabel = new JLabel("Date:");
            JLabel eventDate = new JLabel(deadline.getDateTime().toString());

            line3.add(eventDateLabel);
            line3.add(eventDate);

            //LINE 4 (Completion)
            JLabel completeStatusLabel = new JLabel("Completed?");
            JCheckBox completeStatus = new JCheckBox();
            completeStatus.setSelected(deadline.complete);
            completeStatus.setEnabled(true);

            line4.add(completeStatusLabel);
            line4.add(completeStatus);

            //ADD LINES TO PANEL
            this.add(line1);
            this.add(line2);
            this.add(line3);
            this.add(line4);

            line1.setBackground(new Color(113, 175, 170));
            line2.setBackground(Color.WHITE);
            line3.setBackground(Color.WHITE);
            line4.setBackground(Color.WHITE);
            completeStatus.setBackground(Color.WHITE);
        }
    }
}
