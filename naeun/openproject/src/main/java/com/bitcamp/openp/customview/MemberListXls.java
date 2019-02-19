package com.bitcamp.openp.customview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.bitcamp.openp.model.Member;

@Component(value="memberlistXLS")
@SuppressWarnings("deprecation")
public class MemberListXls
	extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			HSSFWorkbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 1. 시트 만들기			
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "회원리스트");
		sheet.setColumnWidth(1, 256*20);
		
		// 2. 라벨 만들기
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("이메일");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("이름");
		
		// 3. 행의 셀 만들기
		// LIST 원본 가져오기
		List<Member> memberlist = (List<Member>) model.get("memberlist");
		
		int rowNum = 1; // 첫번째 행은 라벨 처리를 했음.
		
		for(Member member : memberlist) {
			
			// 행 만들기
			HSSFRow row = sheet.createRow(rowNum);
			
			// 순위 셀 
			HSSFCell c = row.createCell(0);
			c.setCellValue(member.getEmail());
			
			// 페이지 셀
			c = row.createCell(1);
			c.setCellValue(member.getName());
			
			rowNum++;
			
			
		}
		
	}

	
	
}
