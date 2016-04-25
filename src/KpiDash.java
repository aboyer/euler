import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;

import static java.awt.geom.Point2D.Float;

/**
 * TODO: File Purpose
 * <p/>
 * Created by : aboyer (8/6/14 20:48)
 */
public class KpiDash {
    public static final String[] xAxisLabels = {"KPI", "accuracy", "latency", "Notes"};
    public static final String[] yAxisLabels = {"URL", "e-Mail", "General Text"};
    public static final int RADIUS = 40;
    public static final int COL_WIDTH = RADIUS*2;
    public static final int ROW_HEIGHT = RADIUS*2;
    public static final int WIDTH = COL_WIDTH * (xAxisLabels.length+1);
    public static final int HEIGHT = ROW_HEIGHT * (yAxisLabels.length+1);

    private static Graphics2D g = null;

    public static void main(String[] args) {
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();

        // Fill in background
        g.setColor(new Color(188,188,188));
        g.fillRect(0,0,WIDTH,HEIGHT);

        drawGrid();

        Font font = new Font("Serif", Font.PLAIN, 14);
        g.setFont(font);

        String str = "sample text";
        FontRenderContext frc = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(str,frc);

        int textWidth = (int) bounds.getWidth();

        g.setColor(Color.black);

        int xTextTemp = getColCenter(1) - (int) bounds.getX();
        int yTextTemp = getRowCenter(0) - (int) bounds.getY();
        g.drawString(str, xTextTemp, yTextTemp);


//        g.drawString(yAxisLabels[0],10,10);
        drawBall(1, 1, Color.RED);
        drawBall(2, 2, Color.YELLOW);
        drawBall(3, 3, Color.GREEN);


        try {
            File outfile = new File("/tmp/saved.png");
            ImageIO.write(image, "png", outfile);
        } catch (IOException e) {
            System.err.println("Failed writing file: " + e);
        }
    }

    private static void drawBall(int row, int col, Color color) {
        int x = getRowCenter(row);
        int y = getColCenter(col);

        float offset = RADIUS * 0.2f;
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {Color.WHITE, color};

        RadialGradientPaint p = new RadialGradientPaint(new Float(x,y), RADIUS, new Float(x-offset, y-offset),
                dist, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);

        g.setPaint(p);
        g.fillOval(x-RADIUS/2, y-RADIUS/2, RADIUS, RADIUS);
    }

    private static void drawGrid() {
        Color c = g.getColor();

        g.setColor(Color.black);
        for (int row=1; row<=xAxisLabels.length; row++) {
            g.drawLine(10,row*ROW_HEIGHT,WIDTH-10,row*ROW_HEIGHT);
        }

        int firstColWidth = COL_WIDTH;
        g.drawLine(firstColWidth,HEIGHT-10,firstColWidth,10);

        for (int col=0; col<xAxisLabels.length-1; col++) {
            int y = firstColWidth + (col*COL_WIDTH);
            g.drawLine(y,HEIGHT-10,y,10);
        }
        g.setColor(c);
    }

    private static int getColCenter(int col) {
        return (col * COL_WIDTH) + COL_WIDTH/2;
    }

    private static int getRowCenter(int row) {
        return (row * ROW_HEIGHT) + ROW_HEIGHT/2;
    }
}
