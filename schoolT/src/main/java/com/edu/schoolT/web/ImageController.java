package com.edu.schoolT.web;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.schoolT.model.Student;

@Controller
public class ImageController {
	static final Logger logger = Logger.getLogger(ImageController.class);
	
	@RequestMapping(value="/studentImage.htm", method=RequestMethod.GET)
	public void getStudentImage(final HttpSession session, HttpServletResponse response){  
		 
		if((session).getAttribute("student")!=null){			
		Student student=(Student)session.getAttribute("student");		
		           
		try {
			OutputStream out = response.getOutputStream();
			Blob photo= student.getStudent_photo();
			if(photo!=null){
				byte[] b= photo.getBytes(1,(int) photo.length());
				out.write(b);
				//IOUtils.copy(photo.getBinaryStream(), out);
				out.flush();             
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}             

		}
	}

}
