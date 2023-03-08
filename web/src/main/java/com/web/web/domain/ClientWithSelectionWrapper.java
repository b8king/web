package com.web.web.domain;

import java.util.ArrayList;
import java.util.List;

public class ClientWithSelectionWrapper {
    private ArrayList<Carcas> clientList;

    public List<Carcas> getClientList() {
        return clientList;
    }

    public void setClientList(ArrayList<Carcas> clients) {
        this.clientList = clients;
    }

}
