package com.ylsk.onvif.client;

import javax.xml.ws.BindingProvider;

import org.onvif.ver10.device.wsdl.Device;
import org.onvif.ver10.device.wsdl.DeviceService;
import org.onvif.ver10.schema.SystemDateTime;

public class OnvifClientTeser {

	public static void main(String[] args) {

		// ��֤���� 0-NONE��1-�û������룬2-DIGIST
		int flag = 1;
		
		// Ŀ�����
		String S_URL = "http://localhost:8080/onvif/device_service?wsdl";
		String username = "adminonvif";
		String password = "adminonvif";
		
		// ����˿ڻ�ȡ
		DeviceService deviceService;
		deviceService = new DeviceService();
		Device device;
		device = deviceService.getDevicePort();
		
		// �޸İ�
		if(flag == 1)
		{
			BindingProvider bp = (BindingProvider) device;  
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,username);  
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,password);  
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,S_URL);  
		}
		
        // ���÷���
		SystemDateTime dt;
		dt = device.getSystemDateAndTime();
		System.out.println("�豸ϵͳʱ�䣺" + dt.toString());
		String dtstr;
		dtstr = dt.getUTCDateTime().getDate().getYear()+"-"
				+dt.getUTCDateTime().getDate().getMonth()+"-"
				+dt.getUTCDateTime().getDate().getDay()+" "
				+dt.getUTCDateTime().getTime().getHour()+":"
				+dt.getUTCDateTime().getTime().getMinute()+":"
				+dt.getUTCDateTime().getTime().getSecond();
		System.out.println(dtstr);
	}
}
