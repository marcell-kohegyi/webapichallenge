package com.example.marcell.webapichallenge.controller;

import com.example.marcell.webapichallenge.entity.Contact;
import com.example.marcell.webapichallenge.entity.Skill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import com.example.marcell.webapichallenge.service.ContactService;
import com.example.marcell.webapichallenge.service.SkillService;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@Api(value = "Contact Management")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private SkillService skillService;

    @GetMapping("/")
    @ApiOperation(value = "Get the list of all contacts")
    public List<Contact> getAllContacts() {
        return contactService.getContacts();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get an individual contact by id")
    public Contact getContact(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return contactService.getContact(id);
    }

    @PostMapping
    @ApiOperation(value = "Create a new contact")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing contact by id")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) throws ChangeSetPersister.NotFoundException {
        return contactService.updateContact(id, contactDetails);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a contact by id")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @PostMapping("/{contactId}/skills/{skillId}")
    @ApiOperation(value = "Assign a skill to an existing contact by skill id and contact id")
    public Contact addSkillToContact(@PathVariable Long contactId, @PathVariable Long skillId) throws ChangeSetPersister.NotFoundException {
        Contact contact = contactService.getContact(contactId);
        Skill skill = skillService.getSkill(skillId);

        contact.getSkills().add(skill);
        return contactService.updateContact(contactId, contact);
    }

    @DeleteMapping("/{contactId}/skills/{skillId}")
    @ApiOperation(value = "Remove a skill of an existing contact by skill id and contact id")
    public Contact removeSkillFromContact(@PathVariable Long contactId, @PathVariable Long skillId) throws ChangeSetPersister.NotFoundException {
        Contact contact = contactService.getContact(contactId);
        Skill skill = skillService.getSkill(skillId);

        contact.getSkills().remove(skill);
        return contactService.updateContact(contactId, contact);
    }
}
