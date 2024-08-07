package org.example.bookmanagement.service.librarianDAO;

import org.example.bookmanagement.model.Librarian;

import java.util.List;

public interface ILibrarianDAO {

    List<Librarian> showAllLibrarian();
    void insertLibrarian(Librarian librarian);
    boolean updateLibrarian(Librarian librarian);
    Librarian searchByID(int id);
    boolean deleteLibrarian(int id);
    List<Librarian> searchByName(String name);
    Librarian searchByEmail(String email);
}
