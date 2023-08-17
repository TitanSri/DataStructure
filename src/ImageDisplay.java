import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author admin www . j a v a 2 s . co m
 *
 */

public class ImageDisplay {

	@SuppressWarnings("null")
	public static void main(String s[]) throws IOException {

		// import the file
		File file = new File("C:/Users/admin/Pictures/GoKu.jpg");
		BufferedImage img = ImageIO.read(file);

		// image needs to be rescaled by half to fit screen
		ImageIcon imageIcon = new ImageIcon(img);
		int width = imageIcon.getIconWidth();
		int height = imageIcon.getIconHeight();
		ImageIcon imageIconRescaled = new ImageIcon(
				new ImageIcon(img).getImage().getScaledInstance(width / 2, height / 2, Image.SCALE_DEFAULT));

		// window needs to be rescaled to the image size from the URL site
		BufferedImage img2 = ImageIO
				.read(new URL("https://s3.amazonaws.com/images.seroundtable.com/google-amp-1454071566.jpg"));
		ImageIcon imageIcon2 = new ImageIcon(img2);
		int width2 = imageIcon2.getIconWidth();
		int height2 = imageIcon2.getIconHeight();
		System.out.println(width + " " + height);

		// create frame
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(width / 2, height / 2);
		JLabel lbl = new JLabel();
		lbl.setIcon(imageIconRescaled);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JFrame frame2 = new JFrame();
		frame2.setLayout(new FlowLayout());
		frame2.setSize(width2, height2);
		JLabel lbl2 = new JLabel();
		lbl2.setIcon(imageIcon2);
		frame2.add(lbl2);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}

}
