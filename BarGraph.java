import java.awt.*;
import javax.swing.*;

class BarGraph extends JPanel {
    private double[] data; 
    private String[] labels;
    public Color color;

    // Constructor
    public BarGraph(double [] data, String[] labels, Color color) {
        this.data = data;
        this.labels = labels;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / data.length; 

        
        double maxValue = 0;
        for (double value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        
        for (int i = 0; i < data.length; i++) {
            int barHeight = (int) ((double) data[i] / maxValue * (height - 50));
            int x = i * barWidth + 10;
            int y = height - barHeight - 30;

           
            g2d.setColor(color);
            g2d.fillRect(x, y, barWidth - 20, barHeight);

            
            g2d.setColor(Color.BLACK);
            g2d.drawString(labels[i], x + (barWidth - 20) / 4, height - 10);
        }
    }

}