package edu.miu.cs.cs425.fairfieldlibrarywebappsec.controller;

import edu.miu.cs.cs425.fairfieldlibrarywebappsec.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebappsec.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/secured/publisher", "/fairfieldlibrary/secured/publisher"})
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listPublishers() {
        var modelAndView = new ModelAndView();
        var publishers = publisherService.getAllPublishers();
        modelAndView.addObject("publishers", publishers);
        modelAndView.addObject("publishersCount", publishers.size());
        modelAndView.setViewName("secured/publisher/list");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "secured/publisher/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewPublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
                                       BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/publisher/new";
        }
        publisherService.savePublisher(publisher);
        return "redirect:/fairfieldlibrary/secured/publisher/list";
    }

    @GetMapping(value = {"/edit/{publisherId}"})
    public String editPublisher(@PathVariable Integer publisherId, Model model) {
        var publisher = publisherService.getPublisherById(publisherId);
        if(publisher != null) {
            model.addAttribute("publisher", publisher);
            return "secured/publisher/edit";
        }
        return "redirect:/fairfieldlibrary/secured/publisher/list";
    }

    @PostMapping(value = {"/update"})
    public String updatePublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/publisher/edit";
        }
        publisherService.updatePublisher(publisher);
        return "redirect:/fairfieldlibrary/secured/publisher/list";
    }

    @GetMapping(value = {"/delete/{publisherId}"})
    public String deletePublisher(@PathVariable Integer publisherId) {
        publisherService.deletePublisherById(publisherId);
        return "redirect:/fairfieldlibrary/secured/publisher/list";
    }
}
