package api.payload;

import java.util.Random;

public enum PetStatus {

    available,pending,sold;

    private static final Random random = new Random();

    public static PetStatus randomPetStatus()  {
        PetStatus[] petStatus = values();
        return petStatus[random.nextInt(petStatus.length)];
    }
}
