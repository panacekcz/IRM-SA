package firefighters;

import cz.cuni.mff.d3s.deeco.annotations.Ensemble;
import cz.cuni.mff.d3s.deeco.annotations.In;
import cz.cuni.mff.d3s.deeco.annotations.Invariant;
import cz.cuni.mff.d3s.deeco.annotations.KnowledgeExchange;
import cz.cuni.mff.d3s.deeco.annotations.Membership;
import cz.cuni.mff.d3s.deeco.annotations.Out;
import cz.cuni.mff.d3s.deeco.annotations.PeriodicScheduling;
import cz.cuni.mff.d3s.deeco.task.ParamHolder;
import cz.cuni.mff.d3s.deeco.task.ProcessContext;

@Ensemble
@Invariant("ei1")
@PeriodicScheduling(period=Settings.ENSEMBLE_PERIOD)
public class GMsInDangerUpdate {

	@Membership
	public static boolean membership(
		@In("member.leaderId") String leaderId,  
		@In("coord.id") String id 
	) {
		return leaderId.equals(id);
	}

	@KnowledgeExchange
	public static void map(
		@In("member.id") String id,	
		@Out("member.nearbyGMInDanger") ParamHolder<Boolean> nearbyGMInDanger,   
		@In("coord.noOfGMsInDanger") Integer noOfGMsInDanger
	) {
		nearbyGMInDanger.value = noOfGMsInDanger > 0;
		if (nearbyGMInDanger.value) {
			long simulatedTime = ProcessContext.getTimeProvider().getCurrentMilliseconds();
			System.out.println("nearbyGMInDanger signal propagated to GroupMember " + id + " at time : " + simulatedTime);	
		}
		
	}	
}