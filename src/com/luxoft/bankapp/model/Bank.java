package com.luxoft.bankapp.model;

import java.util.*;

import com.luxoft.bankapp.exceptions.ClientExistsException;

public class Bank implements Report {

	Map<String, Client> bankClients = new HashMap<>();

//	private List<Client> clients = new ArrayList<Client>();

//	public List<Client> getClients() {
//		return clients;
//	}

	public Map<String, Client> getClients(){
		return bankClients;
	}

//	public void addClient(Client c) throws ClientExistsException {
//		if (!checkIfClientExists(c)) {
//			clients.add(c);
//		} else {
//			throw new ClientExistsException();
//		}
//	}

		public void addClient(Client c) throws ClientExistsException {
		if (!checkIfClientExists(c)) {
			bankClients.put(c.getName() , c);
		} else {
			throw new ClientExistsException();
		}
	}

//	public void removeClient(Client c) {
//		clients.remove(c);
//	}

	public void removeClient(Client c) {
		bankClients.remove(c);
	}

//	@Override
//	public void printReport() {
//		for (Client c : clients) {
//			c.printReport();
//		}
//
//	}
	@Override
	public void printReport() {
		bankClients.values();
	}

//	public boolean checkIfClientExists(Client client) {
//		for (Client c : clients) {
//			if (c.getName().equals(client.getName())) {
//				return true;
//			}
//		}
//		return false;
//	}

	public boolean checkIfClientExists(Client client) {
			if (bankClients.containsValue(client)) {
				return true;
			}
		return false;
	}

	public void parseFeed(Map<String, String> map) {
		String name = map.get("name");
		Client client = bankClients.get(name);
		if(client == null){
			client = new Client(name);
			bankClients.put(name, client);
		}
		client.setGender(map.get("gender"));
		client.parseFeed(map);
	}

	@Override
	public String toString() {
		return "Bank: " + bankClients.values();
	}
}


