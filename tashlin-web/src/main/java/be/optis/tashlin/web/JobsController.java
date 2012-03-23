package be.optis.tashlin.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value= {"/", "/jobs"})
public class JobsController {

	@RequestMapping(method = RequestMethod.GET)
	public String showJobs() {
		return ".jobs.overview";
	}
	
	@RequestMapping(value="/build", method = RequestMethod.GET)
	public  @ResponseBody void build(HttpServletResponse response) throws Exception {
		response.setContentType("application/json");
        String json = "{\"status\": \"Build Started\"}";
        PrintWriter out= response.getWriter();
        out.write(json);
	}

}
