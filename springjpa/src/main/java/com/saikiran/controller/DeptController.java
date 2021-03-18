package com.saikiran.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.model.Department;
import com.saikiran.repo.DeptRePo;


@Controller
public class DeptController {
@Autowired
private DeptRePo depts;
@RequestMapping ("/adddept")
public String addDept(ModelMap model) {
	Department d  = new Department();
	model.addAttribute("depts", d);
	return "add_dept";
}
@RequestMapping(value  = "/adddept" ,method = RequestMethod.POST)
public String addDept(@Valid Department d ,Errors errors ,Model model) {
	try {
		if(errors.getErrorCount()>0)throw new RuntimeException(errors.toString());
		if(depts.findById(d.getId()).isPresent()) throw new RuntimeException("Dept Identity");
		
		depts.save(d);
		return "add_dept";
	}
	catch(Exception ex) {
		model.addAttribute("depts", d);
		model.addAttribute("meassge", ex.getMessage());
		return "add_dept";
	}
}
}