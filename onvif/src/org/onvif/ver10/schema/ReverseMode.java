package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ReverseMode.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="ReverseMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OFF"/>
 *     &lt;enumeration value="ON"/>
 *     &lt;enumeration value="AUTO"/>
 *     &lt;enumeration value="Extended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReverseMode")
@XmlEnum
public enum ReverseMode {

	OFF("OFF"), ON("ON"), AUTO("AUTO"), @XmlEnumValue("Extended")
	EXTENDED("Extended");
	private final String value;

	ReverseMode(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static ReverseMode fromValue(String v) {
		for (ReverseMode c : ReverseMode.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
