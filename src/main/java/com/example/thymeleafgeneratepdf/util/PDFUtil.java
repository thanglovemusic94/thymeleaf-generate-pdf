package com.example.thymeleafgeneratepdf.util;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

@Component
public class PDFUtil {

    private final SpringTemplateEngine templateEngine;

    public PDFUtil(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public final String folderFDF = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";

    public String parseThymeleafTemplate(String pathFile, Context context) {
        return templateEngine.process(pathFile, context);
    }

    public void generatePdfFromHtml(String html) throws DocumentException, IOException {
        OutputStream outputStream = new FileOutputStream(folderFDF);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
    }
}
