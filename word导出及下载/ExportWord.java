package com.ssm.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.dao.agrbase.TPlaceBaseinfoMapper;
import com.ssm.dao.agrbase.TPlaceSoilMapper;
import com.ssm.dao.agrbase.TPlaceSoilPlantMapper;
import com.ssm.dao.agrbase.TPlaceSoilStubbleMapper;
import com.ssm.model.agrbase.TPlaceBaseinfo;
import com.ssm.model.agrbase.TPlaceBaseinfoExample;
import com.ssm.model.agrbase.TPlaceSoil;
import com.ssm.model.agrbase.TPlaceSoilExample;
import com.ssm.model.agrbase.TPlaceSoilPlant;
import com.ssm.model.agrbase.TPlaceSoilPlantExample;
import com.ssm.model.agrbase.TPlaceSoilStubble;
import com.ssm.model.agrbase.TPlaceSoilStubbleExample;
import com.ssm.util.CustomXWPFDocument;
import com.ssm.util.XwpfTUtil;

@Controller
public class ExportWord{
	@Resource
    private TPlaceBaseinfoMapper plcMapper; 
	@Resource
	private TPlaceSoilMapper soilMapper;
	@Resource
	private TPlaceSoilPlantMapper splantMapper;
	@Resource
	private TPlaceSoilStubbleMapper stubbleMapper;

	
	@RequestMapping("exportWordData.do")
	public void exWord(HttpServletResponse response, HttpServletRequest request,Integer id) throws Exception {  
		TPlaceBaseinfoExample example = new TPlaceBaseinfoExample();
		TPlaceBaseinfoExample.Criteria c = example.createCriteria();
		
		TPlaceSoilExample soil = new TPlaceSoilExample();
		TPlaceSoilExample.Criteria csoil = soil.createCriteria();
		
		TPlaceSoilPlantExample splant = new TPlaceSoilPlantExample();
		TPlaceSoilPlantExample.Criteria csplant = splant.createCriteria();
		
		TPlaceSoilStubbleExample stubble = new TPlaceSoilStubbleExample();
		TPlaceSoilStubbleExample.Criteria cstubble = stubble.createCriteria();
		if(id!=null){
			c.andIdEqualTo(id);
			csoil.andPlaceBaseinfoIdEqualTo(id);
			csplant.andPlaceBaseinfoIdEqualTo(id);
			cstubble.andPlaceBaseinfoIdEqualTo(id);
		}
		List<TPlaceBaseinfo> lists = plcMapper.selectByExample(example);
		List<TPlaceSoil> soillists = soilMapper.selectByExample(soil);
		List<TPlaceSoilPlant> plantlists = splantMapper.selectByExample(splant);
		List<TPlaceSoilStubble> stubblelists = stubbleMapper.selectByExample(stubble);
		String filePath = request.getSession().getServletContext().getRealPath("/resources/sta.docx");
        InputStream is = new FileInputStream(filePath); 
        
        CustomXWPFDocument doc = new CustomXWPFDocument(is);
        
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("${year}", lists.get(0).getPlaceyear());
        params.put("${province}", lists.get(0).getPlaceprovince());  
        params.put("${city}", lists.get(0).getPlacecity());  
        params.put("${county}", lists.get(0).getPlacecounty());  
        params.put("${village}", lists.get(0).getPlacevillage()); 
        params.put("${parea}", lists.get(0).getPlacearea()); 
        params.put("${chanliang}", lists.get(0).getPlaceoutput()); 
        params.put("${plcnum}",lists.get(0).getPlacenum());  
        params.put("${pname}", lists.get(0).getPlacefarmername());  
        params.put("${phone}", lists.get(0).getPlacefarmerphone());  
        params.put("${vname}", lists.get(0).getPlacevegetablename());  
        params.put("${vtype}", lists.get(0).getPlacevegetabletype());  
        params.put("${postcode}", lists.get(0).getPlacezipcode());  
        params.put("${bztime}", lists.get(0).getPlacesowdatetime());  
        params.put("${dztime1}", lists.get(0).getPlaceplantdatetime());  
        params.put("${cstime1}", lists.get(0).getPlaceharvestdatetime());  
        params.put("${chakou}", lists.get(0).getPlacecultivatemodel());  
        params.put("${qiancha}", lists.get(0).getPlacefrontcrop());  
        params.put("${cstime2}", lists.get(0).getPlacefrontharvestdatetime());  
        params.put("${houcha}", lists.get(0).getPlaceaftercrop());  
        params.put("${dztime2}", lists.get(0).getPlaceafterplantdatetime());
        params.put("${createUnit}", lists.get(0).getCreateunit());
        params.put("${createUser}", lists.get(0).getCreateuser());
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  //将时间格式化并转换为字符串
        String dateString = formatter.format(lists.get(0).getCreatedatetime());   
        params.put("${createDateTime}",dateString);
        
        		params.put("${soilHole1}",soillists.get(0).getSoilhole());
        		params.put("${soilVolume1}",soillists.get(0).getSoilvolume());
        		params.put("${soilWaterContent1}",soillists.get(0).getSoilwatercontent());
        		params.put("${soilOrganic1}",soillists.get(0).getSoilorganic());
        		params.put("${soilConductivity1}",soillists.get(0).getSoilconductivity());
        		params.put("${soilPH1}",soillists.get(0).getSoilph());
        		params.put("${soilAllN1}",soillists.get(0).getSoilalln());
        		params.put("${soilAllP1}",soillists.get(0).getSoilallp());
        		params.put("${soilAllK1}",soillists.get(0).getSoilallk());
        		params.put("${soilAlkalineN1}",soillists.get(0).getSoilalkalinen());
        		params.put("${soilQuickP1}",soillists.get(0).getSoilquickp());
        		params.put("${soilQuickK1}",soillists.get(0).getSoilquickk());
        		params.put("${soilHeavyMetal1}",soillists.get(0).getSoilheavymetal());
        		params.put("${soilPesticideResidue1}",soillists.get(0).getSoilpesticideresidue());
        		params.put("${soilBug1}",soillists.get(0).getSoilbug());
        		params.put("${soilRemark1}",soillists.get(0).getSoilremark());
        		
        		params.put("${soilHole2}",soillists.get(1).getSoilhole());
        		params.put("${soilVolume2}",soillists.get(1).getSoilvolume());
        		params.put("${soilWaterContent2}",soillists.get(1).getSoilwatercontent());
        		params.put("${soilOrganic2}",soillists.get(1).getSoilorganic());
        		params.put("${soilConductivity2}",soillists.get(1).getSoilconductivity());
        		params.put("${soilPH2}",soillists.get(1).getSoilph());
        		params.put("${soilAllN2}",soillists.get(1).getSoilalln());
        		params.put("${soilAllP2}",soillists.get(1).getSoilallp());
        		params.put("${soilAllK2}",soillists.get(1).getSoilallk());
        		params.put("${soilAlkalineN2}",soillists.get(1).getSoilalkalinen());
        		params.put("${soilQuickP2}",soillists.get(1).getSoilquickp());
        		params.put("${soilQuickK2}",soillists.get(1).getSoilquickk());
        		params.put("${soilHeavyMetal2}",soillists.get(1).getSoilheavymetal());
        		params.put("${soilPesticideResidue2}",soillists.get(1).getSoilpesticideresidue());
        		params.put("${soilBug2}",soillists.get(1).getSoilbug());
        		params.put("${soilRemark2}",soillists.get(1).getSoilremark());
        		
        		params.put("${A1}",plantlists.get(0).getPlantbasefertilizertype());
        		params.put("${A2}",plantlists.get(0).getPlantbasemuuselevel());
        		params.put("${A3}",plantlists.get(0).getPlantbasen());
        		params.put("${A4}",plantlists.get(0).getPlantbasep());
        		params.put("${A5}",plantlists.get(0).getPlantbasek());
        		params.put("${A6}",plantlists.get(0).getPlantfertilizertype());
        		params.put("${A7}",plantlists.get(0).getPlantferusenum());
        		params.put("${A8}",plantlists.get(0).getPlantferpermuuselevel());
        		params.put("${A9}",plantlists.get(0).getPlantfermuuselevel());
        		params.put("${A10}",plantlists.get(0).getPlantpern());
        		params.put("${A11}",plantlists.get(0).getPlantperp());
        		params.put("${A12}",plantlists.get(0).getPlantperk());
        		params.put("${A13}",plantlists.get(0).getPlantmicrotype());
        		params.put("${A14}",plantlists.get(0).getPlantmicrouselevel());
        		params.put("${A15}",plantlists.get(0).getPlantmicron());
        		params.put("${A16}",plantlists.get(0).getPlantmicrop());
        		params.put("${A17}",plantlists.get(0).getPlantmicrok());
        		params.put("${A18}",plantlists.get(0).getPlantremark());
        		
        		params.put("${B1}",plantlists.get(1).getPlantbasefertilizertype());
        		params.put("${B2}",plantlists.get(1).getPlantbasemuuselevel());
        		params.put("${B3}",plantlists.get(1).getPlantbasen());
        		params.put("${B4}",plantlists.get(1).getPlantbasep());
        		params.put("${B5}",plantlists.get(1).getPlantbasek());
        		params.put("${B6}",plantlists.get(1).getPlantfertilizertype());
        		params.put("${B7}",plantlists.get(1).getPlantferusenum());
        		params.put("${B8}",plantlists.get(1).getPlantferpermuuselevel());
        		params.put("${B9}",plantlists.get(1).getPlantfermuuselevel());
        		params.put("${B10}",plantlists.get(1).getPlantpern());
        		params.put("${B11}",plantlists.get(1).getPlantperp());
        		params.put("${B12}",plantlists.get(1).getPlantperk());
        		params.put("${B13}",plantlists.get(1).getPlantmicrotype());
        		params.put("${B14}",plantlists.get(1).getPlantmicrouselevel());
        		params.put("${B15}",plantlists.get(1).getPlantmicron());
        		params.put("${B16}",plantlists.get(1).getPlantmicrop());
        		params.put("${B17}",plantlists.get(1).getPlantmicrok());
        		params.put("${B18}",plantlists.get(1).getPlantremark());

        		
        		params.put("${C1}",plantlists.get(2).getPlantbasefertilizertype());
        		params.put("${C2}",plantlists.get(2).getPlantbasemuuselevel());
        		params.put("${C3}",plantlists.get(2).getPlantbasen());
        		params.put("${C4}",plantlists.get(2).getPlantbasep());
        		params.put("${C5}",plantlists.get(2).getPlantbasek());
        		params.put("${C6}",plantlists.get(2).getPlantfertilizertype());
        		params.put("${C7}",plantlists.get(2).getPlantferusenum());
        		params.put("${C8}",plantlists.get(2).getPlantferpermuuselevel());
        		params.put("${C9}",plantlists.get(2).getPlantfermuuselevel());
        		params.put("${C10}",plantlists.get(2).getPlantpern());
        		params.put("${C11}",plantlists.get(2).getPlantperp());
        		params.put("${C12}",plantlists.get(2).getPlantperk());
        		params.put("${C13}",plantlists.get(2).getPlantmicrotype());
        		params.put("${C14}",plantlists.get(2).getPlantmicrouselevel());
        		params.put("${C15}",plantlists.get(2).getPlantmicron());
        		params.put("${C16}",plantlists.get(2).getPlantmicrop());
        		params.put("${C17}",plantlists.get(2).getPlantmicrok());
        		params.put("${C18}",plantlists.get(2).getPlantremark());


        		params.put("${Root}",stubblelists.get(0).getStubbleroot());
        		params.put("${Stem}",stubblelists.get(0).getStubblestem());
        		params.put("${Leaf}",stubblelists.get(0).getStubbleleaf());
        		params.put("${Shell}",stubblelists.get(0).getStubbleshell());
        		params.put("${Fw}",stubblelists.get(0).getStubblefreshweight());
        		params.put("${pl}",stubblelists.get(0).getStubbleplant());
        		params.put("${dry}",stubblelists.get(0).getStubbledryweight());
        		params.put("${opt}",stubblelists.get(0).getStubblemuoutput());
        		params.put("${Compost}",stubblelists.get(0).getStubblecompost());
        		params.put("${sil}",stubblelists.get(0).getStubblesilage());
        		params.put("${sha}",stubblelists.get(0).getStubbleshatter());
        		params.put("${burn}",stubblelists.get(0).getStubbleburn());
	
        XwpfTUtil x= new XwpfTUtil();
        x.replaceInPara(doc, params);
        x.replaceInTable(doc, params);
    
        //doc.getTables().get(0);
		String fileName =   System.currentTimeMillis()  + ".docx";
		File tar = new File(request.getSession().getServletContext().getRealPath("/resources/") +"/" +fileName);
		
		// 复制文件，就是复制出另一个啥都没有的文件，然后用它来存储数据，保证每个人都能下载自己的word
		// 将内容写入目标文件
		OutputStream os = new FileOutputStream(request.getSession().getServletContext().getRealPath("/resources/") +"/"+ fileName);
		
		 response.setContentType("application/x-msdownload");
		 response.addHeader("Content-Disposition", "attachment; filename*=utf-8'zh_cn'"+fileName);
		 ByteArrayOutputStream ostream = new ByteArrayOutputStream();
         ServletOutputStream servletOS = response.getOutputStream();
         doc.write(ostream);
         servletOS.write(ostream.toByteArray());
         servletOS.flush();
         servletOS.close();
         doc.write(os);
         os.close();
		
         is.close();
		
	}
	

}
