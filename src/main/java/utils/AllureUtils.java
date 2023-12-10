package utils;

import io.qameta.allure.Attachment;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static utils.WebDriverUtils.DRIVER;

public class AllureUtils {
    private static final String downloadsDirectoryPath = "build/downloads";

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() { return ((TakesScreenshot) DRIVER).getScreenshotAs(OutputType.BYTES); }

    @Attachment(value = "Texto PDF", type = "text/plain")
    public static String addTextFile(String fileName) {
        File file = getDownloadFile(fileName);
        try {
            PDDocument document = PDDocument.load(file);
            file.deleteOnExit();
            return new PDFTextStripper().getText(document);
        } catch (Exception e) { e.printStackTrace(); }
        return "Error al leer el PDF";
    }

    @Attachment(value = "PDF", type = "application/pdf")
    public static byte[] addFile(String fileName) {
        File file = getDownloadFile(fileName);
        try {
            byte[] arch = Files.readAllBytes(file.toPath());
            file.deleteOnExit();
            return arch;
        }
        catch (IOException e) { e.printStackTrace(); }
        return new byte[0];
    }

    private static File getDownloadFile(String fileName) {
        return new File(downloadsDirectoryPath + "/" + fileName);
    }
}