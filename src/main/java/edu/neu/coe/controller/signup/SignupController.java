package edu.neu.coe.controller.signup;

import edu.neu.coe.model.Party;
import edu.neu.coe.repository.AccountRepository;
import edu.neu.coe.repository.PartyRepository;
import edu.neu.coe.service.UserService;
import edu.neu.coe.support.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SignupController {

    private static final String SIGNUP_VIEW_NAME = "signup/signup";

	@Autowired
	private AccountRepository accountRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private UserService userService;
	
	@RequestMapping(value = "signup")
	public String signup(Model model) {
		model.addAttribute(new SignupForm());
        return SIGNUP_VIEW_NAME;
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return SIGNUP_VIEW_NAME;
		}

        Party party = new Party();
        party.setFirstName("Jesse");
        party.setLastName("Ge");
        party.setGender(Party.Gender.FEMALE);
        party.setTitle("Mrs");
        party.setAlias("Jesse");

        partyRepository.save(party);


        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, "signup.success");
		return "redirect:/";
	}
}
