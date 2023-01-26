
class Voldemort {
    private int horcruxesLeft;

    public Voldemort(int amountOfHorcruxes) {
        this.horcruxesLeft = amountOfHorcruxes;
    }

    public RegularPerson killLily() {
        System.out.println("Coś smutnego");
        return new RegularPerson();
    }

    public boolean isAlive() {
        return horcruxesLeft > 0;
    }

    public void destroyHorcrux() {
        horcruxesLeft = horcruxesLeft - 1;
    }
}

class RegularPerson {
    private String name;
    private String familyName;

    public RegularPerson() {
        this.name = "Harry";
        this.familyName = "Potter";
    }
}

class Dumbledore {
    public Wizard youAreWizard(RegularPerson person) {
        return new Wizard(person);
    }
}

class Wizard {
    private RegularPerson person;

    public Wizard(RegularPerson person) {
        this.person = person;
    }

    public void destroyHorcruxOf(Voldemort voldemort) {
        voldemort.destroyHorcrux();
    }

    public void tryToDefeat(Voldemort voldemort) {
        if (!voldemort.isAlive()) {
            System.out.println("Sukces");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int amountOfHorcruxes = 8;
        Voldemort youKnowWho = new Voldemort(amountOfHorcruxes);
        String name = "Harry";
        String familyName = "Potter";
        RegularPerson harry = youKnowWho.killLily();
        Dumbledore albus = new Dumbledore();
        Wizard harryWizard = albus.youAreWizard(harry);
        while (youKnowWho.isAlive()) {
            harryWizard.destroyHorcruxOf(youKnowWho);
            harryWizard.tryToDefeat(youKnowWho);
        }
        System.out.println("Happy ending");
    }
}