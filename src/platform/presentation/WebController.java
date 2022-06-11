package platform.presentation;

import platform.businesslayer.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    @Autowired
    CodeService codeService;

    @GetMapping("/code/{number}")
    public String getCodeByPage(@PathVariable String number, Model model) {
        model.addAttribute("code", codeService.findCodeById(number));
        return "Code";
    }

    @GetMapping("/code/latest")
    public String getLast(Model model) {
        model.addAttribute("codes", codeService.getLatestCodes());
        return "Latest";
    }

    @GetMapping("/code/new")
    public String newCodePage() {
        return "Create";
    }
}