package com.yedam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
<<<<<<< HEAD
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchVO {

	private int pageNo;
	private String searchCondition;
	private String keyword;
=======

@Data
@AllArgsConstructor
public class SearchVO {
	private int page;
	private String searchCondition;
	private String keyWord;
>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
}
