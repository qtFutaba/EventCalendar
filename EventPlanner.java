import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

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
        topLabel.setFont(new Font("Rockwell",Font.BOLD,18));


        JPanel top = new JPanel();
        top.add(topLabel);

        JPanel main = new JPanel();
        EventListPanel eventListPanel = new EventListPanel();

        main.add(eventListPanel);

        //ADD COMPONENTS TO THE GUI
        this.add(top, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);

        top.setBackground(new Color(208, 255, 249));
        main.setBackground(new Color(208, 255, 249));

        this.setSize(400,500);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventPlanner eventPlanner = new EventPlanner();
    }
}
