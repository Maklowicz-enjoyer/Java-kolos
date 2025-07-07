package org.example;
import org.example.filewritter.FileWritterImpl;
import org.example.models.BoardGame;
import org.example.models.Book;
import org.example.models.Client;
import org.example.models.CommonBase;

import java.io.IOException;
import java.util.*;

public class LibrarryService {
    Map<Client, List<CommonBase>> clientsData;

    FileWritterImpl fileWritter = new FileWritterImpl();
    public LibrarryService(){
        clientsData = new LinkedHashMap<>();
    }


    // wpożyczenie

    public void addObjectsToClient(Client client, CommonBase object){
        if(object instanceof Book){
            Book book = (Book) object;
            if(book.getMinAge() > client.getAge()){
                throw new IllegalArgumentException("Age exception while adding board game to client");
            }
            List<CommonBase> books;
            if(!clientsData.containsKey(client)){
                books = new ArrayList<>();
            } else {
                books = clientsData.get(client);
            }
            books.add(book);
            clientsData.put(client, books);

        } else{
            BoardGame boardGame = (BoardGame) object;
            if(boardGame.getMinAge() > client.getAge()){
                throw new IllegalArgumentException("Age exception while adding board game to client");
            }
            List<CommonBase> boardGames;
            if(!clientsData.containsKey(client)){
                boardGames = new ArrayList<>();
            } else {
                boardGames = clientsData.get(client);
            }
            boardGames.add(boardGame);
            clientsData.put(client, boardGames);
        }
    }
    // ad2 wyświetlenie na ekranie listy w postaci:
    public void display(){
        for(Client cLient: clientsData.keySet()){
            List<CommonBase> allClientsObjects = clientsData.get(cLient);

            for(Object object : allClientsObjects){
                System.out.println(object.toString());
            }
        }
    }

    // ad3 program powinien umożliwić generowanie raportó pokazujących informacje zbiorcze
    /*
    1) ilosc wypożyczonych książek
    2) ilosc wypożyczonych gier.
    3) ilosc wypożyczen z podziałem na rodzaj clientow ze względu na wiek: dzieci, mlodzież i dorośli

     */

    public int amountOfAllBooksTaken(){
        int totalBooks = 0;
        for(Client client: clientsData.keySet()){
            List<CommonBase> allClientsObjects = clientsData.get(client);
            for(Object object: allClientsObjects){
                if(object instanceof Book){
                    totalBooks +=1;
                }
            }
        }
        return totalBooks;
    }

    public int amountOfAllGameTaken(){
        int totalGames =0;

        for(Client client: clientsData.keySet()){
            List<CommonBase> allClientsObjects = clientsData.get(client);
            for(Object object: allClientsObjects) {
                if(object instanceof BoardGame){
                    totalGames +=1;
                }
            }
        }
        return totalGames;
    }

    public String amountOfTakenThingsPerAgeGroup(){
        int childern = 0;
        int teens = 0;
        int adults = 0;

        for(Client client: clientsData.keySet()){
            int clientAge = client.getAge();

            if(clientAge < 11){
                childern +=1;
            } else if (clientAge <= 17) {
                teens +=1;
            }
            else {
                adults +=1;
            }
        }
        return "Children took: {%x}; Teens took: {%x}; Adults took: {%x}".formatted(childern, teens, adults);
    }


    //ad4. Program powinien umożliwić eksport listy wypożyczeń do pliku tekstowego

    public void writeTOFile() throws IOException{
        fileWritter.writeToFile(this.clientsData);
    }
}