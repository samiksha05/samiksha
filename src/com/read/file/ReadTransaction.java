package com.read.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTransaction {
	
	Map<Integer, transactionBean> mapOfObjects = new HashMap<Integer, transactionBean>();
	Map<String, Long> mapOfSum = new HashMap<String, Long>();
	public  Map<Integer, transactionBean> transactionRead(){
		JSONParser jsonParser = new JSONParser();
		
		
		try (FileReader reader = new FileReader("C:/Users/Samiksha.Parihar/1537277231233_Input_Transactions.json")){
			Object obj = jsonParser.parse(reader);
			JSONArray TransactionList = (JSONArray) obj;
			//System.out.println(TransactionList);
			
			
			for(int i=0; i< TransactionList.size() ;i++)
			{
				//System.out.println(i+" element is >>>>");
				
				JSONObject TransactioListObj= (JSONObject) TransactionList.get(i);
				Long TransactionId = (Long) TransactioListObj.get("TransactionId");  
				//TransactionIdList.add(TransactionId);
		        String Instrument=(String) TransactioListObj.get("Instrument");
				//InstrumentList.add(Instrument);
				String TransactionType= (String)TransactioListObj.get("TransactionType");
				//TransactionTypetList.add(TransactionType);
				Long TransactionQuantity=(Long)TransactioListObj.get("TransactionQuantity");
				//TransactionQuantityList.add(TransactionQuantity);
				mapOfObjects.put(i, new transactionBean(TransactionId,
						Instrument,TransactionType,TransactionQuantity));
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapOfObjects;
	}
	
	/*public static void main(String args[]){
		Rt r= new Rt();
		r.transactionRead();
	}*/
	 
}
