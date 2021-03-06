
package com.csic.crm.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ICustomerService", targetNamespace = "http://service.crm.csic.com/")
@XmlSeeAlso({
   // ObjectFactory.class
})
public interface ICustomerService {


    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "assigncustomerstodecidedzone", targetNamespace = "http://service.crm.csic.com/", className = "com.csic.crm.service.Assigncustomerstodecidedzone")
    @ResponseWrapper(localName = "assigncustomerstodecidedzoneResponse", targetNamespace = "http://service.crm.csic.com/", className = "com.csic.crm.service.AssigncustomerstodecidedzoneResponse")
    public void assigncustomerstodecidedzone(
		    @WebParam(name = "arg0", targetNamespace = "")
				    String arg0,
		    @WebParam(name = "arg1", targetNamespace = "")
				    List<Integer> arg1);

    /**
     * 
     * @return
     *     returns java.util.List<com.csic.crm.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://service.crm.csic.com/", className = "com.csic.crm.service.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://service.crm.csic.com/", className = "com.csic.crm.service.FindAllResponse")
    public List<Customer> findAll();

    /**
     * 
     * @return
     *     returns java.util.List<com.csic.crm.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findListNotAssociation", targetNamespace = "http://service.crm.csic.com/", className = "com.csic.crm.service.FindListNotAssociation")
    @ResponseWrapper(localName = "findListNotAssociationResponse", targetNamespace = "http://service.crm.csic.com/", className = "com.csic.crm.service.FindListNotAssociationResponse")
    public List<Customer> findListNotAssociation();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.csic.crm.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findListHasAssociation", targetNamespace = "http://service.crm.csic.com/", className = "com.csic.crm.service.FindListHasAssociation")
    @ResponseWrapper(localName = "findListHasAssociationResponse", targetNamespace = "http://service.crm.csic.com/", className = "com.csic.crm.service.FindListHasAssociationResponse")
    public List<Customer> findListHasAssociation(
		    @WebParam(name = "arg0", targetNamespace = "")
				    String arg0);

}
