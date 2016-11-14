import java.awt.*;
import javax.swing.*;

public class RemoteControl {
    public static void main(String[] args) {
        JFrame remote = getRemote();
        remote.add(getPowerPanel(), BorderLayout.NORTH);
        remote.add(getChannelPanel(), BorderLayout.CENTER);
        remote.add(getDirectionPanel(), BorderLayout.SOUTH);
        remote.setVisible(true);
    }

    private static JPanel getChannelPanel() {
        JPanel panel = new JPanel(new GridLayout (4,3));
        panel.add(new JButton("Ch. -"));
        panel.add(new JButton("0"));
        panel.add(new JButton("Ch. +"));
        return panel;
    }

    private static JPanel getDirectionPanel() {
        JPanel panel = new JPanel(new GridLayout (3,2));
        panel.add(new JButton("Forward"));
        return panel;
    }

    private static JPanel getPowerPanel() {
        JPanel panel = new JPanel(new GridLayout (3,2));
        panel.add(new JButton("Off"));
        panel.add(new JButton("On"));
        panel.add(new JButton("DVD"));
        panel.add(new JButton("Aux"));
        panel.add(new JButton("Cable"));
        panel.add(new JButton("Menu"));
        return panel;
    }

    private static JFrame getRemote() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Universal Remote");
        frame.setSize(300, 300);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
}
