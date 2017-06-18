package at.fhj.swd.web;

import at.fhj.swd.model.User;
import at.fhj.swd.sequence.SequenceGenerator;
import at.fhj.swd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	private UserService userService;

	private SequenceGenerator sequenceGenerator;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setSequenceGenerator(SequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)				//check
	public String index(Model model) {
		return "redirect:/users";
	}

	// list all users
	@RequestMapping(value = "/users", method = RequestMethod.GET)			//check
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users/list";
	}

	// show add form
	@RequestMapping(value = "/users/add", method = RequestMethod.GET)		//check
	public String showAddUserForm(Model model) {
		User user = new User();
		model.addAttribute("userForm", user);
		return "users/form";
	}

	// save user
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("userForm") @Validated User user, BindingResult result, Model model) {
		user.setId(sequenceGenerator.generateId());
		userService.save(user);
		return "redirect:/users/" + user.getId();
	}

	// show update form
	@RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
		User user = userService.find(id);
		model.addAttribute("userForm", user);
		return "users/updateform";
	}

	// update user
	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userForm") @Validated User user, BindingResult result, Model model) {
		userService.change(user);
		return "redirect:/users/" + user.getId();
	}

	// delete user
	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/users";
	}

	//show user
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model) {
		User user = userService.find(id);
		if (user == null) {
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);
		return "users/show";
	}

}