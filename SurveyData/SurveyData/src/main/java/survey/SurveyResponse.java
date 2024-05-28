/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package survey;

/**
 *
 * @author Simamkele Ndwandwa
 */
public class SurveyResponse {
    
private String name;
	private int age;
	private boolean likePizza;
	private boolean likeSushi;
	private boolean likeTacos;
	private int rating;

	public SurveyResponse() {
	}

	public SurveyResponse(String name, int age, boolean likePizza, boolean likeSushi, boolean likeTacos, int rating) {
		this.name = name;
		this.age = age;
		this.likePizza = likePizza;
		this.likeSushi = likeSushi;
		this.likeTacos = likeTacos;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isLikePizza() {
		return likePizza;
	}

	public void setLikePizza(boolean likePizza) {
		this.likePizza = likePizza;
	}

	public boolean isLikeSushi() {
		return likeSushi;
	}

	public void setLikeSushi(boolean likeSushi) {
		this.likeSushi = likeSushi;
	}

	public boolean isLikeTacos() {
		return likeTacos;
	}

	public void setLikeTacos(boolean likeTacos) {
		this.likeTacos = likeTacos;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
