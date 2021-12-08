package fr.lernejo.chat;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;
import java.util.Scanner;

@SpringBootApplication

public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class,args);
        var ctx= new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate template = ctx.getBean((RabbitTemplate.class));
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean start = true;
        System.out.println("Saisissez un message, nous vous l'enverrons (q pour quitter)");
        input = scanner.nextLine();

        while(!(input.equals("q"))) {
            System.out.println("message envoyé, Saisissez un message, nous vous l'enverrons (q pour quitter)");
            template.convertAndSend("","chat_messages",input);
            input = scanner.nextLine();
        }
        System.out.println("ciao");
        ctx.close();
    }
}
