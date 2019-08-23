package com.example.spring.gitcommitid.controller;

import com.example.spring.gitcommitid.utils.HtmlToPdf;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author xinj.x
 */
@Controller
@RequestMapping("/test")
public class TestThymeleafEngineController {
  @Autowired
  private TemplateEngine templateEngine;

  @GetMapping("/index")
  public String index(HttpServletRequest request, HttpServletResponse response) {
    WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale());
    //这里图片路径设置成了全路径，要不然在pdf中不显示
    ctx.setVariable("imgUrl", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/static/images/1.jpg");
    ctx.setVariable("now", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    ctx.setVariable("contractNo", "D1605291554136315");
    try {
      //"/contract" 为模板文件，注意路径和“/”
      String htmlcontext = templateEngine.process("/contract", ctx);
      HtmlToPdf.topdf(htmlcontext, "C:/Users/MJ-Summit/Desktop/word2pdf/thymeleaf-2-pdf.pdf");
    } catch (Exception e) {
      e.printStackTrace();
    }
    request.setAttribute("time", new Date());
    return "/contract";
  }
}
