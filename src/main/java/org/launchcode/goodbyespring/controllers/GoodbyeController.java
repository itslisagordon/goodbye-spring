package org.launchcode.goodbyespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class GoodbyeController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //lives at /hello/hello
    //query parameter. Handles request of the form /hello?name=Lisa
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="postrequesthello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String friend) {
        return "Hello, " + name + " and " + friend + "!";
    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="postrequestlang")
    @ResponseBody
    public String langWithQueryParam(@RequestParam String name, @RequestParam String language) {
        name = name.trim();

        if (name.equals("")) {
            return "oops, must enter name!";
        } else if (language.equals("english")) {
            return "Hello, " + name + "!";
        } else if (language.equals("spanish")) {
            return "Hola, " + name + "!";
        } else if (language.equals("french")) {
            return "Bonjour, " + name + "!";
        } else if (language.equals("japanese")) {
            return "Kon'nichiwa, " + name + "!";
        } else if (language.equals("piglatin")) {
            return "lloHe, " + name + "!";
        } else {
            return "oops!";
        }
    }

    // lives at /hello/Lisa
    //path parameter. Handles requests of the form /hello/Lisa
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // lives at /hello/form
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='postrequesthello' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='text' name='friend'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("langform")
    @ResponseBody
    public String langForm(){
        return "<html>" +
                "<body>" +
                "<form action='postrequestlang' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "<option style=\"color:red\" value='english'>English</option>" +
                "<option style=\"color:blue\" value='spanish'>Spanish</option>" +
                "<option style=\"color:green\" value='french'>French</option>" +
                "<option style=\"color:orange\" value='japanese'>Japanese</option>" +
                "<option style=\"color:pink\" value='piglatin'>Pig Latin</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
