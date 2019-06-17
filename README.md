# Fixtures

## Before

```java
    @Test
    public void saveArtist() {
        Genre genre = new Genre();
        genre.setName("pop");
        genre = genreRepository.save(genre);

        Artist artist = new Artist();
        artist.setName("Rick Astley");

        List<Title> album1Titles = new ArrayList<>();
        album1Titles.add(createTitle("Never Gonna Give You Up", 1, 214));
        album1Titles.add(createTitle("Whenever You Need Somebody", 2, 234));
        album1Titles.add(createTitle("Together Forever", 3, 206));
        album1Titles.add(createTitle("It Would Take A Strong Strong Man", 4, 221));
        album1Titles.add(createTitle("The Love Has Gone", 5, 260));
        album1Titles.add(createTitle("Don't Say Goodbye", 6, 249));
        album1Titles.add(createTitle("Slipping Away", 7, 193));
        album1Titles.add(createTitle("No More Looking For Love", 8, 223));
        album1Titles.add(createTitle("You Move Me", 9, 220));
        album1Titles.add(createTitle("When I Fall In Love", 10, 183));

        Album album1 = createAlbum("Whenever You Need Somebody", 1987, album1Titles, genre);

        List<Title> album2Titles = new ArrayList<>();
        album2Titles.add(createTitle("She Wants To Dance With Me", 1, 214));
        album2Titles.add(createTitle("Take Me To Your Heart", 2, 285));
        album2Titles.add(createTitle("I Don't Want To Lose Her", 3, 189));
        album2Titles.add(createTitle("Giving Up On Love", 4, 230));
        album2Titles.add(createTitle("Ain't Too Proud To Beg", 5, 210));
        album2Titles.add(createTitle("Till Then", 6, 232));
        album2Titles.add(createTitle("Dial My Number", 7, 201));
        album2Titles.add(createTitle("I'll Never Let You Down", 8, 214));
        album2Titles.add(createTitle("I Don't Want To Be Your Lover", 9, 301));
        album2Titles.add(createTitle("Hold Me In Your Arms", 10, 171));

        Album album2 = createAlbum("Hold Me In Your Arms", 1988, album2Titles, genre);

        artist.setAlbums(asList(album1, album2));

        artistRepository.save(artist);

    }

    public Album createAlbum(String name, int year, List<Title> titles, Genre genre) {
        Album album = new Album();
        album.setName(name);
        album.setYear(year);
        album.setTitles(titles);
        album.setGenre(genre);

       return albumRepository.save(album);
    }

    private Title createTitle(String name, int trackNumber, int duration) {
        Title title = new Title();
        title.setDuration(duration);
        title.setName(name);
        title.setTrackNumber(trackNumber);

        return titleRepository.save(title);
    }
```

## After
 
```java
    @Test
    public void saveArtist() {
        Artist savedArtist = artistBuilder.rick_astley();

        assertEquals(4450 , savedArtist.getTotalDuration());
        assertEquals("Rick Astley", savedArtist.getName());

    }
```
