package resources;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TestImage {

	public static String getTextFromImage(String filePath) throws TesseractException {
		File imgFile = new File(filePath);
		ITesseract instance = new Tesseract();
		instance.setDatapath("/Users/techsupporttx/Movies/eclipse-workspace/xendit-qa-assessment/tessdata");
		return instance.doOCR(imgFile);
	}
}
