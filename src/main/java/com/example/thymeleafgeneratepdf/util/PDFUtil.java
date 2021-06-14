package com.example.thymeleafgeneratepdf.util;

import com.lowagie.text.DocumentException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

public class PDFUtil {

    public static String folderFDF = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";

    public static String parseThymeleafTemplate(String pathFile, Context context) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine.process(pathFile, context);
    }

    public static void generatePdfFromHtml(String html) throws DocumentException, IOException {
        OutputStream outputStream = new FileOutputStream(folderFDF);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
    }
}
