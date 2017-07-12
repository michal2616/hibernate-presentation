package com.gwiazda;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwiazda.model.Address;
import com.gwiazda.model.Person;
import com.gwiazda.repository.PersonRepository;

@SpringBootApplication
@Transactional
public class HibernateEmptyApplication implements CommandLineRunner {

	public static final String JANUSZ = "Janusz";
	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateEmptyApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		personRepository.deleteAll();
		createFakePeople();

	}


	public void createFakePeople(){

		IntStream.range(1, 10).forEach(i -> savePerson(i));

	}

	private void savePerson(int i) {

		List<Address> addressList = IntStream.range(1, 11).boxed().
				map(a -> Address.builder()
				.city("Katowice" + a)
				.postalCode("a" + new SecureRandom().nextInt(10000))
				.street("Konduktorska" + a)
				.nr(i).build()
				).collect(Collectors.toList());


		Person nowaOsoba = Person.builder().name(JANUSZ + i).addresses(addressList).build();
		personRepository.save(nowaOsoba);
	}
}
