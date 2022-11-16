package com.solera.bootcamp.airlinemanager.origin;

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
class OriginController {

	private final OriginRepository originRepository;

	OriginController(OriginRepository originRepository) {
		this.originRepository = originRepository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/airline/origins")
	List<Origin> all() {
		return originRepository.findAll();
	}
	// end::get-aggregate-root[]

	// Single item
	@GetMapping("/airline/origins/{idOrigin}")
	Origin one(@PathVariable Integer idOrigin) {

		return originRepository.findById(idOrigin).orElseThrow(() -> new OriginNotFoundException(idOrigin));
	}

	@PostMapping("/airline/origins")
	Origin newOrigin(@RequestBody Origin newOrigin) {
		return originRepository.save(newOrigin);
	}

	@PutMapping("/airline/origins/{idOrigin}")
	Origin replaceOrigin(@RequestBody Origin newOrigin, @PathVariable Integer idOrigin) {

		return originRepository.findById(idOrigin).map(origin -> {
			origin.setLocation(newOrigin.getLocation());
			origin.setPrice_origin(newOrigin.getPrice_origin());
			origin.setPrice_scale(newOrigin.getPrice_scale());
			origin.setPrice_destination(newOrigin.getPrice_destination());
			origin.setScalePos(newOrigin.getScalePos());
			return originRepository.save(origin);
		}).orElseGet(() -> {
			newOrigin.setIdOrigin(idOrigin);
			return originRepository.save(newOrigin);
		});
	}

	@DeleteMapping("/airline/origins/{idOrigin}")
	void deleteOrigin(@PathVariable Integer idOrigin) {
		originRepository.deleteById(idOrigin);
	}
}