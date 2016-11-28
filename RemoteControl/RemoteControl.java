import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RemoteControl implements ActionListener {
    public RemoteControl() {
        JFrame remote = getRemote();
        remote.add(getPowerAndInputPanel(), BorderLayout.NORTH);
        remote.add(getChannelAndVolumePanel(), BorderLayout.CENTER);
        remote.add(getDirectionPanel(), BorderLayout.SOUTH);
        remote.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        System.out.println(getButtonIdentity(button));
    }

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
    }

    private String getButtonIdentity(JButton button) {
        String text = button.getText();
        if (text != null && text.length() > 0)
            return text;

        String name = button.getName();
        if (name != null && name.length() > 0)
            return name;

        return "undefined";
    }

    private JButton getButtonWithListener(String text, Font font, Color color) {
        JButton button = new JButton();
        button.addActionListener(this);
        if (text != null && text.length() > 0)
            button.setText(text);
        if (font != null)
            button.setFont(font);
        if (color != null)
            button.setForeground(color);
        return button;
    }

    private JPanel getChannelAndVolumePanel() {
        JPanel panel = new JPanel(new GridLayout (5,3));

        IncrementListener volumeListener = new IncrementListener(false, 15, 50, 0);
        JButton volumeUpButton = new JButton("Vol. +");
        JButton volumeDownButton = new JButton("Vol. -");
        volumeUpButton.addActionListener(volumeListener);
        volumeDownButton.addActionListener(volumeListener);

        IncrementListener channelListener = new IncrementListener(true, 2, 999, 2);
        JButton channelUpButton = new JButton("Ch. +");
        JButton channelDownButton = new JButton("Ch. -");
        channelUpButton.addActionListener(channelListener);
        channelDownButton.addActionListener(channelListener);

        for (int i=1; i<10; i++)
            panel.add(getButtonWithListener(Integer.toString(i), null, null));
        panel.add(volumeUpButton);
        panel.add(getButtonWithListener("0", null, null));
        panel.add(channelUpButton);
        panel.add(volumeDownButton);
        panel.add(getButtonWithListener("Mute", null, null));
        panel.add(channelDownButton);

        return panel;
    }

    private JPanel getDirectionPanel() {
        JPanel panel = new JPanel(new GridLayout (2,3));

        panel.add(getImageButtonWithListener("play.png"));
        panel.add(getImageButtonWithListener("pause.png"));
        panel.add(getImageButtonWithListener("stop.png"));
        panel.add(getImageButtonWithListener("rewind.png"));
        panel.add(new JButton());
        panel.add(getImageButtonWithListener("fast-forward.png"));

        return panel;
    }

    private JButton getImageButtonWithListener(String image) {
        ImageIcon icon = new ImageIcon(image);
        JButton button = new JButton(icon);
        button.setName(image.substring(0, image.lastIndexOf('.')));
        button.addActionListener(this);

        return button;
    }

    private JPanel getPowerAndInputPanel() {
        Font arialBold = new Font("Arial", Font.BOLD, 24);
        JPanel panel = new JPanel(new GridLayout (3,2));

        panel.add(getButtonWithListener("Off", arialBold, Color.red));
        panel.add(getButtonWithListener("On", arialBold, Color.red));
        panel.add(getButtonWithListener("DVD", arialBold, null));
        panel.add(getButtonWithListener("Aux", arialBold, null));
        panel.add(getButtonWithListener("Cable", arialBold, null));
        panel.add(getButtonWithListener("Menu", arialBold, null));

        return panel;
    }

    private JFrame getRemote() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Universal Remote");
        frame.setSize(300, 400);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private class IncrementListener implements ActionListener {
        private boolean cycle;
        private int level;
        private int max;
        private int min;

        private IncrementListener() {
            cycle = false;
            level = 0;
            max = Integer.MAX_VALUE;
            min = Integer.MIN_VALUE;
        }
        private IncrementListener(boolean cycle, int level, int max, int min) {
            this.cycle = cycle;
            this.level = level;
            this.max = max;
            this.min = min;
        }

        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            String text = button.getText();
            level = getNextLevel(cycle, level, max, min, text);

            System.out.println(
                getButtonIdentity(button) + " | "
                + "level: " + Integer.toString(level)
                );
        }

        private int getNextLevel(boolean cycle, int level, int max, int min, String text) {
            if (text.contains("+") && level == max && cycle)
                return min;
            if (text.contains("-") && level == min && cycle)
                return max;
            if (text.contains("+") && level < max)
                return ++level;
            if (text.contains("-") && level > min)
                return --level;
            return level;
        }
    }
}
