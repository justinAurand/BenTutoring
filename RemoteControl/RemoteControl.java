import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RemoteControl {
    public static void main(String[] args) {
        JFrame remote = getRemote();
        remote.add(getPowerAndInputPanel(), BorderLayout.NORTH);
        remote.add(getChannelAndVolumePanel(), BorderLayout.CENTER);
        remote.add(getDirectionPanel(), BorderLayout.SOUTH);
        remote.setVisible(true);
    }

    private static JButton getButton(String image) {
        ImageIcon icon = new ImageIcon(image);
        return new JButton(icon);
    }

    private static JButton getButton(String text, Font font, Color color) {
        JButton button = new JButton();
        if (text != null && text.length() > 0)
            button.setText(text);
        if (font != null)
            button.setFont(font);
        if (color != null)
            button.setForeground(color);
        return button;
    }

    private static JPanel getChannelAndVolumePanel() {
        JPanel panel = new JPanel(new GridLayout (5,3));
        for (int i=1; i<10; i++)
            panel.add(new JButton(Integer.toString(i)));
        panel.add(new JButton("Ch. -"));
        panel.add(new JButton("0"));
        panel.add(new JButton("Ch. +"));
        panel.add(new JButton("Vol. +"));
        panel.add(new JButton("Mute"));
        panel.add(new JButton("Vol. -"));
        return panel;
    }

    private static JPanel getDirectionPanel() {
        JPanel panel = new JPanel(new GridLayout (2,3));
        panel.add(getButton("play.png"));
        panel.add(getButton("pause.png"));
        panel.add(getButton("stop.png"));
        panel.add(getButton("rewind.png"));
        panel.add(new JButton());
        panel.add(getButton("fast-forward.png"));
        return panel;
    }

    private static JPanel getPowerAndInputPanel() {
        Font arialBold = new Font("Arial", Font.BOLD, 24);
        JPanel panel = new JPanel(new GridLayout (3,2));
        panel.add(getButton("Off", arialBold, Color.red));
        panel.add(getButton("On", arialBold, Color.red));
        panel.add(getButton("DVD", arialBold, null));
        panel.add(getButton("Aux", arialBold, null));
        panel.add(getButton("Cable", arialBold, null));
        panel.add(getButton("Menu", arialBold, null));
        return panel;
    }

    private static JFrame getRemote() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Universal Remote");
        frame.setSize(300, 400);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
}
