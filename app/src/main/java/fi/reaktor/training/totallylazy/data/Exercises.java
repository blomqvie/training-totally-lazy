package fi.reaktor.training.totallylazy.data;

public class Exercises {

    public static Exercise getExerciseBySection(int sectionNumber) {
        switch(sectionNumber) {
            case 0:
                return new Exercise1();
            case 1:
                return new Exercise2();
            case 2:
                return new Exercise1();
            default:
                return new Exercise1();
        }
    }
}
