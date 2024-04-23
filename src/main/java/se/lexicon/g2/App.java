package se.lexicon.g2;

import se.lexicon.g2.dao.EmailDaoImpl;
import se.lexicon.g2.dao.EmailDao;
import se.lexicon.g2.model.Email;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        EmailDao dao = EmailDaoImpl.getInstance(); // emailList is empty

        dao.save(new Email("mehrdad.javan@lexicon.se", "Test Subject", "Test Content"));

        System.out.println(dao.findAll().size());

        EmailDao dao2 = EmailDaoImpl.getInstance();
        System.out.println(dao2.findAll().size());

    }
}
