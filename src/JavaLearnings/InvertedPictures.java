package JavaLearnings;
import edu.duke.*;
import java.io.*;

public class InvertedPictures {

	public ImageResource makeInverted(ImageResource inImage) {
		
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		
		for (Pixel pixel: outImage.pixels()) {
		
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			int redinverse = (255-inPixel.getRed());
			int greeninverse = (255-inPixel.getGreen());
			int blueinverse = (255-inPixel.getBlue());
		
			pixel.setRed(redinverse);
			
			pixel.setGreen(greeninverse);
			
			pixel.setBlue(blueinverse);
		}
	
		return outImage;
	}

	public void testGray() {
		ImageResource ir = new ImageResource();
		ImageResource gray = makeInverted(ir);
		gray.draw();
	}
	
	public void selectAndConvert () {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource inImage = new ImageResource(f);
			ImageResource gray = makeInverted(inImage);
			gray.draw();
			String fname = inImage.getFileName();
			String newName = "inverse-" + fname;
			inImage.setFileName(newName);
			inImage.save();
			
		}
	}
	
	public static void main(String[] args) {
		InvertedPictures obj1 = new InvertedPictures();
		//obj1.testGray();
		obj1.selectAndConvert();
		
		
	}
}


