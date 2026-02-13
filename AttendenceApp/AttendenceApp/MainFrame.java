package ui;

import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainFrame extends JFrame {
    private JTextField studentNameField;
    private JButton addStudentBtn, markAttendanceBtn, countAttendanceBtn;
    private JTextField studentIdField, courseIdField, dateField;

    public MainFrame() {
        setTitle("Öğrenci Yoklama Sistemi");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        studentNameField = new JTextField();
        addStudentBtn = new JButton("Öğrenci Ekle");
        studentIdField = new JTextField();
        courseIdField = new JTextField();
        dateField = new JTextField("2025-06-22");
        markAttendanceBtn = new JButton("Yoklama Al");
        countAttendanceBtn = new JButton("Yoklama Say");

        add(new JLabel("Öğrenci Adı:"));
        add(studentNameField);
        add(addStudentBtn);
        add(new JLabel());

        add(new JLabel("Öğrenci ID:"));
        add(studentIdField);
        add(new JLabel("Ders ID:"));
        add(courseIdField);
        add(new JLabel("Tarih (YYYY-MM-DD):"));
        add(dateField);
        add(markAttendanceBtn);
        add(countAttendanceBtn);

        // Öğrenci Ekle
        addStudentBtn.addActionListener(e -> {
            try (Connection conn = DBConnection.getConnection()) {
                CallableStatement cs = conn.prepareCall("{ call AddStudent(?) }");
                cs.setString(1, studentNameField.getText());
                cs.execute();
                JOptionPane.showMessageDialog(this, "Öğrenci eklendi!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        // Yoklama Al
        markAttendanceBtn.addActionListener(e -> {
            try (Connection conn = DBConnection.getConnection()) {
                CallableStatement cs = conn.prepareCall("{ call AddAttendance(?, ?, ?) }");
                cs.setInt(1, Integer.parseInt(studentIdField.getText()));
                cs.setInt(2, Integer.parseInt(courseIdField.getText()));
                cs.setDate(3, Date.valueOf(dateField.getText()));
                cs.execute();
                JOptionPane.showMessageDialog(this, "Yoklama alındı!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        // Tarihe Göre Yoklama Sayısı
        countAttendanceBtn.addActionListener(e -> {
            try (Connection conn = DBConnection.getConnection()) {
                CallableStatement cs = conn.prepareCall("{ ? = call GetAttendanceCount(?) }");
                cs.registerOutParameter(1, Types.INTEGER);
                cs.setDate(2, Date.valueOf(dateField.getText()));
                cs.execute();
                int count = cs.getInt(1);
                JOptionPane.showMessageDialog(this, "Katılan öğrenci sayısı: " + count);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
}
