package com.sprint.be_java_hisp_w23_g04.utils;

import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.*;

import java.time.LocalDate;
import java.util.List;

public class UtilsIntegrationTests {

    public static BuyerDTO getBuyerDTOTestUS0003(String order) {
        UserDTO user1 = new UserDTO(6,"Diego Lopez");
        UserDTO user2 = new UserDTO(4,"Sofia Gomez");

        if(order.equals("name_dsc")) {
            return new BuyerDTO(1,"Juan Perez",List.of(user2,user1));
        }

        return new BuyerDTO(1,"Juan Perez",List.of(user1,user2));
    }

    public static BuyerDTO getBuyerDTOTestUS0003() {
        UserDTO user1 = new UserDTO(6,"Diego Lopez");
        UserDTO user2 = new UserDTO(4,"Sofia Gomez");

        return new BuyerDTO(1,"Juan Perez",List.of(user1,user2));
    }

    public static BuyerDTO getBuyerDTOTestUS0004(String order) {
        UserDTO user1 = new UserDTO(1,"Juan Perez");
        UserDTO user2 = new UserDTO(3,"Pablo Gonzalez");

        if(order.equals("name_dsc")) {
            return new BuyerDTO(4,"Sofia Gomez",List.of(user2,user1));
        }

        return new BuyerDTO(4,"Sofia Gomez",List.of(user1,user2));
    }

    public static BuyerDTO getBuyerDTOTestUS0004() {
        UserDTO user1 = new UserDTO(1,"Juan Perez");
        UserDTO user2 = new UserDTO(3,"Pablo Gonzalez");

        return new BuyerDTO(4,"Sofia Gomez",List.of(user1,user2));
    }

    public static PostDTO generatePostDTOUS0005(){
        LocalDate date = LocalDate.of(2023,12,19);
        ProductDTO product = getProductDTO(1);

        PostDTO post = new PostDTO();
        post.setUserId(5);
        post.setDate(date);
        post.setProduct(product);
        post.setCategory(100);
        post.setPrice(1500.50);

        return post;
    }

    private static ProductDTO getProductDTO(int productId){
        switch (productId) {
            case 1 -> {
                ProductDTO product = new ProductDTO();
                product.setId(1);
                product.setType("Gamer");
                product.setBrand("Racer");
                product.setColor("Red and Black");
                product.setNotes("Special Edition");
                product.setName("Silla gamer");

                return product;
            }
            case 2 -> {
                ProductDTO product = new ProductDTO();
                product.setId(2);
                product.setType("Gamer");
                product.setBrand("Redragon");
                product.setColor("Black");
                product.setNotes("Special Edition");
                product.setName("Teclado");

                return product;
            }
        }

        return null;
    }

    public static PostDTO generatePostDTOUS0005(String modifier){
        PostDTO post = generatePostDTOUS0005();
        return applyModificationsPost(post,modifier);
    }

    private static PostDTO applyModificationsPost(PostDTO post, String modifier){
        switch (modifier){
            case "invalid_user" -> post.setUserId(88);
            case "user_on_null" -> post.setUserId(null);
            case "user_on_zero" -> post.setUserId(0);
            case "date_null" -> post.setDate(null);
            case "product_on_null" -> post.getProduct().setId(null);
            case "product_on_zero" -> post.getProduct().setId(0);
            case "product_name_null" -> post.getProduct().setName(null);
            case "product_name_large" -> post.getProduct().setName("kdnshuayscmdloikeuqywencjdouyraksjcbvmzxerpoqjalsjncajfpokaascd");
            case "product_name_special_chars" -> post.getProduct().setColor("Red & Black");
            case "product_type_on_null" -> post.getProduct().setType(null);
            case "product_type_large" -> post.getProduct().setType("kasifhsdasdfasgdfyuoiqwyeqpoqweurmcnwezxcsdhfkasdfbasdfasdgasdiu");
            case "product_type_special_chars" -> post.getProduct().setType("Home & Deco");
            case "product_brand_null" -> post.getProduct().setBrand(null);
            case "product_brand_large" -> post.getProduct().setBrand("jasdhvaoweurywefaajsdfklpoapsdofiaksdcnausdAPasdifjHIAUDHsgdhfgahsdgnclaospdfiqweufn");
            case "product_brand_special_chars" -> post.getProduct().setBrand("Moño");
        }

        return post;
    }

    public static SimpleMessageDTO generateUserNotFoundMessage(Integer userID){
        return new SimpleMessageDTO("No se encontró usuario con el id "+ userID+".");
    }

    public static PostListDTO generatePostListDTOUS0006(Integer userId,String order) {
        PostResponseDTO post1 = new PostResponseDTO();
        post1.setDate(LocalDate.of(2023,12,23));
        post1.setProduct(getProductDTO(2));
        post1.setCategory(58);
        post1.setPrice(800.0);
        post1.setUserId(3);
        post1.setPostId(4);

        PostResponseDTO post2 = new PostResponseDTO();
        post2.setDate(LocalDate.of(2023,12,29));
        post2.setProduct(getProductDTO(1));
        post2.setCategory(100);
        post2.setPrice(1000.0);
        post2.setUserId(1);
        post2.setPostId(7);

        PostResponseDTO post3 = new PostResponseDTO();
        post3.setDate(LocalDate.of(2023,12,31));
        post3.setProduct(getProductDTO(1));
        post3.setCategory(100);
        post3.setPrice(1000.0);
        post3.setUserId(1);
        post3.setPostId(8);

        if(order.equals("date_asc")){
            return new PostListDTO(userId,List.of(post1,post2,post3));
        }

        return new PostListDTO(userId,List.of(post3,post2,post1));
    }
}
