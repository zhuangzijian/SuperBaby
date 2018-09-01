package com.pd.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pd.domain.AllLxxnjcVo;
import com.pd.domain.LxxnjcReport;
/**
 * @author wangzheng
 *
 *2017-11-06 20:55
 *这是最新工具类，在更新文档目录方面做了修改
 */
public class WordUtils {

	static CustomXWPFDocument lxTableDoc;
	static XWPFTable lxxnjcFirstTable1;
	static XWPFTable lxxnjcFirstTable2;
	static XWPFTable lxxnjcSecondTable1;
	static XWPFTable lxxnjcSecondTable2;
	static HttpServletRequest req;
	static int lxxnjcTableNum;// 力学性能检测表格排在第几个

	/**
	 * 用一个docx文档作为模板，然后替换其中的内容，再写入目标文档中。 ===================
	 * 改良版本======================================
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static synchronized String testTemplateWrite(Map<String, Object> params, HttpServletRequest mreq)
			throws Exception {
		req = mreq;
		/*
		 * ===========================================================
		 * ===================== 如果请求的是原始记录word===================
		 * ===========================================================
		 */
		if ((params.get("reportType") + "").equals("0")) {
			// 加载原始记录模板
			String filePath = req.getRealPath("/resources/ysjlTemplate.docx");
			InputStream is = new FileInputStream(filePath);
			CustomXWPFDocument doc = new CustomXWPFDocument(is);
			// 加载力学性能检测模板表格
			String filePath1 = req.getRealPath("/resources/lxxnjcTable.docx");
			InputStream isT = new FileInputStream(filePath1);
			lxTableDoc = new CustomXWPFDocument(isT);
			lxxnjcFirstTable1 = lxTableDoc.getTables().get(0);
			lxxnjcFirstTable2 = lxTableDoc.getTables().get(1);
			lxxnjcSecondTable1 = lxTableDoc.getTables().get(2);
			lxxnjcSecondTable2 = lxTableDoc.getTables().get(3);
			// 封装一部分
			if (params == null) {
				params = new HashMap<>();
			} else {
				String mblx = params.get("${mblx}") + "";
				if (mblx.equals("G")) {
					params.put("${wgbbzxlf}", "不应");
					params.put("${wgbbhxlf}", "≤0.05");
					params.put("${gzyqgjgjjlqjj}", "≤500");
				} else if (mblx.equals("Y")) {
					params.put("${wgbbzxlf}", "不应");
					params.put("${wgbbhxlf}", "不应");
					params.put("${gzyqgjgjjlqjj}", "≤1000");
				} else if (mblx.equals("BY")) {
					params.put("${wgbbzxlf}", "不应");
					params.put("${wgbbhxlf}", "不应");
					params.put("${gzyqgjgjjlqjj}", "≤1000");
				}
				params.put("${poleType1}", params.get("${poleType}"));
				params.put("${specifications1}", params.get("${specifications}"));
				params.put("${inspectedUnit1}", params.get("${inspectedUnit}"));
				params.put("${productionUnit1}", params.get("${productionUnit}"));
			}

			// 替换段落里面的变量
			replaceInPara(doc, params);
			// 替换表格里面的变量
			replaceInTable(doc, params);
			// 替换页眉里面的变量
			replaceInHeader(doc, params);
			// 将有检测数据的word写入一个新的docx文件
			String mblx = params.get("${mblx}") == null ? "wzlx" : "" + params.get("${mblx}");// 类型
			File src = new File(req.getRealPath("/resources/result.docx"));//
			// 拿到初始文件（一个啥都没有的文件）
			String time = System.currentTimeMillis() + "";
			String fileName = mblx + "_ysjl" + time + ".docx";
			File tar = new File(req.getRealPath("/resources/") + fileName);
			FileUtils.copyFile(src, tar);//
			// 复制文件，就是复制出另一个啥都没有的文件，然后用它来存储数据，保证每个人都能下载自己的word
			// 将内容写入目标文件
			OutputStream os = new FileOutputStream(req.getRealPath("/resources/" + fileName));
			doc.write(os);
			close(os);
			close(isT);
			close(is);
			return fileName;

			/*
			 * ===========================================================
			 * ==============如果请求的是检测报告word===========================
			 * ===========================================================
			 */
		} else if ((params.get("reportType") + "").equals("1")) {
			// 先根据后台传的buhegeStr和hegeStr生成一下检验结论
			String jyjl = "该电杆产品";
			if (hasData(params.get("hegeStr") + "")) {
				jyjl = jyjl + params.get("hegeStr") + "符合标准要求。";
			}
			if (hasData(params.get("buhegeStr") + "")) {
				jyjl = jyjl + params.get("buhegeStr") + "不符合标准要求。";
			}
			params.put("${project}", jyjl);
			// 加载检测报告模板
			String filePath = req.getRealPath("/resources/jcbgTemplate.docx");
			InputStream is = new FileInputStream(filePath);
			CustomXWPFDocument doc = new CustomXWPFDocument(is);
			lxxnjcTableNum = -1;// 设置默认值为-1，相当于没有力学性能检测表格
			// 加载检测报告模板表格
			String tableWordPath = "";
			// ================钢筋混凝土============================================
			if ((params.get("reportWordType") + "").equals("0")) {
				tableWordPath = req.getRealPath("/resources/gjhntTable.docx");
				InputStream isT = new FileInputStream(tableWordPath);
				CustomXWPFDocument jcbgTableDoc = new CustomXWPFDocument(isT);
				// 像原始模板文件中放入带标签的表格、段落等
				setTablesAndDatas(doc, jcbgTableDoc, params);
				// =====写入临时模板文件======
				// 生成目标文件
				File src = new File(req.getRealPath("/resources/result.docx"));// 拿到初始文件（一个啥都没有的文件）
				String time = System.currentTimeMillis() + "";
				String tempfileName = "G_jcbg" + time + "temp.docx";
				File tar = new File(req.getRealPath("/resources/") + tempfileName);
				FileUtils.copyFile(src, tar);// 复制文件，就是复制出另一个啥都没有的文件，然后用它来存储数据，保证每个人都能下载自己的word
				// 将内容写入目标文件
				OutputStream os = new FileOutputStream(req.getRealPath("/resources/" + tempfileName));
				doc.write(os);
				close(os);
				close(isT);
				close(is);

				String resultFileName = generateResultJcbgWordByTempTemplateWord(tempfileName, params);
				return resultFileName;
				// ==============预应力混凝土=========================================
			} else if ((params.get("reportWordType") + "").equals("1")) {
				// =======构造中间word，只有替换符的word=====start=========
				tableWordPath = req.getRealPath("/resources/yylhntTable.docx");
				InputStream isT = new FileInputStream(tableWordPath);
				CustomXWPFDocument jcbgTableDoc = new CustomXWPFDocument(isT);
				setTablesAndDatas(doc, jcbgTableDoc, params);
				// =====写入临时模板文件======
				// 生成目标文件
				File src = new File(req.getRealPath("/resources/result.docx"));// 拿到初始文件（一个啥都没有的文件）
				String time = System.currentTimeMillis() + "";
				String tempfileName = "Y_jcbg" + time + "temp.docx";
				File tar = new File(req.getRealPath("/resources/") + tempfileName);
				FileUtils.copyFile(src, tar);// 复制文件，就是复制出另一个啥都没有的文件，然后用它来存储数据，保证每个人都能下载自己的word
				// 将内容写入目标文件
				OutputStream os = new FileOutputStream(req.getRealPath("/resources/" + tempfileName));
				doc.write(os);
				close(os);
				close(isT);
				close(is);
				// =========构造中间word，只有替换符的word=====end================
				String resultFileName = generateResultJcbgWordByTempTemplateWord(tempfileName, params);
				return resultFileName;
				// ===============部分预应力混凝土=================================
			} else if ((params.get("reportWordType") + "").equals("2")) {
				tableWordPath = req.getRealPath("/resources/bfyylhntTable.docx");
				InputStream isT = new FileInputStream(tableWordPath);
				CustomXWPFDocument jcbgTableDoc = new CustomXWPFDocument(isT);
				setTablesAndDatas(doc, jcbgTableDoc, params);
				// =====写入临时模板文件======
				// 生成目标文件
				File src = new File(req.getRealPath("/resources/result.docx"));// 拿到初始文件（一个啥都没有的文件）
				String time = System.currentTimeMillis() + "";
				String tempfileName = "BY_jcbg" + time + "temp.docx";
				File tar = new File(req.getRealPath("/resources/") + tempfileName);
				FileUtils.copyFile(src, tar);// 复制文件，就是复制出另一个啥都没有的文件，然后用它来存储数据，保证每个人都能下载自己的word
				// 将内容写入目标文件
				OutputStream os = new FileOutputStream(req.getRealPath("/resources/" + tempfileName));
				doc.write(os);
				close(os);
				close(isT);
				close(is);
				String resultFileName = generateResultJcbgWordByTempTemplateWord(tempfileName, params);
				return resultFileName;
			} else {
				close(is);
				return null;
			}

		} else {
			return null;
		}

	}

	/**
	 * 拿到检测报告的临时模板文件，将文件中的替换符都替换成params中的数据
	 * 
	 * @param tempfileName
	 *            得到的模板文件的文件名
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private static String generateResultJcbgWordByTempTemplateWord(String tempfileName, Map<String, Object> params) {
		// =====放置值之后写入真正的word====
		// 首先拿到上面构造好的临时模板word（tempfileName）并加载
		try {
			String tempfilePath = req.getRealPath("/resources/" + tempfileName);
			InputStream tempis = new FileInputStream(tempfilePath);
			CustomXWPFDocument tempdoc = new CustomXWPFDocument(tempis);
			// ========开始操作临时模板文件。。。。。
			// 首先给力学性能检测表格放置数据
			if (lxxnjcTableNum != -1) {
				System.out.println("开始操作结果word序号" + lxxnjcTableNum);
				setDataForLxxnjcTables(tempdoc, params);
			}
			// 然后在目录位置放个标记
//			generateTOC(tempdoc);
			// 然后替换段落（非表格）中的数据
			replaceInPara(tempdoc, params);
			// 然后替换表格数据
			replaceInTable(tempdoc, params);
			// 然后替换页眉数据
			replaceInHeader(tempdoc, params);
			// 最后更新文档结构
//			tempdoc.enforceUpdateFields();
			// 操作完成后保存到新的word文件，名字和模板文件只有"temp"几个字的差别
			String fileName = tempfileName.replace("temp", "");
			File src1 = new File(req.getRealPath("/resources/result.docx"));// 拿到初始文件（一个啥都没有的文件）
			File tar1 = new File(req.getRealPath("/resources/") + fileName);
			FileUtils.copyFile(src1, tar1);// 复制文件，就是复制出另一个啥都没有的文件，然后用它来存储数据，保证每个人都能下载自己的word
			// 将内容写入目标文件
			OutputStream ros = new FileOutputStream(req.getRealPath("/resources/" + fileName));
			tempdoc.write(ros);
			close(ros);
			close(tempis);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 在指定位置放目录标记
	 * 
	 * @param document
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void generateTOC(XWPFDocument document)
			throws InvalidFormatException, FileNotFoundException, IOException {
		String findText = "${TOC}";
		String replaceText = "";
		for (XWPFParagraph p : document.getParagraphs()) {
			for (XWPFRun r : p.getRuns()) {
				int pos = r.getTextPosition();
				String text = r.getText(pos);
				if (text != null && text.contains(findText)) {
					text = text.replace(findText, replaceText);
					r.setText(text, 0);
					addField(p, "TOC \\o \"1-3\" \\h \\z \\u");
					break;
				}
			}
		}
	}

	private static void addField(XWPFParagraph paragraph, String fieldName) {
		CTSimpleField ctSimpleField = paragraph.getCTP().addNewFldSimple();
		// ctSimpleField.setInstr(fieldName + " \\* MERGEFORMAT ");
		ctSimpleField.setInstr(fieldName);
		ctSimpleField.addNewR().addNewT().setStringValue("<<fieldName>>");
	}

	/**
	 * 给力学性能检测的表格放值
	 * 
	 * @param tempdoc
	 *            带替换符的临时模板文件 lxxnjcTableNum 全局变量，所以不放在参数里，这里用来拿到力学性能检测表格
	 * @param params
	 *            手机端传递的参数
	 */
	private static void setDataForLxxnjcTables(CustomXWPFDocument tempdoc, Map<String, Object> params) {
		List<XWPFTable> tables = tempdoc.getTables();
		List<LxxnjcReport> allLxxnjcReportList = null;
		Gson gson = new Gson();
		String json = gson.toJson(params.get("${lxxnjcreport}"));
		System.out.println(json);
		allLxxnjcReportList = (List<LxxnjcReport>) getObjectList(json, LxxnjcReport.class);
		// 这里tables.size()-4表示力学性能检测表格的结束位置，因为力学性能检测后面可以肯定有四个表格
		// 分别是(仪器仪表，检验人员，环境，最后一页标识也是个表格)
		// allLxxnjcReportList.size()和力学性能检测表格的数量相等
		for (int i = lxxnjcTableNum, j = 0; j < allLxxnjcReportList.size(); i++, j++) {
			// 封装数据map
			LxxnjcReport lr = allLxxnjcReportList.get(j);
			Map<String, Object> lxxnparams = new HashMap<>();
			System.out.println("样品编号" + lr.getSample().getSortCode());
			lxxnparams.put("${ypbh}", lr.getSample().getSortCode());
			lxxnparams.put("${lxxnjcL2}", lr.getRule().getL2());
			lxxnparams.put("${lxxnjcL}", lr.getRule().getL());
			lxxnparams.put("${lxxnjcL1}", lr.getRule().getL1());
			lxxnparams.put("${kljywjzhgzb}", hasData(lr.getKljywjzhgzb()) ? lr.getKljywjzhgzb() : "/");
			lxxnparams.put("${kljyjyxsscz}", hasData(lr.getKljyjyxsscz()) ? lr.getKljyjyxsscz() : "/");
			lxxnparams.put("${kljywjzscz}", hasData(lr.getKljywjzscz()) ? lr.getKljywjzscz() : "/");
			lxxnparams.put("${czljywjzhgzb}", hasData(lr.getCzljywjzhgzb()) ? lr.getCzljywjzhgzb() : "/");
			lxxnparams.put("${czljyjyxsscz}", hasData(lr.getCzljyjyxsscz()) ? lr.getCzljyjyxsscz() : "/");
			lxxnparams.put("${czljywjzscz}", hasData(lr.getCzljywjzscz()) ? lr.getCzljywjzscz() : "/");
			lxxnparams.put("${ndkljywjhgzb}", hasData(lr.getNdkljywjhgzb()) ? lr.getNdkljywjhgzb() : "/");
			lxxnparams.put("${ndczljywjhgzb}", hasData(lr.getNdczljywjhgzb()) ? lr.getNdczljywjhgzb() : "/");
			lxxnparams.put("${ndkljywjscz}", hasData(lr.getNdkljywjscz()) ? lr.getNdkljywjscz() : "/");
			lxxnparams.put("${ndczljywjscz}", hasData(lr.getNdczljywjscz()) ? lr.getNdczljywjscz() : "/");
			lxxnparams.put("${lfkdkljywjhgzb}", hasData(lr.getLfkdkljywjhgzb()) ? lr.getLfkdkljywjhgzb() : "/");
			lxxnparams.put("${lfkdczljywjhgzb}", hasData(lr.getLfkdczljywjhgzb()) ? lr.getLfkdczljywjhgzb() : "/");
			lxxnparams.put("${lfkdkljywjscz}", hasData(lr.getLfkdkljywjscz()) ? lr.getLfkdkljywjscz() : "/");
			lxxnparams.put("${lfkdczljywjscz}", hasData(lr.getLfkdczljywjscz()) ? lr.getLfkdczljywjscz() : "/");
			lxxnparams.put("${kljyStr}", hasData(lr.getKljyStr()) ? lr.getKljyStr() : "/");
			lxxnparams.put("${czljyFirstStr}", hasData(lr.getCzljyFirstStr()) ? lr.getCzljyFirstStr() : "/");
			lxxnparams.put("${czljySecondStr}", hasData(lr.getCzljySecondStr()) ? lr.getCzljySecondStr() : "/");
			lxxnparams.put("${czljyThiredStr}", hasData(lr.getCzljyThiredStr()) ? lr.getCzljyThiredStr() : "/");
			lxxnparams.put("${lxxnpdjg}", hasData(lr.getDxpd()) ? lr.getDxpd() : "/");
			XWPFTable lxTable = tables.get(i);
			List<XWPFTableRow> rows = lxTable.getRows();
			for (XWPFTableRow row : rows) {
				List<XWPFTableCell> cells = row.getTableCells();
				for (XWPFTableCell tbcell : cells) {
					List<XWPFParagraph> paras = tbcell.getParagraphs();
					for (XWPFParagraph tbpara : paras) {
						replaceInTablePara(tempdoc, tbpara, lxxnparams);
					}
				}
			}
		}
	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param doc
	 *            要替换的文档
	 * @param params
	 *            参数
	 */
	private static void replaceInPara(CustomXWPFDocument doc, Map<String, Object> params) {
//		Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
//		XWPFParagraph para;
//		while (iterator.hasNext()) {
//			para = iterator.next();
//			replaceInPara(doc, para, params);
//		}
		List<XWPFParagraph> ps=doc.getParagraphs();
		for(int i=0;i<ps.size();i++){
			replaceInPara(doc, ps.get(i), params);
		}
	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param para
	 *            要替换的段落
	 * @param params
	 *            参数
	 */
	private static void replaceInPara(CustomXWPFDocument doc, XWPFParagraph para, Map<String, Object> params) {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		List<XWPFRun> runs;
		String zwf = para.getParagraphText();
		if (zwf != null && matcher(zwf).find()) {
			System.err.println("paragraph" + zwf);
			runs = para.getRuns();
			int i = 0;
			for (; i < runs.size(); i++) {
				para.removeRun(i);
				para.insertNewRun(i).setText("");
			}
			// 切割参数
			String s = zwf;
			String data = zwf;
			// 替换数据
			if (s.equals("${bjcp}") || s.equals("${cycp}") || s.equals("${bzcp}") || s.equals("${kacp}")) {
				data = data.replace(s, "");
				try {
					byte[] imgByte = null;
					if (params.get(s) != null) {
						imgByte = Base64.decodeBase64(params.get(s) + "");
						// System.out.println("===============================================>"
						// + params.get(s));
					}
					if (imgByte != null) {
						doc.addPictureData(imgByte, XWPFDocument.PICTURE_TYPE_JPEG);
						doc.createPicture(doc.getAllPictures().size() - 1, 540, 310, para);
					}
					for (XWPFRun run : runs) {
						run.removeBreak();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if (s.equals("${lxxnjc}")) {
					data = data.replace(s, "");
					List<AllLxxnjcVo> allLxxnjcVoList = null;
					Gson gson = new Gson();
					String json = gson.toJson(params.get("${lxxnjc}"));
					System.out.println(json);
					allLxxnjcVoList = (List<AllLxxnjcVo>) getObjectList(json, AllLxxnjcVo.class);
					insertLxxnjcTable(doc, para, allLxxnjcVoList);
				}else if(s.equals("${TOC}")){
					data = data.replace(s, "");
					
					String checkItem = params.get("projectStr") + "";
					insertAlignLeftRun(doc,para, "结论页");
					int currentTitleNum = 1;// 当前位于第几个标题，初始为1  
					insertAlignLeftRun(doc,para, getHzByNum(currentTitleNum)+"检验项目及检验结论一览表");
					currentTitleNum++;
					if (checkItem.contains("," + 0 + ",")) {//外观质量检测结果
						insertAlignLeftRun(doc,para, getHzByNum(currentTitleNum)+"外观质量检测结果");
						currentTitleNum++;
					}
					if (checkItem.contains("," + 2 + ",") || checkItem.contains("," + 4 + ",")) {//尺寸偏差及保护层厚度检测结果
						insertAlignLeftRun(doc,para, getHzByNum(currentTitleNum)+"外观质量检测结果");
						currentTitleNum++;
					}
					if (checkItem.contains("," + 5 + ",")) {//构造要求检测结果
						insertAlignLeftRun(doc,para, getHzByNum(currentTitleNum)+"构造要求检测结果");
						currentTitleNum++;
					}
					if (checkItem.contains("," + 3 + ",")) {// 力学性能检测结果
						insertAlignLeftRun(doc,para, getHzByNum(currentTitleNum)+"力学性能检测结果");
						currentTitleNum++;
					}
					// =========检验用仪器仪表==============================
					insertAlignLeftRun(doc,para, getHzByNum(currentTitleNum)+"检验用仪器仪表");
					currentTitleNum++;
					// ========测试环境条件========
					insertAlignLeftRun(doc,para, getHzByNum(currentTitleNum)+"测试环境条件");
					currentTitleNum++;
					// ==========检验人员================
					insertAlignLeftRun(doc,para, getHzByNum(currentTitleNum)+"检验人员");
					currentTitleNum++;
					// ===附录一：检测现场图片====
					insertAlignLeftRun(doc,para, "附录一：检测现场图片");
					currentTitleNum++;
				}else {
					// System.out.println("startrep================>");
					while (s.indexOf("${") >= 0) {
						// System.out.println("rep===");
						String jieguo = s.substring(s.indexOf("${"), s.indexOf("}") + 1);
						if (params.get(jieguo) != null && !(params.get(jieguo) + "").trim().equals("")) {
							String sNum = params.get(jieguo) + "";
							if (isNumeric(sNum)) {
								sNum = cutStr(sNum);
								data = data.replace(jieguo, sNum);
							} else {
								data = data.replace(jieguo, sNum);
							}
						} else {
							data = data.replace(jieguo, "/");
						}
						s = data;
					}
				}
			}
			// System.out.println(data);
			XWPFRun run = para.insertNewRun(0);
			run.setFontFamily("宋体");
			if ((params.get("reportType") + "").equals("0")) {
				run.setFontSize(18);
			} else {
				run.setFontSize(22);
			}

			run.setBold(true);
			run.setText(data);
		}
	}

	private static void replaceInHeader(CustomXWPFDocument doc, Map<String, Object> params) {
		List<XWPFHeader> xs = doc.getHeaderList();
		for (int i = 0; i < xs.size(); i++) {
			// List<XWPFParagraph> ps = xs.get(i).getListParagraph();
			// for (int j = 0; j < ps.size(); j++) {
			 //replaceInHeaderPara(doc, ps.get(j), params);
			// }
			List<XWPFTable> ts = xs.get(i).getTables();
			for (int j = 0; j < ts.size(); j++) {
				raplaceInHeaderTableParas(doc, ts.get(j), params);
			}
		}
	}
    /**
     * 替换页眉表格中的原始记录编号替换符,这里获取页眉中表格的cell中的所有段落，调用方法进行真正
     * 的替换
     * @param doc
     * @param table
     * @param params
     */
	private static void raplaceInHeaderTableParas(CustomXWPFDocument doc, XWPFTable table, Map<String, Object> params) {

		List<XWPFTableRow> rows = table.getRows();
		for (XWPFTableRow row : rows) {
			List<XWPFTableCell> cells = row.getTableCells();
			for (XWPFTableCell cell : cells) {
				List<XWPFParagraph> paras = cell.getParagraphs();
				for (XWPFParagraph para : paras) {
					replaceInHeaderTablePara(doc, para, params);
				}
			}
		}
	}
	/**
	 * 进行单个页眉表格中的单元格中的段落的操作
	 * @param doc
	 * @param para
	 * @param params
	 */
	private static void replaceInHeaderTablePara(CustomXWPFDocument doc,XWPFParagraph para,Map<String, Object> params){

		if (params == null) {
			params = new HashMap<String, Object>();
		}
		List<XWPFRun> runs; 
		String zwf = para.getParagraphText();
		if (zwf != null && matcher(zwf).find()) {
			System.err.println("paragraph" + zwf);
			runs = para.getRuns(); 
			int i = 0;
			for (; i < runs.size(); i++) {
				para.removeRun(i);
				para.insertNewRun(i).setText("");
			}
			// 切割参数
			String s = zwf;
			String data = zwf;
			// 替换数据
			while (s.indexOf("${") >= 0) {
				// System.out.println("rep===");
				String jieguo = s.substring(s.indexOf("${"), s.indexOf("}") + 1);
				if (params.get(jieguo) != null && !(params.get(jieguo) + "").trim().equals("")) {
					String sNum = params.get(jieguo) + "";
					if (isNumeric(sNum)) {
						sNum = cutStr(sNum);
						data = data.replace(jieguo, sNum);
					} else {
						data = data.replace(jieguo, sNum);
					}
				} else {
					data = data.replace(jieguo, "/");
				}
				s = data;
			}
			XWPFRun run = para.insertNewRun(0);
			run.setFontFamily("宋体");
			run.setFontSize(14);
			run.setText(data);
		}
	}

	/**
	 * 替换页眉中段落的变量（由于需求要求必须把页码显示在页眉上，所以此方法废弃）
	 * 本来使用此方式，是因为页码在页脚上，操作页眉的原始记录编号不会影响页码
	 * 但是把页码显示在页眉上，会受改变原始记录编码的代码的影响而导致页码混乱
	 * 现在使用表格方式显示（页眉上将编号和页码放在了两个表格cell中，隐藏了边框），
	 * 所以此方法被raplaceInHeaderTablePara方法替代！！
	 * 
	 * @param doc
	 * @param para
	 * @param params
	 */
	private static void replaceInHeaderPara(CustomXWPFDocument doc, XWPFParagraph para, Map<String, Object> params) {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		List<XWPFRun> runs;
		String zwf = para.getParagraphText();
		if (zwf != null && matcher(zwf).find()) {
			System.err.println("paragraph" + zwf);
			runs = para.getRuns();
			int i = 0;
			for (; i < runs.size(); i++) {
				para.removeRun(i);
				para.insertNewRun(i).setText("");
			}
			// 切割参数
			String s = zwf;
			String data = zwf;
			// 替换数据
			// System.out.println("startrep================>");
			while (s.indexOf("${") >= 0) {
				// System.out.println("rep===");
				String jieguo = s.substring(s.indexOf("${"), s.indexOf("}") + 1);
				if (params.get(jieguo) != null && !(params.get(jieguo) + "").trim().equals("")) {
					String sNum = params.get(jieguo) + "";
					if (isNumeric(sNum)) {
						sNum = cutStr(sNum);
						data = data.replace(jieguo, sNum);
					} else {
						data = data.replace(jieguo, sNum);
					}
				} else {
					data = data.replace(jieguo, "/");
				}
				s = data;
			}
			// System.out.println(data);
			XWPFRun run = para.insertNewRun(0);
			run.setFontFamily("宋体");
			run.setFontSize(14);
			run.setText(data);
		}
	}

	/**
	 * 替换表格中段落的变量
	 * 
	 * @param doc
	 * @param para
	 * @param params
	 */
	private static void replaceInTablePara(CustomXWPFDocument doc, XWPFParagraph para, Map<String, Object> params) {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		List<XWPFRun> runs;
		String zwf = para.getParagraphText();
		if (zwf != null && matcher(zwf).find()) {
			System.err.println("paragraph" + zwf);
			runs = para.getRuns();
			int i = 0;
			for (; i < runs.size(); i++) {
				para.removeRun(i);
				para.insertNewRun(i).setText("");
			}
			// 切割参数
			String s = zwf;
			String data = zwf;
			// 替换数据
			// System.out.println("startrep================>");
			// Boolean isWritingSampleCode = s.contains("${sampleCode}");
			boolean isWritingYsjlFirstPageTable = s.contains("${poleType1}") || s.contains("${specifications1}")
					|| s.contains("${inspectedUnit1}") || s.contains("${productionUnit1}");
			boolean isWritingProjectJgOrZzjg = s.contains("${project}") || s.contains("${zzjg}");
			while (s.indexOf("${") >= 0) {
				// System.out.println("rep===");
				String jieguo = s.substring(s.indexOf("${"), s.indexOf("}") + 1);
				if (params.get(jieguo) != null && !(params.get(jieguo) + "").trim().equals("")) {
					String sNum = params.get(jieguo) + "";
					if (isNumeric(sNum)) {
						sNum = cutStr(sNum);
						data = data.replace(jieguo, sNum);
					} else {
						data = data.replace(jieguo, sNum);
					}
				} else {
					data = data.replace(jieguo, "/");
				}
				s = data;
			}
			// System.out.println(data);
			XWPFRun run = para.insertNewRun(0);
			// if (isWritingSampleCode) {
			// run.setFontFamily("Times New Roman");
			// } else {
			// run.setFontFamily("宋体");
			// }
			// run.setFontSize(12);
			if ((params.get("reportType") + "").equals("1")) {
				run.setFontSize(9);
			}
			if (isWritingYsjlFirstPageTable) {
				run.setFontFamily("Times New Roman");
				run.setBold(true);
				run.setFontSize(16);
			}
			if (isWritingProjectJgOrZzjg) {
				run.setBold(true);
				run.setFontSize(12);
			}
			if (data.trim().equals("□")) {
				run.setFontSize(18);
			}
			run.setText(data);
		}
	}

	/**
	 * 替换表格里面的变量
	 * 
	 * @param doc
	 *            要替换的文档
	 * @param params
	 *            参数
	 */
	private static void replaceInTable(CustomXWPFDocument doc, Map<String, Object> params) {
		Iterator<XWPFTable> iterator = doc.getTablesIterator();
		XWPFTable table;
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		List<XWPFParagraph> paras;
		while (iterator.hasNext()) {
			table = iterator.next();
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					paras = cell.getParagraphs();
					for (XWPFParagraph para : paras) {
						replaceInTablePara(doc, para, params);
					}
				}
			}
		}
	}

	public static void insertLxxnjcTable(CustomXWPFDocument doc, XWPFParagraph para,
			List<AllLxxnjcVo> allLxxnjcVoList) {
		for (int i = 0; i < allLxxnjcVoList.size(); i++) {
			// ============================lxxnjc1====start===========================================
			insertLxxnjc1Tables(doc, para, allLxxnjcVoList, i);
			// ============================lxxnjc1====end===========================================
			// ============================lxxnjc2====start===========================================
			insertLxxnjc2Tables(doc, para, allLxxnjcVoList, i);
			// ============================lxxnjc2====end===========================================
		}

	}

	/**
	 * 力学性能检测一表格生成
	 * 
	 * @param doc
	 * @param para
	 * @param allLxxnjcVoList
	 */
	public static void insertLxxnjc1Tables(CustomXWPFDocument doc, XWPFParagraph para,
			List<AllLxxnjcVo> allLxxnjcVoList, int pos) {
		// 给力学性能检测第一个表插入值
		AllLxxnjcVo vo = allLxxnjcVoList.get(pos);
		replaceStringInCell(lxxnjcFirstTable1.getRow(0).getCell(2), vo.getSample().getSortCode());
		replaceStringInCell(lxxnjcFirstTable1.getRow(2).getCell(1),
				hasData(vo.getRule().getL()) ? vo.getRule().getL() : "/");
		replaceStringInCell(lxxnjcFirstTable1.getRow(2).getCell(2),
				hasData(vo.getRule().getL1()) ? vo.getRule().getL1() : "/");
		replaceStringInCell(lxxnjcFirstTable1.getRow(2).getCell(3),
				hasData(vo.getRule().getL2()) ? vo.getRule().getL2() : "/");
		replaceStringInCell(lxxnjcFirstTable1.getRow(2).getCell(4),
				hasData(vo.getRule().getP()) ? vo.getRule().getP() : "/");
		for (int j = 0; j < 8; j++) {
			if (vo.getLxxnjcFristList() != null && j < vo.getLxxnjcFristList().size()) {
				replaceStringInCell(lxxnjcFirstTable1.getRow(4).getCell(1 + j),
						hasData(vo.getLxxnjcFristList().get(j).getLoadingGrade())
								? vo.getLxxnjcFristList().get(j).getLoadingGrade() : "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(5).getCell(1 + j),
						hasData(vo.getLxxnjcFristList().get(j).getLoadingValue())
								? vo.getLxxnjcFristList().get(j).getLoadingValue() : "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(6).getCell(1 + j),
						hasData(vo.getLxxnjcFristList().get(j).getGdnd()) ? vo.getLxxnjcFristList().get(j).getGdnd()
								: "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(7).getCell(1 + j),
						hasData(vo.getLxxnjcFristList().get(j).getZzwy_A()) ? vo.getLxxnjcFristList().get(j).getZzwy_A()
								: "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(8).getCell(1 + j),
						hasData(vo.getLxxnjcFristList().get(j).getZzwy_B()) ? vo.getLxxnjcFristList().get(j).getZzwy_B()
								: "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(9).getCell(1 + j),
						hasData(vo.getLxxnjcFristList().get(j).getLfkd()) ? vo.getLxxnjcFristList().get(j).getLfkd()
								: "/");
			} else {
				replaceStringInCell(lxxnjcFirstTable1.getRow(4).getCell(1 + j), "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(5).getCell(1 + j), "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(6).getCell(1 + j), "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(7).getCell(1 + j), "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(8).getCell(1 + j), "/");
				replaceStringInCell(lxxnjcFirstTable1.getRow(9).getCell(1 + j), "/");
			}
		}
		// 首先插入力学性能检测第一个表
		XWPFRun run = para.insertNewRun(0);
		run.setText(" ");
		// doc.insertTable(13, bbTable);
		XmlCursor cursor = para.getCTP().newCursor();// this is the key!
		XWPFTable t = doc.insertNewTbl(cursor);
		XWPFTableCell cell = t.getRow(0).getCell(0);
		cell.setText("GOAL!!!");
		doc.setTable(doc.getTables().size() - 1, lxxnjcFirstTable1);
		// 插入力学性能第一次检测后边的表(如果数据大于8列)
		if (vo.getLxxnjcFristList() != null && vo.getLxxnjcFristList().size() > 8) {
			int n = vo.getLxxnjcFristList().size() / 8;
			if (vo.getLxxnjcFristList().size() % 8 > 0) {
				n++;
			}
			n--;
			for (int tn = 0; tn < n; tn++) {
				// 插入值
				XWPFTable lxxn1currentTable = doc.getTables().get(doc.getTables().size() - 1);
				for (int j = 0; j < 8; j++) {
					int itemPos = (tn + 1) * 8 + j;
					if (vo.getLxxnjcFristList() != null && itemPos < vo.getLxxnjcFristList().size()) {
						replaceStringInCell(lxxnjcFirstTable2.getRow(1).getCell(1 + j),
								hasData(vo.getLxxnjcFristList().get(itemPos).getLoadingGrade())
										? vo.getLxxnjcFristList().get(itemPos).getLoadingGrade() : "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(2).getCell(1 + j),
								hasData(vo.getLxxnjcFristList().get(itemPos).getLoadingValue())
										? vo.getLxxnjcFristList().get(itemPos).getLoadingValue() : "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(3).getCell(1 + j),
								hasData(vo.getLxxnjcFristList().get(itemPos).getGdnd())
										? vo.getLxxnjcFristList().get(itemPos).getGdnd() : "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(4).getCell(1 + j),
								hasData(vo.getLxxnjcFristList().get(itemPos).getZzwy_A())
										? vo.getLxxnjcFristList().get(itemPos).getZzwy_A() : "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(5).getCell(1 + j),
								hasData(vo.getLxxnjcFristList().get(itemPos).getZzwy_B())
										? vo.getLxxnjcFristList().get(itemPos).getZzwy_B() : "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(6).getCell(1 + j),
								hasData(vo.getLxxnjcFristList().get(itemPos).getLfkd())
										? vo.getLxxnjcFristList().get(itemPos).getLfkd() : "/");
					} else {
						replaceStringInCell(lxxnjcFirstTable2.getRow(1).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(2).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(3).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(4).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(5).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcFirstTable2.getRow(6).getCell(1 + j), "/");
					}
				}
				XWPFRun lxxn1run = para.insertNewRun(0);
				lxxn1run.setText(" ");
				// doc.insertTable(13, bbTable);
				XmlCursor lxxn1cursor = para.getCTP().newCursor();// this is the
																	// key!
				XWPFTable lxxn1t = doc.insertNewTbl(lxxn1cursor);
				XWPFTableCell lxxn1cell = lxxn1t.getRow(0).getCell(0);
				lxxn1cell.setText("GOAL!!!");
				doc.setTable(doc.getTables().size() - 1, lxxnjcFirstTable2);
			}
		}
	}

	/**
	 * 力学性能检测二表格生成
	 * 
	 * @param doc
	 * @param para
	 * @param allLxxnjcVoList
	 * @param pos
	 */
	public static void insertLxxnjc2Tables(CustomXWPFDocument doc, XWPFParagraph para,
			List<AllLxxnjcVo> allLxxnjcVoList, int pos) {
		// XWPFTable newTable=doc1.getTables().get(2);
		// lxxnjcSecondTable1=newTable;
		// 插入值
		AllLxxnjcVo vo = allLxxnjcVoList.get(pos);// pos
		XWPFTable currentTable = doc.getTables().get(doc.getTables().size() - 1);
		// 设置卸载的值
		replaceStringInCell(lxxnjcSecondTable1.getRow(1).getCell(1),
				hasData(vo.getLxxnjcOff().getLoadingGrade()) ? vo.getLxxnjcOff().getLoadingGrade() : "/");
		replaceStringInCell(lxxnjcSecondTable1.getRow(2).getCell(1),
				hasData(vo.getLxxnjcOff().getLoadingValue()) ? vo.getLxxnjcOff().getLoadingValue() : "/");
		replaceStringInCell(lxxnjcSecondTable1.getRow(3).getCell(1),
				hasData(vo.getLxxnjcOff().getGdnd()) ? vo.getLxxnjcOff().getGdnd() : "/");
		replaceStringInCell(lxxnjcSecondTable1.getRow(4).getCell(1),
				hasData(vo.getLxxnjcOff().getZzwy_A()) ? vo.getLxxnjcOff().getZzwy_A() : "/");
		replaceStringInCell(lxxnjcSecondTable1.getRow(5).getCell(1),
				hasData(vo.getLxxnjcOff().getZzwy_B()) ? vo.getLxxnjcOff().getZzwy_B() : "/");
		replaceStringInCell(lxxnjcSecondTable1.getRow(6).getCell(1),
				hasData(vo.getLxxnjcOff().getLfkd()) ? vo.getLxxnjcOff().getLfkd() : "/");
		for (int j = 0; j < 7; j++) {
			if (vo.getLxxnjcSecondList() != null && j < vo.getLxxnjcSecondList().size()) {
				replaceStringInCell(lxxnjcSecondTable1.getRow(1).getCell(2 + j),
						hasData(vo.getLxxnjcSecondList().get(j).getLoadingGrade())
								? vo.getLxxnjcSecondList().get(j).getLoadingGrade() : "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(2).getCell(2 + j),
						hasData(vo.getLxxnjcSecondList().get(j).getLoadingValue())
								? vo.getLxxnjcSecondList().get(j).getLoadingValue() : "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(3).getCell(2 + j),
						hasData(vo.getLxxnjcSecondList().get(j).getGdnd()) ? vo.getLxxnjcSecondList().get(j).getGdnd()
								: "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(4).getCell(2 + j),
						hasData(vo.getLxxnjcSecondList().get(j).getZzwy_A())
								? vo.getLxxnjcSecondList().get(j).getZzwy_A() : "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(5).getCell(2 + j),
						hasData(vo.getLxxnjcSecondList().get(j).getZzwy_B())
								? vo.getLxxnjcSecondList().get(j).getZzwy_B() : "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(6).getCell(2 + j),
						hasData(vo.getLxxnjcSecondList().get(j).getLfkd()) ? vo.getLxxnjcSecondList().get(j).getLfkd()
								: "/");
			} else {
				replaceStringInCell(lxxnjcSecondTable1.getRow(1).getCell(2 + j), "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(2).getCell(2 + j), "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(3).getCell(2 + j), "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(4).getCell(2 + j), "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(5).getCell(2 + j), "/");
				replaceStringInCell(lxxnjcSecondTable1.getRow(6).getCell(2 + j), "/");
			}
		}
		// 插入力学性能检测第二次加载第一个表
		XWPFRun run = para.insertNewRun(0);
		run.setText(" ");
		// doc.insertTable(13, bbTable);
		XmlCursor cursor = para.getCTP().newCursor();// this is the key!
		XWPFTable t = doc.insertNewTbl(cursor);
		XWPFTableCell cell = t.getRow(0).getCell(0);
		cell.setText("GOAL!!!");
		doc.setTable(doc.getTables().size() - 1, lxxnjcSecondTable1);
		// 插入力学性能第er次检测后边的表(如果数据大于7列)
		if (vo.getLxxnjcSecondList() != null && vo.getLxxnjcSecondList().size() > 7) {
			int n = (vo.getLxxnjcSecondList().size() - 7) / 8;
			n++;
			if ((vo.getLxxnjcSecondList().size() - 7) % 8 > 0) {
				n++;
			}
			n--;
			for (int tn = 0; tn < n; tn++) {
				// XWPFTable newTable1=doc1.getTables().get(3);
				// lxxnjcSecondTable2=newTable1;
				// 插入值
				for (int j = 0; j < 8; j++) {
					int itemPos = tn * 8 + 7 + j;
					if (vo.getLxxnjcSecondList() != null && itemPos < vo.getLxxnjcSecondList().size()) {
						replaceStringInCell(lxxnjcSecondTable2.getRow(1).getCell(1 + j),
								hasData(vo.getLxxnjcSecondList().get(itemPos).getLoadingGrade())
										? vo.getLxxnjcSecondList().get(itemPos).getLoadingGrade() : "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(2).getCell(1 + j),
								hasData(vo.getLxxnjcSecondList().get(itemPos).getLoadingValue())
										? vo.getLxxnjcSecondList().get(itemPos).getLoadingValue() : "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(3).getCell(1 + j),
								hasData(vo.getLxxnjcSecondList().get(itemPos).getGdnd())
										? vo.getLxxnjcSecondList().get(itemPos).getGdnd() : "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(4).getCell(1 + j),
								hasData(vo.getLxxnjcSecondList().get(itemPos).getZzwy_A())
										? vo.getLxxnjcSecondList().get(itemPos).getZzwy_A() : "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(5).getCell(1 + j),
								hasData(vo.getLxxnjcSecondList().get(itemPos).getZzwy_B())
										? vo.getLxxnjcSecondList().get(itemPos).getZzwy_B() : "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(6).getCell(1 + j),
								hasData(vo.getLxxnjcSecondList().get(itemPos).getLfkd())
										? vo.getLxxnjcSecondList().get(itemPos).getLfkd() : "/");
					} else {
						replaceStringInCell(lxxnjcSecondTable2.getRow(1).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(2).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(3).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(4).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(5).getCell(1 + j), "/");
						replaceStringInCell(lxxnjcSecondTable2.getRow(6).getCell(1 + j), "/");
					}
				}
				XWPFRun lxxn2run = para.insertNewRun(0);
				lxxn2run.setText(" ");
				XmlCursor lxxn2cursor = para.getCTP().newCursor();// this is the
																	// key!
				XWPFTable lxxn2t = doc.insertNewTbl(lxxn2cursor);
				XWPFTableCell lxxn2cell = lxxn2t.getRow(0).getCell(0);
				lxxn2cell.setText("GOAL!!!");
				doc.setTable(doc.getTables().size() - 1, lxxnjcSecondTable2);
			}
		}
	}

	/**
	 * 清空单元格
	 * 
	 * @param cell
	 */
	private static void replaceStringInCell(XWPFTableCell cell, String s) {
		List<XWPFParagraph> paras = cell.getParagraphs();
		for (XWPFParagraph para : paras) {
			clearTableParaAndAddString(para, s);
		}
	}

	/**
	 * 替换表格中段落的变量
	 * 
	 * @param doc
	 * @param para
	 * @param params
	 */
	private static void clearTableParaAndAddString(XWPFParagraph para, String s) {
		List<XWPFRun> runs;
		runs = para.getRuns();
		int i = 0;
		for (; i < runs.size(); i++) {
			para.removeRun(i);
		}
		XWPFRun run = para.insertNewRun(0);
		run.setText(s);
	}

	/**
	 * 正则匹配字符串
	 * 
	 * @param str
	 * @return
	 */
	private static Matcher matcher(String str) {
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str.trim());//
		return matcher;
	}

	/**
	 * 关闭输入流
	 * 
	 * @param is
	 */
	private static void close(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭输出流
	 * 
	 * @param os
	 */
	private static void close(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将输入流中的数据写入字节数组
	 * 
	 * @param in
	 * @return
	 */
	public byte[] inputStream2ByteArray(InputStream in, boolean isClose) {
		byte[] byteArray = null;
		try {
			int total = in.available();
			byteArray = new byte[total];
			in.read(byteArray);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (isClose) {
				try {
					in.close();
				} catch (Exception e2) {
					System.out.println("关闭流失败");
				}
			}
		}
		return byteArray;
	}

	/**
	 * 根据json获取list
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> getObjectList(String jsonString, Class<T> cls) {
		List<T> list = new ArrayList<T>();
		try {
			Gson gson = new Gson();
			JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
			for (JsonElement jsonElement : arry) {
				list.add(gson.fromJson(jsonElement, cls));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 判断是否有数据
	public static Boolean hasData(String s) {
		Boolean isHas = true;
		if (s == null || s.equals("无") || s.trim().equals("")) {
			isHas = false;
		}
		return isHas;
	}

	/**
	 * 匹配是否数字
	 * 
	 * @param str
	 *            可能为中文，也可能是-19162431.1254，不使用BigDecimal的话，变成-1.91624311254E7
	 * @return
	 * @author wz
	 */
	public static boolean isNumeric(String str) {
		// 该正则表达式可以匹配所有的数字 包括负数
		Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
		String bigStr;
		try {
			bigStr = new BigDecimal(str).toString();
		} catch (Exception e) {
			return false;// 异常 说明包含非数字。
		}

		Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 去掉数字字符串无效的0
	 * 
	 * @param str
	 * @return
	 */
	public static String cutStr(String str) {
		String newStr = "";
		if (str.contains(".")) {
			newStr = str.replaceAll("0*$", "");
			if (!newStr.equals("")) {
				String laststr = newStr.substring(newStr.length() - 1, newStr.length());
				// 如果最后一个字符是“.”则去掉
				if (laststr.equals(".")) {
					newStr = newStr.substring(0, newStr.length() - 1);
				}
			}
		} else {
			newStr = str;
		}

		return newStr;
	}

	/**
	 * 向检测报告模板中插入表格和部分数据
	 * 
	 * @param doc
	 * @param tableDoc
	 * @param params
	 */
	public static void setTablesAndDatas(CustomXWPFDocument doc, CustomXWPFDocument tableDoc,
			Map<String, Object> params) {
		List<XWPFParagraph> ps = doc.getParagraphs();
		for (int i = 0; i < ps.size(); i++) {
			replaceInJcbgPara(doc, tableDoc, ps.get(i), params);
		}
	}

	/**
	 * 开始进行表格和段落的添加(在指定替换符位置替换)
	 * 
	 * @param doc
	 * @param tableDoc
	 * @param para
	 * @param params
	 */
	private static void replaceInJcbgPara(CustomXWPFDocument doc, CustomXWPFDocument tableDoc, XWPFParagraph para,
			Map<String, Object> params) {

		if (params == null) {
			params = new HashMap<String, Object>();
		}
		List<XWPFRun> runs;
		String zwf = para.getParagraphText();
		if (zwf != null && matcher(zwf).find()) {
			System.err.println("paragraph" + zwf);
			runs = para.getRuns();
			// 切割参数
			String s = zwf;
			String data = zwf;
			// 替换数据
			if (s.equals("${inserttable}")) {
				int i = 0;
				for (; i < runs.size(); i++) {
					para.removeRun(i);
					para.insertNewRun(i).setText("");
				}
				data = data.replace(s, "");
				// System.out.println("lxxnjc=================>");
				List<LxxnjcReport> allLxxnjcReportList = null;
				Gson gson = new Gson();
				String json = gson.toJson(params.get("${lxxnjcreport}"));
				allLxxnjcReportList = (List<LxxnjcReport>) getObjectList(json, LxxnjcReport.class);
				insertJcbgTables(doc, tableDoc, para, params, allLxxnjcReportList);

			}
		}

	}

	/**
	 * 插入表格和标题
	 * 
	 * @param doc
	 * @param tableDoc
	 * @param para3
	 * @param para
	 * @param params
	 * @param allLxxnjcReportList
	 */
	private static void insertJcbgTables(CustomXWPFDocument doc, CustomXWPFDocument tableDoc, XWPFParagraph para3,
			Map<String, Object> params, List<LxxnjcReport> allLxxnjcReportList) {
		String checkItem = params.get("projectStr") + "";
		int currentTitleNum = 2;// 当前位于第几个标题，初始为2
		if (checkItem.contains("," + 0 + ",")) {
			insertTitle(doc, getHzByNum(currentTitleNum) + "外观质量检测结果", currentTitleNum);
			currentTitleNum++;// 标题序号加1
			// 放置表格
			insertTable(doc, tableDoc, 0, true);
		}
		if (checkItem.contains("," + 2 + ",") || checkItem.contains("," + 4 + ",")) {
			insertTitle(doc, getHzByNum(currentTitleNum) + "尺寸偏差及保护层厚度检测结果", currentTitleNum);
			currentTitleNum++;// 标题序号加1
			// 专门放置表格的段落
			insertTable(doc, tableDoc, 1, true);
		}
		if (checkItem.contains("," + 5 + ",")) {
			insertTitle(doc, getHzByNum(currentTitleNum) + "构造要求检测结果", currentTitleNum);
			currentTitleNum++;// 标题序号加1
			// 专门放置表格的段落
			insertTable(doc, tableDoc, 2, true);
		}
		if (checkItem.contains("," + 3 + ",")) {// 力学性能检测结果
			insertTitle(doc, getHzByNum(currentTitleNum) + "力学性能检测结果", currentTitleNum);
			currentTitleNum++;// 标题序号加1
			insertJcbgLxxnTableAndSetData(doc, tableDoc, allLxxnjcReportList);
		}
		// =========检验用仪器仪表==============================
		insertTitle(doc, getHzByNum(currentTitleNum) + "检验用仪器仪表", currentTitleNum);
		currentTitleNum++;// 标题序号加1
		insertTable(doc, tableDoc, 4, false);
		// ========测试环境条件========
		insertTitle(doc, getHzByNum(currentTitleNum) + "测试环境条件", currentTitleNum);
		currentTitleNum++;// 标题序号加1
		insertTable(doc, tableDoc, 5, false);
		// ==========检验人员================
		insertTitle(doc, getHzByNum(currentTitleNum) + "检验人员", currentTitleNum);
		currentTitleNum++;// 标题序号加1
		insertTable(doc, tableDoc, 6, true);
		// ===附录一：检测现场图片====
		insertTitle(doc, "附录一：检测现场图片", currentTitleNum);
		insertCenterPara(doc, "${bjcp}");
		insertCenterPara(doc, "图1 被检产品");
		insertCenterPara(doc, "${cycp}");
		insertCenterPara(doc, "图2 抽样产品");
		// 放入最后一页的标记
		XWPFParagraph para = doc.createParagraph();
		XWPFRun run = para.insertNewRun(0);
		run.addBreak();
		run.addBreak();
		insertTable(doc, tableDoc, 7, false);
	}

	/**
	 * 插入检测报告力学性能检测表格并插入数据
	 * 
	 * @param doc
	 * @param tableDoc
	 * @param allLxxnjcReportList
	 */
	private static void insertJcbgLxxnTableAndSetData(CustomXWPFDocument doc, CustomXWPFDocument tableDoc,
			List<LxxnjcReport> allLxxnjcReportList) {
		boolean getNum = false;// 是否已经得到第一个力学性能检测表格的位置
		for (int i = 0; i < allLxxnjcReportList.size(); i++) {
			System.err.println("==========================插入一个力学性能检测报告表格================");
			if (!getNum) {
				lxxnjcTableNum = doc.getTables().size();
				getNum = true;
			}
			// 插入一个带替换符的表格
			XWPFParagraph para = doc.createParagraph();
			para.setPageBreak(true);
			XWPFRun run = para.insertNewRun(0);
			run.setText(" ");
			XmlCursor cursor = para.getCTP().newCursor();// this is the key!
			XWPFTable t = doc.insertNewTbl(cursor);
			XWPFTableCell cell = t.getRow(0).getCell(0);
			cell.setText(" ");
			doc.setTable(doc.getTables().size() - 1, tableDoc.getTables().get(3));
		}
	}

	/**
	 * 插入一个标题
	 * 
	 * @param doc
	 * @param title
	 * @param currentTitleNum 暂时不用
	 */
	public static void insertTitle(CustomXWPFDocument doc, String title, int currentTitleNum) {
		// 专门设置标题的段落
		XWPFParagraph para = doc.createParagraph();
		// 关键行// 1级大纲
		para.setStyle("1");
		XWPFRun run1 = para.createRun();
		// 标题内容
		run1.setText(title);
	}

	/**
	 * 插入tabledoc中第whichTable个表格,不加分页符
	 * 
	 * @param doc
	 *            正在操作的docx
	 * @param tableDoc
	 *            包含模板表格的docx
	 * @param whichTable
	 *            要使用第几个表格
	 * @param setPageBreak
	 *            是否放置分页符
	 */
	public static void insertTable(CustomXWPFDocument doc, CustomXWPFDocument tableDoc, int whichTable,
			boolean setPageBreak) {
		// 专门放置表格的段落
		XWPFParagraph para2 = doc.createParagraph();
		if (setPageBreak) {
			para2.setPageBreak(true);
		}
		XWPFRun run = para2.insertNewRun(0);
		run.setText(" ");
		XmlCursor cursor = para2.getCTP().newCursor();// this is the key!
		XWPFTable t = doc.insertNewTbl(cursor);
		XWPFTableCell cell = t.getRow(0).getCell(0);
		cell.setText("GOAL!!!");
		doc.setTable(doc.getTables().size() - 1, tableDoc.getTables().get(whichTable));
	}

	/**
	 * 插入一个居中的段落
	 * 
	 * @param doc
	 *            当前操作的文档
	 * @param text
	 *            要向段落放入的文本
	 */
	public static void insertCenterPara(CustomXWPFDocument doc, String text) {
		XWPFParagraph para = doc.createParagraph();
		para.setSpacingAfter(100);
		para.setSpacingBefore(100);
		para.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun run = para.createRun();
		run.setText(text);

	}
	
	/**
	 * 插入一个左对齐的run（当做目录）
	 * 
	 * @param doc
	 *            当前操作的文档
	 * @param text
	 *            要向段落放入的文本
	 */
	public static void insertAlignLeftRun(CustomXWPFDocument doc,XWPFParagraph para, String tableOfContent) {
		para.setSpacingAfter(100);
		para.setSpacingBefore(100);
		para.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run = para.createRun();
		run.setFontSize(14);
		run.addBreak();
		run.setTextPosition(40);//这个相当于设置行间距的，具体这个20是怎么算的，不清楚
		run.setText(tableOfContent);
	}

	public static String getHzByNum(int num) {
		if (num == 1) {
			return "一、";
		}else if (num == 2) {
			return "二、";
		} else if (num == 3) {
			return "三、";
		} else if (num == 4) {
			return "四、";
		} else if (num == 5) {
			return "五、";
		} else if (num == 6) {
			return "六、";
		} else if (num == 7) {
			return "七、";
		} else if (num == 8) {
			return "八、";
		} else if (num == 9) {
			return "九、";
		} else if (num == 10) {
			return "十、";
		} else if (num == 11) {
			return "十一、";
		} else if (num == 12) {
			return "十二、";
		} else {
			return null;
		}

	}

}
