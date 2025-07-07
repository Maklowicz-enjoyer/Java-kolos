package org.example.filewritter;

import org.example.models.Client;
import org.example.models.CommonBase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileWritter {

    public void writeToFile(Map<Client, List<CommonBase>> clientsData) throws IOException;

}
