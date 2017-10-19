
package addComponent;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Abdul_Rohim
 */
public class image2 extends JPanel {

    private final Image gambar; // deklarasi variabel gambar

    public image2() {
        gambar = new ImageIcon(this.getClass().getResource("/image/background3.jpg")).getImage(); // memanggil lokasi gambar
    }

    @Override
    protected void paintComponent(Graphics a) {
        super.paintComponent(a);
        Graphics gbr = a.create();
        gbr.drawImage(gambar, 0, 0, getWidth(), getHeight(), this);
    }
}
