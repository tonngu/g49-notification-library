package se.lexicon.g2.dao;

import se.lexicon.g2.exception.DataNotFoundException;
import se.lexicon.g2.model.Email;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmailDaoImpl implements EmailDao {

    private List<Email> emailList;

    private static EmailDaoImpl instance;

    private EmailDaoImpl(){
        emailList = new ArrayList<>();
    }

    public static EmailDaoImpl getInstance(){
        if(instance == null){
            instance = new EmailDaoImpl();
        }
        return instance;
    }



    @Override
    public Email save(Email email) {
        if (email == null) throw new IllegalArgumentException("Email is null.");
        email.setId(UUID.randomUUID().toString());
        email.setCreateDateTime(LocalDateTime.now());
        emailList.add(email);
        return email;

    }

    @Override
    public void update(Email email) {
        if (email == null) throw new IllegalArgumentException("email is null.");
        if (email.getId() == null) throw new IllegalArgumentException("email id is null.");

        Email existingEmail = find(email.getId());
        existingEmail.setSubject(email.getSubject());
        existingEmail.setContent(email.getContent());
        existingEmail.setRecipient(email.getRecipient());
    }

    @Override
    public Email find(String id) {
        if (id == null) throw new IllegalArgumentException("Id is null.");
        return emailList.stream()
                .filter(email -> email.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException("Email data with id: " + id + " not found."));

    }

    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emailList);
    }

    @Override
    public List<Email> findBySubject(String subject) {
        if (subject == null) throw new IllegalArgumentException("Subject is null");
        return emailList.stream()
                .filter(email -> email.getSubject().equalsIgnoreCase(subject))
                .collect(Collectors.toList());
    }
}
