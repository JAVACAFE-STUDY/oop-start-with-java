package net.chandol.study.oop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class IndexController {

    @RequestMapping("/api")
    public View redirectToSwagger(){
        return new RedirectView("/swagger-ui.html");
    }

}
