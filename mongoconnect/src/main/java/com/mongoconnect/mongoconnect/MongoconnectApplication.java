package com.mongoconnect.mongoconnect;

import com.mongoconnect.mongoconnect.Repository.StudentRepository;
import com.mongoconnect.mongoconnect.entity.Address;
import com.mongoconnect.mongoconnect.entity.Gender;
import com.mongoconnect.mongoconnect.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoconnectApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return args -> {
			Address address = new Address("United States", "Millburn", "0000");
			Student student = new Student("Michael", "Lee", "michae_email.gmail.com", Gender.MALE,address, BigDecimal.TEN,List.of("Computer Science"),  LocalDateTime.now());
			String email = "michae_email.gmail.com";
//			Query query = new Query();

//			query.addCriteria(Criteria.where("email").is(email));
//			List<Student> students = mongoTemplate.find(query, Student.class);
//			if(students.size() > 1){
//				throw new IllegalStateException("Found many studnets with email " + email);
//			}
//			if(students.isEmpty()){
//				System.out.println("Inserting student " + student);
//				repository.insert(student);
//			}else{
//				System.out.println(student + " already exists");
//			}
			repository.findStudentByEmail(email)
					.ifPresentOrElse(targetStudent->{
						System.out.println("Already Exists: " + targetStudent);
					}, ()->{
						System.out.println("Inserting student: " + student );
						repository.insert(student);
					});
		};
	}
}
