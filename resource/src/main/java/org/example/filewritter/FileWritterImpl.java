package org.example.filewritter;

import org.example.models.Client;
import org.example.models.CommonBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileWritterImpl implements FileWritter {


    //  się metodami ściśle powiązanymi poprzez obszar swojej funkcjonalności.

    @Override
    public void writeToFile(Map<Client, List<CommonBase>> clientsData) throws IOException {
        FileWriter myWriter = new FileWriter("usersData.txt");

        try {
            for (Client client : clientsData.keySet()){
                StringBuilder sb = new StringBuilder(); // new String(); ""

                sb.append(client.toString());
                sb.append(" : [ ");

                List<CommonBase> addClientsObjects = clientsData.get(client); // get all the books/board games assigned to user
                for (Object object: addClientsObjects) {
                    sb.append(object.toString());
                    sb.append("\n");

                }
                sb.append(" ]\n\n ");

                myWriter.write(sb.toString());
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
