/**
 * Onvif��SOAP��Ӧ������Content-Length����
 * ������ƣ�
 * 	1��ʹ�ù�������������/onvif��url
 *  2��ʹ��HttpServletResponseWrapper��ԭʼ��response���з�װ��
 *  3��Ȼ��ʹ�÷�װ���response���󴫵ݸ�������filter���д���
 *  4������󣬽����ݺͳ�������ԭʼ��resposne��Ӧ��
 */
package com.ylsk.onvif.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author gsj
 * 
 */
public class OnvifResponseWrapper extends HttpServletResponseWrapper
{
	/**
	 * �����Լ������writer�����ڽ��մ����������
	 */
	private StringWriter output;
	
	/**
	 * �Զ���������
	 */
	OnvifServletOutputStream sos;
	
	/**
	 * ���͵�װ����ģʽ
	 * 
	 * @param response
	 * @throws FileNotFoundException 
	 */
	public OnvifResponseWrapper(HttpServletResponse response) throws FileNotFoundException
	{
		super(response);
		
		// ʵ�����Լ������ݽ��ն���
		output = new StringWriter();
		
	}

	//-------------------------------------------------------------------------
	/**
	 * ����1
	 */
	@Override
	public PrintWriter getWriter()
	{
		// ��servlet��jsp���������ʱ����������������response�е�writer,���Ǹ��������Լ������writer
		System.out.println("1-OnvifResponseWrapper.getWriter");
		return new PrintWriter(output);
	}

	
	/**
	 * ����2
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException
	{
		System.out.println("2-OnvifResponseWrapper.getOutputStream");
		//return super.getOutputStream();
		//return this.fileOutputStream;
		//ServletOutputStream sos;
		sos = new OnvifServletOutputStream();
		return sos;
	}

	/**
	 * ����3
	 */
	@Override
	public ServletResponse getResponse()
	{
		System.out.println("3-OnvifResponseWrapper.getResponse");
		return super.getResponse();
	}

	//-------------------------------------------------------------------------
	
	/**
	 * 
	 * �������е����ݣ�������ʲô�������ԡ�
	 * 
	 * @return
	 */
	public String getResult()
	{
		if(output.toString().length() > 0)
		{
			return output.toString();
		}
		else
		{
			int cl = this.sos.getContentLength();
			if(cl > 0)
			{
				return this.sos.getResult();
			}
			return "";
		}
	}
}
