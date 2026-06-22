interface Animal {
    boolean feed (boolean timeToEat);
    void groom();
    void pet();
}

class Gorilla implements Animal {

    boolean feed;

    Gorilla (boolean feedTheGorilla) {
        this.feed = feedTheGorilla;
    }

    public void groom () {
        //lather, rinse, repeat.
        System.out.println("Although it may seem difficult, you decide to groom the gorilla.");
    }

    public void pet () {
        //pet at your own risk.
        System.out.println("You give in to your intrusive thoughts and pet the gorilla.");
    }

     public boolean feed (boolean timeToEat) {
        //put gorilla food into cage.
        return feed;
    }

    public void feedGorilla () {
        if (feed) {
            System.out.println("It's time, so you feed the gorilla.");
        } else {
            System.out.println("It's not yet time, so you do not feed the gorilla.");
        }
    }

}

public class Task16 {
    public void main(String[] args) {

        //Edit the boolean for feeding the gorilla here.
        Gorilla gorilla = new Gorilla(false); 

        gorilla.feedGorilla();
        gorilla.pet();
        gorilla.groom();
    }
}
