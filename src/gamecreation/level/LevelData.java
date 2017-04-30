package gamecreation.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import data.SpriteMakerModel;
import javafx.beans.property.StringProperty;
import newengine.managers.conditions.ICondition;
import newengine.sprite.components.Spawner;

public class LevelData extends Observable implements ILevelData {
	private String name;
	private ICondition winningCondition;
	private ICondition losingCondition;
	private double spawnTime;
	private List<SpriteMakerModel> spawners;

	public LevelData() {
		this.name = "Untitled Level";
		spawners = new ArrayList<SpriteMakerModel>();
	}

	public void setName(String name) {
		this.name = name;
		this.setChanged();
		this.notifyObservers(this.getName());
	}

	@Override
	public String getName() {
		return name;
	}

	public void setSpawnTime(double time) {
		this.spawnTime = time;
	}

	@Override
	public double getSpawnTime() {
		return spawnTime;
	}

	public void setWinningCondition(ICondition condition) {
		this.winningCondition = condition;
	}

	@Override
	public ICondition getWinningCondition() {
		return winningCondition;
	}

	@Override
	public ICondition getLosingCondition() {
		return losingCondition;
	}

	public StringProperty getNameTextProperty() {
		return null;
	}

	public void subscribe(Observer o) {
		this.addObserver(o);
	}

	public void addSpawner(SpriteMakerModel spawner) {
		spawners.add(spawner);
	}

	@Override
	public List<SpriteMakerModel> getSpawners() {
		return spawners;
	}

}
