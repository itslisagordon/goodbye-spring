package org.launchcode.goodbyespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

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
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hi")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String friend, Model model) {
        String theGreeting = "Hello, " + name + " and " + friend + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    // lives at /hello/Lisa
    //path parameter. Handles requests of the form /hello/Lisa
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
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

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("langform")
    public String langForm(){
        return "langform";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Lisa");
        names.add("Brett");
        names.add("Bradley");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
