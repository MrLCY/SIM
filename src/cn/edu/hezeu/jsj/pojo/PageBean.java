package cn.edu.hezeu.jsj.pojo;

import java.util.List;

public class PageBean<T> {

	private int currentPage;//当前�?
	private int totalPage;//总页�?
	private int pageSize=10;//每页的记录数
	private int totalSize;//总的记录�?
	private List<T> list;//�?��的集�?
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int currentPage, int totalPage, int pageSize,
			int totalSize, List<T> list) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", list=" + list
				+ ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalSize=" + totalSize + "]";
	}
	
}
