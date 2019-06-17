package nl.robertalblas.testfixturesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitleBuilder {

    @Autowired
    private TitleRepository titleRepository;

    public Title findOrCreateTitle(String name, int trackNumber, int duration) {
        return titleRepository.findByName(name)
                .orElseGet(() -> {
                    Title title = new Title();
                    title.setDuration(duration);
                    title.setName(name);
                    title.setTrackNumber(trackNumber);
                    return titleRepository.save(title);
                });
    }

    public Title never_gonna_give_you_up() {
        return findOrCreateTitle("Never Gonna Give You Up", 1, 214);
    }

    public Title whenever_you_need_somebody() {
        return findOrCreateTitle("Whenever You Need Somebody", 2, 234);
    }

    public Title together_forever() {
        return findOrCreateTitle("Together Forever", 3, 206);
    }

    public Title it_would_take_a_strong_man() {
        return findOrCreateTitle("It Would Take A Strong Strong Man", 4, 221);
    }

    public Title the_love_has_gone() {
        return findOrCreateTitle("The Love Has Gone", 5, 260);
    }

    public Title dont_say_goodbye() {
        return findOrCreateTitle("Don't Say Goodbye", 6, 249);
    }

    public Title slipping_away() {
        return findOrCreateTitle("Slipping Away", 7, 193);
    }

    public Title no_more_looking_for_love() {
        return findOrCreateTitle("No More Looking For Love", 8, 223);
    }

    public Title you_move_me() {
        return findOrCreateTitle("You Move Me", 9, 220);
    }

    public Title when_I_fall_in_love() {
        return findOrCreateTitle("When I Fall In Love", 10, 183);
    }

    public Title she_wants_to_dance_with_me() {
        return findOrCreateTitle("She Wants To Dance With Me", 1, 214);
    }

    public Title take_me_to_your_heart() {
        return findOrCreateTitle("Take Me To Your Heart", 2, 285);
    }

    public Title I_dont_want_too_lose_her() {
        return findOrCreateTitle("I Don't Want To Lose Her", 3, 189);
    }

    public Title giving_up_on_love() {
        return findOrCreateTitle("Giving Up On Love", 4, 230);
    }

    public Title aint_too_proud_to_beg() {
        return findOrCreateTitle("Ain't Too Proud To Beg", 5, 210);
    }

    public Title till_then() {
        return findOrCreateTitle("Till Then", 6, 232);
    }

    public Title dial_my_number() {
        return findOrCreateTitle("Dial My Number", 7, 201);
    }

    public Title ill_never_let_you_down() {
        return findOrCreateTitle("I'll Never Let You Down", 8, 214);
    }

    public Title I_dont_want_to_be_your_lover() {
        return findOrCreateTitle("I Don't Want To Be Your Lover", 9, 301);
    }

    public Title hold_me_in_your_arms() {
        return findOrCreateTitle("Hold Me In Your Arms", 10, 171);
    }

}
