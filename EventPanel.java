import javax.swing.*;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class EventPanel extends JPanel
{
    Event event;
    JButton completeButton;

    public EventPanel(Event event)
    {
        JPanel labels = new JPanel();
        JPanel data = new JPanel();

        JLabel eventNameLabel = new JLabel("Event Name:");
        JLabel eventDateLabel = new JLabel("Date:");
        JLabel eventDurationLabel = new JLabel("Duration:");
        JLabel eventLocationLabel = new JLabel("Location:");
        JLabel completeStatusLabel = new JLabel("Completed?");

        //JLabel eventName = new JLabel(event.getName());
        //JLabel eventDate = new JLabel(event.getDateTime().toString());
        //JLabel eventDuration = new JLabel();
        //JLabel eventLocation = new JLabel();
        //JCheckBox completeStatus = new JCheckBox();

        //completeStatus.setSelected(event.complete());
        //completeStatus.setEnabled(false);

        LocalDateTime start = LocalDateTime.of(2024, 10, 7, 15, 0);
        LocalDateTime end = LocalDateTime.of(2024, 10, 7, 16, 0);

        Event fartTime = new Meeting("Fart Time!", start, end, "My place" );

        JLabel eventName = new JLabel(fartTime.getName());
        JLabel eventDate = new JLabel(fartTime.getDateTime().toString());
        JLabel eventDuration = new JLabel(((Meeting) fartTime).getEndDateTime() - fartTime.getDateTime());
        JLabel eventLocation = new JLabel();
        JCheckBox completeStatus = new JCheckBox();

        completeStatus.setSelected(event.complete());
        completeStatus.setEnabled(false);


    }
}
