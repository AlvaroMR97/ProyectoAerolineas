package com.solera.bootcamp.airlinemanager.passenger;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
class PassengerController {

	private final PassengerRepository passengerRepository;

	PassengerController(PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/airline/passengers")
	List<Passenger> all() {
		return passengerRepository.findAll();
	}
	// end::get-aggregate-root[]

	// Single item
	@GetMapping("/airline/passengers/{idPassenger}")
	Passenger one(@PathVariable Integer idPassenger) {

		return passengerRepository.findById(idPassenger).orElseThrow(() -> new PassengerNotFoundException(idPassenger));
	}

	@PostMapping("/airline/passengers")
	Passenger newPassenger(@RequestBody Passenger newPassenger) {
		return passengerRepository.save(newPassenger);
	}

	@PutMapping("/airline/passengers/{idPassenger}")
	Passenger replacePassenger(@RequestBody Passenger newPassenger, @PathVariable Integer idPassenger) {

		return passengerRepository.findById(idPassenger).map(passenger -> {
			passenger.setIdDocument(newPassenger.getIdDocument());
			passenger.setName(newPassenger.getName());
			passenger.setSurname(newPassenger.getSurname());
			passenger.setNationality(newPassenger.getNationality());
			passenger.setAge(newPassenger.getAge());
			return passengerRepository.save(passenger);
		}).orElseGet(() -> {
			newPassenger.setIdPassenger(idPassenger);
			return passengerRepository.save(newPassenger);
		});
	}

	@DeleteMapping("/airline/passengers/{idPassenger}")
	void deletePassenger(@PathVariable Integer idPassenger) {
		passengerRepository.deleteById(idPassenger);
	}
}