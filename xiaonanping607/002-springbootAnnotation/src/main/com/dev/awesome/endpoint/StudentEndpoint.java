package main.com.dev.awesome.endpoint;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.com.dev.awesome.model.Student;

@RestController
@RequestMapping("student")
public class StudentEndpoint {

	@RequestMapping(method = RequestMethod.GET,
			path = "/list")
	public List<Student> listAll() {
		return asList(new Student("Samuel"), new Student("Marco"));
	}
}
