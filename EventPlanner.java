import javax.swing.*;
import java.awt.*;

public class EventPlanner extends JFrame
{
    public EventPlanner()
    {
        //OPEN THE FRAME
        this.setTitle("Event Planner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TOP OF GUI
        JLabel statusLabel = new JLabel("Status: ", JLabel.CENTER);

        JLabel topLabel = new JLabel("Event Planner",10);


        JPanel top = new JPanel();
        top.add(topLabel);

        JPanel main = new JPanel();
        EventListPanel eventListPanel = new EventListPanel();

        main.add(eventListPanel);

        //ADD COMPONENTS TO THE GUI
        this.add(top, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);

        this.setSize(600,500);
        this.setVisible(true);
    }

    static void addDefaultEvents(EventPanel events)
    {

    }

    public static void main(String[] args)
    {
        EventPlanner eventPlanner = new EventPlanner();
    }
}
