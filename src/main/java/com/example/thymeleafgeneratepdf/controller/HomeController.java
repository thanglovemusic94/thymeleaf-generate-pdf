package com.example.thymeleafgeneratepdf.controller;

import com.example.thymeleafgeneratepdf.model.User;
import com.example.thymeleafgeneratepdf.util.PDFUtil;
import com.lowagie.text.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;

import java.io.IOException;

@Controller
public class HomeController {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/pdf")
    @ResponseBody
    public String pdf() throws DocumentException, IOException {
        User user = new User("thang", "thang@gmail.com");

        Context context = new Context();
        context.setVariable("user", user);

        String html = PDFUtil.parseThymeleafTemplate("templates/thymeleaf_template", context);
        PDFUtil.generatePdfFromHtml(html);

        return "dowload pdf success in link: " + PDFUtil.folderFDF;
    }
}
