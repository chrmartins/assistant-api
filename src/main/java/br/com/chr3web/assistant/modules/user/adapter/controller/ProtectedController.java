package br.com.chr3web.assistant.modules.user.adapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    @GetMapping("/protected-endpoint")
    public String protectedEndpoint() {
        return "Este é um endpoint protegido!";
    }
}