package fde.controller;

import fde.service.WebBuilderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webBuilder")
public class WebBuilderController {
    private final WebBuilderService websiteService;

    public WebBuilderController(WebBuilderService websiteService) {
        this.websiteService = websiteService;
    }

    @PostMapping("/build")
    public String generateWebsite(@RequestBody String message) {
        return websiteService.generate(message);
    }
}
