package com.gamma.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.core.io.Resource;

import com.gamma.bean.code.NameCollectionBean;
import com.gamma.bean.table.TableConfigBean;
import com.gamma.bean.table.TableDetailBean;

public class ModelGeneratorConfig {
		
	  // 1: 整型，2:字符，3:(Long)长整型 4:double型
	  private Integer idType;
	
	  private String  beanPackage;
	   
	  private String  mapperPackage;
	
	  private String  modelPackage;
	  
	  private String  xmlPackage;
	  
	  private String  pageCss;
	  
	  private String path;
	  
	  private String  besePackage;
	  
	  private Boolean isBaseBean;
	  
	  private Boolean isBaseModel;
	  
	  private NameCollectionBean nameBean;
	  
	  //压缩后的文件地址
	  private String zipFileName;
	  
	public ModelGeneratorConfig(TableConfigBean bean){
		this.setBesePackage(bean.getBesePackage());
		this.setBeanPackage(bean.getBeanPackage());
		this.setMapperPackage(bean.getMapperPackage());
		this.setModelPackage(bean.getModelPackage());
		this.setPath(bean.getPath());
		this.setXmlPackage(bean.getXmlPackage());
		this.setPageCss(bean.getPageCss());
		this.setIsBaseBean(bean.getIsBaseBean());
		this.setIsBaseModel(bean.getIsBaseModel());
	}

	public void mkdir() {
		String filePathName = new DateTime().toString("yyyymmddHHmmss");
		String filePath = this.getPath()+"\\"+filePathName;
		
		File folder = new File(filePath);
		if(!folder.exists()){
			folder.mkdir();
		}
		
		this.setZipFileName(this.getPath()+"\\"+filePathName+".zip");
		this.setPath(filePath);
		
	}
	
	
	
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



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public Integer getIdType() {
		return idType;
	}



	public void setIdType(Integer idType) {
		this.idType = idType;
	}


	

	public String getBesePackage() {
		return besePackage;
	}



	public void setBesePackage(String besePackage) {
		this.besePackage = besePackage;
	}


	public NameCollectionBean getNameBean() {
		return nameBean;
	}



	public void setNameBean(NameCollectionBean nameBean) {
		this.nameBean = nameBean;
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

	public String getZipFileName() {
		return zipFileName;
	}

	public void setZipFileName(String zipFileName) {
		this.zipFileName = zipFileName;
	}

}
