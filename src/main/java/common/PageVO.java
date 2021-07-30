package common;

public class PageVO {
	private int totalList 				/* 총 목록수 */
				, totalPage				/* 총 페이지 수 */
				, totalBlock			/* 총 블럭수 */
				, pageList = 10			/* 페이지당 보여질 목록 수 */
				,blockPage = 10			/* 블럭당 보여질 페이지 수 */
				,endList, beginList		/* 한 페이지에 보여질 시작/끝 글번호 */		
				, curPage, curBlock		/* 현재페이지 번호 / 현재 블럭 번호 */
				, beginPage, endPage;	/* 한 블럭에 보여질 시작/끝 페이지 번호*/
	
	private String search, keyword;
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getTotalList() {
		return totalList;
	}

	
	public void setTotalList(int totalList) {
		this.totalList = totalList;
		
		//총페이지수 = 총목록수 / 페이지당 보여질 목록수 : 768/10 = 76...8
		totalPage = totalList / pageList;
		//나머지 발생시 처리
		if(totalList % pageList > 0) ++totalPage;
		
		//총블럭수 = 총페이지 수 / 블럭당 보여질 페이지 수 : 77/10=7...7
		totalBlock = totalPage / blockPage;
		//나머지 발생시 처리
		if(totalPage % blockPage > 0 ) ++totalBlock;
		
		//각 페이지에 보여질 목록번호
		//끝 목록번호 = 총목록수 - (현재 페이지번호-1) * 페이지당 보여질 목록수
		endList = totalList - (curPage-1) * pageList;
		//시작 목록번호 = 끝 목록번호 - (페이지당 보여질 목록수 -1);
		beginList = endList - (pageList-1);
		
		//각 블럭에 보여질 페이지 번호
		//현재블럭번호 = 현재페이지 번호 / 블럭당 보여질 페이지수
		curBlock = curPage / blockPage;
		if(curPage % blockPage > 0) ++curBlock;
		//끝 페이지번호 = 현재블럭번호 * 블럭당 보여질 페이지 수
		endPage = curBlock * blockPage;
		//시작 페이지 번호 = 끝 페이지번호 -(블럭당 보여질 페이지 수 -1)
		beginPage = endPage - (blockPage -1 );
		
		//끝 페이지번호가 총페이지 수보다 크면
		//총 페이지수를 끝 페이지 번호로 한다.
		if(endPage > totalPage) endPage = totalPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getPageList() {
		return pageList;
	}

	public void setPageList(int pageList) {
		this.pageList = pageList;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getEndList() {
		return endList;
	}

	public void setEndList(int endList) {
		this.endList = endList;
	}

	public int getBeginList() {
		return beginList;
	}

	public void setBeginList(int beginList) {
		this.beginList = beginList;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
}
