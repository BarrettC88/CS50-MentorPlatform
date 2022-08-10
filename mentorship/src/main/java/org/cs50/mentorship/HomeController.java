package org.cs50.mentorship;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/currentrequests")
    public String index() {
        return "CurrentMentorshipRequests";
    }

    @RequestMapping(value = "/myrequests")
    public String createRequest() {
        return "MyRequests";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }
}
