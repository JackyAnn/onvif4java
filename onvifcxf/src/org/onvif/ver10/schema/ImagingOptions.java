
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>ImagingOptions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ImagingOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BacklightCompensation" type="{http://www.onvif.org/ver10/schema}BacklightCompensationOptions"/>
 *         &lt;element name="Brightness" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="ColorSaturation" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="Contrast" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="Exposure" type="{http://www.onvif.org/ver10/schema}ExposureOptions"/>
 *         &lt;element name="Focus" type="{http://www.onvif.org/ver10/schema}FocusOptions"/>
 *         &lt;element name="IrCutFilterModes" type="{http://www.onvif.org/ver10/schema}IrCutFilterMode" maxOccurs="unbounded"/>
 *         &lt;element name="Sharpness" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="WideDynamicRange" type="{http://www.onvif.org/ver10/schema}WideDynamicRangeOptions"/>
 *         &lt;element name="WhiteBalance" type="{http://www.onvif.org/ver10/schema}WhiteBalanceOptions"/>
 *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImagingOptions", propOrder = {
    "backlightCompensation",
    "brightness",
    "colorSaturation",
    "contrast",
    "exposure",
    "focus",
    "irCutFilterModes",
    "sharpness",
    "wideDynamicRange",
    "whiteBalance",
    "any"
})
public class ImagingOptions {

    @XmlElement(name = "BacklightCompensation", required = true)
    protected BacklightCompensationOptions backlightCompensation;
    @XmlElement(name = "Brightness", required = true)
    protected FloatRange brightness;
    @XmlElement(name = "ColorSaturation", required = true)
    protected FloatRange colorSaturation;
    @XmlElement(name = "Contrast", required = true)
    protected FloatRange contrast;
    @XmlElement(name = "Exposure", required = true)
    protected ExposureOptions exposure;
    @XmlElement(name = "Focus", required = true)
    protected FocusOptions focus;
    @XmlElement(name = "IrCutFilterModes", required = true)
    protected List<IrCutFilterMode> irCutFilterModes;
    @XmlElement(name = "Sharpness", required = true)
    protected FloatRange sharpness;
    @XmlElement(name = "WideDynamicRange", required = true)
    protected WideDynamicRangeOptions wideDynamicRange;
    @XmlElement(name = "WhiteBalance", required = true)
    protected WhiteBalanceOptions whiteBalance;
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡbacklightCompensation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BacklightCompensationOptions }
     *     
     */
    public BacklightCompensationOptions getBacklightCompensation() {
        return backlightCompensation;
    }

    /**
     * ����backlightCompensation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BacklightCompensationOptions }
     *     
     */
    public void setBacklightCompensation(BacklightCompensationOptions value) {
        this.backlightCompensation = value;
    }

    /**
     * ��ȡbrightness���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getBrightness() {
        return brightness;
    }

    /**
     * ����brightness���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setBrightness(FloatRange value) {
        this.brightness = value;
    }

    /**
     * ��ȡcolorSaturation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getColorSaturation() {
        return colorSaturation;
    }

    /**
     * ����colorSaturation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setColorSaturation(FloatRange value) {
        this.colorSaturation = value;
    }

    /**
     * ��ȡcontrast���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getContrast() {
        return contrast;
    }

    /**
     * ����contrast���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setContrast(FloatRange value) {
        this.contrast = value;
    }

    /**
     * ��ȡexposure���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ExposureOptions }
     *     
     */
    public ExposureOptions getExposure() {
        return exposure;
    }

    /**
     * ����exposure���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ExposureOptions }
     *     
     */
    public void setExposure(ExposureOptions value) {
        this.exposure = value;
    }

    /**
     * ��ȡfocus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FocusOptions }
     *     
     */
    public FocusOptions getFocus() {
        return focus;
    }

    /**
     * ����focus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FocusOptions }
     *     
     */
    public void setFocus(FocusOptions value) {
        this.focus = value;
    }

    /**
     * Gets the value of the irCutFilterModes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the irCutFilterModes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIrCutFilterModes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IrCutFilterMode }
     * 
     * 
     */
    public List<IrCutFilterMode> getIrCutFilterModes() {
        if (irCutFilterModes == null) {
            irCutFilterModes = new ArrayList<IrCutFilterMode>();
        }
        return this.irCutFilterModes;
    }

    /**
     * ��ȡsharpness���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getSharpness() {
        return sharpness;
    }

    /**
     * ����sharpness���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setSharpness(FloatRange value) {
        this.sharpness = value;
    }

    /**
     * ��ȡwideDynamicRange���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link WideDynamicRangeOptions }
     *     
     */
    public WideDynamicRangeOptions getWideDynamicRange() {
        return wideDynamicRange;
    }

    /**
     * ����wideDynamicRange���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link WideDynamicRangeOptions }
     *     
     */
    public void setWideDynamicRange(WideDynamicRangeOptions value) {
        this.wideDynamicRange = value;
    }

    /**
     * ��ȡwhiteBalance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link WhiteBalanceOptions }
     *     
     */
    public WhiteBalanceOptions getWhiteBalance() {
        return whiteBalance;
    }

    /**
     * ����whiteBalance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link WhiteBalanceOptions }
     *     
     */
    public void setWhiteBalance(WhiteBalanceOptions value) {
        this.whiteBalance = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.Object }
     * {@link Element }
     * 
     * 
     */
    public List<java.lang.Object> getAny() {
        if (any == null) {
            any = new ArrayList<java.lang.Object>();
        }
        return this.any;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}