/**
 * Dados sobre um objeto Review.
 * 
 * @author grupo 64
 * @version
 */

package model.Reviews;

import java.io.Serializable;
import model.Businesses.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class Review implements Serializable
{
    private String reviewId;
    private String userId;
    private String businessId;
    private float stars;
    private int useful;
    private int funny;
    private int cool;
    private LocalDateTime date;
    private String text;
    
    /*********************************************** CONSTRUTORES ***********************************************/

    public Review(){
         this.reviewId = "";
         this.userId = "";
         this.businessId = "";
         this.stars = 0;
         this.useful = 0;
         this.funny = 0;
         this.cool = 0;
         this.date = LocalDateTime.now();
         this.text = "";
    }

    public Review(String reviewId, String userId, String businessId, float stars, int useful,
               int funny, int cool, LocalDateTime date, String text){
         this.reviewId = reviewId;
         this.userId = userId;
         this.businessId = businessId;
         this.stars = stars;
         this.useful = useful;
         this.funny = funny;
         this.cool = cool;
         this.date = date;
         this.text = text;
    }

    public Review(Review rev){
         this.reviewId = rev.getReviewId();
         this.userId = rev.getUserId();
         this.businessId = rev.getBusinessId();
         this.stars = rev.getStars();
         this.useful = rev.getUseful();
         this.funny = rev.getFunny();
         this.cool = rev.getCool();
         this.date = rev.getDate();
         this.text = rev.getText();
    }

    /**
     * Construtor que cria um objeto User a partir de uma string.
     */
    
    
    /******************************************** GETTERS E SETTERS ********************************************/

    /**
     * M??todo que obt??m o review id.
     * @return review id
     */
    public String getReviewId(){
        return this.reviewId;
    }

    /**
     * M??todo que obt??m o user id.
     * @return user id
     */
    public String getUserId(){
        return this.userId;
    }

    /**
     * M??todo que obt??m o business id.
     * @return business id
     */
    public String getBusinessId(){
        return this.businessId;
    }

    /**
     * M??todo que obt??m o n??mero de stars.
     * @return n??mero de stars
     */
    public float getStars(){
        return this.stars;
    }

    /**
     * M??todo que obt??m o valor de useful.
     * @return valor de useful
     */
    public int getUseful(){
        return this.useful;
    }

    /**
     * M??todo que obt??m o valor de funny.
     * @return valor de funny
     */
    public int getFunny(){
        return this.funny;
    }

    /**
     * M??todo que obt??m o valor de cool.
     * @return valor de cool
     */
    public int getCool(){
        return this.cool;
    }

    /**
     * M??todo que obt??m a data.
     * @return data
     */
    public LocalDateTime getDate(){
        return this.date;
    }

    /**
     * M??todo que obt??m o texto da review.
     * @return texto (todo como uma string)
     */
    public String getText(){
        return this.text;
    }
    
    /**
     * M??todo que muda o review id.
     * @param reviewId novo review id
     */
    public void setReviewId(String reviewId){
        this.reviewId = reviewId;
    }

    /**
     * M??todo que muda o user id.
     * @param userId novo user id
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * M??todo que muda o business id.
     * @param businessId novo business id
     */
    public void setBusinessId(String businessId){
        this.businessId = businessId;
    }

    /**
     * M??todo que muda o n??mero de stars.
     * @param stars novo n??mero de stars
     */
    public void setStars(float stars){
        this.stars = stars;
    }

    /**
     * M??todo que muda o valor do useful.
     * @param useful novo valor do useful
     */
    public void setUseful(int useful){
        this.useful = useful;
    }

    /**
     * M??todo que muda o valor de funny.
     * @param funny novo valor de funny
     */
    public void setFunny(int funny){
        this.funny = funny;
    }

    /**
     * M??todo que muda o valor de cool.
     * @param cool novo valor de cool
     */
    public void setCool(int cool){
        this.cool = cool;
    }

    /**
     * M??todo que muda a data.
     * @param date nova data
     */
    public void setDate(LocalDateTime date){
        this.date = date;
    }

    /**
     * M??todo que muda o texto da review.
     * @param text novo texto da review
     */
    public void setText(String text){
        this.text = text;
    }

    /**
     * M??todo que devolve a lista dos neg??cios de um determinado ano.
     * @param businesses lista de todos os neg??cios
     * @param review lista de todos os reviews
     * @param anoPar ano
     * @return lista de neg??cios desse ano
     */
    public BusinessList negociosDoAno(BusinessList businesses,ReviewList review,int anoPar){
       
        BusinessList negocios = new BusinessList();
        List<Business> aux = new ArrayList<>();

        for(Business bus: businesses.getList()){
            for(Review r : review.getList())
                if(r.getBusinessId().equals(bus.getBusinessId()))    
                    if(r.getDate().getYear() == anoPar)
                    aux.add(bus.clone());
        
        }
        negocios.setList(aux);
        return negocios;
    }

    /**
     * M??todo que devolve um clone de um objeto Review.
     * @return clone
     */
    public Review clone(){
        return new Review(this);
    }
    
    /**
     * M??todo que reescreve o equals de um objeto Review.
     * @param obj objeto Review
     * @return verdadeiro se dois objetos Review forem iguais.
     */
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || ! obj.getClass().equals(this.getClass())) return false;
        Review rev = (Review) obj;
        return  this.reviewId.equals(rev.getReviewId()) &&
            this.userId.equals(rev.getUserId())&&
            this.businessId.equals(rev.getBusinessId()) &&
            this.stars == rev.getStars() &&
            this.useful == rev.getUseful() &&
            this.funny == rev.getFunny() &&
            this.cool == rev.getCool() &&
            this.date == rev.getDate() &&
            this.text.equals(rev.getText());
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Review ID: ").append(this.reviewId);
        sb.append("User ID: ").append(this.userId);
        sb.append("Business ID: ").append(this.businessId);
        sb.append("Stars: ").append(this.stars);
        sb.append("Useful: ").append(this.useful);
        sb.append("Funny: ").append(this.funny);
        sb.append("Cool: ").append(this.cool);
        sb.append("Date: ").append(this.date);
        sb.append("Text: ").append(this.text);
        return sb.toString();
    }
}
