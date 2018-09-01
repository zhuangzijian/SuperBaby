 package com.pd.controller;

import java.io.PrintWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.pd.word.WordUtils;

@Controller
@RequestMapping("/PD")
public class PDController {

	@RequestMapping("/view")
	public ModelAndView view(HttpServletRequest request) {
		String path = request.getParameter("path") + "";
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path); 
		return mav;
	}
	@RequestMapping(value = "/wordPath", produces = "text/html;charset=UTF-8")
	public void getWord(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
		Gson json = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Map<String, Object> resultMap = new HashMap<>();// 用来返回数据的map
		PrintWriter out = null;
		String para = request.getParameter("para");
		try {
			System.out.println("======" + para);
			out = response.getWriter(); 
			if (para == null || para.trim().equals("")) {
				resultMap.put("status", -1);
				out.write(json.toJson(resultMap));
			} else {
				// 获取参数
				JsonReader jsonReader = new JsonReader(new StringReader(para == null ? "" : para));// 其中jsonContext为String类型的Json数据
				jsonReader.setLenient(true);
				Map<String, Object> paras = json.fromJson(jsonReader, Map.class);
				String ipAndPort=paras.get("serverIPAndPort")+"";//从请求参数获取服务器IP和端口号（或者域名）例如：192.168.1.8:8080
				String fileName= WordUtils.testTemplateWrite(paras, request);
				String wordPath = ipAndPort+"/poleDetectionServer/resources/"+fileName;
				resultMap.put("status", 0);
				resultMap.put("path", wordPath);// 保定学院本科毕业论文开题报告书.doc
				out.write(json.toJson(resultMap));
			}

		} catch (Exception e) {
			e.printStackTrace();

			resultMap.put("status", -1);
			out.write(json.toJson(resultMap));
		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("res+++++>" + json.toJson(resultMap));
	}
}
