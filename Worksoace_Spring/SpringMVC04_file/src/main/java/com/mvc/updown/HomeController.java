package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.updown.validate.FileValidator;
import com.mvc.updown.validate.UploadFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request,Model model, UploadFile uploadFile, BindingResult result) {
		// 파일 유효성 검사
		fileValidator.validate(uploadFile, result);
		if (result.hasErrors()) {
			return "upload";
		}
		// 임시 저장소에 업로드
		MultipartFile file = uploadFile.getMpfile();
		String name = file.getOriginalFilename();
		
		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream();
			// getRealPath : 서블릿 컨테이너에서 제공하는 대로 웹 응용 프로그램 내에서 지정된 경로의 실제 경로를 반환합니다
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			System.out.println("업로드 실제 경로 : " + path);
			
			// 해강 경로에 파일이 없으면 폴더생성
			File storage = new File(path);
			if (!storage.exists()) {
				storage.mkdirs();
			}
			
			// 해당 경로에 파일이 없으면 파일생성
			File newFile = new File(path + "/" + name);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			
			outputStream = new FileOutputStream(storage);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			while ((read = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		model.addAttribute("fileObj", fileObj);
		
		return "download";
	}
	
	@ResponseBody
	@RequestMapping("/download")
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response,String name) {
		
		byte[] down = null;

		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			File file = new File(path + "/" + name);
			
			// FileCopyUtils란 파일및 스트림복사를 위한 간단한 유틸리티 메소드의 집합체
	        // copyToByteArray 지정한 inputStream의 내용을 카피하고 완료하면 stream을 닫는다.
			down = FileCopyUtils.copyToByteArray(file);
			// getBytes : 플랫폼의 기본 문자 집합을 사용하여 이 문자열을 바이트 시퀀스로 인코딩하고 결과를 새 바이트 배열에 저장합니다.
			// getName : 이 추상 경로 이름으로 표시된 파일 또는 디렉터리의 이름을 반환합니다.
			// 한글은 http 헤더에 사용할 수 없기때문에 파일명은 영문으로 인코인하여 헤더에 적용한다.
			String filename = new String(file.getName().getBytes(), "8859_1");
			
			// Content-Disposition : attachment -> file download 설정 (filename 설정)
			//attachment : 브라우저 인식 파일확장자를 포함하여 모든 확장자의 파일들에 대해, 다운로드 시 무조건 '파일다운로드' 대화상자가 뜨도록 하는 해더속성
			response.setHeader("Content-disposition", "attachment; filename=\""+filename+"\"");
			//content-disPosition : 컨텐트 타입의 옵션
			response.setContentLength(down.length);
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return down;
	}
}
