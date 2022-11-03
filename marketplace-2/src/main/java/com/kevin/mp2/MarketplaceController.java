package com.kevin.mp2;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kevin.mp2.model.*;
import com.kevin.mp2.repo.ProductRepo;
import com.kevin.mp2.repo.UserRepo;

@Controller
public class MarketplaceController {

	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ProductRepo prodRepo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/products")
	public String listProducts() {
		return "products";
	}
	


	@GetMapping("/register_user")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register_user";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}

	@PostMapping("/process_register")
	public String saveUser(User user, @RequestParam("image") MultipartFile multipartFile) throws IOException {

		if (multipartFile != null) {
			try {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(user.getPassword());
				user.setPassword(encodedPassword);

				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				user.setUserImage(fileName);

				User savedUser = userRepo.save(user);

				String uploadDir = "user-photos/" + savedUser.getUserId();

				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
				System.out.println("Successfully added user: " + savedUser.toString());
			} catch (IOException e) {
				System.out.println("Problem with photo, skipping...");

			}

		} else {
			System.out.println("Photo is null, skipping verifications...");
		}
		
		return "register_success";
	}
}
