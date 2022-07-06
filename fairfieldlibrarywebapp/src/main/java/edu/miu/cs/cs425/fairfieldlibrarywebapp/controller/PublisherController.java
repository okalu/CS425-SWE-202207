package edu.miu.cs.cs425.fairfieldlibrarywebapp.controller;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/fairfieldlibrary/publisher"})
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = {"/list"})
    public ModelAndView listPublishers() {
        var publishers = publisherService.getAllPublishers();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("publishers", publishers);
        modelAndView.setViewName("secured/publisher/list");
        return modelAndView;
    }

//    @GetMapping(value = {"/list"})
//    public String listPublishers2(Model model) {
//        var publishers = publisherService.getAllPublishers();
//        model.addAttribute("publishers", publishers);
//        return "secured/publisher/list";
//    }

    @GetMapping(value = {"/new"})
    public String displayNewPublisherForm(Model model) {
        var newPublisher = new Publisher();
        model.addAttribute("publisher", newPublisher);
        return "secured/publisher/new";
    }

    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewPublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
          BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/publisher/new";
        }
        publisherService.addNewPublisher(publisher);
        return "redirect:/fairfieldlibrary/publisher/list";
    }
}
