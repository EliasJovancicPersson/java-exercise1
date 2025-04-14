package task15;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Frame {
    public static void main(String[] args) {
    JFrame frame = new JFrame();

    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");
    var circle = new JLabel() {
        private Color circleColor = Color.red;

        public void setCircleColor(Color color){
            circleColor = color;
            repaint(); 
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(circleColor);
            g2.fillOval(10, 10, 80, 80);
        }

        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }
    };
    
    redButton.addActionListener(e -> circle.setCircleColor(Color.RED));
    greenButton.addActionListener(e -> circle.setCircleColor(Color.GREEN));
    blueButton.addActionListener(e -> circle.setCircleColor(Color.BLUE));

    frame.setLayout(new FlowLayout());
    frame.add(redButton);   
    frame.add(greenButton);
    frame.add(blueButton);
    frame.add(circle);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack(); frame.setVisible(true);
}
}


