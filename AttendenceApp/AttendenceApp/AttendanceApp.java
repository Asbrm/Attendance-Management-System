import ui.MainFrame;

import javax.swing.*;

public class AttendanceApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}


