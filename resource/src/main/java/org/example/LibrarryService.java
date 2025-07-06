package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarryService {
    Map<Klient, List<CommonBase>> usersData;

    public LibrarryService() {
        usersData = new HashMap<>();
    }


//    {"user1" : ["book", "boardGame"]}

    // wypożyczyć
    public void addObjectToUser(Klient klient, CommonBase object) {
        if (object instanceof Book) {
            Book book = (Book) object;
            if (book.getMinAge() > klient.getAge()) {
                throw new IllegalArgumentException("Age exception while adding book to klient");
            }

            List<CommonBase> books;
            if (!usersData.containsKey(klient)) {
                books = new ArrayList<>();
            } else {
                books = usersData.get(klient);
            }
            books.add(book);
            usersData.put(klient, books);

        } else {
            BoardGame boardGame = (BoardGame) object;
            if (boardGame.getMinAge() > klient.getAge()) {
                throw new IllegalArgumentException("Age exception while adding board game to klient");
            }

            List<CommonBase> boardGames;
            if (!usersData.containsKey(klient)) {
                boardGames = new ArrayList<>();
            } else {
                boardGames = usersData.get(klient);
            }
            boardGames.add(boardGame);
            usersData.put(klient, boardGames);

        }
    }


}
