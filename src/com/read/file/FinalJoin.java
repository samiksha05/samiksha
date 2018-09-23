package com.read.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FinalJoin {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> Input_Instrument_list = new ArrayList<>();
		ArrayList<String> Input_Account_list = new ArrayList<>();
		ArrayList<String> Input_AccountType_list = new ArrayList<>();
		ArrayList<String> Input_Quantity_list = new ArrayList<>();
		ArrayList<String> Initial_Input_Quantity_list = new ArrayList<>();

		Map<String, Long> mapOfSum = new HashMap<String, Long>();

		ReadCsv readCsv = new ReadCsv(Input_Instrument_list, Input_Account_list, Input_AccountType_list,
				Input_Quantity_list);
		readCsv.Input_position_details();
		Initial_Input_Quantity_list.addAll(Input_Quantity_list);

		ReadTransaction rt = new ReadTransaction();
		rt.transactionRead();

		for (transactionBean Bean : rt.mapOfObjects.values()) {
			long newAmount = 0;
			if (mapOfSum.containsKey(Bean.getTransactionType() + Bean.getInstrument())) {
				newAmount = mapOfSum.get(Bean.getTransactionType() + Bean.getInstrument())
						+ Bean.getTransactionQuantity();
			} else {
				newAmount = Bean.getTransactionQuantity();
			}
			mapOfSum.put(Bean.getTransactionType() + Bean.getInstrument(), newAmount);

		}

		for (Entry<String, Long> entry : mapOfSum.entrySet()) {
			for (int j = 1; j < readCsv.Input_AccountType_list.size(); j++) {

				Long Quantity = null;
				if (entry.getKey().substring(0, 1).equals("B")
						&& entry.getKey().substring(1).equalsIgnoreCase(Input_Instrument_list.get(j))) {

					if (Input_AccountType_list.get(j).equalsIgnoreCase("E")) {

						Quantity = Long.parseLong(Input_Quantity_list.get(j)) + entry.getValue();
						Input_Quantity_list.set(j, Quantity.toString());

					}
					if (Input_AccountType_list.get(j).equalsIgnoreCase("I")) {

						Quantity = Long.parseLong(Input_Quantity_list.get(j)) - entry.getValue();
						Input_Quantity_list.set(j, Quantity.toString());

					}
				}

				else if (entry.getKey().substring(0, 1).equals("S")
						&& entry.getKey().substring(1).equalsIgnoreCase(Input_Instrument_list.get(j))) {
					if (Input_AccountType_list.get(j).equalsIgnoreCase("E")) {

						Quantity = Long.parseLong(Input_Quantity_list.get(j)) - entry.getValue();
						Input_Quantity_list.set(j, Quantity.toString());
					}
					if (Input_AccountType_list.get(j).equalsIgnoreCase("I")) {

						Quantity = Long.parseLong(Input_Quantity_list.get(j)) + entry.getValue();

						Input_Quantity_list.set(j, Quantity.toString());

					}

				}

			}
		}

		PrintStream o = new PrintStream(new File("C:/Users/Samiksha.Parihar/Expected_EndOfDay_Positions.txt"));

		// Store current System.out before assigning a new value
		//PrintStream console = System.out;
		System.setOut(o);
		System.out.println("Instrument,Account,AccountType,Quantity,Delta");
		for (int j = 1; j < readCsv.Input_AccountType_list.size(); j++) {
			System.setOut(o);
			Long Delta = null;
			Delta = Long.parseLong(Input_Quantity_list.get(j)) - Long.parseLong(Initial_Input_Quantity_list.get(j));
			System.out.println(Input_Instrument_list.get(j) + "," + Input_Account_list.get(j) + ","
					+ Input_AccountType_list.get(j) + "," + Input_Quantity_list.get(j) + "," + Delta);

			//System.setOut(console);
			//System.out.println("This will be written on the console!");

		}
	}
}
