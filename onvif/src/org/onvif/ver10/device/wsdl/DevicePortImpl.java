package org.onvif.ver10.device.wsdl;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.onvif.ver10.schema.AttachmentData;
import org.onvif.ver10.schema.BackupFile;
import org.onvif.ver10.schema.BinaryData;
import org.onvif.ver10.schema.Capabilities;
import org.onvif.ver10.schema.CapabilityCategory;
import org.onvif.ver10.schema.Certificate;
import org.onvif.ver10.schema.CertificateInformation;
import org.onvif.ver10.schema.CertificateStatus;
import org.onvif.ver10.schema.CertificateWithPrivateKey;
import org.onvif.ver10.schema.DNSInformation;
import org.onvif.ver10.schema.Date;
import org.onvif.ver10.schema.DateTime;
import org.onvif.ver10.schema.DiscoveryMode;
import org.onvif.ver10.schema.Dot11AvailableNetworks;
import org.onvif.ver10.schema.Dot11Status;
import org.onvif.ver10.schema.Dot1XConfiguration;
import org.onvif.ver10.schema.DynamicDNSInformation;
import org.onvif.ver10.schema.DynamicDNSType;
import org.onvif.ver10.schema.FactoryDefaultType;
import org.onvif.ver10.schema.HostnameInformation;
import org.onvif.ver10.schema.HostnameInformationExtension;
import org.onvif.ver10.schema.IPAddress;
import org.onvif.ver10.schema.IPAddressFilter;
import org.onvif.ver10.schema.NTPInformation;
import org.onvif.ver10.schema.NetworkGateway;
import org.onvif.ver10.schema.NetworkHost;
import org.onvif.ver10.schema.NetworkInterface;
import org.onvif.ver10.schema.NetworkInterfaceSetConfiguration;
import org.onvif.ver10.schema.NetworkProtocol;
import org.onvif.ver10.schema.NetworkZeroConfiguration;
import org.onvif.ver10.schema.OnvifVersion;
import org.onvif.ver10.schema.RelayLogicalState;
import org.onvif.ver10.schema.RelayOutput;
import org.onvif.ver10.schema.RelayOutputSettings;
import org.onvif.ver10.schema.RemoteUser;
import org.onvif.ver10.schema.Scope;
import org.onvif.ver10.schema.SetDateTimeType;
import org.onvif.ver10.schema.SupportInformation;
import org.onvif.ver10.schema.SystemDateTime;
import org.onvif.ver10.schema.SystemLog;
import org.onvif.ver10.schema.SystemLogType;
import org.onvif.ver10.schema.SystemLogUriList;
import org.onvif.ver10.schema.Time;
import org.onvif.ver10.schema.TimeZone;
import org.onvif.ver10.schema.User;

