package com.example.thymeleafgeneratepdf.controller;

import com.example.thymeleafgeneratepdf.model.User;
import com.example.thymeleafgeneratepdf.util.PDFUtil;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;

import java.io.IOException;

@Controller
public class HomeController {

    private final PDFUtil util;
    private final Context context;

    public HomeController(Context context, PDFUtil util) {
        this.context = context;
        this.util = util;
    }

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/pdf")
    @ResponseBody
    public String pdf() throws DocumentException, IOException {
        User user = new User("thang", "thang@gmail.com");
        context.setVariable("user", user);

        String html = util.parseThymeleafTemplate("thymeleaf_template", context);
        util.generatePdfFromHtml(html);

        return "dowload pdf success in link: " + util.folderFDF;
    }
}
