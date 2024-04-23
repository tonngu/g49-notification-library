package se.lexicon.g2.dao;

import se.lexicon.g2.model.Email;

import java.util.List;

public interface EmailDao extends NotificationDao<Email>{
 List<Email> findBySubject(String subject);
}
