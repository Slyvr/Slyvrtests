package com.slyvronline.core.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.slyvrtests.utils.GameConstants;
import com.slyvronline.core.utils.Xbox360Controller;
import com.slyvronline.slyvrtests.Game;

/**
 * This class maintains all the data and entities required in a menu
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class Menu {

	private String name;
	private int id;
	private String type;
	private ArrayList<Ent> ents;
	private ArrayList<Menu> subMenus;
	private Menu currentSubMenu;
	private int controllerAxisTimer;
	
	public Menu(){
		
	}
	
	public void render(SpriteBatch batch){
		for(Ent e : ents){
			e.render(batch);
		}
	}
	
	public void update(float stateTime){
		
	}
	
	public static void updateButtonHover(){
		
	}
	
	public void updateKeyboardNavigation(){
		if (Gdx.input.isKeyJustPressed(GameConstants.FIRST_KEY_DOWN) || Gdx.input.isKeyJustPressed(GameConstants.SEC_KEY_DOWN)){
			downButton();
		}
		if (Gdx.input.isKeyJustPressed(GameConstants.FIRST_KEY_UP) || Gdx.input.isKeyJustPressed(GameConstants.SEC_KEY_UP)){
			upButton();
		}
	}
	
	public void updateKeyboardSelect(){
		if (Gdx.input.isKeyJustPressed(GameConstants.FIRST_KEY_A) || Gdx.input.isKeyJustPressed(GameConstants.SEC_KEY_A)){
			buttonSelect();
		}
		if (Gdx.input.isKeyJustPressed(GameConstants.FIRST_KEY_B) || Gdx.input.isKeyJustPressed(GameConstants.SEC_KEY_B) || Gdx.input.isKeyJustPressed(GameConstants.KEY_QUIT)){
			buttonDeselect();
		}
	}
	
	public void buttonSelect(){
		
	}
	
	public void buttonDeselect(){
		
	}
	
	public void updateControllerPOV(Controller controller, int povCode, PovDirection value){
		//System.out.println(controller.getName()+" - "+povCode+" - "+value);
	}
	
	public void updateControllerAxis(Controller controller, int axisCode, float value){
		//Down
		if (value > 0.5 && axisCode == 0){
			if (value == 1.0){
				downButton();
			}
		}
		//Up
		if (value < -0.5 && axisCode == 0){
			if (value == -1.0){
				upButton();
			}
		}
		//Right
		if (value > 0.5 && axisCode == 1){
			if (value == 1.0){
				rightButton();
			}
		}
		//Left
		if (value < -0.5 && axisCode == 1){
			if (value == -1.0){
				leftButton();
			}
		}
	}
	
	public void downButton(){
		//Navigate btn to next one down
		Ent selected = this.getSelectedEnt();
		if (selected != null){
			int nextId = selected.getId() + 1;
			if (selected.getId() == this.getMaxBtnId()){
				nextId = 1;
			}
			else{
				if (this.getEntById(nextId) == null){
					nextId = 1;
				}
			}
			if (this.getEntById(nextId) != null && !this.getEntById(nextId).isSelected()){
				//Game.getGlobal().getSfxByName("paperflip").play();
			}
			selected.setSelected(false);
			if (this.getEntById(nextId) != null) this.getEntById(nextId).setSelected(true);
		}
	}
	
	public void upButton(){
		//Navigate btn to next one up
		Ent selected = this.getSelectedEnt();
		if (selected != null){
			int nextId = selected.getId() - 1;
			if (selected.getId() <= 1){
				nextId = this.getMaxBtnId();
			}
			else{
				if (this.getEntById(nextId) == null){
					nextId = 1;
				}
			}
			if (this.getEntById(nextId) != null && !this.getEntById(nextId).isSelected()){
				//Game.getGlobal().getSfxByName("paperflip").play();
			}
			selected.setSelected(false);
			if (this.getEntById(nextId) != null) this.getEntById(nextId).setSelected(true);
		}
	}
	
	public void leftButton(){
		
	}
	
	public void rightButton(){
		
	}
	
	public void updateControllerButtonDown(Controller controller, int buttonCode){
		if (buttonCode == Xbox360Controller.BUTTON_A){
			buttonSelect();
		}
		if (buttonCode == Xbox360Controller.BUTTON_B){
			buttonDeselect();
		}
	}
	
	public void updateControllerButtonUp(Controller controller, int buttonCode){
		//System.out.println(controller.getName()+" - "+buttonCode+" UP");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<Ent> getEnts() {
		return ents;
	}
	public void setEnts(ArrayList<Ent> ents) {
		this.ents = ents;
	}
	public ArrayList<Menu> getSubMenus(){
		return subMenus;
	}
	public void setSubMenus(ArrayList<Menu> subMenus){
		this.subMenus=subMenus;
	}
	public Menu getCurrentSubMenu(){
		return currentSubMenu;
	}
	public void setCurrentSubMenu(Menu currentSubMenu){
		this.currentSubMenu=currentSubMenu;
	}
	public void setCurrentSubMenuByName(String menuName){
		for(Menu subMenu : subMenus){
			if (menuName.equals(subMenu.getName())){
				this.currentSubMenu = subMenu;
				break;
			}
		}
	}
	public Ent getEntByName(String name){
		for(Ent e : ents)
			if (e.getName().equals(name)) return e;
		return null;
	}
	public Menu getSubMenuByName(String name){
		for(Menu m : subMenus)
			if (m.getName().equals(name)) return m;
		return null;
	}
	public int getMaxBtnId(){
		int maxId = 1;
		for(Ent e : this.getEnts()){
			if (maxId < e.getId()) maxId = e.getId();
		}
		return maxId;
	}
	public Ent getEntById(int id){
		for(Ent e : this.getEnts())
			if (e.getId() == id) return e;
		return null;
	}
	public int getControllerAxisTimer() {
		return controllerAxisTimer;
	}
	public void setControllerAxisTimer(int controllerAxisTimer) {
		this.controllerAxisTimer = controllerAxisTimer;
	}
	public Ent getSelectedEnt(){
		for(Ent e : this.getEnts())
			if (e.isSelected() && e.getName().contains("btn")) return e;
		return null;
	}
}
