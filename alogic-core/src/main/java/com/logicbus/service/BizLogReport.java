package com.logicbus.service;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.anysoft.util.Settings;
import com.logicbus.backend.AbstractServant;
import com.logicbus.backend.Context;
import com.logicbus.backend.ServantException;
import com.logicbus.backend.bizlog.BizLogger;
import com.logicbus.backend.message.JsonMessage;
import com.logicbus.backend.message.XMLMessage;
import com.logicbus.models.servant.ServiceDescription;

/**
 * BizLog报告
 * 
 * @author duanyy
 *
 * @version 1.4.0 [20141117 duanyy] <br>
 * - 将MessageDoc和Context进行合并整合 <br>
 */
public class BizLogReport extends AbstractServant{

	
	protected void onDestroy() {
	}

	
	protected void onCreate(ServiceDescription sd) throws ServantException{
	}

	
	protected int onXml(Context ctx) throws Exception{
		XMLMessage msg = (XMLMessage) ctx.asMessage(XMLMessage.class);
		
		Settings settings = Settings.get();
		
		BizLogger bizLogger = (BizLogger) settings.get("bizLogger");
		
		Element root = msg.getRoot();
		Document doc = root.getOwnerDocument();
		
		Element logger = doc.createElement(bizLogger.getHandlerType());
		
		bizLogger.report(logger);
		
		root.appendChild(logger);
		return 0;
	}

	
	protected int onJson(Context ctx) throws Exception{
		JsonMessage msg = (JsonMessage)ctx.asMessage(JsonMessage.class);
		
		Settings settings = Settings.get();
		
		BizLogger bizLogger = (BizLogger) settings.get("bizLogger");
		
		Map<String,Object> root = msg.getRoot();
	
		Map<String,Object> logger = new HashMap<String,Object>();
		
		bizLogger.report(logger);
		
		root.put(bizLogger.getHandlerType(), logger);
		return 0;
	}


}
