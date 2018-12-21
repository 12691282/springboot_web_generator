package com.gamma.bean.table;

import java.util.Arrays;

public class TableConfigBean {
	
	  private String  besePackage;
	
	  private String  beanPackage;
	   
	  private String  mapperPackage;
	
	  private String  modelPackage;
	  
	  private String  xmlPackage;
	  
	  private String  pageCss;
	  
	  private String  path;
	  
	  private Boolean isBaseBean;
	  
	  private Boolean isBaseModel;
	  
	  private String[] tableArr;
	  
	  

	public String getBeanPackage() {
		return beanPackage;
	}

	public void setBeanPackage(String beanPackage) {
		this.beanPackage = beanPackage;
	}

	public String getMapperPackage() {
		return mapperPackage;
	}

	public void setMapperPackage(String mapperPackage) {
		this.mapperPackage = mapperPackage;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getXmlPackage() {
		return xmlPackage;
	}

	public void setXmlPackage(String xmlPackage) {
		this.xmlPackage = xmlPackage;
	}

	public String getPageCss() {
		return pageCss;
	}

	public void setPageCss(String pageCss) {
		this.pageCss = pageCss;
	}

	public String[] getTableArr() {
		return tableArr;
	}

	public void setTableArr(String[] tableArr) {
		this.tableArr = tableArr;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "TableConfigBean [beanPackage=" + beanPackage + ", mapperPackage=" + mapperPackage + ", modelPackage="
				+ modelPackage + ", xmlPackage=" + xmlPackage + ", pageCss=" + pageCss + ", tableArr="
				+ Arrays.toString(tableArr) + "]";
	}

	public String getBesePackage() {
		return besePackage;
	}

	public void setBesePackage(String besePackage) {
		this.besePackage = besePackage;
	}

	public Boolean getIsBaseBean() {
		return isBaseBean;
	}

	public void setIsBaseBean(Boolean isBaseBean) {
		this.isBaseBean = isBaseBean;
	}

	public Boolean getIsBaseModel() {
		return isBaseModel;
	}

	public void setIsBaseModel(Boolean isBaseModel) {
		this.isBaseModel = isBaseModel;
	}

	

}
