package com.rik.regsys;

import com.rik.regsys.data.company.CompanyEntity;
import com.rik.regsys.data.company.CompanyService;
import com.rik.regsys.data.event.EventEntity;
import com.rik.regsys.data.event.EventService;
import com.rik.regsys.data.paymentmethod.PaymentEntity;
import com.rik.regsys.data.paymentmethod.PaymentService;
import com.rik.regsys.data.person.PersonEntity;
import com.rik.regsys.data.person.PersonService;
import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class WebappController implements WebMvcConfigurer {
    private final PersonService personService;
    private final EventService eventService;
    private final CompanyService companyService;
    private final PaymentService paymentService;

    @ModelAttribute("persons")
    public List<PersonEntity> populatePersons(){
        return this.personService.findAll();
    }
    @ModelAttribute("upcomingEvents")
    public List<EventEntity> populateUpcoming(){return this.eventService.findUpcoming();}
    @ModelAttribute("previousEvents")
    public List<EventEntity> populatePrevious(){return this.eventService.findPrevious();}
    @ModelAttribute("paymentMethods")
    public List<PaymentEntity> populatePayment(){return this.paymentService.findAll();}

    @RequestMapping("/")
    public String redirectHome(){
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String homePage(){
        return "home";
    }

    @RequestMapping("/addEvent")
    public String addEventPage(final EventEntity eventEntity){
        return "addEvent";
    }

    @RequestMapping(value = "/addEvent", params = "saveEvent")
    public String saveEvent(@Valid @ModelAttribute("eventEntity") EventEntity eventEntity, BindingResult result, final ModelMap modelMap, @RequestParam String dateString){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm");
        try {
            DateTime dateTime = DateTime.parse(dateString, formatter);
            if (dateTime.isBeforeNow()){
                result.addError(new ObjectError("dateString", "Sisestatud kuupäev on minevikus!"));
            }
            eventEntity.setDate(dateTime.toDate());
        } catch (IllegalArgumentException e){
            result.addError(new ObjectError("dateString", "Sisestatud kuupäev pole õiges formaadis!"));
        }
        if (result.hasErrors()){
            return "addEvent";
        }
        eventService.newEvent(eventEntity);
        modelMap.clear();
        return "redirect:/home";
    }

    @RequestMapping("/event/{id}")
    public String eventPage(@PathVariable ("id") Long id, ModelMap modelMap, PersonEntity personEntity, CompanyEntity companyEntity){
        EventEntity event = eventService.findById(id);
        if (event != null){
            modelMap.addAttribute("eventEntity", event);
            if (populatePrevious().contains(event)){
                modelMap.addAttribute("isPast", true);
            } else {
                modelMap.addAttribute("isPast", false);
            }
        } else { return "redirect:/home"; }
        return "event";
    }

    @RequestMapping(value = "/event/{id}", params = "savePerson")
    public String addEventPerson(@Valid @ModelAttribute("personEntity") PersonEntity personEntity, BindingResult result, CompanyEntity companyEntity, final ModelMap modelMap, @PathVariable("id") Long id){
        EventEntity event = eventService.findById(id);
        if (event == null){
            return "redirect:/home";
        }
        modelMap.addAttribute("eventEntity", event);
        if (result.hasErrors()){
            return "event";
        }
        personEntity.setEventEntity(event);
        personService.newPerson(personEntity);
        modelMap.clear();
        return "redirect:/event/" + id;
    }

    @RequestMapping(value = "/event/{id}", params = "saveCompany")
    public String addEventCompany(@Valid @ModelAttribute("companyEntity") CompanyEntity companyEntity, BindingResult result, PersonEntity personEntity,final ModelMap modelMap, @PathVariable("id") Long id){
        EventEntity event = eventService.findById(id);
        if (event == null){
            return "redirect:/home";
        }
        modelMap.addAttribute("eventEntity", event);
        if (result.hasErrors()){
            return "event";
        }
        companyEntity.setEventEntity(event);
        companyService.newCompany(companyEntity);
        modelMap.clear();
        return "redirect:/event/" + id;
    }

    @RequestMapping("/event/{id}/delete")
    public String deleteEvent(@PathVariable ("id") Long id, ModelMap modelMap, PersonEntity personEntity, CompanyEntity companyEntity){
        EventEntity event = eventService.findById(id);
        if (event != null){
            eventService.deleteById(id);
        }
        return "redirect:/home";
    }

    @RequestMapping("/person/{id}")
    public String personPage(@PathVariable ("id") Long id, ModelMap modelMap){
        PersonEntity person = personService.findById(id);
        if (person != null){
            modelMap.addAttribute("personEntity", person);
            modelMap.addAttribute("eventEntity", person.getEventEntity());
        } else { return "redirect:/home"; }
        return "person";
    }

    @RequestMapping(value = "/person/{id}", params = "savePerson")
    public String savePerson(@Valid @ModelAttribute("personEntity") PersonEntity personEntity, BindingResult result, EventEntity eventEntity, final ModelMap modelMap, @PathVariable("id") Long id){
        if (result.hasErrors()){
            modelMap.addAttribute("personEntity", personEntity);
            modelMap.addAttribute("eventEntity", personEntity.getEventEntity());
            return "person";
        }
        personService.save(personEntity);
        modelMap.clear();
        return "redirect:/event/" + eventEntity.getId();
    }

    @RequestMapping("/person/{id}/delete")
    public String deletePerson(@PathVariable ("id") Long id, ModelMap modelMap, PersonEntity personEntity){
        PersonEntity person = personService.findById(id);
        Long eventId = person.getEventEntity().getId();
        if (person != null){
            personService.deleteById(id);
        }
        return "redirect:/event/" + eventId;
    }

    @RequestMapping("/company/{id}")
    public String companyPage(@PathVariable ("id") Long id, ModelMap modelMap){
        CompanyEntity company = companyService.findById(id);
        if (company != null){
            modelMap.addAttribute("companyEntity", company);
            modelMap.addAttribute("eventEntity", company.getEventEntity());
        } else { return "redirect:/home"; }
        return "company";
    }

    @RequestMapping(value = "/company/{id}", params = "saveCompany")
    public String savePerson(@Valid @ModelAttribute("companyEntity") CompanyEntity companyEntity, BindingResult result, EventEntity eventEntity, final ModelMap modelMap, @PathVariable("id") Long id){
        if (result.hasErrors()){
            modelMap.addAttribute("companyEntity", companyEntity);
            modelMap.addAttribute("eventEntity", companyEntity.getEventEntity());
            return "company";
        }
        companyEntity.setEventEntity(eventEntity);
        companyService.save(companyEntity);
        modelMap.clear();
        return "redirect:/event/" + eventEntity.getId();
    }

    @RequestMapping("/company/{id}/delete")
    public String deleteCompany(@PathVariable ("id") Long id, ModelMap modelMap, CompanyEntity companyEntity){
        CompanyEntity company = companyService.findById(id);
        Long eventId = company.getEventEntity().getId();
        if (company != null){
            companyService.deleteById(id);
        }
        return "redirect:/event/" + eventId;
    }

}
