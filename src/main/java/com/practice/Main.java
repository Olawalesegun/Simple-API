package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse greetResponse = new GreetResponse("Hello User, You are Welcome",
                List.of("Nigeria", "Ghana", "Kenya"),
                new User("Bolatito"));
        return greetResponse;
        //return "Good Morning User David";
    }

    record GreetResponse(String greet, List<String> countries, User user){}
    record User(String userName){}

    // Everything stated here is doing the job of what the record GreetRespose is doing above
    // However for we to write all these things, the record class will do this same thing in one line
    // The code below is basically showing what is happening under the hood for record GreetResponse
    /*class GreetResponse{
        private final String greet;
        public GreetResponse(String greet){
            this.greet = greet;
        }
        public String getGreet() {
            return greet;
        }

        @Override
        public String toString() {
            return "GreetResponse{" +
                    "greet='" + greet + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GreetResponse that = (GreetResponse) o;
            return Objects.equals(greet, that.greet);
        }

        @Override
        public int hashCode() {
            return Objects.hash(greet);
        }
    }*/
}
