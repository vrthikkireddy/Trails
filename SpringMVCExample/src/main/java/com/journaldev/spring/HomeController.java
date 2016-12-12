package com.journaldev.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.model.Employee;
import com.journaldev.spring.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	EmployeeService empService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dummy", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String login(@Validated User user, Model model) {
		model.addAttribute("userName", user.getUserName());
		return "user";
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String summary(Model model) {
		List<Employee> employees=empService.findAllUsers();
		model.addAttribute("empList", employees);
		return "EmpSummary";
	}
	
	@RequestMapping(value = "/empmgr", method = RequestMethod.GET)
	public String empMGR(Model model) {
		return "EmployeeForm";
	}
	
	@RequestMapping(value = "/empsave", method = RequestMethod.GET)
	public String empSave(@Validated Employee employee, Model model) {
		int result = empService.saveEmployee(employee);
		logger.info("Emp Save Result "+((result==1)?"Success":"Failure"));
		model.addAttribute("empName", result);
		return "empSuccess";
	}
	
	/**
	 * Method to show employee summary details
	 * @param pageid
	 * @return
	 */
	  @RequestMapping(value="/viewemp/{pageid}",method=RequestMethod.GET)  
	    public ModelAndView edit(@PathVariable int pageid){  
	        int total=10;  
	        if(pageid==1){}  
	        else{  
	        	pageid=(pageid-1)*total+1;  
	        }  
	        List<Employee> list=empService.getEmployeesByPage(pageid, total);
	        return new ModelAndView("viewemp","list",list);  
	    }
	  
	  /**
	   * Method to save the employee 
	   */
//	  @RequestMapping(value="/save/{empid}",method=RequestMethod.GET)  
//	    public ModelAndView save(@PathVariable int empid){
//		  logger.info("In Controller - Delete Emp");
//		  int result = empService.saveEmployee(emp);
//	      return new ModelAndView("DeleteEmployee","result",result);
//	    }
	  
	  /**
	   * Method to delete the employee 
	   */
	  @RequestMapping(value="/delete/{empid}",method=RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int empid){
		  logger.info("In Controller - Delete Emp");
		  int result = empService.deleteEmployee(empid);
	      return new ModelAndView("DeleteEmployee","result",result);
	    }
	  
	  
	  @RequestMapping(value = "/emp/save", method = RequestMethod.GET)
		public String saveCustomerPage(Model model) {
			logger.info("Returning empSave.jsp page");
			model.addAttribute("employee", new Employee());
			return "empSave";
		}

		@RequestMapping(value = "/emp/save.do", method = RequestMethod.POST)
		public String saveEmployeeAction(
				@Valid Employee employee,
				BindingResult bindingResult, Model model) {
			if (bindingResult.hasErrors()) {
				logger.info("Returning empSave.jsp page");
				return "empSave";
			}
			logger.info("Returning empSaveSuccess.jsp page");
			model.addAttribute("employee", employee);
			logger.info("Saved Employee\t"+employee);
//			customers.put(customer.getEmail(), customer);
			empService.saveEmployee(employee);
			return "empSaveSuccess";
		}
		
		  @RequestMapping(value = "/emp/edit/{empId}", method = RequestMethod.GET)
			public String editEmpPage(@PathVariable int empId, Model model) {
				logger.info("Returning empSave.jsp page");
				Employee employee = empService.findById(empId);
				model.addAttribute("employee", employee);
				return "empEdit";
			}

		
		@RequestMapping(value = "/emp/edit.do", method = RequestMethod.POST)
		public String editEmployeeAction(
				@Valid Employee employee,
				BindingResult bindingResult, Model model) {
			if (bindingResult.hasErrors()) {
				logger.info("Returning empEdit.jsp page");
				return "empEdit";
			}
			logger.info("Returning empEditSuccess.jsp page");
			model.addAttribute("employee", employee);
			empService.updateEmployee(employee);
			logger.info("Updated Employee\t"+employee);
			return "empEditSuccess";
		}
		

}
