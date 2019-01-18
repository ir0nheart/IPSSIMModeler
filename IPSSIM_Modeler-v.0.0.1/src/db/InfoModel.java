package db;

import java.awt.Shape;
import java.util.ArrayList;

public class InfoModel {
//Singleton Class
private static InfoModel instance = null;

public static InfoModel getInstance() {
	if (instance == null) {
		instance = new InfoModel();
	}
return instance;
}

private InfoModel() {
	commands = new ArrayList<>();
}



private String meshType;
private String meshDimension;
private Shape domain;
private ArrayList<String> commands;
private int fishnet_x;
private int fishnet_y;


public String getMeshType() {
	return meshType;
}

public void setMeshType(String meshType) {
	this.meshType = meshType;
}

public Shape getDomain() {
	return domain;
}

public void setDomain(Shape domain) {
	this.domain = domain;
}

public String getLastCommand() {
	return commands.get(commands.size()-1);
}

public void addCommand(String command) {
	this.commands.add(command);
}

public String getMeshDimension() {
	return meshDimension;
}

public void setMeshDimension(String meshDimension) {
	this.meshDimension = meshDimension;
}

public int getFishnet_x() {
	return fishnet_x;
}

public void setFishnet_x(int fishnet_x) {
	this.fishnet_x = fishnet_x;
}

public int getFishnet_y() {
	return fishnet_y;
}

public void setFishnet_y(int fishnet_y) {
	this.fishnet_y = fishnet_y;
}

//



	
}
