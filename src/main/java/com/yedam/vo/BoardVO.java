package com.yedam.vo;

import java.util.Date;
<<<<<<< HEAD

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int viewCnt;
	private String img;

=======
// lombok을 활용.

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO { // tbl_board
	private int boardNo; // board_no
	// title.....view_cnt
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int viewCnt;
	
	
	
	
	
	
	
>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
}
