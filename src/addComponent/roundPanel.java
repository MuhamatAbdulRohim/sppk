
package addComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author rohim
 */
public class roundPanel extends JPanel {

    private Color warna;

    public roundPanel() {
        setOpaque(false);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 125);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 125);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();
        gd.setColor(warna);
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        gd.dispose();
    }
}
