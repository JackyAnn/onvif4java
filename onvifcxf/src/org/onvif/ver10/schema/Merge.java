
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Merge complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Merge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="from" type="{http://www.onvif.org/ver10/schema}ObjectId" maxOccurs="unbounded" minOccurs="2"/>
 *         &lt;element name="to" type="{http://www.onvif.org/ver10/schema}ObjectId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Merge", propOrder = {
    "from",
    "to"
})
public class Merge {

    @XmlElement(required = true)
    protected List<ObjectId> from;
    @XmlElement(required = true)
    protected ObjectId to;

    /**
     * Gets the value of the from property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the from property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFrom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectId }
     * 
     * 
     */
    public List<ObjectId> getFrom() {
        if (from == null) {
            from = new ArrayList<ObjectId>();
        }
        return this.from;
    }

    /**
     * ��ȡto���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ObjectId }
     *     
     */
    public ObjectId getTo() {
        return to;
    }

    /**
     * ����to���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectId }
     *     
     */
    public void setTo(ObjectId value) {
        this.to = value;
    }

}
