import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.Buffer;

public class ImgService {
    public static void updateImage(JLabel imageContainer, String resourcePath, boolean isResized, int targetWidth, int targetHeight){
        BufferedImage image;
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(resourcePath);
            image = ImageIO.read(inputStream);
            if(isResized)
                image = resizeImage(image, targetWidth, targetHeight);
            imageContainer.setIcon(new ImageIcon(image));
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    public static JButton createImageButton(String resourcePath, String command){
        BufferedImage image;
        JButton imageButton;
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(resourcePath);
            image = ImageIO.read(inputStream);
            imageButton = new JButton(command);
            imageButton.setIcon(new ImageIcon(image));
            return imageButton;
        }catch(Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }
    public static JLabel loadImage(String resourcePath, boolean isResized, int targetWidth, int targetHeight){
        BufferedImage image;
        JLabel imageContainer;
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(resourcePath);
            image = ImageIO.read(inputStream);
            if(isResized)
                image = resizeImage(image, targetWidth, targetHeight);
            imageContainer = new JLabel(new ImageIcon(image));
            return imageContainer;
        }catch(Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }

    private static BufferedImage resizeImage(BufferedImage image, int targetWidth, int targetHeight){
        BufferedImage newImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = newImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return newImage;
    }
}
