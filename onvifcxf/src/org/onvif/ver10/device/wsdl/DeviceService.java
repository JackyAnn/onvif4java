package org.onvif.ver10.device.wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2016-06-28T16:57:51.766+08:00
 * Generated source version: 2.7.18
 * 
 */
@WebServiceClient(name = "DeviceService", 
                  wsdlLocation = "file:/D:/OPENCVR/javaonvif/wsdls/devicemgmt_1.wsdl",
                  targetNamespace = "http://www.onvif.org/ver10/device/wsdl") 
public class DeviceService extends javax.xml.ws.Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.onvif.org/ver10/device/wsdl", "DeviceService");
    public final static QName DevicePort = new QName("http://www.onvif.org/ver10/device/wsdl", "DevicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/OPENCVR/javaonvif/wsdls/devicemgmt_1.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DeviceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/OPENCVR/javaonvif/wsdls/devicemgmt_1.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DeviceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DeviceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DeviceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DeviceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DeviceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DeviceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns Device
     */
    @WebEndpoint(name = "DevicePort")
    public Device getDevicePort() {
        return super.getPort(DevicePort, Device.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Device
     */
    @WebEndpoint(name = "DevicePort")
    public Device getDevicePort(WebServiceFeature... features) {
        return super.getPort(DevicePort, Device.class, features);
    }

}