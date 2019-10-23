
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ClassDescriptor complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ClassDescriptor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClassCandidate" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Type" type="{http://www.onvif.org/ver10/schema}ClassType"/>
 *                   &lt;element name="Likelihood" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}ClassDescriptorExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassDescriptor", propOrder = {
    "classCandidate",
    "extension"
})
public class ClassDescriptor {

    @XmlElement(name = "ClassCandidate")
    protected List<ClassDescriptor.ClassCandidate> classCandidate;
    @XmlElement(name = "Extension")
    protected ClassDescriptorExtension extension;

    /**
     * Gets the value of the classCandidate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classCandidate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassCandidate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassDescriptor.ClassCandidate }
     * 
     * 
     */
    public List<ClassDescriptor.ClassCandidate> getClassCandidate() {
        if (classCandidate == null) {
            classCandidate = new ArrayList<ClassDescriptor.ClassCandidate>();
        }
        return this.classCandidate;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClassDescriptorExtension }
     *     
     */
    public ClassDescriptorExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClassDescriptorExtension }
     *     
     */
    public void setExtension(ClassDescriptorExtension value) {
        this.extension = value;
    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Type" type="{http://www.onvif.org/ver10/schema}ClassType"/>
     *         &lt;element name="Likelihood" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "type",
        "likelihood"
    })
    public static class ClassCandidate {

        @XmlElement(name = "Type", required = true)
        protected ClassType type;
        @XmlElement(name = "Likelihood")
        protected float likelihood;

        /**
         * ��ȡtype���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link ClassType }
         *     
         */
        public ClassType getType() {
            return type;
        }

        /**
         * ����type���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link ClassType }
         *     
         */
        public void setType(ClassType value) {
            this.type = value;
        }

        /**
         * ��ȡlikelihood���Ե�ֵ��
         * 
         */
        public float getLikelihood() {
            return likelihood;
        }

        /**
         * ����likelihood���Ե�ֵ��
         * 
         */
        public void setLikelihood(float value) {
            this.likelihood = value;
        }

    }

}
