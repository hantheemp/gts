package com.muratkagan.gts.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.context.annotation.Import;

import com.muratkagan.gts.entities.Album;

@DataJpaTest
@Import(AlbumDao.class)
class AlbumDaoTest {

	@Autowired
	private AlbumDao albumDao;

	@Autowired
	private TestEntityManager entityManager;

	private Album sampleAlbum;

	@BeforeEach
	void setUp() {

		sampleAlbum = new Album();

		sampleAlbum.setArtistId(1);
		sampleAlbum.setTitle("Test Album");
		sampleAlbum.setReleaseDate(LocalDate.of(2025, 1, 1));
		sampleAlbum.setCoverArtUrl("http://cover.jpg");

		entityManager.persist(sampleAlbum);
		entityManager.flush();
	}

	@Test
	void getAll_returnsAlbums_whenDatabaseHasRecords() {
		List<Album> albums = albumDao.getAll();

		assertNotNull(albums);
		assertFalse(albums.isEmpty());
		assertEquals(1, albums.size());
		assertEquals("Test Album", albums.get(0).getTitle());
		assertEquals(1, albums.get(0).getArtistId());
		assertEquals(LocalDate.of(2025, 1, 1), albums.get(0).getReleaseDate());
	}

	@Test
	void getAll_returnsEmptyList_whenDatabaseIsEmpty() {

		entityManager.getEntityManager().createQuery("DELETE FROM Album").executeUpdate();

		List<Album> albums = albumDao.getAll();

		assertNotNull(albums);
		assertTrue(albums.isEmpty());
		assertEquals(0, albums.size());
	}

	@Test
	void getAll_returnsMultipleAlbums_whenMultipleExist() {
		Album secondAlbum = new Album();
		secondAlbum.setArtistId(2);
		secondAlbum.setTitle("Second Album");
		secondAlbum.setReleaseDate(LocalDate.of(2024, 6, 15));
		secondAlbum.setCoverArtUrl("http://cover2.jpg");
		entityManager.persist(secondAlbum);
		entityManager.flush();

		List<Album> albums = albumDao.getAll();
		assertNotNull(albums);
		assertEquals(2, albums.size());
		assertTrue(albums.stream().anyMatch(a -> a.getTitle().equals("Test Album")));
		assertTrue(albums.stream().anyMatch(a -> a.getTitle().equals("Second Album")));
	}

	@Test
	void getById_returnsAlbum_whenAlbumExists() {
		Optional<Album> found = albumDao.getById(sampleAlbum.getId());

		assertTrue(found.isPresent());
		assertEquals("Test Album", found.get().getTitle());
		assertEquals(sampleAlbum.getId(), found.get().getId());
		assertEquals(1, found.get().getArtistId());
	}

	@Test
	void getById_returnsEmpty_whenAlbumDoesNotExist() {
		Integer nonExistentId = 99999;

		Optional<Album> found = albumDao.getById(nonExistentId);

		assertTrue(found.isEmpty());
		assertFalse(found.isPresent());
	}

}