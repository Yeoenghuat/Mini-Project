package com.govtech.miniproject.startup;

import com.govtech.miniproject.model.User;
import com.govtech.miniproject.repository.UserRepository;
import com.govtech.miniproject.util.FileReaderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Component
public class PopulateDatabase implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(PopulateDatabase.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * This method is used to populate the database table using the csv file provided in the resources folder.
     * @param args Unused.
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.debug("Populating Database");

        try {
            File initialFile = new File("src/main/resources/user_list.csv");
            InputStream inputStream = new FileInputStream(initialFile);
            List<User> userList = FileReaderUtils.read(User.class, inputStream);
            userRepository.saveAll(userList);
        } catch (Exception ex) {
            logger.error("Error inserting user list from csv file.", ex);
        }
    }
}
