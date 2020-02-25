package com.cwfkm.common.vo;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable{
	private static final long serialVersionUID = 1684876792546164773L;
	private List<T> records;
	private Integer rowCount=0;
	private Integer pageCount=0;
	private Integer pageCurrent=1;
	private Integer pageSize=10;
	public PageObject(List<T> records, Integer rowCount, Integer pageCurrent, Integer pageSize) {
		super();
		this.records = records;
		this.rowCount = rowCount;
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0)
			this.pageCount++;
//		this.pageCount=(rowCount-1)/pageSize+1;
	}
	
}
