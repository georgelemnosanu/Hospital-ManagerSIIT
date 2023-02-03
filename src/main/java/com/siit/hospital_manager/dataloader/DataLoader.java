package com.siit.hospital_manager.dataloader;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final BCryptPasswordEncoder encoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //todo
    }


}