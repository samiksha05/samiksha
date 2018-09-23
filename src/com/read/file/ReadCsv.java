package com.read.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCsv {
	 ArrayList<String> Input_Instrument_list = new ArrayList<>();
	 ArrayList<String> Input_Account_list = new ArrayList<>();
	 ArrayList<String> Input_AccountType_list = new ArrayList<>();
	 ArrayList<String> Input_Quantity_list = new ArrayList<>();
	 BufferedReader br;
	public ReadCsv(ArrayList<String> Input_Instrument_list, ArrayList<String> input_Account_list,
			ArrayList<String> input_AccountType_list, ArrayList<String> input_Quantity_list) {
		// TODO Auto-generated constructor stub
		this.Input_Instrument_list= Input_Instrument_list;
		this.Input_Account_list =  input_Account_list;
		this.Input_AccountType_list= input_AccountType_list;
		this.Input_Quantity_list= input_Quantity_list;
		
	}

	public ReadCsv Input_position_details() {
	
		
		String file="C:/Users/Samiksha.Parihar/Input_StartOfDay_Positions.txt";
		 try {
			
		      br = new BufferedReader( new FileReader(file));
	            String strLine = "";
	           
	            while( (strLine = br.readLine()) != null)
	            {
	               
	                //break comma separated line using ","
	                String[] cols = strLine.split(",");
	                Input_Instrument_list.add(cols[0]);
	                Input_Account_list.add(cols[1]);
	                Input_AccountType_list.add(cols[2]);
	                Input_Quantity_list.add(cols[3]);
	            }
			
	            
	           
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ReadCsv(Input_Instrument_list,Input_Account_list,Input_AccountType_list,Input_Quantity_list);
	}
	}
	
