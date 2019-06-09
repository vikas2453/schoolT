package com.edu.schoolT.web;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.schoolT.dao.impl.KakshaDao;
import com.edu.schoolT.model.Leave;
import com.edu.schoolT.model.StudentListForm;
import com.edu.schoolT.model.Teacher;
import com.edu.schoolT.service.AttendanceService;

@Controller
public class AttendenceConroller {
	static final Logger logger = Logger.getLogger(AttendenceConroller.class);
	@Autowired	AttendanceService attendanceService;
	@Autowired	KakshaDao KakshaDao;
	@Autowired	StudentListForm studentListForm;
	@Autowired	Leave leaveform;

	static Map<String, String> status = new LinkedHashMap<String, String>();
	static {
		status.put("Present", "Present");
		status.put("Leave", "Leave");
		status.put("Absent", "Absent");
		status.put("Absconding", "Absconding");

	}

	@RequestMapping(value = "/attendence.htm", method = RequestMethod.GET)
	public String showAttendenceForm(HttpSession session, Principal principal,
			Model model) {

		// replace below code and get all student from Kakshaservice instead

		Teacher teacher = (Teacher) session.getAttribute("teacher");
		if (teacher != null) {
			/*studentListForm.setStudentList(KakshaDao.students(teacher
					.getKaksha()));*/
			model.addAttribute(studentListForm);
			model.addAttribute("status", status);

			return "Teacher/Attendance";
		}
		return null;

	}

	@RequestMapping(value = "/attendence.htm", method = RequestMethod.POST)
	public String markAttendence(StudentListForm studentListForm) {
		attendanceService.markAttendence(studentListForm.getStudentList());
		return "Teacher/Attendance";

	}

	@RequestMapping(value = "/applyLeave.htm", method = RequestMethod.GET)
	public String applyLeave(Model model) {
		attendanceService.markAttendence(studentListForm.getStudentList());
		model.addAttribute(leaveform);
		return "parent/leave";

	}

}
