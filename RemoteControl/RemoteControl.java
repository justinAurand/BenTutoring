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
        printButtonIdentity(button);
    }

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
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
        VolumeListener listener = new VolumeListener();

        JButton volumeUpButton = new JButton("Vol. +");
        JButton volumeDownButton = new JButton("Vol. -");
        volumeUpButton.addActionListener(listener);
        volumeDownButton.addActionListener(listener);

        for (int i=1; i<10; i++)
            panel.add(getButtonWithListener(Integer.toString(i), null, null));
        panel.add(getButtonWithListener("Ch. -", null, null));
        panel.add(getButtonWithListener("0", null, null));
        panel.add(getButtonWithListener("Ch. +", null, null));
        panel.add(volumeUpButton);
        panel.add(getButtonWithListener("Mute", null, null));
        panel.add(volumeDownButton);

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

    private void printButtonIdentity(JButton button) {
        String text = button.getText();
        if (text != null && text.length() > 0) {
            System.out.println(text);
            return;
        }

        String name = button.getName();
        if (name != null && name.length() > 0) {
            System.out.println(name);
            return;
        }

        System.out.println("Undefined");
    }

    private class VolumeListener implements ActionListener {
        private int volume;

        private VolumeListener() {
            volume = 0;
        }

        public int getVolume() { return volume; }

        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            String text = button.getText();
            if (text.contains("+"))
                volume++;
            if (text.contains("-"))
                volume--;

            System.out.println("Volume: " + Integer.toString(volume));
        }
    }
}
