package com.example.euroleaguewordle;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@EnableScheduling
@SpringBootApplication
public class EuroleagueWordleApplication {

    public static int randomNum;

    public static void main(String[] args) {
        SpringApplication.run(EuroleagueWordleApplication.class, args);
//        Random random = new Random();
//
//        randomNum = random.nextInt((6 - 1) + 1) + 1;
//
        scheduledRandomPlayer();
        //randomNum = 164;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public static void scheduledRandomPlayer () {
        Random random = new Random();

        randomNum = random.nextInt(15 - 1 + 1) + 1;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
