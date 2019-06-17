package nl.robertalblas.testfixturesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumBuilder {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TitleBuilder titleBuilder;

    @Autowired
    private GenreBuilder genreBuilder;

    public Album findOrCreateAlbum(String name, int year, List<Title> titles, Genre genre) {
        return albumRepository.findByName(name)
                .orElseGet(() -> {
                    Album album = new Album();
                    album.setName(name);
                    album.setYear(year);
                    album.setTitles(titles);
                    album.setGenre(genre);

                    return albumRepository.save(album);
                });
    }

    public Album whenever_you_need_somebody() {
        List<Title> album1Titles = new ArrayList<>();
        album1Titles.add(titleBuilder.never_gonna_give_you_up());
        album1Titles.add(titleBuilder.whenever_you_need_somebody());
        album1Titles.add(titleBuilder.together_forever());
        album1Titles.add(titleBuilder.it_would_take_a_strong_man());
        album1Titles.add(titleBuilder.the_love_has_gone());
        album1Titles.add(titleBuilder.dont_say_goodbye());
        album1Titles.add(titleBuilder.slipping_away());
        album1Titles.add(titleBuilder.no_more_looking_for_love());
        album1Titles.add(titleBuilder.you_move_me());
        album1Titles.add(titleBuilder.when_I_fall_in_love());

        return findOrCreateAlbum("Whenever You Need Somebody", 1987, album1Titles, genreBuilder.pop());
    }

    public Album hold_me_in_your_arms() {
        List<Title> album2Titles = new ArrayList<>();
        album2Titles.add(titleBuilder.she_wants_to_dance_with_me());
        album2Titles.add(titleBuilder.take_me_to_your_heart());
        album2Titles.add(titleBuilder.I_dont_want_too_lose_her());
        album2Titles.add(titleBuilder.giving_up_on_love());
        album2Titles.add(titleBuilder.aint_too_proud_to_beg());
        album2Titles.add(titleBuilder.till_then());
        album2Titles.add(titleBuilder.dial_my_number());
        album2Titles.add(titleBuilder.ill_never_let_you_down());
        album2Titles.add(titleBuilder.I_dont_want_to_be_your_lover());
        album2Titles.add(titleBuilder.hold_me_in_your_arms());

        return findOrCreateAlbum("Hold Me In Your Arms", 1988, album2Titles, genreBuilder.pop());
    }
}
