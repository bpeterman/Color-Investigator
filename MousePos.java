import java.awt.*;
import javax.swing.*;

public class MousePos {
	static int xPos, yPos;
	static int rgbRed, rgbGreen, rgbBlue;

	public static void main(String[] a) {
		JFrame myFrame = new JFrame("Mouse-Over RGB & Color");
		myFrame.setBounds(100, 50, 500, 300);

		while (true) {
			MyRobotMethod();
			myFrame.getContentPane().add(new MyComponent());
			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myFrame.setVisible(true);
		}
	}

	static class MyComponent extends JComponent {
		public void paint(Graphics g) {
			Color rgbColor = new Color(rgbRed, rgbGreen, rgbBlue);
			// << un-comment below for valid test on mouse over RGB value
			// rgbColor = new Color(0, 0, 0);
			g.drawString("RGB = " + rgbRed + "," + rgbGreen + "," + rgbBlue,
					100, 75);
			g.drawRect(100, 100, 300, 50);
			g.setColor(rgbColor);
			g.fillRect(101, 101, 299, 49);
		}
	}

	public static void MyRobotMethod() {
		try {
			Robot myRobot = new Robot();

			xPos = MouseInfo.getPointerInfo().getLocation().x;
			yPos = MouseInfo.getPointerInfo().getLocation().y;

			Color color = myRobot.getPixelColor(xPos, yPos);
			rgbRed = color.getRed();
			rgbGreen = color.getGreen();
			rgbBlue = color.getBlue();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
