package in.inuron.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class formData {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(Model model) {

        return "form";
    }
}
