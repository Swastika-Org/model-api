package org.agoncal.quarkus.microservices.book;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.agoncal.quarkus.microservices.book.model.ISBNNumber;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
@Tag(name="Book Rest Service")
public class BookResource {

	@Inject
	Logger log;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary ="Get List of Books")
	public Set<ISBNNumber> getIsbn() {
		Set<ISBNNumber> isbns = Collections.synchronizedSet(new LinkedHashSet<>());
		ISBNNumber first = new ISBNNumber();
		first.setIsbnNumber("12334");
		first.setCreationTime(Instant.now());
		
		ISBNNumber second = new ISBNNumber();
		second.setIsbnNumber("56789");
		second.setCreationTime(Instant.now());
		
		isbns.add(first);
		isbns.add(second);
		
		log.info("result is "+isbns);
		
		return isbns;
	}
}
