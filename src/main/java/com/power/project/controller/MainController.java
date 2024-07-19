package com.power.project.controller;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
public class MainController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "Please upload a valid CSV file.";}
        Reader reader = new InputStreamReader(file.getInputStream());
        List<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader).getRecords();
        return generateHtmlTable(records);
    }

    private String generateHtmlTable(List<CSVRecord> records) {
        StringBuilder html = new StringBuilder();
        html.append("<table class=\"table\">")
                .append("<thead><tr>");
        if (!records.isEmpty()) {
            CSVRecord header = records.get(0);
            for (String column : header.toMap().keySet()) {
                html.append("<th>").append(column).append("</th>");
            }
            html.append("</tr></thead><tbody>");
        }
        for (CSVRecord record : records) {
            html.append("<tr>");
            for (String value : record) {
                html.append("<td>").append(value).append("</td>");
            }
            html.append("</tr>");
        }
        html.append("</tbody></table>");
        return html.toString();
    }
}
