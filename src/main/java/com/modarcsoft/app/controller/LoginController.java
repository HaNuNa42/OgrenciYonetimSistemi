package com.modarcsoft.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.modarcsoft.app.entities.Kullanicilar;
import com.modarcsoft.app.service.KullaniciService;

//@RestController
@Controller
public class LoginController {
	
	@Autowired
	private KullaniciService kullaniciService;
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public String controlUser(Kullanicilar kullanici, HttpServletRequest request) {

		Kullanicilar kullanicilar = kullaniciService.kullaniciadiVeSifreKontrol(kullanici);
		try {
			if (kullanici != null) {
				System.out.printf("oturum açıldı", kullanici.getKullanciadi().toString());

				request.getSession().setAttribute("kullanici", kullanicilar);
				request.getSession().setAttribute("id", kullanicilar.getId());

				return "redirect:/index";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/login";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String cikisYap(Model model, HttpServletRequest request) {
		request.getSession().setAttribute("kullanici", null);

		return "redirect:/login";
	}
	
	/* 
    @Autowired private DepartmentService departmentService;
  
    // Save operation
    @PostMapping("/departments")
    public Department saveDepartment(
        @Valid @RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }
  
    // Read operation
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }
  
    // Update operation
    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(
            department, departmentId);
    }
  
    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        departmentService.deleteDepartmentById(
            departmentId);
  
        return "Deleted Successfully";
    }
    
    */
}
