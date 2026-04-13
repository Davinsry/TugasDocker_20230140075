package com.example.pertemuan6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/")
    public String index() {
        logger.info("Akses root, redirect ke login");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        logger.info("Mencoba login untuk user: {}", username);
        // Simple logic for demo
        if ("admin".equals(username) && "admin".equals(password)) {
            logger.info("Login berhasil untuk user: {}", username);
            return "redirect:/home";
        }
        logger.warn("Login gagal untuk user: {}", username);
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model, 
                       @RequestParam(required = false) String nama,
                       @RequestParam(required = false) String nim,
                       @RequestParam(required = false) String jenisKelamin) {
        if (nama != null) {
            model.addAttribute("nama", nama);
            model.addAttribute("nim", nim);
            model.addAttribute("jenisKelamin", jenisKelamin);
        }
        return "home";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@RequestParam String nama, 
                             @RequestParam String nim, 
                             @RequestParam String jenisKelamin) {
        logger.info("Form disubmit: Nama={}, NIM={}, JK={}", nama, nim, jenisKelamin);
        return "redirect:/home?nama=" + nama + "&nim=" + nim + "&jenisKelamin=" + jenisKelamin;
    }
}
