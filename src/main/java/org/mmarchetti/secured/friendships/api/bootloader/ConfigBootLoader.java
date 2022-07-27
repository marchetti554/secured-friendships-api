package org.mmarchetti.secured.friendships.api.bootloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.mmarchetti.secured.friendships.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.Arrays;

@Configuration
public class ConfigBootLoader {

    private final UserRepository userRepository;

    @Value("${initialize.test.data}")
    private String initializeUserTestData;

    public ConfigBootLoader(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeUserTestData() throws IOException {
        if (Boolean.parseBoolean(initializeUserTestData)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            UserDto[] testUsersList = mapper.readValue(ResourceUtils.getFile("classpath:test_user_data.json"), UserDto[].class);
            userRepository.saveAll(Arrays.stream(testUsersList).toList());
        }
    }
}
