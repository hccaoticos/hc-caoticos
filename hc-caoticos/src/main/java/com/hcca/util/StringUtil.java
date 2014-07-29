package com.hcca.util;
/*package com.brilyint.util;

import javax.servlet.http.HttpSession;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;

import com.brilyint.model.Asset;
import com.brilyint.model.Message;
import com.brilyint.model.Property;
import com.brilyint.model.RFP;
import com.brilyint.model.ServiceRequest;

public class StringUtil {

	public static String defaultString(String value){
		return value == null ? "" : value; 
	}
	
	public static Object xss(Object obj, String type, HttpSession session){
		AntiSamy as = new AntiSamy();
		CleanResults cr = null;
		String realPath = session.getServletContext().getRealPath("/WEB-INF/spring/antisamy-brilyint.xml");
		
		switch(type){
		case "property":
			Property property = (Property)obj;
			
			try{
				cr = as.scan(property.getAddress(), realPath);			
				property.setAddress(cr.getCleanHTML());
				cr = as.scan(property.getCity(), realPath);			
				property.setCity(cr.getCleanHTML());
				cr = as.scan(property.getCounty(), realPath);			
				property.setCounty(cr.getCleanHTML());
				cr = as.scan(property.getUsState(), realPath);			
				property.setUsState(cr.getCleanHTML());
				cr = as.scan(property.getZipCode(), realPath);			
				property.setZipCode(cr.getCleanHTML());
				cr = as.scan(property.getName(), realPath);			
				property.setName(cr.getCleanHTML());
				cr = as.scan(property.getPropertyType(), realPath);			
				property.setPropertyType(cr.getCleanHTML());
				cr = as.scan(property.getPropertySubType(), realPath);			
				property.setPropertySubType(cr.getCleanHTML());
				cr = as.scan(property.getDescription(), realPath);			
				property.setDescription(cr.getCleanHTML());
				cr = as.scan(property.getPropertyStatus(), realPath);			
				property.setPropertyStatus(cr.getCleanHTML());
				
				//Site Description
				cr = as.scan(property.getSiteSizeUnit(), realPath);			
				property.setSiteSizeUnit(cr.getCleanHTML());
				cr = as.scan(property.getSiteSizeUnitSecondary(), realPath);			
				property.setSiteSizeUnitSecondary(cr.getCleanHTML());
				cr = as.scan(property.getSiteShape(), realPath);			
				property.setSiteShape(cr.getCleanHTML());
				cr = as.scan(property.getZoningCode(), realPath);			
				property.setZoningCode(cr.getCleanHTML());
				cr = as.scan(property.getZoningDescription(), realPath);			
				property.setZoningDescription(cr.getCleanHTML());
				cr = as.scan(property.getLegalDescription(), realPath);			
				property.setLegalDescription(cr.getCleanHTML());
				cr = as.scan(property.getCensusTract(), realPath);			
				property.setCensusTract(cr.getCleanHTML());
				
				//Improvement Information
				cr = as.scan(property.getImprovementType(), realPath);			
				property.setImprovementType(cr.getCleanHTML());
				cr = as.scan(property.getImprovementSizeUnit(), realPath);			
				property.setImprovementSizeUnit(cr.getCleanHTML());
				cr = as.scan(property.getImprovementSizeUnitSecondary(), realPath);			
				property.setImprovementSizeUnitSecondary(cr.getCleanHTML());
				cr = as.scan(property.getImprovementCondition(), realPath);			
				property.setImprovementCondition(cr.getCleanHTML());
				cr = as.scan(property.getGroundLeaseTerm(), realPath);			
				property.setGroundLeaseTerm(cr.getCleanHTML());
				
				//Additional Information
				cr = as.scan(property.getOffsiteParkingType(), realPath);			
				property.setOffsiteParkingType(cr.getCleanHTML());
				cr = as.scan(property.getOnsiteParkingType(), realPath);			
				property.setOffsiteParkingType(cr.getCleanHTML());
				
				obj = (Object)property;
			}catch (ScanException | PolicyException e1) {
				e1.printStackTrace();
			}
			break;
			
		case "asset":
			Asset asset = (Asset)obj;
			
			try{
				cr = as.scan(asset.getReceivershipName(), realPath);			
				asset.setReceivershipName(cr.getCleanHTML());
				cr = as.scan(asset.getType(), realPath);			
				asset.setType(cr.getCleanHTML());
				cr = as.scan(asset.getDealType(), realPath);			
				asset.setDealType(cr.getCleanHTML());
				cr = as.scan(asset.getNumber(), realPath);			
				asset.setNumber(cr.getCleanHTML());
				cr = as.scan(asset.getName(), realPath);			
				asset.setName(cr.getCleanHTML());
				cr = as.scan(asset.getCodName(), realPath);			
				asset.setCodName(cr.getCleanHTML());
				cr = as.scan(asset.getTaskOrder(), realPath);			
				asset.setTaskOrder(cr.getCleanHTML());
				cr = as.scan(asset.getContractor(), realPath);			
				asset.setContractor(cr.getCleanHTML());
				cr = as.scan(asset.getFin(), realPath);			
				asset.setFin(cr.getCleanHTML());
			}catch (ScanException | PolicyException e1) {
				e1.printStackTrace();
			}
			break;
		
		case "SR":
			ServiceRequest sr = (ServiceRequest)obj;
			
			try{
				cr = as.scan(sr.getServiceType(), realPath);			
				sr.setServiceType(cr.getCleanHTML());
				cr = as.scan(sr.getReportFormat(), realPath);			
				sr.setReportFormat(cr.getCleanHTML());
				cr = as.scan(sr.getReportType(), realPath);			
				sr.setReportType(cr.getCleanHTML());
				cr = as.scan(sr.getIntendedUse(), realPath);			
				sr.setIntendedUse(cr.getCleanHTML());
			}catch (ScanException | PolicyException e1) {
				e1.printStackTrace();
			}
			break;
		
		case "message":
			Message message = (Message)obj;
			
			try{
				cr = as.scan(message.getComment(), realPath);			
				message.setComment(cr.getCleanHTML());
				cr = as.scan(message.getVisibility(), realPath);			
				message.setVisibility(cr.getCleanHTML());
			}catch (ScanException | PolicyException e1) {
				e1.printStackTrace();
			}
			break;
		case "apn":
			try{
				cr = as.scan((String)obj, realPath);
				obj = cr.getCleanHTML();
			}catch (ScanException | PolicyException e1) {
				e1.printStackTrace();
			}
			break;
		case "RFPTabSow":
			RFP rfp = (RFP)obj;
			
			try{
				cr = as.scan(rfp.getFormLetterEL().getName(), realPath);
				rfp.getFormLetterEL().setName(cr.getCleanHTML());
				cr = as.scan(rfp.getFormLetterSOW().getName(), realPath);
				rfp.getFormLetterSOW().setName(cr.getCleanHTML());
			}catch (ScanException | PolicyException e1) {
				e1.printStackTrace();
			}
			break;
		}
		
		
		return obj;
	}
}
*/