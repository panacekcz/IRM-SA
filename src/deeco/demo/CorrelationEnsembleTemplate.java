package deeco.demo;

import deeco.metadata.KnowledgeMetadataHolder;
import deeco.metadata.CorrelationLevel.DistanceClass;
import cz.cuni.mff.d3s.deeco.annotations.Ensemble;
import cz.cuni.mff.d3s.deeco.annotations.In;
import cz.cuni.mff.d3s.deeco.annotations.KnowledgeExchange;
import cz.cuni.mff.d3s.deeco.annotations.Membership;
import cz.cuni.mff.d3s.deeco.annotations.Out;
import cz.cuni.mff.d3s.deeco.annotations.PeriodicScheduling;
import cz.cuni.mff.d3s.deeco.knowledge.KnowledgeNotFoundException;
import cz.cuni.mff.d3s.deeco.task.ParamHolder;
import deeco.metadata.MetadataWrapper;

// This class is not used. It only illustrates what is being created inside the CorrelationEnsembleFactory
@Ensemble
@PeriodicScheduling(period = 1000)
public class CorrelationEnsembleTemplate {
	
	private static final int timeTrashold = 1000;
	
	@Membership
	public static boolean membership(
			@In("member.position") MetadataWrapper<Integer> memberPosition,
			@In("member.temperature") MetadataWrapper<Integer> memberTemperature,
			@In("coord.position") MetadataWrapper<Integer> coordPosition,
			@In("coord.temperature") MetadataWrapper<Integer> coordTemperature) {
		
		return (!memberTemperature.isOperational()
				&& coordTemperature.isOperational()
				&& KnowledgeMetadataHolder.classifyDistance("position", memberPosition.getValue(), coordPosition.getValue()) == DistanceClass.Close);
	}

	@KnowledgeExchange
	public static void map(
			@In("member.id") String memberId,
			@In("coord.temperature") MetadataWrapper<Integer> coordTemperature,
			@Out("member.temperature") ParamHolder<MetadataWrapper<Integer>> memberTemperature) throws KnowledgeNotFoundException {

		System.out.println("Knowledge injection for component " + memberId);

		memberTemperature.value = coordTemperature;
	}
}
