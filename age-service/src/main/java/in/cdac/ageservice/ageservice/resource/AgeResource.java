package in.cdac.ageservice.ageservice.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.cdac.ageservice.ageservice.logic.AgeCalculator;
import in.cdac.ageservice.ageservice.model.Age;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Age REST Endpoint")
@RestController
@RequestMapping("/rest/age")
public class AgeResource {

	@Autowired
	RestTemplate restTemplate;

	@ApiOperation(value="returns User with age")
	@ApiResponses(value = {
			@ApiResponse(code=200 , message="success")
	})
	@GetMapping("/{username}")
	public User getUserAge(@PathVariable("username") final String username) {

		User user = restTemplate.getForObject("http://localhost:8300/rest/db/" + username, User.class);

		user.setAge(dobToAge(user.getAge()));
		
		return user;

	}

	private String dobToAge(String dob) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = new Date();
		try {
			birthDate = sdf.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Yeh !! It's my date of birth :-)
		Age age = AgeCalculator.calculateAge(birthDate);

		return age.toString();

	}

}
