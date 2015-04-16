package cz.cuni.mff.d3s.deeco.demo.firefighters.complex;

import java.util.HashMap;
import java.util.Map;

import cz.cuni.mff.d3s.deeco.annotations.Component;
import cz.cuni.mff.d3s.deeco.annotations.IRMComponent;
import cz.cuni.mff.d3s.deeco.annotations.In;
import cz.cuni.mff.d3s.deeco.annotations.Invariant;
import cz.cuni.mff.d3s.deeco.annotations.Local;
import cz.cuni.mff.d3s.deeco.annotations.Out;
import cz.cuni.mff.d3s.deeco.annotations.PeriodicScheduling;
import cz.cuni.mff.d3s.deeco.annotations.Process;
import cz.cuni.mff.d3s.deeco.task.ParamHolder;
import cz.cuni.mff.d3s.deeco.timer.CurrentTimeProvider;

@Component
@IRMComponent("Officer")
public class Officer {

	public static final int TEMPERATURE_THREASHOLD = 50;
	
	// just to pass the annotation processor checks - use GL_ID instead
	public String id;

	public String GL_ID;
	public Integer noOfGMsInDanger;
	public Map<String,Long> temperatureMap;
	public Map<String,Position> positionMap;
	public Map<String,Integer> accelerationMap;
	public Map<String,Long> oxygenLevelMap;
	
	@Local public CurrentTimeProvider clock;
 
	public Officer(String GL_ID, CurrentTimeProvider clock) {
		this.GL_ID = GL_ID;
		this.noOfGMsInDanger = 0;
		this.temperatureMap = new HashMap<>();
		this.positionMap = new HashMap<>();
		this.accelerationMap = new HashMap<>();
		this.oxygenLevelMap = new HashMap<>();
		this.clock = clock;
	}
 
	@Process
	@Invariant("4")
	@PeriodicScheduling(period=4000) 
	public static void findGMsInDanger(
		@In("temperatureMap") Map<String,Long> temperatureMap,  
		@In("oxygenLevelMap") Map<String,Long> oxygenLevelMap,  
		@In("accelerationMap") Map<String,Integer> accelerationMap,  
		@In("positionMap") Map<String,Position> positionMap,  
		@Out("noOfGMsInDanger") ParamHolder<Integer> noOfGMsInDanger 
	) {
		//Simplification that takes into account the temperature growth.
		noOfGMsInDanger.value = 0;
		for (Long temperature: temperatureMap.values()) {
			if (temperature != null && temperature > TEMPERATURE_THREASHOLD) {
				noOfGMsInDanger.value++;
			}
		}
		System.out.println("End");
	}
}
