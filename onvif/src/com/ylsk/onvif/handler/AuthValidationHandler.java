/**
 * ��֤������
 */
package com.ylsk.onvif.handler;

import java.security.NoSuchAlgorithmException;
import java.util.*;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.*;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.NodeList;

/**
 * ��֤������
 * @author gsj
 *
 */
public class AuthValidationHandler implements SOAPHandler<SOAPMessageContext>
{
	/**
	 * ��ȡͷ��Ϣ
	 */
	public Set<QName> getHeaders()
	{
		// ����null�Ļ�����������Ϣ
		System.out.println("AuthValidationHandler.getHeaders()");
		return null;
	}

	/**
	 * �ر�
	 */
	public void close(MessageContext context)
	{
		System.out.println("AuthValidationHandler.close()");
	}

	/**
	 * �������
	 */
	public boolean handleFault(SOAPMessageContext context)
	{
		System.out.println("AuthValidationHandler.handleFault()");
		return false;
	}

	/**
	 * ����in���͵���Ϣ
	 */
	public boolean handleMessage(SOAPMessageContext context)
	{
		// �Ƿ�����UsernameToken��֤��ʽ true-���ã�false-������
		boolean usernameTokenflag = false;
		usernameTokenflag = AuthrizationGlobal.getMode();
		if(!usernameTokenflag)
		{
			// ���������UsernameToken��֤ģʽ��ֱ�ӷ���true��
			return true;
		}
		// У���� in ���� out���͵�message
		Boolean outbound;
		outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// �����in���͵�message
		if (!outbound.booleanValue())
		{
			// ��ȡsoap��Ϣ
			SOAPMessage soapMessage;
			soapMessage = context.getMessage();

			int errorType = 0;
			try
			{
				System.out.println("!!--------------------------------------------------------------------------");
				// ���soapMessage������̨
				soapMessage.writeTo(System.out);
				System.out.println("\r\n!!--------------------------------------------------------------------------");
				
				SOAPEnvelope soapEnvelope;
				soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
											
				SOAPHeader soapHeader;
				soapHeader = soapEnvelope.getHeader();

				if (soapHeader == null)
				{
					//generateSoapFault(soapMessage, "No Message Header...");
					System.out.println("û��ͷ��Ϣ!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
				System.out.println("Header: \r\n" +soapHeader.getNamespaceURI());
				
				// �ı����ݿ��Դ�ӡ����
				String str = soapHeader.getTextContent();
				System.out.println("ͷ������ƣ�   " + str);
				
				NodeList nlSecurity = soapHeader.getElementsByTagName("wsse:Security");
				org.w3c.dom.Node securityNode = nlSecurity.item(0);
				
				NodeList nlUsernameToken = securityNode.getChildNodes();
				org.w3c.dom.Node usernameTokenNode = nlUsernameToken.item(0);
				
				NodeList valuesNode = usernameTokenNode.getChildNodes();
				
				Hashtable<String,String> hs = new Hashtable<String, String>();
				for(int i=0; i<valuesNode.getLength(); i++)
				{
					org.w3c.dom.Node n = valuesNode.item(i);
					String nodename = n.getNodeName();
					String nodevalue = n.getTextContent();
					hs.put(nodename, nodevalue);
					System.out.println(nodename + "=" + nodevalue);
				}
				
				// У��
				boolean ret = validateInfo(hs);
				System.out.println("У����: " + ret);
				if(ret == true)
				{
					return true;
				}
				
				errorType = 1;
			}
			catch(Exception ex)
			{
				generateSoapFault(soapMessage, "Sender not Authorized(��������-��֤���Ͳ���ȷ����ʹ��UsernameToken��ʽ��֤ ��)");
			}
			
			if(errorType == 1)
			{
				//���ɴ�����Ϣ
				generateSoapFault(soapMessage, "Sender not Authorized(�û����������)");
			}
			else
			{
				generateSoapFault(soapMessage, "Sender not Authorized(��������-δ֪���� ��)");
			}
		}
		
		return false;
	}

	/**
	 * @throws NoSuchAlgorithmException 
	 * У���û���Ϣ
	 * @param hs ��֤��Ϣ��ϣ��
	 * @return true-ͨ����֤��false-��֤ʧ��
	 * @throws ֻ֧��SHA1�㷨
	 */
	private boolean validateInfo(Hashtable<String, String> hs) throws NoSuchAlgorithmException
	{
		//String serverUsername = "adminonvif";
		//String serverPassword = "adminonvif";
		String serverUsername = AuthrizationGlobal.username;
		String serverPassword = AuthrizationGlobal.password;
		
		String clientUsername = hs.get("wsse:Username");
		String clientPasswordDigest = hs.get("wsse:Password");
		String clientNonce = hs.get("wsse:Nonce");
		String clientCreated = hs.get("wsu:Created");
		
		if(serverUsername.trim().equals(clientUsername.trim()))
		{
			System.out.println("�û���ƥ�䣡 ....������֤����......");
		
			byte[] noncebytes = Base64.decodeBase64(clientNonce);
			byte[] datebytes = clientCreated.getBytes();
			byte[] passwordbytes = serverPassword.getBytes();
			
			// 1. SHA-1����ʵ������
			java.security.MessageDigest alga=java.security.MessageDigest.getInstance("SHA-1");
			// 2. ���Ҫ���м���ժҪ����Ϣ
			alga.update(noncebytes);
			alga.update(datebytes);
			alga.update(passwordbytes);
			// 3. �����ժҪ
			byte[] digesta=alga.digest();
			// 4. B64����
			String expectdigest = Base64.encodeBase64String(digesta);
			System.out.println("����˼����������ժҪ��"+expectdigest);
			System.out.println("�ͻ��˸�����    ����ժҪ��"+clientPasswordDigest);
			
			// �Ƚ�����
			if(expectdigest.equals(clientPasswordDigest))
			{
				// ��֤���ͨ��
				return true;
			}
		}
		
		// ��֤ʧ��
		return false;
	}

	/**
	 * ��֤�û���������
	 * @param userName
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean authValidate(String userName, String password)
	{
		System.out.println("AuthValidationHandler.authValidate()");
		
		if (userName == null || password == null)
		{
			return false;
		}

		if ("admin".equals(userName) && "admin".equals(password))
		{
			return true;
		}
		
		return false;
	}

	/**
	 * ���ɴ�����Ϣ
	 * @param soapMessage
	 * @param reasion
	 */
	private void generateSoapFault(SOAPMessage soapMessage, String reasion)
	{
		System.out.println("AuthValidationHandler.generateSoapFault()");
		try
		{
//			SOAPBody soapBody = soapMessage.getSOAPBody();
//			SOAPFault soapFault = soapBody.getFault();
//
//			if (soapFault == null)
//			{
//				soapFault = soapBody.addFault();
//			}
			
			SOAPFactory soapfc = SOAPFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			SOAPFault soapFault = soapfc.createFault();
			
			soapFault.setFaultString(reasion);

			throw new SOAPFaultException(soapFault);

		}
		catch (SOAPException e)
		{
			e.printStackTrace();
		}
	}
}
