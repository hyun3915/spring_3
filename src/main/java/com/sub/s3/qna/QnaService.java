package com.sub.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sub.s3.notice.NoticeDTO;
import com.sub.s3.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> qnaList(Pager pager) throws Exception{
		System.out.println("QnA List");
		
		pager.makeRow();
		
		long totalCount = qnaDAO.qnaCount(pager);
		pager.setTotalCount(totalCount);
		pager.makePage();
		return qnaDAO.qnaList(pager);
	}
	
	public int qnaWrite(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.qnaWrite(qnaDTO);
	}
	
	public int qnaUpdate(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.qnaUpdate(qnaDTO);
	}
	
	public QnaDTO qnaSelect(long num) throws Exception{
		return qnaDAO.qnaSelect(num);
	}
	
	public int qnaDelete(long num) throws Exception{
		return qnaDAO.qnaDelete(num);
	}


}
