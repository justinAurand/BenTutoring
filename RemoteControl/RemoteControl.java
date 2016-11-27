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
        JButton source = (JButton)e.getSource();
        printButtonIdentity(source);
    }

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
    }

    private JButton getButton(String text, Font font, Color color) {
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
        for (int i=1; i<10; i++)
            panel.add(getButton(Integer.toString(i), null, null));
        panel.add(getButton("Ch. -", null, null));
        panel.add(getButton("0", null, null));
        panel.add(getButton("Ch. +", null, null));
        panel.add(getButton("Vol. +", null, null));
        panel.add(getButton("Mute", null, null));
        panel.add(getButton("Vol. -", null, null));
        return panel;
    }

    private JPanel getDirectionPanel() {
        JPanel panel = new JPanel(new GridLayout (2,3));
        panel.add(getImageButton("play.png"));
        panel.add(getImageButton("pause.png"));
        panel.add(getImageButton("stop.png"));
        panel.add(getImageButton("rewind.png"));
        panel.add(new JButton());
        panel.add(getImageButton("fast-forward.png"));
        return panel;
    }

    private JButton getImageButton(String image) {
        ImageIcon icon = new ImageIcon(image);
        JButton button = new JButton(icon);
        button.setName(image.substring(0, image.lastIndexOf('.')));
        button.addActionListener(this);
        return button;
    }

    private JPanel getPowerAndInputPanel() {
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
}
