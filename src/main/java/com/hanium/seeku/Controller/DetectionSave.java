package com.hanium.seeku.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class DetectionSave {
    @GetMapping("/alert/detection")
    public String newForm() { return "alert/detection"; }

    @PostMapping("/alert/detection/save")
    public String saveForm() {
        return "redirect:/alert/field";
    }
}
