/*  
 * An interceptor to delete the file after streaming .
 */

package com.exp.rizvi.filepack
import java.io.File;
import org.apache.struts2.StrutsStatics;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class FilePackDeleteInterceptor extends AbstractInterceptor implements StrutsStatics {

  private static final long serialVersionUID = -2323007806200438400L;

	public void init () {
		//left empty
	}

	public void destroy () {}

	public String intercept (ActionInvocation invocation) throws Exception {
		String result =  invocation.invoke();
		String fileName = invocation.getInvocationContext().getValueStack().findValue("fileQueryName").toString();
		//Do File delete
		deleteFile(fileName);
		return result;
	}
	
	/*
	 * delete file
	 */
	private void deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile()){
			if(file.delete()){
				// file deleted
			} else {
				// file not deleted to due to any problem
			}
		}
	}
}
