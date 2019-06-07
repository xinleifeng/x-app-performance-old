package sap.crun.performance;

import java.util.ArrayList;
import java.util.List;

import com.sap.cloud.sdk.service.prov.api.*;
import com.sap.cloud.sdk.service.prov.api.annotations.*;
import com.sap.cloud.sdk.service.prov.api.exits.*;
import com.sap.cloud.sdk.service.prov.api.request.*;
import com.sap.cloud.sdk.service.prov.api.response.*;
import org.slf4j.*;

public class SingleRecInService {
	private static final Logger LOG = LoggerFactory.getLogger (SingleRecInService.class.getName());
	
	@BeforeRead (entity="SNGLRECIN", serviceName="PerformanceDataService")
	public BeforeReadResponse beforeReadSNGLRECIN (ReadRequest req, ExtensionHelper h){
		LOG.error ("##### SNGLRECIN - beforeReadSNGLRECIN ########");
	    return BeforeReadResponse.setSuccess().response();
	}
	
	@AfterRead (entity = "SNGLRECIN", serviceName="PerformanceDataService")
	public ReadResponse afterReadSNGLRECIN (ReadRequest req, ReadResponseAccessor res, ExtensionHelper h) {
		EntityData ed = res.getEntityData();
		EntityData ex = EntityData.getBuilder(ed).addElement("CONNCOUNTER", 8888).buildEntityData("SNGLRECIN");
		return ReadResponse.setSuccess().setData(ex).response();
	}
	
	@AfterQuery (entity = "SNGLRECIN", serviceName="PerformanceDataService")
	public QueryResponse afterQuerySNGLRECIN (QueryRequest req, QueryResponseAccessor res, ExtensionHelper h) {
		
		List<EntityData> dataList = res.getEntityDataList(); //original list
		List<EntityData> modifiedList = new ArrayList<EntityData>(dataList.size()); //modified list
		
		for(EntityData ed : dataList){
			EntityData ex = EntityData.getBuilder(ed).addElement("CONNCOUNTER", 9999).buildEntityData("SNGLRECIN");
			modifiedList.add(ex);
		}
		//return QueryResponse.setSuccess().setData(modifiedList).response();
		return QueryResponse.setSuccess().setData(dataList).response();
	}
}
