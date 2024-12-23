import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Model class for Taxi Booking
class TaxiBooking {
    private int id;
    private String customerName;
    private String destination;
    private double distance;
    private double fare;

    public TaxiBooking(int id, String customerName, String destination, double distance) {
        this.id = id;
        this.customerName = customerName;
        this.destination = destination;
        this.distance = distance;
        this.fare = calculateFare(distance);
    }

    private double calculateFare(double distance) {
        return distance * 10.0; // Example: fare rate is $10 per km
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDistance(double distance) {
        this.distance = distance;
        this.fare = calculateFare(distance);
    }
}

// Main GUI application
public class Main {

    private JFrame frame;
    private JTextField customerNameField, destinationField, distanceField;
    private DefaultListModel<String> bookingListModel;
    private ArrayList<TaxiBooking> bookings;
    private int currentId;

    public Main() {
        bookings = new ArrayList<>();
        currentId = 1;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Booking Taxi");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JLabel customerNameLabel = new JLabel("Nama:");
        customerNameField = new JTextField();

        JLabel destinationLabel = new JLabel("Destinasi:");
        destinationField = new JTextField();

        JLabel distanceLabel = new JLabel("Jarak (km):");
        distanceField = new JTextField();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBooking();
            }
        });

        inputPanel.add(customerNameLabel);
        inputPanel.add(customerNameField);
        inputPanel.add(destinationLabel);
        inputPanel.add(destinationField);
        inputPanel.add(distanceLabel);
        inputPanel.add(distanceField);
        inputPanel.add(new JLabel());
        inputPanel.add(addButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        bookingListModel = new DefaultListModel<>();
        JList<String> bookingList = new JList<>(bookingListModel);
        JScrollPane scrollPane = new JScrollPane(bookingList);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel();

        JButton deleteButton = new JButton("Hapus");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBooking(bookingList.getSelectedIndex());
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBooking(bookingList.getSelectedIndex());
            }
        });

        actionPanel.add(deleteButton);
        actionPanel.add(updateButton);
        frame.add(actionPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addBooking() {
        try {
            String customerName = customerNameField.getText();
            String destination = destinationField.getText();
            double distance = Double.parseDouble(distanceField.getText());

            if (customerName.isEmpty() || destination.isEmpty()) {
                throw new IllegalArgumentException("All fields must be filled out.");
            }

            TaxiBooking booking = new TaxiBooking(currentId++, customerName, destination, distance);
            bookings.add(booking);
            bookingListModel.addElement("Booking ID: " + booking.getId() + ", Name: " + booking.getCustomerName() + ", Fare: $" + booking.getFare());

            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Distance must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteBooking(int index) {
        if (index >= 0) {
            bookings.remove(index);
            bookingListModel.remove(index);
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih yang ingin dihapus.", "Selection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateBooking(int index) {
        if (index >= 0) {
            TaxiBooking booking = bookings.get(index);
            String customerName = JOptionPane.showInputDialog(frame, "Nama:", booking.getCustomerName());
            String destination = JOptionPane.showInputDialog(frame, "Destinasi:", booking.getDestination());
            String distanceStr = JOptionPane.showInputDialog(frame, "Jarak:", booking.getDistance());

            try {
                if (customerName == null || destination == null || distanceStr == null) {
                    throw new IllegalArgumentException("Update canceled.");
                }

                double distance = Double.parseDouble(distanceStr);

                booking.setCustomerName(customerName);
                booking.setDestination(destination);
                booking.setDistance(distance);

                bookingListModel.set(index, "Booking ID: " + booking.getId() + ", Nama: " + booking.getCustomerName() + ", Biaya: $" + booking.getFare());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Distance must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Select a booking to update.", "Selection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        customerNameField.setText("");
        destinationField.setText("");
        distanceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
