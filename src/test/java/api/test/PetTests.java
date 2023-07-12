package api.test;

import api.payload.Category;
import api.payload.Pet;
import api.payload.PetStatus;
import api.payload.Tag;
import api.utilities.FakeDataManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static api.endpoints.PetEndPoints.*;
import static api.payload.PetStatus.randomPetStatus;

public class PetTests {
    Pet pet;

    @BeforeClass
    public void setup() {
        int id = FakeDataManager.getRandomID();
        Category category = new Category(FakeDataManager.getRandomFirstName(),FakeDataManager.getRandomID());
        String name = FakeDataManager.getRandomFirstName();
        List<String> photoURL = new ArrayList<>();
        photoURL.add("https://shorturl.at/GSZ24");
        photoURL.add("https://shorturl.at/hCX12");
        List<Tag> listTag = new ArrayList<>();
        listTag.add(new Tag(FakeDataManager.getRandomLastName(),FakeDataManager.getRandomID()));
        String status = randomPetStatus().toString();
        pet = new Pet(id, category,name,photoURL,listTag,status);

    }

    @Test(priority = 1)
    public void testAddingPetToStore() {
        Response response = addNewPet(pet);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 2)
    public void testUploadingPhoto() {
        Response response = uploadPhoto(pet.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdatingPet() {
        pet.setName(FakeDataManager.getRandomLastName());
        Response response = updateExistingPet(pet);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 4)
    public void testFindPetByStatus() {
        Response response = findPetByStatus(pet.getStatus());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void testFindPetById() {
        Response response = findPetById(pet.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 6)
    public void testUpdateWithFormData() {
        pet.setName(FakeDataManager.getRandomLastName());
        pet.setStatus(PetStatus.randomPetStatus().toString());
        Response response = updatePetWithForm(pet.getId(),pet.getName(),pet.getStatus());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void testDeletePet() {
        Response response = deletePetById(pet.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
