package com.lightrun.demo.jsoupdemo.web;

import com.lightrun.demo.jsoupdemo.service.ParseLinks;
import java.io.IOException;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParseLinksWS {
    private final ParseLinks parseLinks;

    public ParseLinksWS(ParseLinks parseLinks) {
        this.parseLinks = parseLinks;
    }

    @GetMapping("/parseLinks")
    public Set<String> listLinks(@RequestParam String url, @RequestParam(required = false) Boolean includeMedia) throws IOException {
        return parseLinks.listLinks(url, includeMedia == null ? true : includeMedia);
    }
}