@javax.jws.WebService(endpointInterface = "org.onvif.ver10.device.wsdl.Device", targetNamespace = "http://www.onvif.org/ver10/device/wsdl", serviceName = "DeviceService", portName = "DevicePort", wsdlLocation = "WEB-INF/wsdl/devicemgmt_1.wsdl")
@javax.jws.HandlerChain(file="com/ylsk/onvif/handler/handlers.xml")
@javax.xml.ws.BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class DevicePortImpl {

	/**
	 * ��ȡ�����б�
	 * @param includeCapability ������������
	 * @return
	 */
	public List<Service> getServices(boolean includeCapability) {
		//// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet.");
		List<Service> list = new ArrayList<Service>();
		
		// �豸�������
		Service device_service = null;
		device_service = new Service();
		// �汾��Ϣ
		OnvifVersion onvifVersion;
		onvifVersion = new OnvifVersion();
		onvifVersion.setMajor(2);
		onvifVersion.setMinor(0);
		device_service.setVersion(onvifVersion);
		// �����ռ�
		device_service.setNamespace("http://www.onvif.org/ver10/device/wsdl");
		// ��ַ
		device_service.setXAddr("http://192.168.1.105:8080/onvif/device_service");
		
		// ��������
		//org.onvif.ver10.device.wsdl.Service.Capabilities cap = null;
		//cap = new org.onvif.ver10.device.wsdl.Service.Capabilities();
		//device_service.setCapabilities(cap);
		
		list.add(device_service);
		return list;
	}

	public DeviceServiceCapabilities getServiceCapabilities() {
		
		DeviceServiceCapabilities dscs;
		dscs = new DeviceServiceCapabilities();
		SecurityCapabilities scs;
		scs = new SecurityCapabilities();
		
		// ֧��httpժҪ��֤
		scs.setHttpDigest(true);
		dscs.setSecurity(scs);
		
		return dscs;
	}

	/**
	 * ��ȡ�豸��Ϣ
	 * @param manufacturer ������
	 * @param model �ͺ�
	 * @param firmwareVersion �̼��汾
	 * @param serialNumber ���к�
	 * @param hardwareId Ӳ��ID
	 */
	public void getDeviceInformation(Holder<String> manufacturer,
			Holder<String> model, Holder<String> firmwareVersion,
			Holder<String> serialNumber, Holder<String> hardwareId) {
		// ��ȡ�豸��Ϣ
		manufacturer.value = "ʯ��ׯС��˾";
		model.value = "SUPER-ONVIF";
		firmwareVersion.value = "100.99.88.77";
		serialNumber.value = "11-22-33-44-55-66-77-88-99-00";
		hardwareId.value = "11111111111111111111111111";
	}

	/**
	 * ����ϵͳʱ��
	 * @param dateTimeType
	 * @param daylightSavings
	 * @param timeZone
	 * @param utcDateTime
	 */
	public void setSystemDateAndTime(SetDateTimeType dateTimeType,
			boolean daylightSavings, TimeZone timeZone, DateTime utcDateTime) {
		System.out.println("����ϵͳʱ�䣺....Ŀǰ�������κβ���");
		try
		{
		System.out.println(dateTimeType.toString()+" | " +
					daylightSavings +" | " +
					timeZone.getTZ()+" | " +
					utcDateTime.toString()
				);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public SystemDateTime getSystemDateAndTime() {
		SystemDateTime sdt;
		sdt = new SystemDateTime();
		sdt.setDateTimeType(SetDateTimeType.MANUAL);
		sdt.setDaylightSavings(false);
		sdt.setExtension(null);
		TimeZone tz;
		tz = new TimeZone();
		tz.setTZ("8");
		sdt.setTimeZone(tz);
		DateTime dt;
		dt = new DateTime();
		
		// ��ȡϵͳ��ǰʱ��
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		// ��ʼ������
		Date date;
		date = new Date();
		date.setYear(year);
		date.setMonth(month);
		date.setDay(day);
		dt.setDate(date);
		
		// ��ʼ��ʱ��
		Time time;
		time = new Time();
		time.setHour(hour);
		time.setMinute(minute);
		time.setSecond(second);
		dt.setTime(time);
		
		// ���ض���
		sdt.setUTCDateTime(dt);;
		return sdt;
	}

	/**
	 * Ӳ����λ/�ָ���������
	 * @param factoryDefault
	 */
	public void setSystemFactoryDefault(FactoryDefaultType factoryDefault) {
		System.out.println("�ָ��������óɹ���"+factoryDefault.name()+" | " + factoryDefault.value());
	}

	public String upgradeSystemFirmware(AttachmentData firmware) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * �����豸
	 * @return
	 */
	public String systemReboot() {
		return "ϵͳ��������......Ԥ����Ҫ60�롣";
	}

	public void restoreSystem(List<BackupFile> backupFiles) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<BackupFile> getSystemBackup() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public SystemLog getSystemLog(SystemLogType logType) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public SupportInformation getSystemSupportInformation() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<Scope> getScopes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setScopes(List<String> scopes) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void addScopes(List<String> scopeItem) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void removeScopes(Holder<List<String>> scopeItem) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public DiscoveryMode getDiscoveryMode() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setDiscoveryMode(DiscoveryMode discoveryMode) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public DiscoveryMode getRemoteDiscoveryMode() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setRemoteDiscoveryMode(DiscoveryMode remoteDiscoveryMode) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<NetworkHost> getDPAddresses() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public GetEndpointReferenceResponse getEndpointReference(
			GetEndpointReference parameters) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public RemoteUser getRemoteUser() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setRemoteUser(RemoteUser remoteUser) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void createUsers(List<User> user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void deleteUsers(List<String> username) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setUser(List<User> user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public String getWsdlUrl() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Capabilities getCapabilities(List<CapabilityCategory> category) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setDPAddresses(List<NetworkHost> dpAddress) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	
	/**
     * get the local host name
     */
    public static String getLocalHostName(){
        try{
            InetAddress addr=InetAddress.getLocalHost();
            return addr.getHostName();
        }catch(Exception e){
            return "";
        }
    }
    
	/**
	 * ��ȡ��������Ϣ
	 * @return
	 */
	public HostnameInformation getHostname() {
		HostnameInformation hi;
		hi = new HostnameInformation();
		hi.setName(getLocalHostName());
		hi.setFromDHCP(false);
//		HostnameInformationExtension hiext;
//		hiext = new HostnameInformationExtension();
//		hiext.getAny().add("��չ����1");
//		hiext.getAny().add("��չ����2");
//		hiext.getAny().add("��չ����N");
//		hi.setExtension(hiext);
		return hi;
	}

	public void setHostname(String name) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public boolean setHostnameFromDHCP(boolean fromDHCP) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public DNSInformation getDNS() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setDNS(boolean fromDHCP, List<String> searchDomain,
			List<IPAddress> dnsManual) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public NTPInformation getNTP() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setNTP(boolean fromDHCP, List<NetworkHost> ntpManual) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public DynamicDNSInformation getDynamicDNS() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setDynamicDNS(DynamicDNSType type, String name, Duration ttl) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<NetworkInterface> getNetworkInterfaces() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public boolean setNetworkInterfaces(String interfaceToken,
			NetworkInterfaceSetConfiguration networkInterface) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<NetworkProtocol> getNetworkProtocols() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setNetworkProtocols(List<NetworkProtocol> networkProtocols) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public NetworkGateway getNetworkDefaultGateway() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setNetworkDefaultGateway(List<String> iPv4Address,
			List<String> iPv6Address) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public NetworkZeroConfiguration getZeroConfiguration() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setZeroConfiguration(String interfaceToken, boolean enabled) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public IPAddressFilter getIPAddressFilter() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setIPAddressFilter(IPAddressFilter ipAddressFilter) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void addIPAddressFilter(IPAddressFilter ipAddressFilter) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void removeIPAddressFilter(IPAddressFilter ipAddressFilter) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public BinaryData getAccessPolicy() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setAccessPolicy(BinaryData policyFile) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Certificate createCertificate(String certificateID, String subject,
			XMLGregorianCalendar validNotBefore,
			XMLGregorianCalendar validNotAfter) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<Certificate> getCertificates() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<CertificateStatus> getCertificatesStatus() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setCertificatesStatus(List<CertificateStatus> certificateStatus) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void deleteCertificates(List<String> certificateID) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public BinaryData getPkcs10Request(String certificateID, String subject,
			BinaryData attributes) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void loadCertificates(List<Certificate> nvtCertificate) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public boolean getClientCertificateMode() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setClientCertificateMode(boolean enabled) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<RelayOutput> getRelayOutputs() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setRelayOutputSettings(String relayOutputToken,
			RelayOutputSettings properties) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setRelayOutputState(String relayOutputToken,
			RelayLogicalState logicalState) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public String sendAuxiliaryCommand(String auxiliaryCommand) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<Certificate> getCACertificates() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void loadCertificateWithPrivateKey(
			List<CertificateWithPrivateKey> certificateWithPrivateKey) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public CertificateInformation getCertificateInformation(String certificateID) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void loadCACertificates(List<Certificate> caCertificate) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void createDot1XConfiguration(Dot1XConfiguration dot1XConfiguration) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setDot1XConfiguration(Dot1XConfiguration dot1XConfiguration) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Dot1XConfiguration getDot1XConfiguration(
			String dot1XConfigurationToken) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<Dot1XConfiguration> getDot1XConfigurations() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void deleteDot1XConfiguration(List<String> dot1XConfigurationToken) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public GetDot11CapabilitiesResponse getDot11Capabilities(
			GetDot11Capabilities parameters) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Dot11Status getDot11Status(String interfaceToken) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<Dot11AvailableNetworks> scanAvailableDot11Networks(
			String interfaceToken) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void getSystemUris(
			Holder<SystemLogUriList> systemLogUris,
			Holder<String> supportInfoUri,
			Holder<String> systemBackupUri,
			Holder<org.onvif.ver10.device.wsdl.GetSystemUrisResponse.Extension> extension) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void startFirmwareUpgrade(Holder<String> uploadUri,
			Holder<Duration> uploadDelay, Holder<Duration> expectedDownTime) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void startSystemRestore(Holder<String> uploadUri,
			Holder<Duration> expectedDownTime) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<StorageConfiguration> getStorageConfigurations() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public String createStorageConfiguration(
			StorageConfigurationData storageConfiguration) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public StorageConfiguration getStorageConfiguration(String token) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setStorageConfiguration(
			StorageConfiguration storageConfiguration) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void deleteStorageConfiguration(String token) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}