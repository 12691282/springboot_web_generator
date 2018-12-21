package com.gamma.generator.mybatis;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.gamma.bean.code.NameCollectionBean;
import com.gamma.config.ModelGeneratorConfig;
import com.gamma.tools.CommonForPageConfig;
import com.gamma.tools.ServiceCodeGeneratorUtil;


/**
 * controller 生成
 * @param config
 * @throws IOException
 */
public class GeneratorToControllerHelper {
	
	
	public static void outputController( ModelGeneratorConfig config) throws IOException {
		NameCollectionBean nameBean = config.getNameBean();
		String serviceObj = nameBean.getLowerHeadWordClassName()+"Service";
		String pageAddr = config.getBesePackage() + ".controller."+nameBean.getLowerHeadWordClassName();
		String fileAddr = config.getPath()+"/"+pageAddr.replace(".","/")+"/";
		
		File filePath = new File(fileAddr);
		if(!filePath.exists()){
			filePath.mkdirs();
		}
		
		File controllerFile = new File(fileAddr,nameBean.getControllerName()+".java");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(controllerFile)));
		bw.write("package " + pageAddr+";");
		bw.newLine();
		bw.newLine();
		
		bw.write("import java.util.Map;");
		bw.newLine();
		bw.newLine();
		bw.write("import "+config.getBeanPackage()+"."+nameBean.getLowerHeadWordClassName()+"."+nameBean.getBeanName()+";");
		bw.newLine();
		bw.write("import "+config.getBesePackage()+".service."+nameBean.getLowerHeadWordClassName()+"."+nameBean.getServiceName()+";");
		bw.newLine();
		bw.write("import com.github.pagehelper.PageInfo;");
		bw.newLine();
		bw.write("import "+config.getBesePackage()+".base.BaseController;");
		bw.newLine();
		bw.newLine();
		bw.write("import org.springframework.beans.factory.annotation.Autowired;");
		bw.newLine();
		bw.write("import org.springframework.stereotype.Controller;");
		bw.newLine();
		bw.write("import org.springframework.web.bind.annotation.RequestMapping;");
		bw.newLine();
		bw.write("import org.springframework.web.bind.annotation.ResponseBody;");
		bw.newLine();
		bw.write("import org.springframework.ui.Model;");
		bw.newLine();
		ServiceCodeGeneratorUtil.outputAuthor(bw,nameBean.getClazzName()+" Controller");
		bw.newLine();
		bw.write("@Controller");
		bw.newLine();
		bw.write("@RequestMapping(\""+nameBean.getLowerHeadWordClassName()+"\")");
		bw.newLine();
		bw.write("public class "+nameBean.getControllerName()+" extends BaseController{");
		bw.newLine();
		bw.write("\t/**service服务类**/");
		bw.newLine();
		bw.write("\t@Autowired");
		bw.newLine();
		bw.write("\tprivate "+nameBean.getServiceName() + " " + serviceObj+";");
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.write("\t/**列表**/");
		bw.newLine();
		bw.write("\t@RequestMapping(\""+CommonForPageConfig.LIST_METHOD_URL+"\")");
		bw.newLine();
		bw.write("\tpublic String get"+nameBean.getClazzName()+"List(Model model,"+nameBean.getBeanName()+" bean){");
		bw.newLine();
		bw.write("\t\tbean."+nameBean.getBeanPrepareDataMethodName()+"();");
		bw.newLine();
		bw.write("\t\tPageInfo pageInfo = " + serviceObj+"."+nameBean.getListMethodName()+"(bean);");
		bw.newLine();
		bw.write("\t\tmodel.addAttribute(\""+CommonForPageConfig.DATA_PAGE_OBJECT_NAME+"\", pageInfo); "); 
		bw.newLine();
		bw.write("\t\tmodel.addAttribute(\""+CommonForPageConfig.QUERY_PAGE_OBJECT_NAME+"\", bean); "); 
		bw.newLine();
		bw.write("\t\treturn \"/"+nameBean.getLowerHeadWordClassName()+"/"+CommonForPageConfig.LIST_PAGE_NAME+"\";");
		bw.newLine();
		bw.write("\t}");
		
		
		bw.newLine();
		bw.newLine();
		bw.write("\t/**根据id获取对象**/");
		bw.newLine();
		bw.write("\t@RequestMapping(\""+CommonForPageConfig.GET_BEANMETHOD_URL+"\")");
		bw.newLine();
		bw.write("\tpublic String get"+nameBean.getBeanName()+"ById(Model model,"+nameBean.getBeanName()+" bean){");
		bw.newLine();
		bw.write("\t\tif(bean.getId() != null){");
		bw.newLine();
		bw.write("\t\t\tbean = "+serviceObj+"."+nameBean.getGetBeanMethodName()+"(bean);");
		bw.newLine();
		bw.write("\t\t}");
		bw.newLine();
		bw.write("\t\tmodel.addAttribute(\""+nameBean.getLowerHeadWordClassName()+"\", bean); "); 
		bw.newLine();
		bw.write("\t\t"+"return \"/"+nameBean.getLowerHeadWordClassName()+"/"+CommonForPageConfig.INFO_PAGE_NAME+"\";");
		bw.newLine();
		bw.write("\t}");
		
		bw.newLine();
		bw.newLine();
		bw.write("\t/***新增 或修改**/");
		bw.newLine();
		bw.write("\t@RequestMapping(\""+CommonForPageConfig.ADD_OR_MODIFY_METHOD_URL+"\")");
		bw.newLine();
		bw.write("\t@ResponseBody()");
		bw.newLine();
		bw.write("\tpublic Map add"+nameBean.getBeanName()+"("+nameBean.getBeanName()+" bean){");
		bw.newLine();
		bw.write("\t\ttry{");
		bw.newLine();
		bw.newLine();
		bw.write("\t\tbean."+nameBean.getBeanPrepareDataMethodName()+"();");
		bw.newLine();
		bw.write("\t\t\t"+serviceObj+"."+nameBean.getAddOrModifyMethodName()+"(bean);");
		bw.newLine();
		bw.newLine();
		bw.write("\t\t}catch(Exception e){");
		bw.newLine();
		bw.write("\t\t\treturn super.getFailureInfo();");
		bw.newLine();
		bw.write("\t\t}");
		bw.newLine();
		bw.write("\t\treturn super.getSuccessInfo();");
		bw.newLine();
		bw.write("\t}");
		
		bw.newLine();
		bw.newLine();
		bw.write("\t/**删除**/");
		bw.newLine();
		bw.write("\t@RequestMapping(\""+CommonForPageConfig.DELETE_METHOD_URL+"\")");
		bw.newLine();
		bw.write("\t@ResponseBody()");
		bw.newLine();
		bw.write("\tpublic Map delete"+nameBean.getBeanName()+"("+nameBean.getBeanName()+" bean){");
		bw.newLine();
		bw.write("\t\ttry{");
		bw.newLine();
		bw.newLine();
		bw.write("\t\t\t"+serviceObj+"."+nameBean.getDeleteMethodName()+"(bean);");
		bw.newLine();
		bw.newLine();
		bw.write("\t\t}catch(Exception e){");
		bw.newLine();
		bw.write("\t\t\treturn super.getFailureInfo();");
		bw.newLine();
		bw.write("\t\t}");
		bw.newLine();
		bw.write("\t\treturn super.getSuccessInfo();");
		bw.newLine();
		bw.write("\t}");
		
		bw.newLine();
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.flush();
		bw.close();
		
	}

}
