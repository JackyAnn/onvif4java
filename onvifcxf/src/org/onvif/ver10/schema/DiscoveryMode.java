
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DiscoveryMode�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="DiscoveryMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Discoverable"/>
 *     &lt;enumeration value="NonDiscoverable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DiscoveryMode")
@XmlEnum
public enum DiscoveryMode {

    @XmlEnumValue("Discoverable")
    DISCOVERABLE("Discoverable"),
    @XmlEnumValue("NonDiscoverable")
    NON_DISCOVERABLE("NonDiscoverable");
    private final String value;

    DiscoveryMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DiscoveryMode fromValue(String v) {
        for (DiscoveryMode c: DiscoveryMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}