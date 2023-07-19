package com.example.marcell.webapichallenge.service;

import com.example.marcell.webapichallenge.entity.Contact;
import com.example.marcell.webapichallenge.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public Contact getContact(Long id) throws ChangeSetPersister.NotFoundException {
        return contactRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact contact) throws ChangeSetPersister.NotFoundException {
        Contact contactEntity = contactRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        contactEntity.setFirstName(contact.getFirstName());
        contactEntity.setLastName(contact.getLastName());
        contactEntity.setFullName(contact.getFullName());
        contactEntity.setAddress(contact.getAddress());
        contactEntity.setEmail(contact.getEmail());
        contactEntity.setMobilePhoneNumber(contact.getMobilePhoneNumber());
        return contactRepository.save(contactEntity);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
