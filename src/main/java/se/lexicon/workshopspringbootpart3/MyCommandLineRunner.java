package se.lexicon.workshopspringbootpart3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.workshopspringbootpart3.repository.AppUserRepository;
import se.lexicon.workshopspringbootpart3.repository.DetailsRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    DetailsRepository detailsRepository;

    public void run(String...args) throws Exception {




    }
}
