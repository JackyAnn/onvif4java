package com.ylsk.onvif.handler;

/**
 * ȫ����Ȩģʽ���ù�����
 * @author gsj
 *
 */
public class AuthrizationGlobal
{
	// ģʽ1����������֤
	@SuppressWarnings("unused")
	private static final int MODE_NONE = 0;
	// ģʽ2���û���������֤
	private static final int MODE_WS_USERNAME_TOKEN = 1;
	// ģʽ3������ժҪ��֤
	@SuppressWarnings("unused")
	private static final int MODE_DIGEST = 2;

	///////////////////////////////////////////////////////////////////////////
	// ����ģʽ��3ѡ1
	///////////////////////////////////////////////////////////////////////////
	// ��Ȩģʽ1 - ���web-NONE-temple.xmlʹ��
	//private static int authrizationMode = MODE_NONE;
	
	// ��Ȩģʽ2 - ���web-USERNAMETOKEN-temple.xmlʹ��
	private static int authrizationMode = MODE_WS_USERNAME_TOKEN;
	// ���ģʽ2ʹ��
	public static String username = "adminonvif";
	public static String password = "adminonvif";
	
	// ��Ȩģʽ3 - ���web-digest-temple.xmlʹ��
	// ע�⣬��ʱ���û���������Ҫ��tomcat�н������ã�
	//   <role rolename="onvif"/>
	//   <user username="adminonvif" password="adminonvif" roles="onvif"/>
	//private static int authrizationMode = MODE_DIGEST;
	///////////////////////////////////////////////////////////////////////////
	
	/**
	 * ��ȡ��֤ģʽ
	 * @return
	 */
	public static boolean getMode()
	{	
		return (authrizationMode == MODE_WS_USERNAME_TOKEN)?true:false;
	}
}
