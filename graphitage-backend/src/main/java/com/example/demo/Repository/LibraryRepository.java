package com.example.demo.Repository;

import com.example.demo.Model.Library;
import com.example.demo.Model.Reader;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("libraryDAO")
public interface LibraryRepository extends Neo4jRepository<Library, Long> {

    List<Library> findAll();

    Optional<Library> findById(Long readerId);

    @Query("MATCH (l:Library) WHERE toLower(l.libraryName) = toLower($0) RETURN l")
    Optional<Library> findByName(String libraryName);

    @Query("MATCH (l:Library) WHERE toLower(l.libraryLink) = toLower($0) RETURN l")
    Optional<Library> findByLink(String libraryLink);


}
