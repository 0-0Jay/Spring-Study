package com.example.Academy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MainController {
	@GetMapping("/main")
	public String index() {return "Main";}
	
	@GetMapping("/lectureForm")
	public String lectureForm() {return "LectureForm";}
	
	@GetMapping("/teacherForm")
	public String teacherForm() {return "TeacherForm";}
}
