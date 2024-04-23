package se.lexicon.g2.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.g2.exception.DataNotFoundException;
import se.lexicon.g2.model.Email;

public class EmailDaoTest {
    private EmailDaoImpl testObject;
    private Email savedEmail;


     @BeforeEach
     public void setup(){
         testObject = EmailDaoImpl.getInstance();
         Email email = new Email("recipient@example.com", "Test Subject", "Test message");
         savedEmail = testObject.save(email);



     }

     @Test
     @DisplayName("test save email")
    public void testSave(){


         Email email = new Email("recipient@example.com", "Test Subject", "Test message");
         Email savedEmail = testObject.save(email);
         assertNotNull(savedEmail);

         Email foundEmail = testObject.find(savedEmail.getId());
         assertEquals(savedEmail, foundEmail);

     }

     @Test
    public void testUpdate(){
         // save an email

         //find it

         // compare it

         Email foundEmail = testObject.find(savedEmail.getId());
         assertNotNull(foundEmail);
         assertEquals(savedEmail, foundEmail);
     }

     @Test
    public void testNonExistingId(){

        assertThrows(DataNotFoundException.class, () -> testObject.find("non-existing-id") );

     }




}
