package com.bitcamp.openp.customview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bitcamp.openp.model.Member;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

@Component(value = "memberlistPDF")
public class MemberListPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Member> memberlist = (List<Member>) model.get("memberlist");

		BaseFont bfKorean = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		
		Font font = new Font(bfKorean);

		Paragraph p = new Paragraph("회원리스트",font);

		// 테이블의 사이즈 정의 ( 열/칸, 행 )
		Table table = new Table(2, memberlist.size() + 1);
		table.setPadding(5);
		Cell cell = new Cell(new Paragraph("이메일",font));
		cell.setHeader(true);
		table.addCell(cell);
		cell = new Cell(new Paragraph("이름", font));
		table.addCell(cell);
		table.endHeaders();
		for (Member member : memberlist) {
			table.addCell(member.getEmail());
			table.addCell(member.getName());
		}
		
		document.add(p);
		document.add(table);

	}
	
	
	
	
	
	

}
